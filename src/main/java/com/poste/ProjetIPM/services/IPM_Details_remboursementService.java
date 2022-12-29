package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Remboursement;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IPM_Details_remboursementService {
    Collection<IPM_Details_remboursement> getAll();

    IPM_Details_remboursement getById(long id);

    List<IPM_Details_remboursement> save(List<IPM_Details_remboursement> ipmDetailremboursement);

    List <IPM_Details_remboursement> getDetailrembourse(IPM_Remboursement ipmRemboursement);

    void update(IPM_Details_remboursement ipmDetailremboursement);

    void delete(Long id);

    Collection<IPM_Details_remboursement> getIndividuelRembour(Date date1, Date date2, String matricule);
}
