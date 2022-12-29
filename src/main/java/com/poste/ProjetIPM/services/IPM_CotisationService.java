package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Cotisation;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public interface IPM_CotisationService {

    Collection<IPM_Cotisation> getAll();

    IPM_Cotisation getById(long id);



    Long save(IPM_Cotisation ipm_cotisation);

    void update(IPM_Cotisation ipm_cotisation);

    void delete(Long id);
/*    boolean saveDataFromUploadFile(MultipartFile file);
     boolean readDataFromCsv(MultipartFile file);*/
}

