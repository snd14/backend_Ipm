package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.entities.IPM_Prestataire;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface IPM_PrestataireService {

    Collection<IPM_Prestataire> getAll();

    IPM_Prestataire getById(long id);

    void save(IPM_Prestataire ipm_prestataire);

    void update(IPM_Prestataire ipm_prestataire);
    List<IPM_Prestataire> getPrestataireBy(String nom);

    void delete(Long id);

    String AjouterFichierLettre(MultipartFile file) throws IOException;
}
