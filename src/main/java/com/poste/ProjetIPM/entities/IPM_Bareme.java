package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Bareme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBareme;
    private Long min;
    private Long max;
    private Long montant;

    public Long getIdBareme() {
        return idBareme;
    }

    public void setIdBareme(Long idBareme) {
        this.idBareme = idBareme;
    }

    /*public IPM_Prestation getIpm_prestation() {
        return ipm_prestation;
    }

    public void setIpm_prestation(IPM_Prestation ipm_prestation) {
        this.ipm_prestation = ipm_prestation;
    }
*/
    /*@ManyToOne
    private IPM_Prestation ipm_prestation;*/
}
