package com.sliit.paf.payment.repository.custom.impl;

import com.sliit.paf.payment.entity.Customer;
import com.sliit.paf.payment.repository.CrudRepositoryImpl;
import com.sliit.paf.payment.repository.custom.CustomerRepository;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerRepositoryImpl extends CrudRepositoryImpl<Customer, String> implements CustomerRepository {

}
