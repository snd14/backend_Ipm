package com.poste.ProjetIPM.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("lettregrantie")
@PrimaryKeyJoinColumn(name = "idbon")
public class IPM_Bon_Lettre_de_Garantie extends IPM_Bon {

    private String categorie_hospitalisation;
    private String motif;
    @NotNull
    private String ordonnance;
    private String numeroBon;
}
