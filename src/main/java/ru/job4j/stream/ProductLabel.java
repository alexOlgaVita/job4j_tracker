package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.getStandard() - product.getActual() < 4)
                .filter(product -> product.getStandard() - product.getActual() >= 0)
                .map(product -> new Label(product.getName(), (float) (product.getPrice() * 0.5)))
                .map(Label::toString)
                .collect(Collectors.toList());
    }
}
