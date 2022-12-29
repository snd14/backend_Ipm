package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.services.IPM_Bon_PharmaceutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_Bon_PharmaceutiqueController {

    @Autowired
    IPM_Bon_PharmaceutiqueService ipm_bon_pharmaceutiqueService;

    @PostMapping(value="/bonpharma")
    public Long save(@RequestBody IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique) {
        return ipm_bon_pharmaceutiqueService.save(ipm_bon_pharmaceutique);
    }
    @RequestMapping(path= "/uploadeOrdonnance", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadOrdonn(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_bon_pharmaceutiqueService.AjouterUnFichier(file);
        return "succes";
    }
    @GetMapping(value = "/getbonParmByid/{id}")
    public List<IPM_Bon> getBonParmaById(@PathVariable Long id) {
        return ipm_bon_pharmaceutiqueService.getBonPharmacie(id);
    }
    @GetMapping(value = "/getbonParmConjByid/{id}")
    public List<IPM_Bon> getBonParmaConjById(@PathVariable Long id) {
        return ipm_bon_pharmaceutiqueService.getBonConjPharmacie(id);
    }
    @GetMapping(value = "/getbonParmEnfByid/{id}")
    public List<IPM_Bon> getBonParmaEnfById(@PathVariable Long id) {
        return ipm_bon_pharmaceutiqueService.getBonEnfPharmacie(id);
    }
    @GetMapping("/bonpharma/{id}")
    public void getById(@PathVariable Long id) {
        ipm_bon_pharmaceutiqueService.getById(id);
    }


}













































