package com.flikart.inventory_service.dto;

public class InventoryResponseDto {

    private String skuCode;
    private boolean isProductInStock;

    public InventoryResponseDto(String skuCode, boolean isProductInStock) {
        this.skuCode = skuCode;
        this.isProductInStock = isProductInStock;
    }

    public InventoryResponseDto() {
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public boolean isProductInStock() {
        return isProductInStock;
    }

    public void setProductInStock(boolean productInStock) {
        isProductInStock = productInStock;
    }
}
