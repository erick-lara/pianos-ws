package br.com.ericklara.pianosws.domain.dto;

import br.com.ericklara.pianosws.infra.enums.ProductType;

import java.math.BigDecimal;

public class ProductDTO {

    private String productName;
    private BigDecimal price;
    private Integer quantityInStock;
    private ProductType productType;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
