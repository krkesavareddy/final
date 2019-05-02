package com.hcl.retailbank.repository;


import org.springframework.data.repository.CrudRepository;

import com.hcl.retailbank.pojo.CustomerViewHistory;


public interface CustomerViewHistoryRepository  extends CrudRepository<CustomerViewHistory,Integer> {
}
