package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Statut_Facture;

import java.util.Collection;

public interface IPM_Statut_FactureService {

    Collection<IPM_Statut_Facture> getAll();

    IPM_Statut_Facture getById(long id);

    void save(IPM_Statut_Facture ipm_statut_facture);

    void update(IPM_Statut_Facture ipm_statut_facture);

    void delete(Long id);
}
