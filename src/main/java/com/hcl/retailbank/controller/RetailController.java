package com.hcl.retailbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailbank.entity.Admin;
import com.hcl.retailbank.entity.CustomerCreation;
import com.hcl.retailbank.pojo.Response;
import com.hcl.retailbank.service.AdminService;
import com.hcl.retailbank.service.RetailbankService;

@RestController
@RequestMapping("/retailbanking")
public class RetailController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	RetailbankService retailbankService;

	@PostMapping("/adminlogin")
	public Response adminLogin(@RequestParam String userName, @RequestParam String password) {
		Admin admin = adminService.fetchAdminDetails(userName, password);
		if (admin == null) {
			return new Response("UserName and Password is not correct", Boolean.FALSE);

		} else if (admin.getUserName().equals(userName) && admin.getPassword().equals(password)) {

			return new Response(userName + " Logged-in Successfully ", Boolean.TRUE);
		}
		return null;
	}

	   @PostMapping("/customerregistration")
		public String customerRegistration(@RequestBody CustomerCreation customer){
		  String message =  retailbankService.customerRegistration(customer);
		 return message;
		}
}
