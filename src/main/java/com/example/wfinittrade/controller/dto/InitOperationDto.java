package com.example.wfinittrade.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InitOperationDto {
    private Integer id;
    private String operationProduit;
    private String operationEvent;
    private LocalDate operationCreationDate;
    private String donneurOrdreCode;
    private String donneurOrdreRaisonSociale;
    private String beneficiaireNom;
    private String beneficiaireIban;
    private BigDecimal operationMontant;
    private String statut;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperationProduit() {
        return operationProduit;
    }

    public void setOperationProduit(String operationProduit) {
        this.operationProduit = operationProduit;
    }

    public String getOperationEvent() {
        return operationEvent;
    }

    public void setOperationEvent(String operationEvent) {
        this.operationEvent = operationEvent;
    }

    public LocalDate getOperationCreationDate() {
        return operationCreationDate;
    }

    public void setOperationCreationDate(LocalDate operationCreationDate) {
        this.operationCreationDate = operationCreationDate;
    }

    public String getDonneurOrdreCode() {
        return donneurOrdreCode;
    }

    public void setDonneurOrdreCode(String donneurOrdreCode) {
        this.donneurOrdreCode = donneurOrdreCode;
    }

    public String getDonneurOrdreRaisonSociale() {
        return donneurOrdreRaisonSociale;
    }

    public void setDonneurOrdreRaisonSociale(String donneurOrdreRaisonSociale) {
        this.donneurOrdreRaisonSociale = donneurOrdreRaisonSociale;
    }

    public String getBeneficiaireNom() {
        return beneficiaireNom;
    }

    public void setBeneficiaireNom(String beneficiaireNom) {
        this.beneficiaireNom = beneficiaireNom;
    }

    public String getBeneficiaireIban() {
        return beneficiaireIban;
    }

    public void setBeneficiaireIban(String beneficiaireIban) {
        this.beneficiaireIban = beneficiaireIban;
    }

    public BigDecimal getOperationMontant() {
        return operationMontant;
    }

    public void setOperationMontant(BigDecimal operationMontant) {
        this.operationMontant = operationMontant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
