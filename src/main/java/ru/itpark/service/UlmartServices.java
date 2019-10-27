package ru.itpark.service;

import org.jetbrains.annotations.NotNull;
import ru.itpark.model.Product;

import java.util.ArrayList;
import java.util.List;

public class UlmartServices {

    public static void sortByPriceAsc(@NotNull List<Product> productList) {
        productList.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
    }

    public static void sortByPriceDesc(@NotNull List<Product> productList) {
        productList.sort((o1, o2) -> -(o1.getPrice() - o2.getPrice()));
    }

    public static void sortByRating(@NotNull List<Product> productList) {
        productList.sort((o1, o2) -> -(o1.getRating() - o2.getRating()));
    }

    public static void sortByName(@NotNull List<Product> productList) {
        productList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    @NotNull
    public static List<Product> paginate(@NotNull List<Product> productList, int pageNum, int productPerPage) {
        List<Product> pageList = new ArrayList<Product>();
        if (!productList.isEmpty() && productList.size() > (pageNum - 1) * productPerPage) {
            int maxIndex = Math.min(productList.size() - 1, pageNum * productPerPage);
            int minIndex = Math.max(0, (pageNum - 1) * productPerPage);
            pageList.addAll(productList.subList(minIndex, maxIndex));
        }
        return pageList;
    }


}
