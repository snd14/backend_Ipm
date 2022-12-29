package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Suivie_Bon;

import java.util.Collection;

public interface IPM_Suivie_BonService {

    Collection<IPM_Suivie_Bon> getAll();

    IPM_Suivie_Bon getById(long id);

    void save(IPM_Suivie_Bon ipm_suivie_bon);

    void update(IPM_Suivie_Bon ipm_suivie_bon);

    void delete(Long id);
}
