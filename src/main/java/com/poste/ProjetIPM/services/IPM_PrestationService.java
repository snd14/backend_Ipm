package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Prestation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface IPM_PrestationService {

    Collection<IPM_Prestation> getAll();

    IPM_Prestation getById(long id);

    void save(IPM_Prestation ipm_prestation);

    void update(IPM_Prestation ipm_prestation);

    void delete(Long id);

}
