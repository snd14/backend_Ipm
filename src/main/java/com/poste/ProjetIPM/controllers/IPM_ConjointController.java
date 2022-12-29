package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_ConjointRepository;
import com.poste.ProjetIPM.Repository.IPM_EmployeRepository;
import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.services.IPM_ConjointService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.dom4j.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
//@RequestMapping("/api")
public class IPM_ConjointController {

    @Autowired
    IPM_ConjointService ipm_conjointService;

    @Autowired
    private IPM_ConjointRepository ipm_conjointRepo;

    @Autowired
    IPM_ConjointRepository ipm_conjointRepository;

    @Autowired
    IPM_EmployeRepository ipm_employeRepository;

    @GetMapping(value = "/conjoint")
    public Collection<IPM_Conjoint> getAll() {
        return ipm_conjointService.getAll();

    }

    @GetMapping("/conjoint/{id}")
    public IPM_Conjoint getByIdConjoit(@PathVariable Long id){
        IPM_Conjoint ipm_conjoint =ipm_conjointService.getById(id);
        ipm_conjoint.setPhotos(convertStringToBase64(ipm_conjoint.getPhotos()));
        return ipm_conjoint;
    }
    @GetMapping("/conjointsansphoto/{id}")
    public IPM_Conjoint getByIdConjointsansphoto(@PathVariable Long id){
        IPM_Conjoint ipm_conjoint =ipm_conjointService.getById(id);

        return ipm_conjoint;
    }
    @GetMapping(value = "/getconjointByid/{id}")
    public List<IPM_Conjoint> getConjointById(@PathVariable Long id) {
        List<IPM_Conjoint> ipmConjointList=ipm_conjointRepo.getConjointById(id);
        for(int i=0;i<ipmConjointList.size();i++){
            ipmConjointList.get(i).setPhotos(
                    convertStringToBase64(ipmConjointList.get(i).getPhotos())
            );
        }
        log.info("liste conjoint");
        return ipmConjointList;

    }

    @RequestMapping(path= "/uploade", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("image") MultipartFile file)
            throws IOException {
        ipm_conjointService.AjouterUnFichierConjoint(file);
        return "succes";
    }
    //
    @RequestMapping(path= "/uploadeCertif", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadCertif(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_conjointService.AjouterCertifConjoint(file);
        return "succes";
    }
    ////fonction qui Converti l'image en base 64
    public String convertStringToBase64(String fileName) {
        byte[] fileContent;
        if (fileName!=null) {
            try {
                File file = new File(fileName);

                if (file.exists()) {
                    fileContent = FileUtils.readFileToByteArray(file);
                    return "data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(fileContent);
                } else
                    return "";
            } catch (IOException e) {
                return "Erreur de conversio";
            }
        }else{
            return "";
        }
    }

    @PostMapping("/conjoint")
    public void save(@RequestBody IPM_Conjoint ipm_conjoint) {

        //String uploadDir = "E:/MesDossiers/Images-IPM_Conjoints";
        String uploadDir = "/var/www/html/ipmfiles/images/conjoints";
        ipm_conjoint.setPhotos(uploadDir+"/"+ipm_conjoint.getPhotos());
        //String chemin="E:/MesDossiers/Images-IPM_Conjoints";
        String chemin="/var/www/html/ipmfiles/fiLes/certifmariages";
        ipm_conjoint.setCertificat(chemin+"/"+ipm_conjoint.getCertificat());
        ipm_conjointService.save(ipm_conjoint);
       // return "Slt " + ipm_conjoint.getNom_conjoint() + "enregistrement reussi avec success";

    }

    @PutMapping("/putconjoint")
    public void update(@RequestBody IPM_Conjoint ipm_conjoint) {
      //  String filename = file.getOriginalFilename();
        //String modifChemin = "  E:/MesDossiers/Images-IPM_Conjoints";
        String modifChemin = "/var/www/html/ipmfiles/images/conjoints";
        ipm_conjoint.setPhotos(modifChemin+"/"+ipm_conjoint.getPhotos());
//        String cheminCertif="C:/MesDossiers/Images-IPM_conjoint";
//        ipm_conjoint.setCertificat(cheminCertif+"/"+ipm_conjoint.getCertificat());

        ipm_conjointService.update(ipm_conjoint);

    }
    @PutMapping("/putconjointsansphoto")
    public void updatesanstof(@RequestBody IPM_Conjoint ipm_conjoint) {
//        String filename = file.getOriginalFilename();
//        String modifChemin = "C:/MesDossiers/Images-IPM_conjoint";
//        ipm_conjoint.setPhotos(modifChemin+"/"+filename);
//        String cheminCertif="C:/MesDossiers/Images-IPM_conjoint";
//        ipm_conjoint.setCertificat(cheminCertif+"/"+ipm_conjoint.getCertificat());

        ipm_conjointService.update(ipm_conjoint);

    }

    @DeleteMapping("/conjoint/{id}")
    public void delete(@PathVariable Long id) {
        ipm_conjointService.delete(id);
    }
}
