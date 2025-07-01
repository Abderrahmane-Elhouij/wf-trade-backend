package com.example.wfinittrade.controller.converter;

import com.example.wfinittrade.controller.dto.InitOperationDto;
import com.example.wfinittrade.model.InitOperation;
import com.example.wfinittrade.model.Params;

import java.util.List;
import java.util.stream.Collectors;

public class InitOperationConverter {

    public InitOperationDto toDto(InitOperation entity) {
        if (entity == null) {
            return null;
        }

        InitOperationDto dto = new InitOperationDto();
        dto.setId(entity.getId());
        dto.setOperationProduit(entity.getOperationProduit());
        dto.setOperationEvent(entity.getOperationEvent());
        dto.setOperationCreationDate(entity.getOperationCreationDate());
        dto.setDonneurOrdreCode(entity.getDonneurOrdreCode());
        dto.setDonneurOrdreRaisonSociale(entity.getDonneurOrdreRaisonSociale());
        dto.setBeneficiaireNom(entity.getBeneficiaireNom());
        dto.setBeneficiaireIban(entity.getBeneficiaireIban());
        dto.setOperationMontant(entity.getOperationMontant());
        if (entity.getStatut() != null) {
            dto.setStatut(entity.getStatut().getLibelle());
        }

        return dto;
    }

    public InitOperation toEntity(InitOperationDto dto) {
        if (dto == null) {
            return null;
        }

        InitOperation entity = new InitOperation();
        entity.setId(dto.getId());
        entity.setOperationProduit(dto.getOperationProduit());
        entity.setOperationEvent(dto.getOperationEvent());
        entity.setOperationCreationDate(dto.getOperationCreationDate());
        entity.setDonneurOrdreCode(dto.getDonneurOrdreCode());
        entity.setDonneurOrdreRaisonSociale(dto.getDonneurOrdreRaisonSociale());
        entity.setBeneficiaireNom(dto.getBeneficiaireNom());
        entity.setBeneficiaireIban(dto.getBeneficiaireIban());
        entity.setOperationMontant(dto.getOperationMontant());
        if (dto.getStatut() != null) {
            Params statut = new Params();
            statut.setLibelle(dto.getStatut());
            entity.setStatut(statut);
        }

        return entity;
    }

    public List<InitOperationDto> toDto(List<InitOperation> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<InitOperation> toEntity(List<InitOperationDto> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
