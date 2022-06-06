package spring.restdocs.ui.dto;

public class ProductResponse {

    private final Long id;
    private final String name;
    private final Integer price;
    private final String priceUnit;

    public ProductResponse(Long id, String name, Integer price, String priceUnit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceUnit = priceUnit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }
}
