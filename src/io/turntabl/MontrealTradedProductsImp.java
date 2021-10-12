package io.turntabl;

import java.util.HashMap;
import java.util.Map;

public class MontrealTradedProductsImp implements MontrealTradedProducts{

    private static final Map<String, Product> products = new HashMap<>();
    private static final Map<Product, Integer> tradedProducts = new HashMap<>();

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if (products.containsKey(product.getId())) {
            throw new ProductAlreadyRegisteredException("Product with id "+product.getId()+" already exists");
        }
        products.put(product.getId(), product);
    }

    @Override
    public void trade(Product product, int quantity) {

        if (!products.containsKey(product.getId())) {
            return;
        }

        if (tradedProducts.containsKey(product)) {
            int previousQuantity = tradedProducts.get(product);
            tradedProducts.put(product, previousQuantity + quantity);
        }else {
            tradedProducts.put(product, quantity);
        }


    }

    @Override
    public int totalTradeQuantityForDay() {
        int totalQuantity = 0;
        for (Integer quantity : tradedProducts.values()) {
            totalQuantity += quantity;
        }

        return totalQuantity;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValue = 0;

        for (Product product : tradedProducts.keySet()) {
            totalValue += product.getPrice() * tradedProducts.get(product);
        }

        return totalValue;
    }
}
