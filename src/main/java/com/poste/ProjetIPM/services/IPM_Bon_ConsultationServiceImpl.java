package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Bon_ConsultationRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class IPM_Bon_ConsultationServiceImpl implements IPM_Bon_ConsultationService {
    @Autowired
    IPM_Bon_ConsultationRepository ipm_bon_consultationRepository;
    @Override
    public List<IPM_Bon_Consultation> getAll() {
        return null;
    }
    @Override
    public String AjouterUnFichier(MultipartFile file) throws IOException {
        String uploadDir = "/var/www/html/ipmfiles/files/ordonnances/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();

        return "Succes";
    }
    @Override
    public List<IPM_Bon> getBonConjCons(Long id) {
        return ipm_bon_consultationRepository.getConjConsById(id);
    }
    @Override
    public List<IPM_Bon> getBonEnfCons(Long id) {
        return ipm_bon_consultationRepository.getEnfConsById(id);
    }
    @Override
    public List<IPM_Bon> getBonConsultation(Long id) {
        return ipm_bon_consultationRepository.getEmpConsulById(id);
    }
   // @Override
    //public void getById(long id) {
     //   ipm_bon_Consul.findById(id).get();
    //}

    @Override
    public void save(IPM_Bon_Consultation ipm_bon_consultaton) {
        ipm_bon_consultationRepository.save(ipm_bon_consultaton);
    }

   // @Override
   // public void update(IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique) {

   // }
}
