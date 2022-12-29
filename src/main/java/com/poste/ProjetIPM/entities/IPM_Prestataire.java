package com.poste.ProjetIPM.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
/*@Inheritance(strategy = InheritanceType.JOINED)*/
public class IPM_Prestataire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_prestataire;

    public Long getCode_prestataire() {
        return code_prestataire;
    }

    public void setCode_prestataire(Long code_prestataire) {
        this.code_prestataire = code_prestataire;
    }

    public String getNom_prestataire() {
        return nom_prestataire;
    }

    public void setNom_prestataire(String nom_prestataire) {
        this.nom_prestataire = nom_prestataire;
    }

    public String getAdresse_prestataire() {
        return adresse_prestataire;
    }

    public void setAdresse_prestatire(String adresse_prestataire) {
        this.adresse_prestataire = adresse_prestataire;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRaison_social() {
        return raison_social;
    }


    public void setRaison_social(String raison_social) {
        this.raison_social = raison_social;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCode_categorie_pretataire() {
        return code_categorie_pretataire;
    }

    public void setCode_categorie_pretataire(String code_categorie_pretataire) {
        this.code_categorie_pretataire = code_categorie_pretataire;
    }

    public Boolean getNature() {
        return nature;
    }

    public void setNature(Boolean nature) {
        this.nature = nature;
    }

    public List<IPM_Facture> getIpm_factures() {
        return ipm_factures;
    }

    public void setIpm_factures(List<IPM_Facture> ipm_factures) {
        this.ipm_factures = ipm_factures;
    }


    public List<IPM_Bon> getIpm_bons() {
        return ipm_bons;
    }

    public void setIpm_bons(List<IPM_Bon> ipm_bons) {
        this.ipm_bons = ipm_bons;
    }

    private String nom_prestataire;
    private String adresse_prestataire;
    private String email;
    private String raison_social;

    public void setAdresse_prestataire(String adresse_prestataire) {
        this.adresse_prestataire = adresse_prestataire;
    }


    private String telephone;
    private String fax;
    private String code_categorie_pretataire;
    private Boolean nature;
    private  String lettreAgrement;
    @JsonIgnore
    @OneToMany(mappedBy = "ipm_prestataire")
    private List<IPM_Facture> ipm_factures;
//    @OneToMany(mappedBy = "ipm_prestataire")
//    private List<IPM_Prestation> ipm_prestations;
    @JsonIgnore
    @OneToMany(mappedBy = "ipm_prestataire", cascade = CascadeType.ALL)
    private List<IPM_Bon> ipm_bons;
    @ManyToOne
    private IPM_Type_Prestataire ipm_type_prestataire;
}
