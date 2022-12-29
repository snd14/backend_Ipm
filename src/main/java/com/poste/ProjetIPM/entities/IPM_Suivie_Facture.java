package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Suivie_Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_suivie_facture;

    public Long getId_suivie_facture() {
        return id_suivie_facture;
    }

    public void setId_suivie_facture(Long id_suivie_facture) {
        this.id_suivie_facture = id_suivie_facture;
    }

    public List<IPM_Facture> getIpm_factures() {
        return ipm_factures;
    }

    public void setIpm_factures(List<IPM_Facture> ipm_factures) {
        this.ipm_factures = ipm_factures;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ipm_etat_facture",
            joinColumns = @JoinColumn(name = "idfacture"),
            inverseJoinColumns = @JoinColumn(name = "id_suivie_facture")
    )
    private List<IPM_Facture> ipm_factures;

}
