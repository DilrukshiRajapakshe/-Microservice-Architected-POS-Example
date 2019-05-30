package com.sliit.paf.payment.service.custom.impl;

import com.sliit.paf.payment.dto.CustomerDTO;
import com.sliit.paf.payment.repository.custom.CustomerRepository;
import com.sliit.paf.payment.service.Converter;
import com.sliit.paf.payment.service.custom.ManageCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Transactional
public class ManageCustomersServiceImpl implements ManageCustomersService {

    private CustomerRepository customerDAO;

    @Autowired
    public ManageCustomersServiceImpl(CustomerRepository customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> getCustomers(){
        return customerDAO.findAll().map(Converter::<CustomerDTO>getDTOList).get();
    }

    public void createCustomer(CustomerDTO dto) {

        customerDAO.save(Converter.getEntity(dto));
    }

    public void updateCustomer(CustomerDTO dto) {
        customerDAO.update(Converter.getEntity(dto));
    }

    public void deleteCustomer(String customerID) {
        customerDAO.delete(customerID);
    }

    public CustomerDTO findCustomer(String id){
        return customerDAO.find(id).map(Converter::<CustomerDTO>getDTO).orElse(null);
    }

}
