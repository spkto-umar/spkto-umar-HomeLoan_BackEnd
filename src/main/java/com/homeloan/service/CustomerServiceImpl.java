package com.homeloan.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.dao.CustomerRepository;
import com.homeloan.dao.IncomeDetailsRepository;
import com.homeloan.dao.LoanApplicationRepository;
import com.homeloan.entity.Customer;
import com.homeloan.entity.IncomeDetails;
import com.homeloan.entity.LoanApplication;
import com.homeloan.exception.AmountCannotBeNegativeException;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.exception.NoIncomeDetailsFoundException;
import com.homeloan.exception.NoLoanApplicationFoundException;

@Service
public class CustomerServiceImpl implements CustomerService
{
	
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private IncomeDetailsRepository iRepo;
	
	@Autowired
	private LoanApplicationRepository lRepo;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public Customer loginProcess(Customer c) {
		String emailid =  c.getEmail();
		String password = c.getPassword();
		Customer cc = (Customer)em.createQuery("select c from Customer c where  c.email=:emailid").setParameter("emailid", emailid).getSingleResult();
		if(( cc.getEmail().equals(emailid) ) && ( cc.getPassword().equals(password) ) ) 
		{	
			return cc;
		}
		else 
			return null;
	}
	
	@Transactional
	@Override
	public Customer createCustomer(Customer c) {
//			System.out.println(c);
		return cRepo.save(c);
	}

	@Override
	public List<Customer> listOfCustomers() {
		List<Customer> clist=cRepo.findAll();
//		System.out.println(clist);
		return clist;
	}

	@Override
	public Customer findCustomerById(int userId) throws NoCustomerFoundException {
		Optional<Customer> ct=cRepo.findById(userId);
		if(ct.isPresent())
		{
			Customer cust=ct.get();
//			System.out.println(cust);
			return cust;
		}
		throw new NoCustomerFoundException("Customer with id "+userId+" does not exist");
	}
	
	@Transactional
	@Override
	public Customer updateCustomerById(int userId, Customer c) throws NoCustomerFoundException {
		Optional<Customer> ct=cRepo.findById(userId);
		if(ct.isPresent())
		{
			Customer cust=cRepo.save(c);
			return cust;
		}
		throw new NoCustomerFoundException("Customer with id "+userId+" does not exist");	
	}
	
	@Transactional
	@Override
	public Customer deleteCustomerById(int userId) throws NoCustomerFoundException {
		Optional<Customer> ct=cRepo.findById(userId);
		if(ct.isPresent())
		{
			Customer cust=ct.get();
			cRepo.delete(cust);
			return cust;
		}
		throw new NoCustomerFoundException("Customer with id "+userId+" does not exist");	
	}

	@Transactional
	@Override
	public IncomeDetails addDetails(IncomeDetails income,int userId) throws AmountCannotBeNegativeException, NoCustomerFoundException, NoIncomeDetailsFoundException {
		if(income.getAmount()<0)
			throw new AmountCannotBeNegativeException("Amount cannot be negative");
		Customer c=findCustomerById(userId);
		income.setCustomer(c);
		c.setIncome(income);
		cRepo.save(c);
		return findIncomeByUser(userId);
		//return iRepo.save(income);
	}

	@Transactional
	@Override
	public IncomeDetails updateDetails(int incomeId, IncomeDetails income) throws AmountCannotBeNegativeException,NoIncomeDetailsFoundException, NoCustomerFoundException 
	{
		Optional<IncomeDetails> inc=iRepo.findById(incomeId);
		if(inc.isPresent())
		{
			if(income.getAmount()<0)
				throw new AmountCannotBeNegativeException("Amount cannot be negative");
			IncomeDetails ii=inc.get();
			Customer c=findCustomerById(ii.getCustomer().getUserId());
			//System.out.println(c);
			income.setCustomer(c);
			c.setIncome(income);
			cRepo.save(c);
			return findIncomeByUser(c.getUserId());
		}
		throw new NoIncomeDetailsFoundException("Income Details with id "+incomeId+" does not exist");
	}

	@Transactional
	@Override
	public IncomeDetails deleteDetails(int incomeId) throws NoIncomeDetailsFoundException, NoCustomerFoundException {
		Optional<IncomeDetails> inc=iRepo.findById(incomeId);
		if(inc.isPresent())
		{
			IncomeDetails ii=inc.get();
			Customer c=findCustomerById(ii.getCustomer().getUserId());
			//System.out.println(c);
			c.setIncome(null);
			//ii.setCustomer(null);
			cRepo.save(c);
			iRepo.delete(ii);
			return ii;
		}
		throw new NoIncomeDetailsFoundException("Income Details with id "+incomeId+" does not exist");
	}

	@Override
	public IncomeDetails findIncomeByUser(int userId) throws NoIncomeDetailsFoundException, NoCustomerFoundException {
		Customer c=findCustomerById(userId);
		Optional<IncomeDetails> inc=iRepo.findById(c.getIncome().getIncomeId());
		if(inc.isPresent())
		{
			IncomeDetails ii=inc.get();
			return ii;
		}
		throw new NoIncomeDetailsFoundException("Income Details for userId "+userId+" does not exist");
	}

	@Override
	public LoanApplication addLoan(LoanApplication loan, int userId)throws AmountCannotBeNegativeException, NoCustomerFoundException, NoLoanApplicationFoundException
	{
		if(loan.getLoanAmount()<0)
			throw new AmountCannotBeNegativeException("Loan Amount cannot be negative");
		Customer c=findCustomerById(userId);
		loan.setCustomer(c);
		c.setLoan(loan);
		cRepo.save(c);
		return findLoanByUser(userId);		
	}

	@Override
	public LoanApplication findLoanByUser(int userId) throws NoCustomerFoundException,NoLoanApplicationFoundException {
		Customer c=findCustomerById(userId);
		Optional<LoanApplication> loan=lRepo.findById(c.getLoan().getApplicationId());
		if(loan.isPresent())
		{
			LoanApplication lo=loan.get();
			return lo;
		}
		throw new NoLoanApplicationFoundException("Loan application for user "+userId+" does not exist");
	}

	@Override
	public LoanApplication updateLoan(int applicationId,LoanApplication loan) throws NoCustomerFoundException, NoLoanApplicationFoundException, AmountCannotBeNegativeException {
		Optional<LoanApplication> lo=lRepo.findById(applicationId);
		if(lo.isPresent())
		{
			if(loan.getLoanAmount()<0)
				throw new AmountCannotBeNegativeException("Amount cannot be negative");
			LoanApplication ll=lo.get();
			Customer c=findCustomerById(ll.getCustomer().getUserId());
			//System.out.println(c);
			loan.setCustomer(c);
			c.setLoan(loan);
			cRepo.save(c);
			return findLoanByUser(c.getUserId());
		}		
		throw new NoLoanApplicationFoundException("Loan application with loan id "+applicationId+" does not exist");
	}

	@Override
	public LoanApplication deleteLoan(int applicationId) throws NoCustomerFoundException,NoLoanApplicationFoundException 
	{
		Optional<LoanApplication> loan=lRepo.findById(applicationId);
		if(loan.isPresent())
		{
			LoanApplication lo=loan.get();
			Customer c=findCustomerById(lo.getCustomer().getUserId());
			//System.out.println(c);
			c.setLoan(null);
			//ii.setCustomer(null);
			cRepo.save(c);
			lRepo.delete(lo);
			return lo;
		}
		throw new NoLoanApplicationFoundException("Loan application with loan id "+applicationId+" does not exist");
	}
}
