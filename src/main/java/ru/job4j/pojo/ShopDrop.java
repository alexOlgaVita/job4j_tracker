package ru.job4j.pojo;

import java.util.Arrays;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        Product[] result = Arrays.copyOf(products, products.length);
        for (int i = index; i < result.length - 1; i++) {
            result[i] = result[i + 1];
        }
        result[result.length - 1] = null;
        return result;
    }
}
