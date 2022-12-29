/*package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class IPM_Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_beneficiaire;
    private Integer identification;

    //@OneToMany (mappedBy = "ipm_beneficiaire")
    //private List<IPM_Bon> ipm_bons;

    @ManyToOne
    private IPM_Employe ipm_employe;

}
*/
