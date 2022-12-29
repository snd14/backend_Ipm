package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_EmployeRepository;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Service
@Transactional
public class IPM_EmployeServiceImpl implements IPM_EmployeService {

    @Autowired
    IPM_EmployeRepository ipm_employeRepository;

    @Override
    public Collection<IPM_Employe> getAll() {
        return ipm_employeRepository.findAll();
    }

    @Override
    public IPM_Employe getById(long id) {
        return ipm_employeRepository.findById(id).get();
    }
    @Override
    public Collection<IPM_Employe>getListbyservice(IPM_Service ipmService){
        return ipm_employeRepository.findByIpmService(ipmService);
    }
    @Override
    public IPM_Employe save(IPM_Employe ipm_employe) {
        // Long id= ipm_employe.getIpm_categorie().getCode_categorie();
        //    ipm_employe.setIpm_categorie(ipm_categorieService.getById(id));

        return ipm_employeRepository.save(ipm_employe);
    }

    @Override
    public void update(IPM_Employe ipm_employe) {
        ipm_employeRepository.save(ipm_employe);
    }

    @Override
    public  List<IPM_Employe> updateListe(List<IPM_Employe> ipm_employe) {
        for (int i = 0; i < ipm_employe.size(); i++) {
            ipm_employeRepository.save(ipm_employe.get(i));
            //ipm_employeRepository.update(ipm_employe.get(i));
        }
        return ipm_employe;
    }

        @Override
        public IPM_Employe getByMatricule (String matricule){
            return ipm_employeRepository.findByMatricule(matricule);
        }


    @Override
    public IPM_Employe getByReference(String reference) {
        return ipm_employeRepository.findByReference(reference);
    }

   /* @Override
    public IPM_Employe getByImage(long id) {
        return ipm_employeRepository.findByImage(id);
    }*/

    /*@Override
    public Optional<IPM_Employe> findByNom(Long id) {
        return Optional.empty();
    }*/

    @Override
    public void delete(Long id) {
        ipm_employeRepository.deleteById(id);
    }

    @Override
    public void createEmploye(MultipartFile file, IPM_Employe ipm_employe) {
        ipm_employeRepository.save(ipm_employe);
    }

    @Override
    public String AjouterUnFichierE(MultipartFile file) throws IOException {
        String uploadDir = "/var/www/html/ipmfiles/images/employes/";
      //  String uploadDir = "E:/MesDossiers/Images-IPM_Employes/";
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
    public String AjouterFichierJust(MultipartFile file) throws IOException {
      //  String uploadDir = "E:/MesDossiers/justificatif-employe/";
           String uploadDir = "/var/www/html/ipmfiles/files/jusificatifs/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();

        return "Succes";
    }
    @Override
    public IPM_Employe AjouterLesAttributsDuFichier(IPM_Employe ipm_employe) {
        return ipm_employeRepository.save(ipm_employe);
    }

   //Verifier un matricule
    @Override
    public boolean verifier(String matricule) {
//       Optional<IPM_Employe> ipmEmploye = ipm_employeRepository.findByMatricule(matricule);
//        if (!ipmEmploye.isPresent())
//            return false;
//        else return true;
        return  true;
    }

}
