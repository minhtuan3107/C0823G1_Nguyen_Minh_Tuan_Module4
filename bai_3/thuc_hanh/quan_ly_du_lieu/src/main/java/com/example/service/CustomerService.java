package com.example.service;

import com.example.model.Customer;
import com.example.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getList() {
        return customerRepository.getList();
    }

    @Override
    public Customer info(int id) {
        return customerRepository.info(id);
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }

    @Override
    public boolean remove(int id) {
        return customerRepository.remove(id);
    }
}
