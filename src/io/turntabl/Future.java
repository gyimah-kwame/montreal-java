package io.turntabl;

public class Future  extends Product{

    private String exchange, contractCode;
    private int year, month;
    private ProductPricingService productPricingService;

    public Future(String id, double price, String exchange, String contractCode, int year, int month, ProductPricingService productPricingService) {
        super(id, price);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.year = year;
        this.month = month;
        this.productPricingService = productPricingService;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public double getPrice() {
        return productPricingService.price(exchange, contractCode, month, year);
    }
}
