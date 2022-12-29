package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class IPM_Categorie implements Serializable {
    public Long getCode_categorie() {
        return code_categorie;
    }

    public void setCode_categorie(Long code_categorie) {
        this.code_categorie = code_categorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getEchalonnage() {
        return echalonnage;
    }

    public void setEchalonnage(String echalonnage) {
        this.echalonnage = echalonnage;
    }

    public List<IPM_Employe> getIpm_employes() {
        return ipm_employes;
    }

    public void setIpm_employes(List<IPM_Employe> ipm_employes) {
        this.ipm_employes = ipm_employes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_categorie;
    private String libelle;
    private String montant;
    private String echalonnage;

    /*@ManyToOne
    private IPM_Cotisation ipm_cotisation;*/
    @JsonIgnore
    @OneToMany(mappedBy = "ipm_categorie")
    private List<IPM_Employe> ipm_employes;


}
