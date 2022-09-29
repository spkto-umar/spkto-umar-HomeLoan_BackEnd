package com.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.entity.Customer;
import com.homeloan.entity.IncomeDetails;
import com.homeloan.entity.LoanApplication;
import com.homeloan.exception.AmountCannotBeNegativeException;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.exception.NoIncomeDetailsFoundException;
import com.homeloan.exception.NoLoanApplicationFoundException;
import com.homeloan.service.CustomerService;

@CrossOrigin(origins="*")
@RestController
public class CustomerController
{
	@Autowired
	private CustomerService cServ;
	
//	http://localhost:8091/HomeLoan/userlogin
	@PostMapping("/userlogin")
	public Customer userlogin(@RequestBody Customer c)
	{
		return cServ.loginProcess(c);
	}
	
//	http://localhost:8091/HomeLoan/customers
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return cServ.listOfCustomers();
	}
	
//	http://localhost:8091/HomeLoan/customers/{userId}
	@GetMapping("/customers/{userId}")
	public Customer getCustomerById(@PathVariable int userId) throws NoCustomerFoundException
	{
		return cServ.findCustomerById(userId);
	}
	
//	http://localhost:8091/HomeLoan/customers
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer c)
	{
		return cServ.createCustomer(c);
	}
	
//	http://localhost:8091/HomeLoan/customers/{userId}
	@PutMapping("/customers/{userId}")
	public Customer modifyCustomer(@PathVariable("userId")int userId,@RequestBody Customer c ) throws NoCustomerFoundException
	{
		return cServ.updateCustomerById(userId,c);
	}
	
//	http://localhost:8091/HomeLoan/customers/{userId}
	@DeleteMapping("/customers/{userId}")
	public Customer removeCustomer(@PathVariable("userId")int userId) throws NoCustomerFoundException
	{
		return cServ.deleteCustomerById(userId);
	}
	
//	http://localhost:8091/HomeLoan/incomedetails/{userId}
	@PostMapping("/incomedetails/{userId}")
	public IncomeDetails addIncomeDetails(@RequestBody IncomeDetails income,@PathVariable int userId)throws AmountCannotBeNegativeException,NoCustomerFoundException, NoIncomeDetailsFoundException
	{
		//System.out.println(income);
		return cServ.addDetails(income, userId);
	}

//	http://localhost:8091/HomeLoan/incomedetails/{userId}
	@GetMapping("/incomedetails/{userId}")
	public IncomeDetails getIncomeByUser(@PathVariable int userId) throws NoIncomeDetailsFoundException, NoCustomerFoundException
	{
		return cServ.findIncomeByUser(userId);
	}
	
//	http://localhost:8091/HomeLoan/incomedetails/{incomeId}
	@PutMapping("/incomedetails/{incomeId}")
	public IncomeDetails modifyIncome(@RequestBody IncomeDetails income,@PathVariable int incomeId) throws AmountCannotBeNegativeException, NoIncomeDetailsFoundException, NoCustomerFoundException
	{
		return cServ.updateDetails(incomeId,income);
	}
	
//	http://localhost:8091/HomeLoan/incomedetails/{incomeId}
	@DeleteMapping("/incomedetails/{incomeId}")
	public IncomeDetails removeIncome(@PathVariable int incomeId) throws NoIncomeDetailsFoundException, NoCustomerFoundException
	{
		return cServ.deleteDetails(incomeId);
	}
	
//	http://localhost:8091/HomeLoan/incomedetails
	@GetMapping("/incomedetails")
	public List<IncomeDetails> getAllIncome()
	{
		return cServ.listOfIncome();
	}
	
//	http://localhost:8091/HomeLoan/loan
	@GetMapping("/loan")
	public List<LoanApplication> getAllLoan()
	{
		return cServ.listOfLoan();
	}
	
//	http://localhost:8091/HomeLoan/loan/{userId}
	@PostMapping("/loan/{userId}")
	public LoanApplication addLoanDetails(@RequestBody LoanApplication loan,@PathVariable int userId) throws AmountCannotBeNegativeException, NoCustomerFoundException, NoLoanApplicationFoundException
	{
		return cServ.addLoan(loan, userId);
	}
	
//	http://localhost:8091/HomeLoan/loan/{userId}
	@GetMapping("loan/{userId}")
	public LoanApplication getLoanByUser(@PathVariable int userId) throws NoCustomerFoundException, NoLoanApplicationFoundException
	{
		return cServ.findLoanByUser(userId);
	}
	
//	http://localhost:8091/HomeLoan/loan/{applicationId}
	@PutMapping("/loan/{applicationId}")
	public LoanApplication modifyLoanDetails(@RequestBody LoanApplication loan,@PathVariable int applicationId) throws AmountCannotBeNegativeException, NoCustomerFoundException, NoLoanApplicationFoundException
	{
		return cServ.updateLoan(applicationId, loan);
	}
	
//	http://localhost:8091/HomeLoan/loan/{applicationId}
	@DeleteMapping("loan/{applicationId}")
	public LoanApplication removeLoanByUser(@PathVariable int applicationId) throws NoCustomerFoundException, NoLoanApplicationFoundException
	{
		return cServ.deleteLoan(applicationId);
	}
}
