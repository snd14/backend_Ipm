package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_ConjointRepository;
import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class IPM_ConjointServiceImpl implements IPM_ConjointService {

    @Autowired
    IPM_ConjointRepository ipm_conjointRepository;

    @Override
    public Collection<IPM_Conjoint> getAll() {
        return ipm_conjointRepository.findAll();
    }

    @Override
    public List<IPM_Conjoint> getConjointById(Long id) {

        return ipm_conjointRepository.getConjointById(id);
    }

    @Override
    public void save(IPM_Conjoint ipm_conjoint) {
        ipm_conjointRepository.save(ipm_conjoint);
    }

    @Override
    public void update(IPM_Conjoint ipm_conjoint) {
        ipm_conjointRepository.save(ipm_conjoint);
    }

    @Override
    public void delete(Long id) {
        ipm_conjointRepository.deleteById(id);
    }

    @Override
    public String AjouterUnFichierConjoint(MultipartFile file) throws IOException {
     //   String uploadDir = "/var/www/html/ipmfiles/images/conjoints/";
        String uploadDir = "E:/MesDossiers/Images-IPM_Conjoints/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();
        // Validate that file actually got created
        if (!fileCreated) {
            throw new IOException("Unable to create file at specified path. It already exists");
        }
        // IPM_Enfant ipm_enfant = ipm_enfantRepository.findById().get();
        //ipm_enfant.setIdenf(id);
        // ipm_enfant.setChemin(uploadDir + "" + file.getOriginalFilename());
        // ipm_enfantRepository.save(ipm_enfant);

        try (FileOutputStream fout = new FileOutputStream(fileName)) {
            fout.write(file.getBytes());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        return "Succes";
    }
        @Override
    public String AjouterCertifConjoint(MultipartFile file) throws IOException {
      // String chemin = "/var/www/html/ipmfiles/files/certifmariages/";
              String chemin = "E:/MesDossiers/ordonnance_pharmacie/";
        File fileName = new File(chemin+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();
        // Validate that file actually got created
        if (!fileCreated) {
            throw new IOException("Unable to create file at specified path. It already exists");
        }
        // IPM_Enfant ipm_enfant = ipm_enfantRepository.findById().get();
        //ipm_enfant.setIdenf(id);
        // ipm_enfant.setChemin(uploadDir + "" + file.getOriginalFilename());
        // ipm_enfantRepository.save(ipm_enfant);

        try (FileOutputStream fout = new FileOutputStream(fileName)) {
            fout.write(file.getBytes());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        return "Succes";
    }

    @Override
    public IPM_Conjoint AjouterLesAttributsDuFichier(IPM_Conjoint ipm_conjoint) {
        return ipm_conjointRepository.save(ipm_conjoint);
    }

    @Override
    public IPM_Conjoint getById(long id) {
        return ipm_conjointRepository.findById(id).get();
    }
}
