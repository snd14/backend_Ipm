package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Bareme;

import java.util.Collection;

public interface IPM_BaremeService {

    Collection<IPM_Bareme> getAll();

    IPM_Bareme getById(long id);

    void save(IPM_Bareme ipm_bareme);

    void update(IPM_Bareme ipm_bareme);

    void delete(Long id);
}
