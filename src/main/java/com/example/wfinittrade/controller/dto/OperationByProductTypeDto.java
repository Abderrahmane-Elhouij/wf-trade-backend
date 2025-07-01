package com.example.wfinittrade.controller.dto;

import java.math.BigDecimal;

public class OperationByProductTypeDto {
    private String operationProduit;
    private Long operationCount;
    private BigDecimal avgAmount;
    private BigDecimal totalAmount;

    public OperationByProductTypeDto() {}

    public OperationByProductTypeDto(String operationProduit, Long operationCount, BigDecimal avgAmount, BigDecimal totalAmount) {
        this.operationProduit = operationProduit;
        this.operationCount = operationCount;
        this.avgAmount = avgAmount;
        this.totalAmount = totalAmount;
    }

    public String getOperationProduit() {
        return operationProduit;
    }

    public void setOperationProduit(String operationProduit) {
        this.operationProduit = operationProduit;
    }

    public Long getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(Long operationCount) {
        this.operationCount = operationCount;
    }

    public BigDecimal getAvgAmount() {
        return avgAmount;
    }

    public void setAvgAmount(BigDecimal avgAmount) {
        this.avgAmount = avgAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
