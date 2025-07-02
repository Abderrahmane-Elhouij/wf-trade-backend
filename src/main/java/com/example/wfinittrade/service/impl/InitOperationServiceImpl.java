package com.example.wfinittrade.service.impl;

import com.example.wfinittrade.controller.dto.CustomerTypeDistributionDto;
import com.example.wfinittrade.controller.dto.GeographicDistributionDto;
import com.example.wfinittrade.controller.dto.OperationByProductTypeDto;
import com.example.wfinittrade.controller.dto.OperationStatusDistributionDto;
import com.example.wfinittrade.model.InitOperation;
import com.example.wfinittrade.repository.InitOperationRepository;
import com.example.wfinittrade.service.facade.InitOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private InitOperationRepository initOperationRepository;
}
