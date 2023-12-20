package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Dao", 30000, "Dao", "Viet Nam"));
        list.add(new Product(2, "Bua", 40000, "Bua", "Viet Nam"));
        list.add(new Product(3, "Keo", 50000, "Keo", "Viet Nam"));
        list.add(new Product(4, "Bao", 1000, "Bao ni long", "Viet Nam"));
    }

    @Override
    public List<Product> getList() {
        return list;
    }

    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public void edit(Product product) {
        for (Product product1 : list) {
            if (product.getId() == product1.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDes(product.getDes());
                product1.setProducer(product.getProducer());
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                list.remove(product);
                break;
            }
        }
    }

    @Override
    public Product info(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> list1 = new ArrayList<>();
        for (Product product : list) {
            if (product.getName().contains(name)) {
                list1.add(product);
            }
        }
        return list1;
    }
}
