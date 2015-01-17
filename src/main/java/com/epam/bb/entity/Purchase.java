package com.epam.bb.entity;

import java.util.List;

public class Purchase {
    private List<Product> boughtProducts;

    public void add(Product product) {
        boughtProducts.add(product);
    }

}
