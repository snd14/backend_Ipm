package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Consultation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPM_Bon_ConsultationService {
    List<IPM_Bon_Consultation> getAll();

    String AjouterUnFichier(MultipartFile file) throws IOException;

    List<IPM_Bon> getBonConjCons(Long id);

    List<IPM_Bon> getBonEnfCons(Long id);

    List<IPM_Bon> getBonConsultation(Long id);

    //List<IPM_Bon> getBonConsultation(Long id);

    void save(IPM_Bon_Consultation ipm_bon_consultaton);
}
