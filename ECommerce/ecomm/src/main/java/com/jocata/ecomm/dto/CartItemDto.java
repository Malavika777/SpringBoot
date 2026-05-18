package com.jocata.ecomm.dto;

import com.jocata.ecomm.entity.CartItem;
import com.jocata.ecomm.entity.Product;

public class CartItemDto {

    private Long id;
    private ProductDto product;
    private int quantity;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ProductDto getProduct() {
        return product;
    }
    public void setProduct(ProductDto product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
