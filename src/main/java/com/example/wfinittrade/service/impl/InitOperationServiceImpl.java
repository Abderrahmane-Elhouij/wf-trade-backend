package com.example.wfinittrade.service.impl;

import com.example.wfinittrade.controller.dto.*;
import com.example.wfinittrade.model.InitOperation;
import com.example.wfinittrade.repository.InitOperationRepository;
import com.example.wfinittrade.service.facade.InitOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InitOperationServiceImpl implements InitOperationService {

    @Override
    public List<InitOperation> getAllOperations() {
        return initOperationRepository.findAll();
    }

    @Override
    public List<OperationStatusDistributionDto> getOperationStatusDistribution() {
        List<Object[]> results = initOperationRepository.findOperationStatusDistribution();
        
        List<OperationStatusDistributionDto> distributionList = new ArrayList<>();
        for (Object[] result : results) {
            String statusName = (String) result[0];
            Long operationCount = ((Number) result[1]).longValue();
            BigDecimal percentage = new BigDecimal(result[2].toString()).setScale(2, RoundingMode.HALF_UP);
            
            distributionList.add(new OperationStatusDistributionDto(statusName, operationCount, percentage));
        }
        
        return distributionList;
    }


    @Override
    public List<OperationByProductTypeDto> getOperationByProductType() {
        List<Object[]> results = initOperationRepository.findOperationByProductType();
        
        List<OperationByProductTypeDto> productTypeList = new ArrayList<>();
        for (Object[] result : results) {
            String productType = (String) result[0];
            Long count = ((Number) result[1]).longValue();
            BigDecimal avgAmount = new BigDecimal(result[2].toString()).setScale(2, RoundingMode.HALF_UP);
            BigDecimal totalAmount = new BigDecimal(result[3].toString()).setScale(2, RoundingMode.HALF_UP);
            
            productTypeList.add(new OperationByProductTypeDto(productType, count, avgAmount, totalAmount));
        }
        
        return productTypeList;
    }

    @Override
    public List<GeographicDistributionDto> getGeographicDistribution() {
        List<Object[]> results = initOperationRepository.findGeographicDistribution();
        
        List<GeographicDistributionDto> geographicList = new ArrayList<>();
        for (Object[] result : results) {
            String country = (String) result[0];
            Long count = ((Number) result[1]).longValue();
            BigDecimal totalAmount = new BigDecimal(result[2].toString()).setScale(2, RoundingMode.HALF_UP);
            
            geographicList.add(new GeographicDistributionDto(country, count, totalAmount));
        }
        
        return geographicList;
    }

    @Override
    public List<CustomerTypeDistributionDto> getCustomerTypeDistribution() {
        List<Object[]> results = initOperationRepository.findCustomerTypeDistribution();
        
        List<CustomerTypeDistributionDto> customerTypeList = new ArrayList<>();
        for (Object[] result : results) {
            String customerType = (String) result[0];
            Long count = ((Number) result[1]).longValue();
            BigDecimal avgAmount = new BigDecimal(result[2].toString()).setScale(2, RoundingMode.HALF_UP);
            
            customerTypeList.add(new CustomerTypeDistributionDto(customerType, count, avgAmount));
        }
        
        return customerTypeList;
    }

    @Override
    public List<OperationByDateValiditeDto> findByoperationByDateValidite(Integer year) {
        if (year == null || year == 0) {
            year = java.time.LocalDate.now().getYear();
        }

        List<Object[]> results = initOperationRepository.findByOperationDateValidite(year);
        List<String> allProductNames = initOperationRepository.findAllDistinctProductNames();

        Map<Integer, Map<String, OperationByDateValiditeStatsDto>> monthProductStats = new java.util.HashMap<>();
        for (Object[] result : results) {
            int month = ((Number) result[0]).intValue();
            int count_operation = ((Number) result[1]).intValue();
            String productName = (String) result[2];
            monthProductStats.computeIfAbsent(month, k -> new java.util.HashMap<>())
                .put(productName, new OperationByDateValiditeStatsDto(productName, count_operation));
        }
        List<OperationByDateValiditeDto> dtoList = new ArrayList<>();
        for (int m = 1; m <= 12; m++) {
            Map<String, OperationByDateValiditeStatsDto> statsMap = monthProductStats.getOrDefault(m, new java.util.HashMap<>());
            List<OperationByDateValiditeStatsDto> stats = new ArrayList<>();
            for (String product : allProductNames) {
                stats.add(statsMap.getOrDefault(product, new OperationByDateValiditeStatsDto(product, 0)));
            }
            dtoList.add(new OperationByDateValiditeDto(m, stats));
        }
        return dtoList;
    }

    @Autowired
    private InitOperationRepository initOperationRepository;
}
