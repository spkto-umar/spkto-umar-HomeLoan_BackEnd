package com.homeloan.service;

import java.util.List;

import com.homeloan.entity.Admin;
import com.homeloan.entity.LoanApplication;
import com.homeloan.exception.AmountCannotBeNegativeException;
import com.homeloan.exception.NoAdminFoundException;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.exception.NoLoanApplicationFoundException;

public interface AdminService 
{
	public Admin createAdmin(Admin ad);
	public List<Admin> listOfAdmins();
	public Admin findAdminById(int adminId)throws NoAdminFoundException;
	public Admin updateAdminById(int adminId,Admin ad)throws NoAdminFoundException;
	public Admin deleteAdminById(int adminId)throws NoAdminFoundException;
	public List<LoanApplication> findLoanApplications()throws NoLoanApplicationFoundException;
	public LoanApplication modifyLoan(int applicationId,LoanApplication loan) throws NoCustomerFoundException, NoLoanApplicationFoundException, AmountCannotBeNegativeException;
}
