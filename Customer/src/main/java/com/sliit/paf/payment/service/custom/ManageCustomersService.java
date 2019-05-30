package com.sliit.paf.payment.service.custom;



import com.sliit.paf.payment.dto.CustomerDTO;
import com.sliit.paf.payment.service.SuperService;

import java.util.List;

public interface ManageCustomersService extends SuperService {

    List<CustomerDTO> getCustomers();

    void createCustomer(CustomerDTO dto);

    void updateCustomer(CustomerDTO dto);

    void deleteCustomer(String customerID);

    CustomerDTO findCustomer(String id);


}
