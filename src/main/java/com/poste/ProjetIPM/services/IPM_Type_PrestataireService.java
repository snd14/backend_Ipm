package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Type_Prestataire;

import java.util.Collection;

public interface IPM_Type_PrestataireService {

    Collection<IPM_Type_Prestataire> getAll();

    IPM_Type_Prestataire getById(long id);

    void save(IPM_Type_Prestataire ipm_type_prestataire);

    void update(IPM_Type_Prestataire ipm_type_prestataire);

    void delete(Long id);
}
