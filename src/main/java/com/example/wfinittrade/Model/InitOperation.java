package com.example.wfinittrade.Model;

import com.google.common.base.MoreObjects;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "init_operation")
public class InitOperation implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(InitOperation.class.getName());

    // Raw attributes
    private Integer id;
    private String operationProduit;
    private String operationEvent;
    private String operationProduitPrefix;
    private String operationEventPrefix;
    private String operationProduitRef;
    private String operationEventRef;
    private LocalDate operationCreationDate;
    private String operationCreationTime;
    private String operationEntryPoint;
    private String donneurOrdreCode;
    private String donneurOrdreRaisonSociale;
    private String donneurOrdrePays;
    private String donneurOrdreVille;
    private String donneurOrdreCodePostal;
    private String donneurOrdreAdresse;
    private Boolean donneurOrdreVip;
    private String donneurOrdreCategorie;
    private String donneurOrdreCompte;
    private String donneurOrdreDevise;
    private String donneurOrdreCaf;
    private String donneurOrdreType;
    private String donneurOrdreCodeMarche;
    private String donneurOrdreClipriClicom;
    private String donneurOrdreRetailCorpo;
    private BigDecimal donneurOrdreSoldeIntraday;
    private BigDecimal donneurOrdreSoldeComptable;
    private String beneficiaireNom;
    private String beneficiairePays;
    private String beneficiaireVille;
    private String beneficiaireCodePostal;
    private String beneficiaireIban;
    private String beneficiaireBanquePays;
    private String beneficiaireBanqueVille;
    private String beneficiaireBanqueCodePostal;
    private String beneficiaireBanqueAdresse;
    private String beneficiaireBanqueBic;
    private String operationTypePaiement;
    private BigDecimal operationMontant;
    private BigDecimal operationContreValeurMad;
    private LocalDate operationDateValeur;
    private LocalDate operationDateValidite;
    private String operationLieuValidite;
    private Boolean operationDraft;
    private BigDecimal operationTolerancePositif;
    private BigDecimal operationToleranceNegatif;
    private String operationConditionPaiement;
    private String operationRetenueSource;
    private String operationInstructionsComplementaires;
    private String processInstanceId;
    private String decisionFinal;
    private String motifAmend;
    private String motifCancel;
    private Params statut;




    @Column(name = "operation_id", precision = 10)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InitOperation id(Integer id) {
        setId(id);
        return this;
    }

    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [operationProduit] ------------------------

    @Size(max = 50)
    @Column(name = "operation_produit", length = 50)
    public String getOperationProduit() {
        return operationProduit;
    }

    public void setOperationProduit(String operationProduit) {
        this.operationProduit = operationProduit;
    }

    public InitOperation operationProduit(String operationProduit) {
        setOperationProduit(operationProduit);
        return this;
    }
    // -- [operationEvent] ------------------------

    @Size(max = 50)
    @Column(name = "operation_event", length = 50)
    public String getOperationEvent() {
        return operationEvent;
    }

    public void setOperationEvent(String operationEvent) {
        this.operationEvent = operationEvent;
    }

    public InitOperation operationEvent(String operationEvent) {
        setOperationEvent(operationEvent);
        return this;
    }
    // -- [operationProduitPrefix] ------------------------

    @Size(max = 50)
    @Column(name = "operation_produit_prefix", length = 50)
    public String getOperationProduitPrefix() {
        return operationProduitPrefix;
    }

    public void setOperationProduitPrefix(String operationProduitPrefix) {
        this.operationProduitPrefix = operationProduitPrefix;
    }

    public InitOperation operationProduitPrefix(String operationProduitPrefix) {
        setOperationProduitPrefix(operationProduitPrefix);
        return this;
    }
    // -- [operationEventPrefix] ------------------------

    @Size(max = 50)
    @Column(name = "operation_event_prefix", length = 50)
    public String getOperationEventPrefix() {
        return operationEventPrefix;
    }

    public void setOperationEventPrefix(String operationEventPrefix) {
        this.operationEventPrefix = operationEventPrefix;
    }

    public InitOperation operationEventPrefix(String operationEventPrefix) {
        setOperationEventPrefix(operationEventPrefix);
        return this;
    }
    // -- [operationProduitRef] ------------------------

    @Size(max = 50)
    @Column(name = "operation_produit_ref", length = 50)
    public String getOperationProduitRef() {
        return operationProduitRef;
    }

    public void setOperationProduitRef(String operationProduitRef) {
        this.operationProduitRef = operationProduitRef;
    }

    public InitOperation operationProduitRef(String operationProduitRef) {
        setOperationProduitRef(operationProduitRef);
        return this;
    }

    @JoinColumn(name = "statut")
    @ManyToOne
    public Params getStatut() {
        return statut;
    }

    /**
     * Set the {@link #statut} without adding this SgintWfoperations instance on the
     * passed {@link #statut}
     */
    public void setStatut(Params statut) {
        this.statut = statut;
    }


    // -- [operationEventRef] ------------------------

    @Size(max = 50)
    @Column(name = "operation_event_ref", length = 50)
    public String getOperationEventRef() {
        return operationEventRef;
    }

    public void setOperationEventRef(String operationEventRef) {
        this.operationEventRef = operationEventRef;
    }

    public InitOperation operationEventRef(String operationEventRef) {
        setOperationEventRef(operationEventRef);
        return this;
    }
    // -- [operationCreationDate] ------------------------

    @Column(name = "operation_creation_date", length = 13)
    public LocalDate getOperationCreationDate() {
        return operationCreationDate;
    }

    public void setOperationCreationDate(LocalDate operationCreationDate) {
        this.operationCreationDate = operationCreationDate;
    }

    public InitOperation operationCreationDate(LocalDate operationCreationDate) {
        setOperationCreationDate(operationCreationDate);
        return this;
    }
    // -- [operationCreationTime] ------------------------

    @Column(name = "operation_creation_time")
    public String getOperationCreationTime() {
        return operationCreationTime;
    }

    public void setOperationCreationTime(String operationCreationTime) {
        this.operationCreationTime = operationCreationTime;
    }

    public InitOperation operationCreationTime(String operationCreationTime) {
        setOperationCreationTime(operationCreationTime);
        return this;
    }
    // -- [operationEntryPoint] ------------------------

    @Size(max = 50)
    @Column(name = "operation_entry_point", length = 50)
    public String getOperationEntryPoint() {
        return operationEntryPoint;
    }

    public void setOperationEntryPoint(String operationEntryPoint) {
        this.operationEntryPoint = operationEntryPoint;
    }

    public InitOperation operationEntryPoint(String operationEntryPoint) {
        setOperationEntryPoint(operationEntryPoint);
        return this;
    }
    // -- [donneurOrdreCode] ------------------------

    @Size(max = 20)
    @Column(name = "donneur_ordre_code", length = 20)
    public String getDonneurOrdreCode() {
        return donneurOrdreCode;
    }

    public void setDonneurOrdreCode(String donneurOrdreCode) {
        this.donneurOrdreCode = donneurOrdreCode;
    }

    public InitOperation donneurOrdreCode(String donneurOrdreCode) {
        setDonneurOrdreCode(donneurOrdreCode);
        return this;
    }
    // -- [donneurOrdreRaisonSociale] ------------------------

    @Size(max = 100)
    @Column(name = "donneur_ordre_raison_sociale", length = 100)
    public String getDonneurOrdreRaisonSociale() {
        return donneurOrdreRaisonSociale;
    }

    public void setDonneurOrdreRaisonSociale(String donneurOrdreRaisonSociale) {
        this.donneurOrdreRaisonSociale = donneurOrdreRaisonSociale;
    }

    public InitOperation donneurOrdreRaisonSociale(String donneurOrdreRaisonSociale) {
        setDonneurOrdreRaisonSociale(donneurOrdreRaisonSociale);
        return this;
    }
    // -- [donneurOrdrePays] ------------------------

    @Size(max = 50)
    @Column(name = "donneur_ordre_pays", length = 50)
    public String getDonneurOrdrePays() {
        return donneurOrdrePays;
    }

    public void setDonneurOrdrePays(String donneurOrdrePays) {
        this.donneurOrdrePays = donneurOrdrePays;
    }

    public InitOperation donneurOrdrePays(String donneurOrdrePays) {
        setDonneurOrdrePays(donneurOrdrePays);
        return this;
    }
    // -- [donneurOrdreVille] ------------------------

    @Size(max = 50)
    @Column(name = "donneur_ordre_ville", length = 50)
    public String getDonneurOrdreVille() {
        return donneurOrdreVille;
    }

    public void setDonneurOrdreVille(String donneurOrdreVille) {
        this.donneurOrdreVille = donneurOrdreVille;
    }

    public InitOperation donneurOrdreVille(String donneurOrdreVille) {
        setDonneurOrdreVille(donneurOrdreVille);
        return this;
    }
    // -- [donneurOrdreCodePostal] ------------------------

    @Size(max = 20)
    @Column(name = "donneur_ordre_code_postal", length = 20)
    public String getDonneurOrdreCodePostal() {
        return donneurOrdreCodePostal;
    }

    public void setDonneurOrdreCodePostal(String donneurOrdreCodePostal) {
        this.donneurOrdreCodePostal = donneurOrdreCodePostal;
    }

    public InitOperation donneurOrdreCodePostal(String donneurOrdreCodePostal) {
        setDonneurOrdreCodePostal(donneurOrdreCodePostal);
        return this;
    }
    // -- [donneurOrdreAdresse] ------------------------

    @Size(max = 200)
    @Column(name = "donneur_ordre_adresse", length = 200)
    public String getDonneurOrdreAdresse() {
        return donneurOrdreAdresse;
    }

    public void setDonneurOrdreAdresse(String donneurOrdreAdresse) {
        this.donneurOrdreAdresse = donneurOrdreAdresse;
    }

    public InitOperation donneurOrdreAdresse(String donneurOrdreAdresse) {
        setDonneurOrdreAdresse(donneurOrdreAdresse);
        return this;
    }
    // -- [donneurOrdreVip] ------------------------

    @Column(name = "donneur_ordre_vip", length = 1)
    public Boolean getDonneurOrdreVip() {
        return donneurOrdreVip;
    }

    public void setDonneurOrdreVip(Boolean donneurOrdreVip) {
        this.donneurOrdreVip = donneurOrdreVip;
    }

    public InitOperation donneurOrdreVip(Boolean donneurOrdreVip) {
        setDonneurOrdreVip(donneurOrdreVip);
        return this;
    }
    // -- [donneurOrdreCategorie] ------------------------

    @Size(max = 50)
    @Column(name = "donneur_ordre_categorie", length = 50)
    public String getDonneurOrdreCategorie() {
        return donneurOrdreCategorie;
    }

    public void setDonneurOrdreCategorie(String donneurOrdreCategorie) {
        this.donneurOrdreCategorie = donneurOrdreCategorie;
    }

    public InitOperation donneurOrdreCategorie(String donneurOrdreCategorie) {
        setDonneurOrdreCategorie(donneurOrdreCategorie);
        return this;
    }
    // -- [donneurOrdreCompte] ------------------------

    @Size(max = 50)
    @Column(name = "donneur_ordre_compte", length = 50)
    public String getDonneurOrdreCompte() {
        return donneurOrdreCompte;
    }

    public void setDonneurOrdreCompte(String donneurOrdreCompte) {
        this.donneurOrdreCompte = donneurOrdreCompte;
    }

    public InitOperation donneurOrdreCompte(String donneurOrdreCompte) {
        setDonneurOrdreCompte(donneurOrdreCompte);
        return this;
    }

    @Size(max = 50)
    @Column(name = "donneur_ordre_devise", length = 50)
    public String getDonneurOrdreDevise() {
        return donneurOrdreDevise;
    }

    public void setDonneurOrdreDevise(String donneurOrdreDevise) {
        this.donneurOrdreDevise = donneurOrdreDevise;
    }

    public InitOperation donneurOrdreDevise(String donneurOrdreDevise) {
        setDonneurOrdreDevise(donneurOrdreDevise);
        return this;
    }

    @Size(max = 50)
    @Column(name = "donneur_ordre_caf", length = 50)
    public String getDonneurOrdreCaf() {
        return donneurOrdreCaf;
    }

    public void setDonneurOrdreCaf(String donneurOrdreCaf) {
        this.donneurOrdreCaf = donneurOrdreCaf;
    }

    public InitOperation donneurOrdreCaf(String donneurOrdreCaf) {
        setDonneurOrdreCaf(donneurOrdreCaf);
        return this;
    }


    @Size(max = 50)
    @Column(name = "donneur_ordre_type", length = 50)
    public String getDonneurOrdreType() {
        return donneurOrdreType;
    }

    public void setDonneurOrdreType(String donneurOrdreType) {
        this.donneurOrdreType = donneurOrdreType;
    }

    public InitOperation donneurOrdreType(String donneurOrdreType) {
        setDonneurOrdreType(donneurOrdreType);
        return this;
    }


    @Size(max = 50)
    @Column(name = "donneur_ordre_code_marche", length = 50)
    public String getDonneurOrdreCodeMarche() {
        return donneurOrdreCodeMarche;
    }

    public void setDonneurOrdreCodeMarche(String donneurOrdreCodeMarche) {
        this.donneurOrdreCodeMarche = donneurOrdreCodeMarche;
    }

    public InitOperation donneurOrdreCodeMarche(String donneurOrdreCodeMarche) {
        setDonneurOrdreCodeMarche(donneurOrdreCodeMarche);
        return this;
    }


    @Size(max = 50)
    @Column(name = "donneur_ordre_clipri_clicom", length = 50)
    public String getDonneurOrdreClipriClicom() {
        return donneurOrdreClipriClicom;
    }

    public void setDonneurOrdreClipriClicom(String donneurOrdreClipriClicom) {
        this.donneurOrdreClipriClicom = donneurOrdreClipriClicom;
    }

    public InitOperation donneurOrdreClipriClicom(String donneurOrdreClipriClicom) {
        setDonneurOrdreClipriClicom(donneurOrdreClipriClicom);
        return this;
    }


    @Size(max = 50)
    @Column(name = "donneur_ordre_retail_corpo", length = 50)
    public String getDonneurOrdreRetailCorpo() {
        return donneurOrdreRetailCorpo;
    }

    public void setDonneurOrdreRetailCorpo(String donneurOrdreRetailCorpo) {
        this.donneurOrdreRetailCorpo = donneurOrdreRetailCorpo;
    }

    public InitOperation donneurOrdreRetailCorpo(String donneurOrdreRetailCorpo) {
        setDonneurOrdreRetailCorpo(donneurOrdreRetailCorpo);
        return this;
    }

    // -- [donneurOrdreSoldeIntraday] ------------------------

    @Digits(integer = 13, fraction = 2)
    @Column(name = "donneur_ordre_solde_intraday", precision = 15, scale = 2)
    public BigDecimal getDonneurOrdreSoldeIntraday() {
        return donneurOrdreSoldeIntraday;
    }

    public void setDonneurOrdreSoldeIntraday(BigDecimal donneurOrdreSoldeIntraday) {
        this.donneurOrdreSoldeIntraday = donneurOrdreSoldeIntraday;
    }

    public InitOperation donneurOrdreSoldeIntraday(BigDecimal donneurOrdreSoldeIntraday) {
        setDonneurOrdreSoldeIntraday(donneurOrdreSoldeIntraday);
        return this;
    }
    // -- [donneurOrdreSoldeComptable] ------------------------

    @Digits(integer = 13, fraction = 2)
    @Column(name = "donneur_ordre_solde_comptable", precision = 15, scale = 2)
    public BigDecimal getDonneurOrdreSoldeComptable() {
        return donneurOrdreSoldeComptable;
    }

    public void setDonneurOrdreSoldeComptable(BigDecimal donneurOrdreSoldeComptable) {
        this.donneurOrdreSoldeComptable = donneurOrdreSoldeComptable;
    }

    public InitOperation donneurOrdreSoldeComptable(BigDecimal donneurOrdreSoldeComptable) {
        setDonneurOrdreSoldeComptable(donneurOrdreSoldeComptable);
        return this;
    }
    // -- [beneficiaireNom] ------------------------

    @Size(max = 100)
    @Column(name = "beneficiaire_nom", length = 100)
    public String getBeneficiaireNom() {
        return beneficiaireNom;
    }

    public void setBeneficiaireNom(String beneficiaireNom) {
        this.beneficiaireNom = beneficiaireNom;
    }

    public InitOperation beneficiaireNom(String beneficiaireNom) {
        setBeneficiaireNom(beneficiaireNom);
        return this;
    }
    // -- [beneficiairePays] ------------------------

    @Size(max = 50)
    @Column(name = "beneficiaire_pays", length = 50)
    public String getBeneficiairePays() {
        return beneficiairePays;
    }

    public void setBeneficiairePays(String beneficiairePays) {
        this.beneficiairePays = beneficiairePays;
    }

    public InitOperation beneficiairePays(String beneficiairePays) {
        setBeneficiairePays(beneficiairePays);
        return this;
    }
    // -- [beneficiaireVille] ------------------------

    @Size(max = 50)
    @Column(name = "beneficiaire_ville", length = 50)
    public String getBeneficiaireVille() {
        return beneficiaireVille;
    }

    public void setBeneficiaireVille(String beneficiaireVille) {
        this.beneficiaireVille = beneficiaireVille;
    }

    public InitOperation beneficiaireVille(String beneficiaireVille) {
        setBeneficiaireVille(beneficiaireVille);
        return this;
    }
    // -- [beneficiaireCodePostal] ------------------------

    @Size(max = 20)
    @Column(name = "beneficiaire_code_postal", length = 20)
    public String getBeneficiaireCodePostal() {
        return beneficiaireCodePostal;
    }

    public void setBeneficiaireCodePostal(String beneficiaireCodePostal) {
        this.beneficiaireCodePostal = beneficiaireCodePostal;
    }

    public InitOperation beneficiaireCodePostal(String beneficiaireCodePostal) {
        setBeneficiaireCodePostal(beneficiaireCodePostal);
        return this;
    }
    // -- [beneficiaireIban] ------------------------

    @Size(max = 50)
    @Column(name = "beneficiaire_iban", length = 50)
    public String getBeneficiaireIban() {
        return beneficiaireIban;
    }

    public void setBeneficiaireIban(String beneficiaireIban) {
        this.beneficiaireIban = beneficiaireIban;
    }

    public InitOperation beneficiaireIban(String beneficiaireIban) {
        setBeneficiaireIban(beneficiaireIban);
        return this;
    }
    // -- [beneficiaireBanquePays] ------------------------

    @Size(max = 50)
    @Column(name = "beneficiaire_banque_pays", length = 50)
    public String getBeneficiaireBanquePays() {
        return beneficiaireBanquePays;
    }

    public void setBeneficiaireBanquePays(String beneficiaireBanquePays) {
        this.beneficiaireBanquePays = beneficiaireBanquePays;
    }

    public InitOperation beneficiaireBanquePays(String beneficiaireBanquePays) {
        setBeneficiaireBanquePays(beneficiaireBanquePays);
        return this;
    }
    // -- [beneficiaireBanqueVille] ------------------------

    @Size(max = 50)
    @Column(name = "beneficiaire_banque_ville", length = 50)
    public String getBeneficiaireBanqueVille() {
        return beneficiaireBanqueVille;
    }

    public void setBeneficiaireBanqueVille(String beneficiaireBanqueVille) {
        this.beneficiaireBanqueVille = beneficiaireBanqueVille;
    }

    public InitOperation beneficiaireBanqueVille(String beneficiaireBanqueVille) {
        setBeneficiaireBanqueVille(beneficiaireBanqueVille);
        return this;
    }
    // -- [beneficiaireBanqueCodePostal] ------------------------

    @Size(max = 20)
    @Column(name = "beneficiaire_banque_code_postal", length = 20)
    public String getBeneficiaireBanqueCodePostal() {
        return beneficiaireBanqueCodePostal;
    }

    public void setBeneficiaireBanqueCodePostal(String beneficiaireBanqueCodePostal) {
        this.beneficiaireBanqueCodePostal = beneficiaireBanqueCodePostal;
    }

    public InitOperation beneficiaireBanqueCodePostal(String beneficiaireBanqueCodePostal) {
        setBeneficiaireBanqueCodePostal(beneficiaireBanqueCodePostal);
        return this;
    }
    // -- [beneficiaireBanqueAdresse] ------------------------

    @Size(max = 200)
    @Column(name = "beneficiaire_banque_adresse", length = 200)
    public String getBeneficiaireBanqueAdresse() {
        return beneficiaireBanqueAdresse;
    }

    public void setBeneficiaireBanqueAdresse(String beneficiaireBanqueAdresse) {
        this.beneficiaireBanqueAdresse = beneficiaireBanqueAdresse;
    }

    public InitOperation beneficiaireBanqueAdresse(String beneficiaireBanqueAdresse) {
        setBeneficiaireBanqueAdresse(beneficiaireBanqueAdresse);
        return this;
    }
    // -- [beneficiaireBanqueBic] ------------------------

    @Size(max = 20)
    @Column(name = "beneficiaire_banque_bic", length = 20)
    public String getBeneficiaireBanqueBic() {
        return beneficiaireBanqueBic;
    }

    public void setBeneficiaireBanqueBic(String beneficiaireBanqueBic) {
        this.beneficiaireBanqueBic = beneficiaireBanqueBic;
    }

    public InitOperation beneficiaireBanqueBic(String beneficiaireBanqueBic) {
        setBeneficiaireBanqueBic(beneficiaireBanqueBic);
        return this;
    }
    // -- [operationTypePaiement] ------------------------

    @Size(max = 50)
    @Column(name = "operation_type_paiement", length = 50)
    public String getOperationTypePaiement() {
        return operationTypePaiement;
    }

    public void setOperationTypePaiement(String operationTypePaiement) {
        this.operationTypePaiement = operationTypePaiement;
    }

    public InitOperation operationTypePaiement(String operationTypePaiement) {
        setOperationTypePaiement(operationTypePaiement);
        return this;
    }
    // -- [operationMontant] ------------------------

    @Column(name = "operation_montant")
    public BigDecimal getOperationMontant() {
        return operationMontant;
    }

    public void setOperationMontant(BigDecimal operationMontant) {
        this.operationMontant = operationMontant;
    }

    public InitOperation operationMontant(BigDecimal operationMontant) {
        setOperationMontant(operationMontant);
        return this;
    }
    // -- [operationContreValeurMad] ------------------------

    @Column(name = "operation_contre_valeur_mad")
    public BigDecimal getOperationContreValeurMad() {
        return operationContreValeurMad;
    }

    public void setOperationContreValeurMad(BigDecimal operationContreValeurMad) {
        this.operationContreValeurMad = operationContreValeurMad;
    }

    public InitOperation operationContreValeurMad(BigDecimal operationContreValeurMad) {
        setOperationContreValeurMad(operationContreValeurMad);
        return this;
    }
    // -- [operationDateValeur] ------------------------

    @Column(name = "operation_date_valeur", length = 13)
    public LocalDate getOperationDateValeur() {
        return operationDateValeur;
    }

    public void setOperationDateValeur(LocalDate operationDateValeur) {
        this.operationDateValeur = operationDateValeur;
    }

    public InitOperation operationDateValeur(LocalDate operationDateValeur) {
        setOperationDateValeur(operationDateValeur);
        return this;
    }

    @Column(name = "operation_date_validite", length = 13)
    public LocalDate getOperationDateValidite() {
        return operationDateValidite;
    }

    public void setOperationDateValidite(LocalDate operationDateValidite) {
        this.operationDateValidite = operationDateValidite;
    }

    public InitOperation operationDateValidite(LocalDate operationDateValidite) {
        setOperationDateValidite(operationDateValidite);
        return this;
    }

    @Column(name = "operation_lieu_validite")
    public String getOperationLieuValidite() {
        return operationLieuValidite;
    }

    public void setOperationLieuValidite(String operationLieuValidite) {
        this.operationLieuValidite = operationLieuValidite;
    }

    public InitOperation operationLieuValidite(String operationLieuValidite) {
        setOperationLieuValidite(operationLieuValidite);
        return this;
    }

    @Column(name = "operation_draft")
    public Boolean getOperationDraft() {
        return operationDraft;
    }

    public void setOperationDraft(Boolean operationDraft) {
        this.operationDraft = operationDraft;
    }

    public InitOperation operationDraft(Boolean operationDraft) {
        setOperationDraft(operationDraft);
        return this;
    }

    @Column(name = "operation_tolerance_positif")
    public BigDecimal getOperationTolerancePositif() {
        return operationTolerancePositif;
    }

    public void setOperationTolerancePositif(BigDecimal operationTolerancePositif) {
        this.operationTolerancePositif = operationTolerancePositif;
    }

    public InitOperation operationTolerancePositif(BigDecimal operationTolerancePositif) {
        setOperationTolerancePositif(operationTolerancePositif);
        return this;
    }


    @Column(name = "operation_tolerance_negatif")
    public BigDecimal getOperationToleranceNegatif() {
        return operationToleranceNegatif;
    }

    public void setOperationToleranceNegatif(BigDecimal operationToleranceNegatif) {
        this.operationToleranceNegatif = operationToleranceNegatif;
    }

    public InitOperation operationToleranceNegatif(BigDecimal operationToleranceNegatif) {
        setOperationToleranceNegatif(operationToleranceNegatif);
        return this;
    }

    @Column(name = "operation_condition_paiement")
    public String getOperationConditionPaiement() {
        return operationConditionPaiement;
    }

    public void setOperationConditionPaiement(String operationConditionPaiement) {
        this.operationConditionPaiement = operationConditionPaiement;
    }

    public InitOperation operationConditionPaiement(String operationConditionPaiement) {
        setOperationConditionPaiement(operationConditionPaiement);
        return this;
    }
    // -- [operationRetenueSource] ------------------------

    @Size(max = 50)
    @Column(name = "operation_retenue_source", length = 50)
    public String getOperationRetenueSource() {
        return operationRetenueSource;
    }

    public void setOperationRetenueSource(String operationRetenueSource) {
        this.operationRetenueSource = operationRetenueSource;
    }

    public InitOperation operationRetenueSource(String operationRetenueSource) {
        setOperationRetenueSource(operationRetenueSource);
        return this;
    }
    // -- [operationInstructionsComplementaires] ------------------------

    @Size(max = 2147483647)
    @Column(name = "operation_instructions_complementaires", length = 2147483647)
    public String getOperationInstructionsComplementaires() {
        return operationInstructionsComplementaires;
    }

    public void setOperationInstructionsComplementaires(String operationInstructionsComplementaires) {
        this.operationInstructionsComplementaires = operationInstructionsComplementaires;
    }

    public InitOperation operationInstructionsComplementaires(String operationInstructionsComplementaires) {
        setOperationInstructionsComplementaires(operationInstructionsComplementaires);
        return this;
    }

    @Column(name = "process_instance_id")
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public InitOperation processInstanceId(String processInstanceId) {
        setProcessInstanceId(processInstanceId);
        return this;
    }





    @Column(name = "decision_final")
    public String getDecisionFinal() {
        return decisionFinal;
    }

    public void setDecisionFinal(String decisionFinal) {
        this.decisionFinal = decisionFinal;
    }

    public InitOperation decisionFinal(String decisionFinal) {
        setDecisionFinal(decisionFinal);
        return this;
    }

    @Column(name = "motif_amend")
    public String getMotifAmend() {
        return motifAmend;
    }

    public void setMotifAmend(String motifAmend) {
        this.motifAmend = motifAmend;
    }

    public InitOperation motifAmend(String motifAmend) {
        setMotifAmend(motifAmend);
        return this;
    }

    @Column(name = "motif_cancel")
    public String getMotifCancel() {
        return motifCancel;
    }

    public void setMotifCancel(String motifCancel) {
        this.motifCancel = motifCancel;
    }

    public InitOperation motifCancel(String motifCancel) {
        setMotifCancel(motifCancel);
        return this;
    }

    public InitOperation withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof InitOperation && hashCode() == other.hashCode());
    }



    /**
     * Construct a readable string representation for this InitOperation instance.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("operationProduit", getOperationProduit()) //
                .add("operationEvent", getOperationEvent()) //
                .add("operationProduitPrefix", getOperationProduitPrefix()) //
                .add("operationEventPrefix", getOperationEventPrefix()) //
                .add("operationProduitRef", getOperationProduitRef()) //
                .add("operationEventRef", getOperationEventRef()) //
                .add("operationCreationDate", getOperationCreationDate()) //
                .add("operationCreationTime", getOperationCreationTime()) //
                .add("operationEntryPoint", getOperationEntryPoint()) //
                .add("donneurOrdreCode", getDonneurOrdreCode()) //
                .add("donneurOrdreRaisonSociale", getDonneurOrdreRaisonSociale()) //
                .add("donneurOrdrePays", getDonneurOrdrePays()) //
                .add("donneurOrdreVille", getDonneurOrdreVille()) //
                .add("donneurOrdreCodePostal", getDonneurOrdreCodePostal()) //
                .add("donneurOrdreAdresse", getDonneurOrdreAdresse()) //
                .add("donneurOrdreVip", getDonneurOrdreVip()) //
                .add("donneurOrdreCategorie", getDonneurOrdreCategorie()) //
                .add("donneurOrdreCompte", getDonneurOrdreCompte()) //
                .add("donneurOrdreSoldeIntraday", getDonneurOrdreSoldeIntraday()) //
                .add("donneurOrdreSoldeComptable", getDonneurOrdreSoldeComptable()) //
                .add("beneficiaireNom", getBeneficiaireNom()) //
                .add("beneficiairePays", getBeneficiairePays()) //
                .add("beneficiaireVille", getBeneficiaireVille()) //
                .add("beneficiaireCodePostal", getBeneficiaireCodePostal()) //
                .add("beneficiaireIban", getBeneficiaireIban()) //
                .add("beneficiaireBanquePays", getBeneficiaireBanquePays()) //
                .add("beneficiaireBanqueVille", getBeneficiaireBanqueVille()) //
                .add("beneficiaireBanqueCodePostal", getBeneficiaireBanqueCodePostal()) //
                .add("beneficiaireBanqueAdresse", getBeneficiaireBanqueAdresse()) //
                .add("beneficiaireBanqueBic", getBeneficiaireBanqueBic()) //
                .add("operationTypePaiement", getOperationTypePaiement()) //
                .add("operationMontant", getOperationMontant()) //
                .add("operationContreValeurMad", getOperationContreValeurMad()) //
                .add("operationDateValeur", getOperationDateValeur()) //
                .add("operationRetenueSource", getOperationRetenueSource()) //
                .add("operationInstructionsComplementaires", getOperationInstructionsComplementaires()) //
                .toString();
    }
}
