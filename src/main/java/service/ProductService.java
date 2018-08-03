package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    List<Product> findBasket();
    void save(Product product);
    void savetoBasket(Product product);
    Product findById(int id);
    void remove(int id);
}
