package com.example.wfinittrade.controller.dto;

import java.math.BigDecimal;

public class OperationStatusDistributionDto {
    private String statusName;
    private Long operationCount;
    private BigDecimal percentage;

    public OperationStatusDistributionDto() {}

    public OperationStatusDistributionDto(String statusName, Long operationCount, BigDecimal percentage) {
        this.statusName = statusName;
        this.operationCount = operationCount;
        this.percentage = percentage;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Long getOperationCount() {
        return operationCount;
    }

    public void setOperationCount(Long operationCount) {
        this.operationCount = operationCount;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}
