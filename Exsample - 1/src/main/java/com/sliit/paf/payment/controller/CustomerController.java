package com.sliit.paf.payment.controller;

import com.sliit.paf.payment.dto.CustomerDTO;
import com.sliit.paf.payment.service.custom.ManageCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private ManageCustomersService customersService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAllCustomers(){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssss");
        List<CustomerDTO> customers = customersService.getCustomers();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",customers.size() + "");
        System.out.println(customers);
        return new ResponseEntity<List<CustomerDTO>>(customers,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/{id:C\\d{3}}")
    public CustomerDTO findCustomer(@PathVariable("id") String cId){
        CustomerDTO customer = customersService.findCustomer(cId);
        return customer;
    }

    @DeleteMapping("/{id:C\\d{3}}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") String cId){
       customersService.deleteCustomer(cId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customersService.createCustomer(customerDTO);
        return customerDTO.getId();
    }

    @PutMapping(value = "/{id:C\\d{3}}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@PathVariable("id") String cId, @RequestBody CustomerDTO customerDTO){
       if (cId.equals(customerDTO.getId())){
           customersService.updateCustomer(customerDTO);
           return new ResponseEntity(HttpStatus.OK);
       }else {
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    }

}
