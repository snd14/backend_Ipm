package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Details_Cotisations {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id_Det_Coti;
     private Double montant;
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private IPM_Employe ipm_employe;
    @ManyToOne
    @JoinColumn(name="idcotisation")
    private IPM_Cotisation ipm_cotisation;
    public IPM_Details_Cotisations( IPM_Employe ipm_employe, IPM_Cotisation ipm_cotisation) {
        this.ipm_employe = ipm_employe;
        this.ipm_cotisation = ipm_cotisation;
    }
    public IPM_Details_Cotisations(Long id_Det_Coti,IPM_Employe ipm_employe, IPM_Cotisation ipm_cotisation,Double montant) {
        this.ipm_employe = ipm_employe;
        this.ipm_cotisation = ipm_cotisation;
        this.montant=montant;
    }
}
