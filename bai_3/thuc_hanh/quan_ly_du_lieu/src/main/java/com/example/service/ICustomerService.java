package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getList();

    Customer info(int id);

    void add(Customer customer);

    void edit(Customer customer);

    boolean remove(int id);
}
