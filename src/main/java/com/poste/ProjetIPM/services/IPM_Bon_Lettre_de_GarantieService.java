package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_Lettre_de_GarantieRepository;
import com.poste.ProjetIPM.Repository.IPM_Bon_PharmaceutiqueRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPM_Bon_Lettre_de_GarantieService {
    List<IPM_Bon_Lettre_de_GarantieRepository> getAll();

    String AjouterUnFichier(MultipartFile file) throws IOException;

    void getById(long id);

    void save(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie);

    List<IPM_Bon> getBonLettreGarant(Long id);

    void update(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie);

    List<IPM_Bon> getBonLettreConj(Long id);

    List<IPM_Bon> getBonLettreEnf(Long id);

    void delete(Long id);
}
