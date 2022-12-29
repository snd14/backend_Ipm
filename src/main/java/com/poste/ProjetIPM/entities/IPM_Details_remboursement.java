package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class IPM_Details_remboursement  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetail;
    private String matricule;
    private Long montant;
    //private  tarification;
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private IPM_Employe ipm_employe;
    @ManyToOne
    @JoinColumn(name = "idRemboursement")
    private IPM_Remboursement ipmRemboursement;
    public IPM_Details_remboursement(Long montant,IPM_Employe ipm_employe,IPM_Remboursement ipmRemboursement){
        this.montant=montant;
        this.ipm_employe=ipm_employe;
        this.ipmRemboursement=ipmRemboursement;
    }
}
