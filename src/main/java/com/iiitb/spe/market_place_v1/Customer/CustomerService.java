package com.iiitb.spe.market_place_v1.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomer(Customer c){
        return customerRepo.save(c);
    }

    public Customer updateCustomer(Customer c){
        return customerRepo.save(c);
    }
    public Customer fetchCustomer(int id){
        return customerRepo.findById(id).orElse(null);
    }
    public void deletecustomer(Customer existingCustomer){
        customerRepo.delete(existingCustomer);
    }
    public Customer fetchOrderList(int id){
        return customerRepo.fetchOrders(id);
    }
}
