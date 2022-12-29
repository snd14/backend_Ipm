package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class IPM_Type_Prestataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_prestataire;
    private String libelle;
    private String nom_type_prestaire;
    @OneToMany
    private List<IPM_Prestataire> ipm_prestataires;
}
