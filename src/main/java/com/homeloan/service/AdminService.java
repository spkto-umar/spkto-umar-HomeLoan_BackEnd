package com.homeloan.service;

import java.util.List;

import com.homeloan.entity.Admin;
import com.homeloan.exception.NoAdminFoundException;

public interface AdminService 
{
	public Admin createAdmin(Admin ad);
	public List<Admin> listOfAdmins();
	public Admin findAdminById(int adminId)throws NoAdminFoundException;
	public Admin updateAdminById(int adminId,Admin ad)throws NoAdminFoundException;
	public Admin deleteAdminById(int adminId)throws NoAdminFoundException;
}
