package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_EnfantRepository;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.services.IPM_EnfantService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_EnfantController {
    @Autowired
    IPM_EnfantService ipm_enfantService;
    @Autowired
    IPM_EnfantRepository ipm_enfantRepo;

    @GetMapping("/enfant")
    public Collection<IPM_Enfant> getAll() {
        return ipm_enfantService.getAll();
    }

    @GetMapping(value = "/enfant/{id}")
    public IPM_Enfant getById(@PathVariable Long id) {
        IPM_Enfant ipmEnfant=ipm_enfantService.getEnfantt(id);
      ipmEnfant.setChemin(convertStringToBase64(ipmEnfant.getChemin()));
        return ipmEnfant;
    }
    @GetMapping(value = "/enfantsansPhoto/{id}")
    public IPM_Enfant getByIdSansPhoto(@PathVariable Long id) {
        IPM_Enfant ipmEnfant=ipm_enfantService.getEnfantt(id);
       // ipmEnfant.setChemin(convertStringToBase64(ipmEnfant.getChemin()));
        return ipmEnfant;
    }

    @GetMapping(value = "/getenfantByid/{id}")
    public List<IPM_Enfant> getEnfantById(@PathVariable Long id) {
        List<IPM_Enfant> ipm_enfantList =ipm_enfantRepo.getEnfantById(id);
        for(int i=0 ;i<ipm_enfantList.size();i++){
            ipm_enfantList.get(i).setChemin(
                    convertStringToBase64(ipm_enfantList.get(i).getChemin())
            );
        }
        return ipm_enfantList;
    }
    @PostMapping("/enfant")
    public void save(@RequestBody IPM_Enfant ipm_enfant) {
         String uploadDir = "/var/www/html/ipmfiles/images/enfants";
        // String uploadDir = "E:/MesDossiers/Images-IPM_Enfants";
        ipm_enfant.setChemin(uploadDir+"/"+ipm_enfant.getChemin());
        String uploadCertif="/var/www/html/ipmfiles/files/extrait";
      //  String uploadCertif="E:/MesDossiers/Images-IPM_Enfants";
        ipm_enfant.setExtrait_naiss(uploadCertif+"/"+ipm_enfant.getExtrait_naiss());
        //ipm_enfant.setExtrait_naiss(uploadDir+"/"+ipm_enfant.getExtrait_naiss());
        ipm_enfantService.save(ipm_enfant);
    }

    @PutMapping("/putenfant")
    public void update(@RequestBody IPM_Enfant ipm_enfant) {
        String cheminupdate = "/var/www/html/ipmfiles/images/enfants";
        //ipm_enfant.setChemin(cheminupdate+"/"+ipm_enfant.getChemin());
        //String uploadExtrait="/var/www/html/ipmfiles/images/enfants/";
        //ipm_enfant.setExtrait_naiss(uploadExtrait+"/"+ipm_enfant.getExtrait_naiss());
       // String cheminupdate = "E:/MesDossiers/Images-IPM_Enfants";
        ipm_enfant.setChemin(cheminupdate+"/"+ipm_enfant.getChemin());
        ipm_enfantService.update(ipm_enfant);
    }
    @PutMapping("/putenfantsansPhoto")
    public void updatesansPhoto(@RequestBody IPM_Enfant ipm_enfant) {
//        String cheminupdate = "/var/www/html/ipmfiles/images/enfants/";
//        ipm_enfant.setChemin(cheminupdate+"/"+ipm_enfant.getChemin());
//        String uploadExtrait="/var/www/html/ipmfiles/images/enfants/";
//        ipm_enfant.setExtrait_naiss(uploadExtrait+"/"+ipm_enfant.getExtrait_naiss());
        ipm_enfantService.update(ipm_enfant);
    }

    @DeleteMapping("/enfant/{id}")
    public void delete(@PathVariable Long id) {
        ipm_enfantService.delete(id);
    }

    @RequestMapping(path= "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("image") MultipartFile file)
            throws IOException {
        ipm_enfantService.AjouterUnFichier(file);
        return "succes";
    }
    //
    @RequestMapping(path= "/uploadExtrait", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFileExtrai(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_enfantService.AjouterUnFichier(file);
        return "succes";
    }

    @RequestMapping(path= "/ext", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFileExtrait(@RequestParam("image") MultipartFile file_extrait)
            throws IOException {
        ipm_enfantService.AjouterUnFichier_extrait(file_extrait);
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
    @GetMapping(path = "/ImagesEmp/{id}")
    public byte[] getPhoto(@PathVariable Long id,@RequestBody IPM_Enfant ipm_enfant) throws Exception {
        String uploadDir = "/var/www/html/ipmfiles/images/enfants/";
        ipm_enfantRepo.getEnfantById(id);
        System.out.println("message");
        byte[] bytes = Files.readAllBytes(Paths.get(uploadDir + "" + ipm_enfant.getChemin()));
        System.out.println(new String(bytes));
        return bytes;

    }
   /*@RequestMapping(value = "/Image/{id:.+}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        byte[] image = ipm_enfantService.getChemin(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }*/
}
