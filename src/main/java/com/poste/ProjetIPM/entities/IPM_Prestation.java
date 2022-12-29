package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Prestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_prestation;

    public Long getCode_prestation() {
        return code_prestation;
    }

    public void setCode_prestation(Long code_prestation) {
        this.code_prestation = code_prestation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getTaux_agrees() {
        return taux_agrees;
    }

    public void setTaux_agrees(Double taux_agrees) {
        this.taux_agrees = taux_agrees;
    }

    public Double getTaux_non_agrees() {
        return taux_non_agrees;
    }

    public void setTaux_non_agrees(Double taux_non_agrees) {
        this.taux_non_agrees = taux_non_agrees;
    }

//    public List<IPM_Bareme> getIpm_baremes() {
//        return ipm_baremes;
//    }
//
//    public void setIpm_baremes(List<IPM_Bareme> ipm_baremes) {
//        this.ipm_baremes = ipm_baremes;
//    }

    private String libelle;
    private Double taux_agrees;
    private Double taux_non_agrees;

//    @ManyToOne
//    private IPM_Prestataire ipm_prestataire;

    /*@OneToMany(mappedBy = "ipm_prestation")
    private List<IPM_Bareme> ipm_baremes;*/
    @JsonIgnore
    @OneToMany(mappedBy = "ipmFacture")
    private List<IPM_Details_Facture> ipm_details_factures;
    @JsonIgnore
    @OneToMany(mappedBy = "ipm_prestation", cascade = CascadeType.ALL)
    private List<IPM_Bon> ipm_bons;
}
