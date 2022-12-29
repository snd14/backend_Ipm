package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfacture;
//    private String matricule;
//    private String code_acte;
//    private Integer tarification;
    private Integer part_patient;
   private Integer part_ipm;
//    private Double taux_ipm;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   private Date dateFacture;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   private Date dateSaisie;
//
//    private Integer montant_facture;
    private String fileName;

    private  boolean certifier;


    @OneToMany(mappedBy = "ipm_facture")
    private List<IPM_Bon> ipm_bons;
    @ManyToOne
    @JoinColumn(name = "code_prestataire")
    private IPM_Prestataire ipm_prestataire;
//    @ManyToOne
//    private IPM_Prestation ipm_prestation;
   private Integer numerofacture;
   private  Integer montantTotal;
//   @ManyToOne
//   @JoinColumn(name = "id_employe")
//     private IPM_Employe ipm_employe;
    @OneToMany(mappedBy = "ipm_facture")
    private List<IPM_Statut_Facture> ipm_statut_factures;
    @JsonIgnore
    //@OneToMany(mappedBy = "ipm_facture")
    @OneToMany(mappedBy = "ipmFacture")
    private List<IPM_Details_Facture> ipm_details_factures;


    public Long getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Long idfacture) {
        this.idfacture = idfacture;
    }



    public List<IPM_Bon> getIpm_bons() {
        return ipm_bons;
    }

    public void setIpm_bons(List<IPM_Bon> ipm_bons) {
        this.ipm_bons = ipm_bons;
    }

   /* public IPM_Prestataire getIpm_prestataire() {
        return ipm_prestataire;
    }

    public void setIpm_prestataire(IPM_Prestataire ipm_prestataire) {
        this.ipm_prestataire = ipm_prestataire;
    }*/

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public IPM_Prestataire getIpm_prestataire() {
        return ipm_prestataire;
    }

    public void setIpm_prestataire(IPM_Prestataire ipm_prestataire) {
        this.ipm_prestataire = ipm_prestataire;
    }
  /*  public Long getIpm_prestataire() {
        return ipm_prestataire;
    }

    public void setIpm_prestataire(Long ipm_prestataire) {
        this.ipm_prestataire = ipm_prestataire;
    }*/

    public List<IPM_Statut_Facture> getIpm_statut_factures() {
        return ipm_statut_factures;
    }

    public void setIpm_statut_factures(List<IPM_Statut_Facture> ipm_statut_factures) {
        this.ipm_statut_factures = ipm_statut_factures;
    }



//    public IPM_Facture(String matricule ,Integer montant_facture,Date date_facture, String fileName) {
//        this.matricule = matricule;
//        this.montant_facture = montant_facture;
//        this.date_facture = date_facture;
//        this.fileName = fileName;
//
//    }
}
