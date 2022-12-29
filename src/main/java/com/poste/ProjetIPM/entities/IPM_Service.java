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
public class IPM_Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private String type_service;
    private String code_service;

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public String getType_service() {
        return type_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
    }

    public String getCode_service() {
        return code_service;
    }

    public void setCode_service(String code_service) {
        this.code_service = code_service;
    }

    public List<IPM_Employe> getIpm_employes() {
        return ipm_employes;
    }

    public void setIpm_employes(List<IPM_Employe> ipm_employes) {
        this.ipm_employes = ipm_employes;
    }

    public IPM_Entity getIpmEntity() {
        return ipmEntity;
    }

    public void setIpmEntity(IPM_Entity ipmEntity) {
        this.ipmEntity = ipmEntity;
    }




    @JsonIgnore
    @OneToMany(mappedBy = "ipmService")
    private List<IPM_Employe> ipm_employes;

    @ManyToOne
    private IPM_Entity ipmEntity;

}
