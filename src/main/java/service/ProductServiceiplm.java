package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceiplm implements ProductService {

    private static Map<Integer, Product> listProducts;
    private static Map<Integer, Product> productBaskets = new HashMap<>();

    static {
        listProducts = new HashMap<>();
        listProducts.put(1, new Product(1, "fan", 150, "PEC"));
        listProducts.put(2, new Product(2, "air conditioning", 15000, "Samsung"));
        listProducts.put(3, new Product(3, "television", 7000, "IG"));
        listProducts.put(4, new Product(4, "I phone 6s", 12000, "apple"));
        listProducts.put(5, new Product(5, "heater", 5000, "sony"));
        listProducts.put(6, new Product(6, "hairdryer", 300, "kuro"));
        listProducts.put(7, new Product(7, "motorbike", 25000, "honda"));
        listProducts.put(8, new Product(8, "Note8", 12000, "Samsung"));
        listProducts.put(9, new Product(9, "Wardrobe", 6500, "luibo"));
        listProducts.put(10, new Product(10, "computer", 20000, "dell"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProducts.values());
    }

    @Override
    public List<Product> findBasket() {
        return new ArrayList<>(productBaskets.values());
    }

    @Override
    public void save(Product product) {
        listProducts.put(product.getId(), product);
    }

    @Override
    public void savetoBasket(Product product) {
        productBaskets.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return listProducts.get(id);
    }

    @Override
    public void remove(int id) {
        listProducts.remove(id);
    }
}
