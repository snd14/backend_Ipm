package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Facture;

import java.util.Collection;
import java.util.Date;

public interface IPM_FactureService {

    Collection<IPM_Facture> getAll();

    //IPM_Facture getById(long id);

    IPM_Facture getById(long id);

    Collection<IPM_Facture>  getBycertifier(boolean certifier);

    Collection<IPM_Facture>  getByDatefacture(Date date);

    Long save(IPM_Facture ipm_facture);

    void update(IPM_Facture ipm_facture);

    void delete(Long id);

    Collection<IPM_Facture> getCreancesGlobales(Date date1,Date date2);
}
