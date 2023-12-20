package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Minh Tuan", "MinhTuan@gmail.com", "Da Nang"));
        customerList.add(new Customer(2, "Do", "MinhTuan@gmail.com", "Da Nang"));
        customerList.add(new Customer(3, "Khoa", "MinhTuan@gmail.com", "Da Nang"));
        customerList.add(new Customer(4, "Toai", "MinhTuan@gmail.com", "Da Nang"));
        customerList.add(new Customer(5, "Anh Tuan", "MinhTuan@gmail.com", "Da Nang"));
    }

    @Override
    public List<Customer> getList() {
        return customerList;
    }

    @Override
    public Customer info(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void edit(Customer customer) {
        for (Customer customer1 : customerList) {
            if (customer1.getId() == customer.getId()) {
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAddress(customer.getAddress());
                break;
            }
        }
    }

    @Override
    public boolean remove(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                customerList.remove(customer);
                return true;
            }
        }
        return false;
    }
}
