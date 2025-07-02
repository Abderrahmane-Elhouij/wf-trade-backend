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

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InitOperationServiceImpl implements InitOperationService {

    @Override
    public List<InitOperation> getAllOperations() {
        return initOperationRepository.findAll();
    }

    @Override
    public List<OperationStatusDistributionDto> getOperationStatusDistribution() {
        String sql = """
            SELECT 
                s.libelle as status_name,
                COUNT(*) as operation_count,
                ROUND((COUNT(*) * 100.0 / (SELECT COUNT(*) FROM init_operation)), 2) as percentage
            FROM init_operation io
            LEFT JOIN params s ON io.statut = s.id
            WHERE s.libelle IS NOT NULL
            GROUP BY s.libelle
            """;
        
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        
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
        String sql = """
            SELECT 
                operation_produit,
                COUNT(*) as operation_count,
                AVG(operation_montant) as avg_amount,
                SUM(operation_montant) as total_amount
            FROM init_operation 
            WHERE operation_produit IS NOT NULL
            GROUP BY operation_produit
            ORDER BY operation_count DESC
            """;
        
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        
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
        String sql = """
            SELECT 
                beneficiaire_pays as country,
                COUNT(*) as operation_count,
                SUM(operation_montant) as total_amount
            FROM init_operation 
            WHERE beneficiaire_pays IS NOT NULL
            GROUP BY beneficiaire_pays
            ORDER BY operation_count DESC
            LIMIT 10
            """;
        
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        
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
        String sql = """
            SELECT 
                CASE WHEN donneur_ordre_vip = true THEN 'VIP' ELSE 'Régulier' END as customer_type,
                COUNT(*) as operation_count,
                AVG(operation_montant) as avg_amount
            FROM init_operation 
            GROUP BY donneur_ordre_vip
            """;
        
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        
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

    @Autowired
    private EntityManager entityManager;
}
