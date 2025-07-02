package com.example.wfinittrade.repository;

import com.example.wfinittrade.model.InitOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InitOperationRepository extends JpaRepository<InitOperation, Integer> {
        
        @Query(value = """
            SELECT 
                s.libelle as status_name,
                COUNT(*) as operation_count,
                ROUND((COUNT(*) * 100.0 / (SELECT COUNT(*) FROM init_operation)), 2) as percentage
            FROM init_operation io
            LEFT JOIN params s ON io.statut = s.id
            WHERE s.libelle IS NOT NULL
            GROUP BY s.libelle
            """, nativeQuery = true)
        List<Object[]> findOperationStatusDistribution();
        
        @Query(value = """
            SELECT 
                operation_produit,
                COUNT(*) as operation_count,
                AVG(operation_montant) as avg_amount,
                SUM(operation_montant) as total_amount
            FROM init_operation 
            WHERE operation_produit IS NOT NULL
            GROUP BY operation_produit
            ORDER BY operation_count DESC
            """, nativeQuery = true)
        List<Object[]> findOperationByProductType();
        
        @Query(value = """
            SELECT 
                beneficiaire_pays as country,
                COUNT(*) as operation_count,
                SUM(operation_montant) as total_amount
            FROM init_operation 
            WHERE beneficiaire_pays IS NOT NULL
            GROUP BY beneficiaire_pays
            ORDER BY operation_count DESC
            """, nativeQuery = true)
        List<Object[]> findGeographicDistribution();
        
        @Query(value = """
            SELECT 
                CASE WHEN donneur_ordre_vip = true THEN 'VIP' ELSE 'Régulier' END as customer_type,
                COUNT(*) as operation_count,
                AVG(operation_montant) as avg_amount
            FROM init_operation 
            GROUP BY donneur_ordre_vip
            """, nativeQuery = true)
        List<Object[]> findCustomerTypeDistribution();

        @Query(value = """
            SELECT 
                MONTH(operation_date_validite) as month,
                COUNT(*) as operation_count,
                operation_Produit
            FROM init_operation 
            WHERE operation_Produit IS NOT NULL
            And YEAR(operation_date_validite) = :year
            GROUP BY MONTH(operation_date_validite), operation_Produit
            ORDER BY operation_count DESC
            """, nativeQuery = true)
        List<Object[]> findByOperationDateValidite( int year);

        @Query(value = "SELECT DISTINCT operation_produit FROM init_operation WHERE operation_produit IS NOT NULL", nativeQuery = true)
        List<String> findAllDistinctProductNames();
}
