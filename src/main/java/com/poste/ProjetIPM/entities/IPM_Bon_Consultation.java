package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("consultation")
@PrimaryKeyJoinColumn(name = "idbon")
public class IPM_Bon_Consultation extends IPM_Bon {
    private String designation;
    private String motif;
    private String numeroBon;

}
