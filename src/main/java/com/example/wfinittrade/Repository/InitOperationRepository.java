package com.example.wfinittrade.Repository;

import com.example.wfinittrade.Model.InitOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface InitOperationRepository extends JpaRepository<InitOperation, Integer> {

        long countByOperationDraftTrue();

        long countByDecisionFinalIsNull();

        @Query("SELECT SUM(o.operationContreValeurMad) FROM InitOperation o")
        BigDecimal getTotalContreValeurMad();

        // Dashboard 2: Donneur d’Ordre
        @Query("SELECT COUNT(DISTINCT o.donneurOrdreCode) FROM InitOperation o")
        long countDistinctDonneurOrdre();

        @Query("SELECT MAX(o.donneurOrdreSoldeComptable) FROM InitOperation o")
        BigDecimal findMaxSoldeComptable();

        long countByDonneurOrdreVipTrue();

        // Dashboard 3: Compliance
        long countByBeneficiaireBanqueBicIsNull();

        @Query("SELECT COUNT(o) FROM InitOperation o WHERE o.operationDateValidite < :now")
        long countExpiredValidite(LocalDate now);

        long countByMotifCancelIsNotNull();

        long countByMotifAmendIsNotNull();

        // Dashboard 4: Workflow
        long countByProcessInstanceIdIsNotNull();


        long countByDecisionFinalIn(List<String> decisions);

        List<InitOperation> findByOperationCreationDateBetween(LocalDate start, LocalDate end);
}
