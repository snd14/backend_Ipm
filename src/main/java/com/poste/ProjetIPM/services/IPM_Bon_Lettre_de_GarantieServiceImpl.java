package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_Lettre_de_GarantieRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
@Transactional
public class IPM_Bon_Lettre_de_GarantieServiceImpl implements IPM_Bon_Lettre_de_GarantieService {
    @Autowired
    IPM_Bon_Lettre_de_GarantieRepository ipm_bon_lettre_de_garantieRepository;
    @Override
    public List<IPM_Bon_Lettre_de_GarantieRepository> getAll() {
        return null;
    }
    @Override
    public String AjouterUnFichier(MultipartFile file) throws IOException {
        String uploadDir = "/var/www/html/ipmfiles/files/ordonnances/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();
        // Validate that file actually got created
//        if (!fileCreated) {
//            throw new IOException("Unable to create file at specified path. It already exists");
//        }
        // IPM_Enfant ipm_enfant = ipm_enfantRepository.findById().get();
        //ipm_enfant.setIdenf(id);
        // ipm_enfant.setChemin(uploadDir + "" + file.getOriginalFilename());
        // ipm_enfantRepository.save(ipm_enfant);

//        try (FileOutputStream fout = new FileOutputStream(fileName)) {
//            fout.write(file.getBytes());
//        } catch (Exception exe) {
//            exe.printStackTrace();
//        }

        return "Succes";
    }
    @Override
    public void getById(long id) {
   ipm_bon_lettre_de_garantieRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie) {
         ipm_bon_lettre_de_garantieRepository.save(ipm_bon_lettre_de_garantie);
    }
    @Override
    public List<IPM_Bon> getBonLettreGarant(Long id) {
        return ipm_bon_lettre_de_garantieRepository.getEmpLettreById(id);
    }

    @Override
    public void update(IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie) {

    }
    @Override
    public List<IPM_Bon> getBonLettreConj(Long id) {
        return ipm_bon_lettre_de_garantieRepository.getConjLettreById(id);
    }
    @Override
    public List<IPM_Bon> getBonLettreEnf(Long id) {
        return ipm_bon_lettre_de_garantieRepository.getEnfLettreById(id);
    }

    @Override
    public void delete(Long id) {

    }
}
