package br.com.ericklara.pianosws.domain.entity;


import br.com.ericklara.pianosws.infra.enums.ProductType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String productName;
    private BigDecimal price;
    private Integer quantityInStock;
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

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


    public static final class Builder {
        private String productName;
        private BigDecimal price;
        private Integer quantityInStock;
        private ProductType productType;

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withQuantityInStock(Integer quantityInStock) {
            this.quantityInStock = quantityInStock;
            return this;
        }

        public Builder withProductType(ProductType productType) {
            this.productType = productType;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setProductName(productName);
            product.setPrice(price);
            product.setQuantityInStock(quantityInStock);
            product.setProductType(productType);
            return product;
        }
    }
}
