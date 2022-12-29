package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Categorie;
import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface IPM_ConjointService {
    Collection<IPM_Conjoint> getAll();

    List<IPM_Conjoint> getConjointById(Long id);

    void save(IPM_Conjoint ipm_conjoint);

    void update(IPM_Conjoint ipm_conjoint);

    void delete(Long id);
    String AjouterUnFichierConjoint(MultipartFile file) throws IOException;
    String AjouterCertifConjoint(MultipartFile file) throws IOException;

    IPM_Conjoint AjouterLesAttributsDuFichier(IPM_Conjoint ipm_conjoint);
    IPM_Conjoint getById(long id);

}
