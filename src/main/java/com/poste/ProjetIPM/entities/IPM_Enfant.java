package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idenf;

    public Long getIdenf() {
        return idenf;
    }

    public void setIdenf(Long idenf) {
        this.idenf = idenf;
    }

    public String getNom_enfant() {
        return nom_enfant;
    }

    public void setNom_enfant(String nom_enfant) {
        this.nom_enfant = nom_enfant;
    }

    public String getPrenom_enfant() {
        return prenom_enfant;
    }

    public void setPrenom_enfant(String prenom_enfant) {
        this.prenom_enfant = prenom_enfant;
    }

    public Date getDate_nais_enfant() {
        return date_nais_enfant;
    }

    public void setDate_nais_enfant(Date date_nais_enfant) {
        this.date_nais_enfant = date_nais_enfant;
    }

    public IPM_Employe getIpm_employe() {
        return ipm_employe;
    }

    public void setIpm_employe(IPM_Employe ipm_employe) {
        this.ipm_employe = ipm_employe;
    }

    private String nom_enfant;
    private String prenom_enfant;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_nais_enfant;
    private String lieu_nais_enfant;
    private String adresse;
    private String sexe_enfant;
    private String chemin;
    private String extrait_naiss;

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getLieu_nais_enfant() {
        return lieu_nais_enfant;
    }

    public void setLieu_nais_enfant(String lieu_nais_enfant) {
        this.lieu_nais_enfant = lieu_nais_enfant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe_enfant() {
        return sexe_enfant;
    }

    public void setSexe_enfant(String sexe_enfant) {
        this.sexe_enfant = sexe_enfant;
    }

    @ManyToOne
    private IPM_Employe ipm_employe;
    @JsonIgnore
    @OneToMany(mappedBy = "ipm_enfant")
    private List<IPM_Bon> ipm_bons;
}

