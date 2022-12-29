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
public class IPM_Suivie_Bon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_suivie_bon;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ipm_etat_bon",
            joinColumns = @JoinColumn(name = "idbon"),
            inverseJoinColumns = @JoinColumn(name = "id_suivie_bon")
    )
    private List<IPM_Bon> ipm_bons;
}
