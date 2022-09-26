package com.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.entity.Customer;
import com.homeloan.entity.IncomeDetails;
import com.homeloan.exception.AmountCannotBeNegativeException;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.exception.NoIncomeDetailsFoundException;
import com.homeloan.service.CustomerService;

@RestController
public class CustomerController
{
	@Autowired
	private CustomerService cServ;
	
	@PostMapping("/userlogin")
	public Customer userlogin(@RequestBody Customer c)
	{
		return cServ.loginProcess(c);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return cServ.listOfCustomers();
	}
	
	@GetMapping("/customers/{userID}")
	public Customer getCustomerById(@PathVariable int userID) throws NoCustomerFoundException
	{
		return cServ.findCustomerById(userID);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer c)
	{
		return cServ.createCustomer(c);
	}
	
	@PutMapping("/customers/{userID}")
	public Customer modifyCustomer(@PathVariable("userID")int userID,@RequestBody Customer c ) throws NoCustomerFoundException
	{
		return cServ.updateCustomerById(userID,c);
	}
	
	@DeleteMapping("/customers/{userID}")
	public Customer removeCustomer(@PathVariable("userID")int userID) throws NoCustomerFoundException
	{
		return cServ.deleteCustomerById(userID);
	}
	
	@PostMapping("/incomedetails/{userId}")
	public IncomeDetails addIncomeDetails(@RequestBody IncomeDetails income,@PathVariable int userId)throws AmountCannotBeNegativeException,NoCustomerFoundException, NoIncomeDetailsFoundException
	{
		return cServ.addDetails(income, userId);
	}
	
	@GetMapping("/incomedetails/{userId}")
	public IncomeDetails getIncomeById(@PathVariable int userId) throws NoIncomeDetailsFoundException, NoCustomerFoundException
	{
		return cServ.findIncomeById(userId);
	}
	
	@PutMapping("/incomedetails/{incomeId}")
	public IncomeDetails modifyIncome(@RequestBody IncomeDetails income,@PathVariable int incomeId) throws AmountCannotBeNegativeException, NoIncomeDetailsFoundException, NoCustomerFoundException
	{
		return cServ.updateDetails(incomeId,income);
	}
	
	@DeleteMapping("/incomedetails/{incomeId}")
	public IncomeDetails removeIncome(@PathVariable int incomeId) throws NoIncomeDetailsFoundException, NoCustomerFoundException
	{
		return cServ.deleteDetails(incomeId);
	}
}
