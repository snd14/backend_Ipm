package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Statut_Bon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatutBon;

    public Long getIdStatutBon() {
        return idStatutBon;
    }

    public void setIdStatutBon(Long idStatutBon) {
        this.idStatutBon = idStatutBon;
    }

    public String getStatutBon() {
        return statutBon;
    }

    public void setStatutBon(String statutBon) {
        this.statutBon = statutBon;
    }

    public IPM_Bon getIpm_bon() {
        return ipm_bon;
    }

    public void setIpm_bon(IPM_Bon ipm_bon) {
        this.ipm_bon = ipm_bon;
    }

    private String statutBon;

    @ManyToOne
    private IPM_Bon ipm_bon;
}
