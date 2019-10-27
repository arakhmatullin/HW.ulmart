package ru.itpark.ru.itpark.repository;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ProductStore {
    private final List<ProductStoreElement> productList = new ArrayList<>();
    private int nextId = 1;

    public boolean add(@NotNull ProductStoreElement product) {
        product.setId(nextId++);
        return productList.add(product);
    }

    public boolean addAll(@NotNull List<? extends ProductStoreElement> productList) {
        boolean result = false;
        for (ProductStoreElement product : productList) {
            result |= add(product);
        }
        return result;
    }

    public boolean remove(int id) {
        return productList.removeIf(o -> o.getId() == id);
    }

    public List getProductList() {
        return productList;
    }

}
