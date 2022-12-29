package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Entity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntity;
    private String nom_entity;
    private String code_entity;

    @JsonIgnore
    @OneToMany(mappedBy = "ipmEntity")
    private List<IPM_Service> ipm_services;

    @JsonIgnore
    @OneToMany(mappedBy = "ipmEntity")
    private List<IPM_Employe> ipm_employes;

    public Long getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(Long idEntity) {
        this.idEntity = idEntity;
    }

    public String getNom_entity() {
        return nom_entity;
    }

    public void setNom_entity(String nom_entity) {
        this.nom_entity = nom_entity;
    }

    public String getCode_entity() {
        return code_entity;
    }

    public void setCode_entity(String code_entity) {
        this.code_entity = code_entity;
    }

    public List<IPM_Service> getIpm_services() {
        return ipm_services;
    }

    public void setIpm_services(List<IPM_Service> ipm_services) {
        this.ipm_services = ipm_services;
    }
}
