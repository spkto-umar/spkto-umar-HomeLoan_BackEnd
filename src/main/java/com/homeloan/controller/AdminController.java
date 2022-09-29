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

import com.homeloan.entity.Admin;
import com.homeloan.entity.LoanApplication;
import com.homeloan.exception.AmountCannotBeNegativeException;
import com.homeloan.exception.NoAdminFoundException;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.exception.NoLoanApplicationFoundException;
import com.homeloan.service.AdminService;

@CrossOrigin(origins="*")
@RestController
public class AdminController 
{
	@Autowired
	private AdminService aServ;
	
//	http://localhost:8091/HomeLoan/admins
	@GetMapping("/admins")
	public List<Admin> getAllAdmins()
	{
		return aServ.listOfAdmins();
	}
	
//	http://localhost:8091/HomeLoan/admins/{adminId}
	@GetMapping("/admins/{adminId}")
	public Admin getById(@PathVariable int adminId) throws NoAdminFoundException
	{
		return aServ.findAdminById(adminId);
	}
	
	@PostMapping("/admins")
	public Admin addAdmin(@RequestBody Admin a)
	{
		return aServ.createAdmin(a);
	}
	
	@PutMapping("/admins/{adminId}")
	public Admin modifyAdmin(@PathVariable("adminId")int adminId,@RequestBody Admin a ) throws NoAdminFoundException
	{
		return aServ.updateAdminById(adminId,a);
	}
	
	@DeleteMapping("/admins/{adminId}")
	public Admin removeAdmin(@PathVariable("adminId")int adminId) throws NoAdminFoundException
	{
		return aServ.deleteAdminById(adminId);
	}
	

//	http://localhost:8091/HomeLoan/admin/loanapplications
	@GetMapping("/admin/loanapplications")
	public List<LoanApplication> getLoanApplications() throws NoLoanApplicationFoundException
	{
		return aServ.findLoanApplications();
	}
	
//	http://localhost:8091/HomeLoan/admin/loanapplications/{applicationId}
		@PutMapping("/admin/loanapplications/{applicationId}")
		public LoanApplication modifyLoanDetails(@RequestBody LoanApplication loan,@PathVariable int applicationId) throws AmountCannotBeNegativeException, NoCustomerFoundException, NoLoanApplicationFoundException
		{
			return aServ.modifyLoan(applicationId, loan);
		}
}
