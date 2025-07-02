package com.example.wfinittrade.controller.dto;

import java.util.List;

public class OperationByDateValiditeDto {
    private int month ;
    private List<OperationByDateValiditeStatsDto> stats;

    public OperationByDateValiditeDto(int month, List<OperationByDateValiditeStatsDto> stats) {
        this.month = month;
        this.stats = stats;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<OperationByDateValiditeStatsDto> getStats() {
        return stats;
    }

    public void setStats(List<OperationByDateValiditeStatsDto> stats) {
        this.stats = stats;
    }
}
