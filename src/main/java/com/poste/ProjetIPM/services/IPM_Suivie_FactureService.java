package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Suivie_Facture;

import java.util.Collection;

public interface IPM_Suivie_FactureService {

    Collection<IPM_Suivie_Facture> getAll();

    IPM_Suivie_Facture getById(long id);

    void save(IPM_Suivie_Facture ipm_suivie_facture);

    void update(IPM_Suivie_Facture ipm_suivie_facture);

    void delete(Long id);
}
