package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        Product[] result = new Product[products.length];
        for (int i = 0; i < products.length; i++) {
            if (i < index) {
                result[i] = products[i];
            } else if (i == products.length - 1) {
                result[result.length - 1] = null;
            } else {
                result[i] = products[i + 1];
            }
        }
        return result;
    }
}
