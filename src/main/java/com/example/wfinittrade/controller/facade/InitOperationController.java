package com.example.wfinittrade.controller.facade;

import com.example.wfinittrade.controller.converter.InitOperationConverter;
import com.example.wfinittrade.controller.dto.*;
import com.example.wfinittrade.service.facade.InitOperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/init-operations")
public class InitOperationController {

    private final InitOperationService initOperationService;
    private final InitOperationConverter initOperationConverter;

    public InitOperationController(InitOperationService initOperationService) {
        this.initOperationService = initOperationService;
        this.initOperationConverter = new InitOperationConverter();
    }

    @GetMapping("/")
    public List<InitOperationDto> getAllOperations() {
        return initOperationConverter.toDto(initOperationService.getAllOperations());
    }

    @GetMapping("/status-distribution")
    public List<OperationStatusDistributionDto> getOperationStatusDistribution() {
        return initOperationService.getOperationStatusDistribution();
    }

    @GetMapping("/product-type-distribution")
    public List<OperationByProductTypeDto> getOperationByProductType() {
        return initOperationService.getOperationByProductType();
    }

    @GetMapping("/geographic-distribution")
    public List<GeographicDistributionDto> getGeographicDistribution() {
        return initOperationService.getGeographicDistribution();
    }

    @GetMapping("/customer-type-distribution")
    public List<CustomerTypeDistributionDto> getCustomerTypeDistribution() {
        return initOperationService.getCustomerTypeDistribution();
    }
    @GetMapping("/Date-Validite")
    public List<OperationByDateValiditeDto> getOperationsByDateValidite(@RequestParam("year") int year) {
        return initOperationService.findByoperationByDateValidite(year);
    }}
