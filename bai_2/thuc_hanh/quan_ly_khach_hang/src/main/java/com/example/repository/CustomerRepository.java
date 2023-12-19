package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> list = new ArrayList<>();

    static {
        list.add(new Customer(1, "Tuan", "Tuan@gmail.com", "Da Nang"));
        list.add(new Customer(2, "Tran Anh Tuan", "Tuan@gmail.com", "Da Nang"));
        list.add(new Customer(3, "Do", "Do@gmail.com", "Da Nang"));
    }

    @Override
    public List<Customer> getList() {
        return list;
    }

    @Override
    public Customer info(int id) {
        for (Customer customer : list) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
