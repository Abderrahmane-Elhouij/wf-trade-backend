package com.example.wfinittrade.controller.dto;

import java.math.BigDecimal;

public class CustomerTypeDistributionDto {
    private String customerType;
    private Long operationCount;
    private BigDecimal avgAmount;

    public CustomerTypeDistributionDto() {}

    public CustomerTypeDistributionDto(String customerType, Long operationCount, BigDecimal avgAmount) {
        this.customerType = customerType;
        this.operationCount = operationCount;
        this.avgAmount = avgAmount;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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
}
