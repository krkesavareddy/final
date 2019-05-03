package com.hcl.retailbank.service;

import com.hcl.retailbank.entity.Admin;

public interface AdminService {

	Admin fetchAdminDetails(String userName, String password);

}
