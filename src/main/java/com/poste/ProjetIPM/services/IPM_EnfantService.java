package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface IPM_EnfantService {

    Collection<IPM_Enfant> getAll();

    IPM_Enfant getById(long id);

    List<IPM_Enfant> getEnfantById(Long id);
    IPM_Enfant getEnfant(Long id);
    public IPM_Enfant getEnfantt(Long id);
    IPM_Enfant save(IPM_Enfant ipm_enfant);

    void update(IPM_Enfant ipm_enfant);

    void delete(long id);

    String AjouterUnFichier(MultipartFile file) throws IOException;
    String AjouterUnFichierExtrait(MultipartFile file) throws IOException;
    String AjouterUnFichier_extrait(MultipartFile file_extrait) throws IOException;
    IPM_Enfant AjouterLesAttributsDuFichier(IPM_Enfant ipm_enfant);

    public ResponseEntity<byte[]> getImage(Long id);
    // void AjouterUnFichier(MultipartFile file);
}
