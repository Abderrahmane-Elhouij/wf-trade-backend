package com.example.wfinittrade.service.facade;

import com.example.wfinittrade.controller.dto.CustomerTypeDistributionDto;
import com.example.wfinittrade.controller.dto.GeographicDistributionDto;
import com.example.wfinittrade.controller.dto.OperationByProductTypeDto;
import com.example.wfinittrade.controller.dto.OperationStatusDistributionDto;
import com.example.wfinittrade.model.InitOperation;

import java.util.List;

public interface InitOperationService {

    List<InitOperation> getAllOperations();

    List<OperationStatusDistributionDto> getOperationStatusDistribution();

    List<OperationByProductTypeDto> getOperationByProductType();

    List<GeographicDistributionDto> getGeographicDistribution();

    List<CustomerTypeDistributionDto> getCustomerTypeDistribution();
}
