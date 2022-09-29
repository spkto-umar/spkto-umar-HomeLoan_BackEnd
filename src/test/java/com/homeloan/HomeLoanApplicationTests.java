package com.homeloan;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.homeloan.dao.AdminRepository;
import com.homeloan.dao.CustomerRepository;
import com.homeloan.entity.Admin;
import com.homeloan.entity.Customer;
import com.homeloan.entity.IncomeDetails;
import com.homeloan.entity.LoanApplication;
import com.homeloan.exception.NoCustomerFoundException;
import com.homeloan.service.AdminService;
import com.homeloan.service.CustomerService;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class HomeLoanApplicationTests {
	
	@Autowired
	CustomerService customerser;
	
	@Autowired
	AdminService adminser;
	
	@MockBean
	CustomerRepository customerRepo;

	@MockBean
	AdminRepository adminRepo; 
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testlistOfCustomers()  {		
		Customer c1=new Customer();
		  c1.setUserId(10002);
		  c1.setEmail("pramod@gmail");
		    c1.setPassword("725001365");
		    c1.setMiddleName(null);
		    c1.setFirstName(null);
		    c1.setLastName(null);
		    c1.setPhone(null);
		    c1.setDob("11/05/2580");
		    c1.setGender("male");
		    c1.setNationality("aus");
		    c1.setAadharNo( (long) 75916);
		    c1.setPanNo( "759861");
			c1.setIncome(null);
			c1.setLoan(null);
	
          List<Customer> custList = new ArrayList<>();
		
          custList.add(c1);
		
		Mockito.when(customerRepo.findAll()).thenReturn(custList);
		assertThat(customerser.listOfCustomers()).isEqualTo(custList);
		
	}
	
	@Test
	void testlistOfAdmins()   {		
		Admin a1=new Admin();
		  a1.setAdminId(10012);
		  a1.setPassword("nit@123");
		  a1.setUsername("nithish");
	
          List<Admin> adminList = new ArrayList<>();
		
          adminList.add(a1);
		
		Mockito.when(adminRepo.findAll()).thenReturn(adminList);
		assertThat(adminser.listOfAdmins()).isEqualTo(adminList);
		
	}
	
	
//	@Test
//	void updateCustomerById() throws NoCustomerFoundException {
//
//			Customer cnew = new Customer(10014,"gdtue@gmail.com","1234","raj","tom","ram",45885l,"20/25/1547","male","ind",7484l,"54892012",null,null);
//		
//			Optional<Customer> c = Optional.of(new Customer());
//			Customer cust = new Customer();
//			
//			LoanApplication l = new LoanApplication();
//			l.setApplicationId(101);
//			l.setInterest(1020);
//			
//			IncomeDetails i = new IncomeDetails();
//			i.setIncomeId(501);
//			i.setOrganization("lti");
//			
//		    cust.setUserId(10014);
//		  cust.setEmail("pramod@gmail.com");
//		    cust.setPassword("8798856");
//		    cust.setLoan(l);
//		    cust.setIncome(i);
//		    
//		    cust.setMiddleName("arjun");
//		    cust.setFirstName("tommy");
//
//		    cust.setLastName("shakti");
//		    cust.setPhone((long) 85203);
//		    cust.setDob("25/07/2852");
//		    cust.setGender("male");
//		    cust.setNationality("aus");
//		    cust.setAadharNo( (long) 79856);
//		    cust.setPanNo( "421103");
//			
////		    Mockito.when(customerRepo.findById(10014)).thenReturn(c);
//			Customer actualresult =  customerser.updateCustomerById(10014,cust);
//			System.out.println(actualresult);
//			assertNotNull(actualresult);
//		}
//	

	@Test
	void deleteCustomerById() throws NoCustomerFoundException {

		Customer actualresult = null ;
		try {
			actualresult = customerser.deleteCustomerById(10014);
		}
		catch(NoCustomerFoundException e) {
			System.out.println(e.getMessage());
			
			
		}
		finally {
			assertNull(actualresult);
		}
		
		
	}
		
		

}
