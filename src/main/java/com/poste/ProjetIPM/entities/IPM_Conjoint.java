package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Conjoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconj;
    private String nom_conjoint;
    private String prenom_conjoint;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_naiss_conj;
    private String lieu_naiss_conj;
    public String telephone;
    @JsonIgnore
    @OneToMany(mappedBy = "ipm_conjoint")
    private List<IPM_Bon> ipm_bons;
    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getSexe_conjoint() {
        return sexe_conjoint;
    }

    public void setSexe_conjoint(String sexe_conjoint) {
        this.sexe_conjoint = sexe_conjoint;
    }

    private String photos;
    private String certificat;
    private String sexe_conjoint;
    public Date getDate_naiss_conj() {
        return date_naiss_conj;
    }

    public void setDate_naiss_conj(Date date_naiss_conj) {
        this.date_naiss_conj = date_naiss_conj;
    }

    public String getLieu_naiss_conj() {
        return lieu_naiss_conj;
    }

    public void setLieu_naiss_conj(String lieu_naiss_conj) {
        this.lieu_naiss_conj = lieu_naiss_conj;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getIdconj() {
        return idconj;
    }

    public void setIdconj(Long idconj) {
        this.idconj = idconj;
    }

    public String getNom_conjoint() {
        return nom_conjoint;
    }

    public void setNom_conjoint(String nom_conjoint) {
        this.nom_conjoint = nom_conjoint;
    }

    public String getPrenom_conjoint() {
        return prenom_conjoint;
    }

    public void setPrenom_conjoint(String prenom_conjoint) {
        this.prenom_conjoint = prenom_conjoint;
    }

    public IPM_Employe getIpm_employe() {
        return ipm_employe;
    }

    public void setIpm_employe(IPM_Employe ipm_employe) {
        this.ipm_employe = ipm_employe;
    }


    @ManyToOne
    private IPM_Employe ipm_employe;
}
