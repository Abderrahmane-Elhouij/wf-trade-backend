package com.example.wfinittrade.controller.dto;

import java.math.BigDecimal;

public class GeographicDistributionDto {
    private String country;
    private Long operationCount;
    private BigDecimal totalAmount;

    public GeographicDistributionDto() {}

    public GeographicDistributionDto(String country, Long operationCount, BigDecimal totalAmount) {
        this.country = country;
        this.operationCount = operationCount;
        this.totalAmount = totalAmount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(Long operationCount) {
        this.operationCount = operationCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
