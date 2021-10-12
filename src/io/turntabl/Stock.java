package io.turntabl;

public class Stock extends Product{

    private String ticker;
    private String exchange;
    private ProductPricingService productPricingService;

    public Stock(String id, double price, String ticker, String exchange, ProductPricingService productPricingService) {
        super(id, price);
        this.exchange = exchange;
        this.ticker = ticker;
        this.productPricingService = productPricingService;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @Override
    public double getPrice() {
        return productPricingService.price(exchange, ticker);
    }
}
