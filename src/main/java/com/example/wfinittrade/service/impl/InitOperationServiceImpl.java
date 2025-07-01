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
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InitOperationServiceImpl implements InitOperationService {

    @Autowired
    private InitOperationRepository initOperationRepository;


    @Override
    public List<InitOperation> getAllOperations() {
        return initOperationRepository.findAll();
    }

    @Override
    public List<OperationStatusDistributionDto> getOperationStatusDistribution() {
        List<InitOperation> operations = initOperationRepository.findAll();
        long totalOperations = operations.size();
        return operations.stream()
                .filter(op -> op.getStatut() != null && op.getStatut().getLibelle() != null)
                .collect(Collectors.groupingBy(op -> op.getStatut().getLibelle(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> {
                    double percentage = (double) entry.getValue() * 100 / totalOperations;
                    return new OperationStatusDistributionDto(entry.getKey(), entry.getValue(), BigDecimal.valueOf(percentage).setScale(2, RoundingMode.HALF_UP));
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<OperationByProductTypeDto> getOperationByProductType() {
        List<InitOperation> operations = initOperationRepository.findAll();
        return operations.stream()
                .filter(op -> op.getOperationProduit() != null)
                .collect(Collectors.groupingBy(InitOperation::getOperationProduit))
                .entrySet().stream()
                .map(entry -> {
                    String productType = entry.getKey();
                    List<InitOperation> ops = entry.getValue();
                    long count = ops.size();
                    double avgAmount = ops.stream().mapToDouble(op -> op.getOperationMontant().doubleValue()).average().orElse(0.0);
                    double totalAmount = ops.stream().mapToDouble(op -> op.getOperationMontant().doubleValue()).sum();
                    return new OperationByProductTypeDto(productType, count, BigDecimal.valueOf(avgAmount).setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP));
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<GeographicDistributionDto> getGeographicDistribution() {
        List<InitOperation> operations = initOperationRepository.findAll();
        return operations.stream()
                .filter(op -> op.getBeneficiairePays() != null)
                .collect(Collectors.groupingBy(InitOperation::getBeneficiairePays))
                .entrySet().stream()
                .map(entry -> {
                    String country = entry.getKey();
                    List<InitOperation> ops = entry.getValue();
                    long count = ops.size();
                    double totalAmount = ops.stream().mapToDouble(op -> op.getOperationMontant().doubleValue()).sum();
                    return new GeographicDistributionDto(country, count, BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP));
                })
                .sorted((a, b) -> Long.compare(b.getOperationCount(), a.getOperationCount()))
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerTypeDistributionDto> getCustomerTypeDistribution() {
        List<InitOperation> operations = initOperationRepository.findAll();
        return operations.stream()
                .collect(Collectors.groupingBy(op -> op.getDonneurOrdreVip() != null && op.getDonneurOrdreVip() ? "VIP" : "Regular"))
                .entrySet().stream()
                .map(entry -> {
                    String customerType = entry.getKey();
                    List<InitOperation> ops = entry.getValue();
                    long count = ops.size();
                    double avgAmount = ops.stream().mapToDouble(op -> op.getOperationMontant().doubleValue()).average().orElse(0.0);
                    return new CustomerTypeDistributionDto(customerType, count, BigDecimal.valueOf(avgAmount).setScale(2, RoundingMode.HALF_UP));
                })
                .collect(Collectors.toList());
    }
}
