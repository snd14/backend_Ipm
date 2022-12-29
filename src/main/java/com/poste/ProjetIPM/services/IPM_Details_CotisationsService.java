package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.entities.IPM_Details_Cotisations;
import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Remboursement;

import java.util.Collection;
import java.util.List;

public interface IPM_Details_CotisationsService {
    Collection<IPM_Details_Cotisations> getAll();

    IPM_Details_Cotisations getById(long id);

    List<IPM_Details_Cotisations> save(List<IPM_Details_Cotisations> ipm_details_cotisations);

    //List <IPM_Details_Cotisations> getDetailcotisation(IPM_Cotisation ipm_cotisation);

    void update(IPM_Details_Cotisations ipm_details_cotisations);

    void delete(Long id);
    Collection<IPM_Details_Cotisations> listCotisationById(long id);
    Collection<IPM_Details_Cotisations> getCumulCotisation(Integer annee);
}
