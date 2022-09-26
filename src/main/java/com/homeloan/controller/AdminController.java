package com.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.homeloan.entity.Admin;
import com.homeloan.exception.NoAdminFoundException;
import com.homeloan.service.AdminService;

public class AdminController 
{
	@Autowired
	private AdminService aServ;
	
	@GetMapping("/admins")
	public List<Admin> getAllAdmins()
	{
		return aServ.listOfAdmins();
	}
	
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
}
