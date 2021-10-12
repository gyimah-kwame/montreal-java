package io.turntabl;

public class Main {

    public static void main(String[] args) {

        MontrealTradedProductsImp productsImp = new MontrealTradedProductsImp();

        ProductPricingServiceImp pricingServiceImp = new ProductPricingServiceImp();

        try {
            Product stock = new Stock("AL", 10.0, "TT", "TT", pricingServiceImp);

            productsImp.addNewProduct(new Stock("AL", 10.0, "TT", "TT", pricingServiceImp));

            System.out.println(stock.getPrice());

            Product future = new Future("AL", 10.0, "TT", "Code", 1, 11, pricingServiceImp);

            productsImp.addNewProduct(new Stock("AL", 10.0, "TT", "TT", pricingServiceImp));

            System.out.println(stock.getPrice());


        }catch (ProductAlreadyRegisteredException e) {
            System.out.println(e.getMessage());
        }
    }
}
