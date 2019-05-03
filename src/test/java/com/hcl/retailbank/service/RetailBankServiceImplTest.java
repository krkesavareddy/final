package com.hcl.retailbank.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.retailbank.entity.CustomerCreation;
import com.hcl.retailbank.repository.CustomerGetRepository;

@RunWith(MockitoJUnitRunner.class)
public class RetailBankServiceImplTest {
	
	@Mock
	CustomerGetRepository customerGetRepository;
	
	@InjectMocks
	RetailbankServiceImpl retailbankServiceImpl;
	

	static CustomerCreation customer = null;
	static CustomerCreation customer1 = new CustomerCreation();
	

	@BeforeClass
	public static void setUp(){
		 customer = new CustomerCreation();
		customer.setCustomerName("aman");
		customer.setAccountType("Credit");
		customer.setBalance(4800);
		customer1 = customer;
		
	}
	
	@Test
	public  void customerRegistrationTest() {
		when(customerGetRepository.save(customer)).thenReturn(customer1);
		String result = retailbankServiceImpl.customerRegistration(customer1);
		assertEquals("Minimum balance of 5000.00 is required to open an A/C", result);		
	}

}
