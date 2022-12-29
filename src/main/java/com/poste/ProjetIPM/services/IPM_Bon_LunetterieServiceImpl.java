package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_LunetterieRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Lunetterie;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class IPM_Bon_LunetterieServiceImpl implements IPM_Bon_LunetterieService {
    @Autowired
     IPM_Bon_LunetterieRepository ipm_bon_lunetterieRepository;
    @Override
    public void save(IPM_Bon_Lunetterie ipm_bon_lunetterie) {
        ipm_bon_lunetterieRepository.save(ipm_bon_lunetterie);
    }
    @Override
    public String AjouterUnFichier(MultipartFile file) throws IOException {
      //  String uploadDir = "E:/MesDossiers/ordonnance_pharmacie/";
         String uploadDir = "/var/www/html/ipmfiles/files/ordonnances/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();

        return "Succes";
    }
    @Override
    public String AjouterUnDevit(MultipartFile file) throws IOException {
       String uploadDir = "/var/www/html/ipmfiles/files/ordonnances/";
     //   String uploadDir = "E:/MesDossiers/ordonnance_pharmacie/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();

        return "Succes";
    }
    @Override
    public List<IPM_Bon> getBonLunetteConj(Long id) {
        return ipm_bon_lunetterieRepository.getConjLunetterieById(id);
    }
    @Override
    public List<IPM_Bon> getBonLunetteEnf(Long id) {
        return ipm_bon_lunetterieRepository.getEnfLunetterieById(id);
    }
    @Override
    public List<IPM_Bon> getBonLunetterie(Long id) {
        return ipm_bon_lunetterieRepository.getEmpLunetterieById(id);
    }
    @Override
    public Collection<IPM_Bon_Lunetterie> getAll(){
        return  ipm_bon_lunetterieRepository.findAll();
    }
}
