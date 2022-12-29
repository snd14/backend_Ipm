package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_EnfantRepository;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class IPM_EnfantServiceImpl implements IPM_EnfantService {
    @Autowired
    IPM_EnfantRepository ipm_enfantRepository;

    @Override
    public Collection<IPM_Enfant> getAll() {
        return ipm_enfantRepository.findAll();
    }

    @Override
    public IPM_Enfant getById(long id) {
            return ipm_enfantRepository.findById(id).get();
    }

    @Override
    public List<IPM_Enfant> getEnfantById(Long id) {
        return ipm_enfantRepository.getEnfantById(id);
    }

    @Override
    public IPM_Enfant getEnfant(Long id) {
        return ipm_enfantRepository.getEnfant(id);
    }
    @Override
    public IPM_Enfant getEnfantt(Long id) {
        return ipm_enfantRepository.findById(id).get();
    }


    @Override
    public IPM_Enfant save(IPM_Enfant ipm_enfant) {
        return ipm_enfantRepository.save(ipm_enfant);
    }

    @Override
    public void update(IPM_Enfant ipm_enfant) {
        ipm_enfantRepository.save(ipm_enfant);
    }

    @Override
    public void delete(long id) {
        ipm_enfantRepository.deleteById(id);
    }

    @Override
    public String AjouterUnFichier(MultipartFile file) throws IOException {
        String uploadDir = "/var/www/html/ipmfiles/images/enfants/";
      //   String uploadDir = "E:/MesDossiers/Images-IPM_Enfants/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();
        // Validate that file actually got created
        if (!fileCreated) {
            throw new IOException("Unable to create file at specified path. It already exists");
        }


        try (FileOutputStream fout = new FileOutputStream(fileName)) {
            fout.write(file.getBytes());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        return "Succes";
    }
    //
    @Override
    public String AjouterUnFichierExtrait(MultipartFile file) throws IOException {
        String uploadCertif = "/var/www/html/ipmfiles/files/extrait/";
        // String uploadCertif = "E:/MesDossiers/Images-IPM_Enfants/";
        File fileName = new File(uploadCertif+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();
        // Validate that file actually got created
        if (!fileCreated) {
            throw new IOException("Unable to create file at specified path. It already exists");
        }


        try (FileOutputStream fout = new FileOutputStream(fileName)) {
            fout.write(file.getBytes());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        return "Succes";
    }

    @Override
    public String AjouterUnFichier_extrait(MultipartFile file_extrait) throws IOException {
        String uploadDir = "/var/www/html/ipmfiles/images/enfants/";
        //String uploadDir = "E:/MesDossiers/Images-IPM_Enfants/";
        File fileName = new File(uploadDir+""+file_extrait.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();
        // Validate that file actually got created
        if (!fileCreated) {
            throw new IOException("Unable to create file at specified path. It already exists");
        }


        try (FileOutputStream fout = new FileOutputStream(fileName)) {
            fout.write(file_extrait.getBytes());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        return "Succes";
    }


    @Override
    public IPM_Enfant AjouterLesAttributsDuFichier(IPM_Enfant ipm_enfant) {
        return ipm_enfantRepository.save(ipm_enfant);
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) {
        return (ResponseEntity<byte[]>) ipm_enfantRepository.getEnfantById(id);
    }
}
