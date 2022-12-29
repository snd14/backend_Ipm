package com.poste.ProjetIPM.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("pharmacie")
@PrimaryKeyJoinColumn(name = "idbon")
public class IPM_Bon_Pharmaceutique extends IPM_Bon {

    private Long nombre_article;
    private String designation;
    @NotNull
    private String ordonnance;
    private String numeroBon;


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


   /* public String getSuivant_ordonnance_docteur() {
        return suivant_ordonnance_docteur;
    }

    public void setSuivant_ordonnance_docteur(String suivant_ordonnance_docteur) {
        this.suivant_ordonnance_docteur = suivant_ordonnance_docteur;
    }*/

    //private Integer prix_unitaire;
    /* private String suivant_ordonnance_docteur;*/
}
