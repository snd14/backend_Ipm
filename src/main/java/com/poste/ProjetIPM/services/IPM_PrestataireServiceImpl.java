package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_PrestataireRepository;
import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Type_Prestataire;
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
public class IPM_PrestataireServiceImpl implements IPM_PrestataireService {

    @Autowired
    IPM_PrestataireRepository ipm_prestataireRepository;

    @Override
    public Collection<IPM_Prestataire> getAll() {
        return ipm_prestataireRepository.findAll();
    }

    @Override
    public IPM_Prestataire getById(long id) {
        return ipm_prestataireRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Prestataire ipm_prestataire) {
        ipm_prestataireRepository.save(ipm_prestataire);
    }

    @Override
    public void update(IPM_Prestataire ipm_prestataire) {
        ipm_prestataireRepository.save(ipm_prestataire);
    }

    @Override
    public List<IPM_Prestataire> getPrestataireBy(String nom) {
        return ipm_prestataireRepository.getIPM_PrestataireByIdL(nom);
    }

    @Override
    public void delete(Long id) {
        ipm_prestataireRepository.deleteById(id);
    }

    @Override
    public String AjouterFichierLettre(MultipartFile file) throws IOException {
        //  String uploadDir = "E:/MesDossiers/justificatif-employe/";
        String uploadDir = "/var/www/html/ipmfiles/files/jusificatifs/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();

        return "Succes";
    }
}
