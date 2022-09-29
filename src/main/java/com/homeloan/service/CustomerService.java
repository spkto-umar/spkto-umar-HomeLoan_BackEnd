package com.homeloan.service;

import java.util.List;

import com.homeloan.entity.Customer;
import com.homeloan.entity.IncomeDetails;
import com.homeloan.entity.LoanApplication;
import com.homeloan.exception.AmountCannotBeNegativeException;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.exception.NoIncomeDetailsFoundException;
import com.homeloan.exception.NoLoanApplicationFoundException;

public interface CustomerService 
{
	public Customer loginProcess(Customer c);
	public Customer createCustomer(Customer c);
	public List<Customer> listOfCustomers();
	public Customer findCustomerById(int userId)throws NoCustomerFoundException;
	public Customer updateCustomerById(int userId,Customer c)throws NoCustomerFoundException;
	public Customer deleteCustomerById(int userId)throws NoCustomerFoundException;
	public IncomeDetails addDetails(IncomeDetails income,int userId)throws AmountCannotBeNegativeException,NoCustomerFoundException, NoIncomeDetailsFoundException;
	public IncomeDetails findIncomeByUser(int userId)throws NoIncomeDetailsFoundException,NoCustomerFoundException;
	public IncomeDetails updateDetails(int incomeId,IncomeDetails income)throws AmountCannotBeNegativeException,NoIncomeDetailsFoundException,NoCustomerFoundException;
	public IncomeDetails deleteDetails(int incomeId)throws NoIncomeDetailsFoundException,NoCustomerFoundException;
	public List<IncomeDetails> listOfIncome();
	public List<LoanApplication> listOfLoan();
	public LoanApplication addLoan(LoanApplication loan,int userId)throws AmountCannotBeNegativeException,NoCustomerFoundException,NoLoanApplicationFoundException;
	public LoanApplication findLoanByUser(int userId)throws NoCustomerFoundException,NoLoanApplicationFoundException;
	public LoanApplication updateLoan(int applicationId,LoanApplication loan)throws NoCustomerFoundException, NoLoanApplicationFoundException,AmountCannotBeNegativeException;
	public LoanApplication deleteLoan(int applicationId) throws NoCustomerFoundException, NoLoanApplicationFoundException;
	
}

