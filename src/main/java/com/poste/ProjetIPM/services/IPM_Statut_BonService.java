package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Statut_Bon;

import java.util.Collection;

public interface IPM_Statut_BonService {

    Collection<IPM_Statut_Bon> getAll();

    IPM_Statut_Bon getById(long id);

    void save(IPM_Statut_Bon ipm_statut_bon);

    void update(IPM_Statut_Bon ipm_statut_bon);

    void delete(Long id);
}
