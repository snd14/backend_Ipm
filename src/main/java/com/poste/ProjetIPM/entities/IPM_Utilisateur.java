
package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
    private boolean isEnable;


    @JsonIgnoreProperties("users")
    @ManyToMany
    @JoinTable( name = "Users_Roles_Associations",
            joinColumns = @JoinColumn( name = "id_user" ),
            inverseJoinColumns = @JoinColumn( name = "id_role" ) )

    private List<IPM_Role> roles =new ArrayList<>();
   /* @ManyToOne
    private IPM_Service ipmService;*/


}

