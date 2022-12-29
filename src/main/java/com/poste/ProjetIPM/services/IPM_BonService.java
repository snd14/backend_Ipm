package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Bon;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IPM_BonService {

   // Collection<IPM_Bon> getAll();

    Collection<IPM_Bon> getAll();

    IPM_Bon getById(long id);

    List<IPM_Bon> getBonById(Long id);

    void save(IPM_Bon ipm_bon);

    void update(IPM_Bon ipm_bon);

    void delete(Long id);

    List<IPM_Bon> getPrestataire(Long id);

    Collection<IPM_Bon> getBonbyperiode(Date date1, Date date2,String typeBon);

    Collection<IPM_Bon> getBonbyperiodeAndType(Date date1, Date date2, Long d3);
}
