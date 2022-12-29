package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Details_Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDedtailsFacture;
    private String matricule;
    private String code_acte;
    private Integer tarification;
    private Double part_patient;
    private Double part_ipm;
    private Double taux_ipm;
    private String fileName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private  Date datePrestation;
/*    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_facture;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateSaisie;*/
    private Double montant_facture;

    @lombok.Getter
    @ManyToOne
    @JoinColumn(name="idfacture")
    private IPM_Facture ipmFacture;
    @ManyToOne
    @JoinColumn(name="code_prestation")
    private IPM_Prestation ipm_prestation;
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private IPM_Employe ipm_employe;
    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

//    public IPM_Details_Facture(String matricule , Double montant_facture, Date date_facture, String fileName) {
//        this.matricule = matricule;
//        this.montant_facture = montant_facture;
//       // this.date_facture = date_facture;
//        this.fileName = fileName;
//
//    }
//    public IPM_Details_Facture(String matricule ,Double montant_factur, String fileName) {
//        this.matricule = matricule;
//        this.montant_facture = montant_facture;
//        this.fileName = fileName;
//
//    }
    public IPM_Details_Facture(IPM_Employe ipm_employe,IPM_Facture ipmFacture,Double part_patient ,Double part_ipm,Double montant_facture) {
        this.ipm_employe =ipm_employe;
        this.ipmFacture=ipmFacture;
        this.part_patient=part_patient;
        this.part_ipm =part_ipm;
        this.montant_facture = montant_facture;


    }
    //Individuel
    public IPM_Details_Facture(Double part_patient ,Double part_ipm,Double montant_facture,IPM_Employe ipm_employe,IPM_Facture ipmFacture,IPM_Prestation ipm_prestation) {
        this.part_patient=part_patient;
        this.part_ipm =part_ipm;
        this.montant_facture = montant_facture;
        this.ipm_employe =ipm_employe;
        this.ipmFacture=ipmFacture;
        this.ipm_prestation=ipm_prestation;
    }
}
