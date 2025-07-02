package com.example.wfinittrade.service.facade;

import com.example.wfinittrade.controller.dto.*;
import com.example.wfinittrade.model.InitOperation;

import java.util.List;

public interface InitOperationService {

    List<InitOperation> getAllOperations();

    List<OperationStatusDistributionDto> getOperationStatusDistribution();

    List<OperationByProductTypeDto> getOperationByProductType();

    List<GeographicDistributionDto> getGeographicDistribution();

    List<CustomerTypeDistributionDto> getCustomerTypeDistribution();

    List<OperationByDateValiditeDto> findByoperationByDateValidite(int year);
}
