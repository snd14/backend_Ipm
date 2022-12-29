package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IPM_StatutEmploye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatut;
    private String emplStatut;
    @JsonIgnore
    @OneToMany(mappedBy = "ipmStatutEmploye")
    private List<IPM_Employe> ipm_employes;
}
