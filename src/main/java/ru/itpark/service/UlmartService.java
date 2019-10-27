package ru.itpark.service;

import org.jetbrains.annotations.NotNull;
import ru.itpark.model.Product;
import ru.itpark.ru.itpark.repository.ProductStore;

import java.util.ArrayList;
import java.util.List;

public class UlmartService {
    private final ProductStore productStore = new ProductStore();


    public boolean addProduct(Product product) {
        return productStore.add(product);
    }

    public boolean addProductsFromList(@NotNull List<Product> productList) {
        boolean result = false;
        return productStore.addAll(productList);
    }

    public List<Product> findByName(@NotNull String name) {
        List<Product> result = new ArrayList<Product>();
        List<Product> productList = productStore.getProductList();
        if (name.isEmpty()) {
            result.addAll(productList);
            return result;
        }
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> findByCategory(@NotNull String category) {
        List<Product> result = new ArrayList<Product>();
        List<Product> productList = productStore.getProductList();
        if(category.isEmpty()){
            result.addAll(productList);
        }
        for (Product product : productList ) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }


}
