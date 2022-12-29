package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Remboursement;

import java.util.Collection;

public interface IPM_RemboursementService {

    Collection<IPM_Remboursement> getAll();

    IPM_Remboursement getById(long id);

    Long save(IPM_Remboursement ipm_remboursement);

    void update(IPM_Remboursement ipm_remboursement);

    void delete(Long id);
}
