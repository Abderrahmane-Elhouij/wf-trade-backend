package com.example.wfinittrade.facade;

import com.example.wfinittrade.Model.InitOperation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface InitOperationService {

    long getTotalOperations();

    BigDecimal getTotalAmountMAD();

    long getDraftCount();

    long getPendingDecisionCount();

    long getUniqueClientsCount();

    BigDecimal getMaxClientBalance();

    long getVipClientsCount();

    long getMissingBICCount();

    long getExpiredOperationsCount();

    long getCancelledOpsCount();

    long getAmendedOpsCount();

    long getWorkflowAttachedCount();

    long getAwaitingDecisionCount();

    long getCompletedCount();

    List<InitOperation> getOperationsBetween(LocalDate start, LocalDate end);

    List<InitOperation> getAllOperations();
}
