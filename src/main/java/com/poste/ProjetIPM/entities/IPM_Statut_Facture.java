package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Statut_Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatutFacture;

    public Long getIdStatutFacture() {
        return idStatutFacture;
    }

    public void setIdStatutFacture(Long idStatutFacture) {
        this.idStatutFacture = idStatutFacture;
    }

    public String getStatutFacture() {
        return statutFacture;
    }

    public void setStatutFacture(String statutFacture) {
        this.statutFacture = statutFacture;
    }

    public IPM_Facture getIpm_facture() {
        return ipm_facture;
    }

    public void setIpm_facture(IPM_Facture ipm_facture) {
        this.ipm_facture = ipm_facture;
    }

    private String statutFacture;

    @ManyToOne
    private IPM_Facture ipm_facture;
}
