package com.poste.ProjetIPM.services;


import com.poste.ProjetIPM.entities.IPM_Precompte;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IPM_PrecompteService {
    Collection<IPM_Precompte> getAll();

    IPM_Precompte getById(long id);

    void save(IPM_Precompte ipm_precompte);



    String AjouterLettreAgr(MultipartFile file) throws IOException;

    Collection<IPM_Precompte>  getByDatePrecompte(Date date);
    List<IPM_Precompte> save(List<IPM_Precompte> ipm_precompte);

    void update(IPM_Precompte ipm_precompte);

    void delete(Long id);
}

