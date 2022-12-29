package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_PharmaceutiqueRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class IPM_Bon_PharmaceutiqueServiceImpl implements IPM_Bon_PharmaceutiqueService {

    @Autowired
    IPM_Bon_PharmaceutiqueRepository ipm_bon_pharmaceutiqueRepository;

    @Override
    public List<IPM_Bon_PharmaceutiqueRepository> getAll() {
        return null;
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
    public void getById(long id) {
        ipm_bon_pharmaceutiqueRepository.findById(id).get();
    }

    @Override
    public Long save(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique) {
        IPM_Bon_Pharmaceutique bonPh=ipm_bon_pharmaceutiqueRepository.save(ipm_bon_pharmaceutique);
        return bonPh.getIdbon();
    }

    //List<IPM_Bon> getBonPharmacie(Long id);
    @Override
    public List<IPM_Bon> getBonPharmacie(Long id) {
        return ipm_bon_pharmaceutiqueRepository.getEmpPharmById(id);
    }
    @Override
    public List<IPM_Bon> getBonConjPharmacie(Long id) {
        return ipm_bon_pharmaceutiqueRepository.getConjPharmById(id);
    }
    @Override
    public List<IPM_Bon> getBonEnfPharmacie(Long id) {
        return ipm_bon_pharmaceutiqueRepository.getEnfPharmById(id);
    }

    @Override
    public void update(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique) {

    }

    @Override
    public void delete(Long id) {

    }
}
