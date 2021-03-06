package com.iiitb.spe.market_place_v1.Customer;

import com.iiitb.spe.market_place_v1.Order.Order;
import com.iiitb.spe.market_place_v1.Order.OrderService;
import com.iiitb.spe.market_place_v1.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderService orderService;

    public Customer addCustomer(Customer c) {
        return customerRepo.save(c);
    }

    public Customer updateCustomer(Customer c) {

        return customerRepo.save(c);
    }

    public Customer fetchCustomer(int id) {
        return customerRepo.findById(id).orElse(null);
    }

    public void deletecustomer(Customer existingCustomer) {
        customerRepo.delete(existingCustomer);
    }

    public Customer fetchOrderList(int id) {
        return customerRepo.fetchOrders(id).orElse(null);
    }

    public Customer fetchbyUsername(String uname) {
        return customerRepo.findByUsername(uname).orElse(null);
    }

    public List<Customer> getallCustomers() {
        List<Customer> result = new ArrayList<Customer>();
        customerRepo.findAll().forEach(result::add);
        return result;
    }
    public Order fetchOrderById(int oid) {

        Order order = orderService.fetchOrderById(oid);
        return order;
    }
}


