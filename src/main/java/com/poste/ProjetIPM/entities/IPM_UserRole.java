package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserRoleId.class)
@Table(name = "Users_Roles_Associations")
public class IPM_UserRole {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
   // @JsonIgnoreProperties({"roles","dg_caisse","dg_fonction","dg_structure","enable"})
    private IPM_Utilisateur ipm_utilisateur;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_role",nullable = false)
    //@JsonIgnoreProperties({"users"})
    private IPM_Role ipm_role;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateAtribution = new Date();

}
