package com.example.wfinittrade.controller.dto;

public class OperationByDateValiditeStatsDto {
    private String productName;
    private int count_operation;

    public OperationByDateValiditeStatsDto(String productName, int count_operation) {
        this.productName = productName;
        this.count_operation = count_operation;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount_operation() {
        return count_operation;
    }

    public void setCount_operation(int count_operation) {
        this.count_operation = count_operation;
    }
}
