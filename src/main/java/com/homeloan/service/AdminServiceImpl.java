package com.homeloan.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.dao.AdminRepository;
import com.homeloan.dao.LoanApplicationRepository;
import com.homeloan.entity.Admin;
import com.homeloan.entity.LoanApplication;
import com.homeloan.exception.AmountCannotBeNegativeException;
import com.homeloan.exception.NoAdminFoundException;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.exception.NoLoanApplicationFoundException;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminRepository aRepo;
	
	@Autowired
	private LoanApplicationRepository lRepo;
	
	@Autowired
	CustomerServiceImpl cServ;
	
	@Transactional
	@Override
	public Admin createAdmin(Admin ad) {
		return aRepo.save(ad);
	}

	@Override
	public List<Admin> listOfAdmins() {
		List<Admin> alist=aRepo.findAll();
		return alist;
	}

	@Override
	public Admin findAdminById(int adminId) throws NoAdminFoundException {
		Optional<Admin> ad=aRepo.findById(adminId);
		if(ad.isPresent())
		{
			Admin adm=ad.get();
//			System.out.println(cust);
			return adm;
		}
		throw new NoAdminFoundException("Admin with id "+adminId+" does not exist");
	}

	@Override
	public Admin updateAdminById(int adminId, Admin a) throws NoAdminFoundException {
		Optional<Admin> ad=aRepo.findById(adminId);
		if(ad.isPresent())
		{
			Admin adm=aRepo.save(a);
//			System.out.println(cust);
			return adm;
		}
		throw new NoAdminFoundException("Admin with id "+adminId+" does not exist");
	}

	@Override
	public Admin deleteAdminById(int adminId) throws NoAdminFoundException {
		Optional<Admin> ad=aRepo.findById(adminId);
		if(ad.isPresent())
		{
			Admin adm=ad.get();
			aRepo.delete(adm);
//			System.out.println(cust);
			return adm;
		}
		throw new NoAdminFoundException("Admin with id "+adminId+" does not exist");
	}

	@Override
	public List<LoanApplication> findLoanApplications() throws NoLoanApplicationFoundException {
		List<LoanApplication> loanList=lRepo.findAll();
		return loanList;
	}

	@Override
	public LoanApplication modifyLoan(int applicationId, LoanApplication loan)
			throws NoCustomerFoundException, NoLoanApplicationFoundException, AmountCannotBeNegativeException {
		
		return cServ.updateLoan(applicationId, loan);
	}
}
