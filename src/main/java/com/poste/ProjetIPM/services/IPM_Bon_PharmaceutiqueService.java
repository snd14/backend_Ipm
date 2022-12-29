package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_PharmaceutiqueRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPM_Bon_PharmaceutiqueService {

    List<IPM_Bon_PharmaceutiqueRepository> getAll();

    String AjouterUnFichier(MultipartFile file) throws IOException;

    void getById(long id);

    Long save(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique);

    List<IPM_Bon> getBonConjPharmacie(Long id);

    List<IPM_Bon> getBonEnfPharmacie(Long id);

    void update(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique);

    void delete(Long id);
    List<IPM_Bon> getBonPharmacie(Long id);
}
