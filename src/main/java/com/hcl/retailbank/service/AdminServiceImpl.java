package com.hcl.retailbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.retailbank.entity.Admin;
import com.hcl.retailbank.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin fetchAdminDetails(String userName, String password) {
		Admin admin = adminRepository.findByUserNameAndPassword(userName, password);
		return admin;
	}

}
