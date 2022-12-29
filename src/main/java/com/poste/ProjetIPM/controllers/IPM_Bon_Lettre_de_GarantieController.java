package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_Bon_Lettre_de_GarantieRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import com.poste.ProjetIPM.services.IPM_Bon_Lettre_de_GarantieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_Bon_Lettre_de_GarantieController {

    @Autowired
    IPM_Bon_Lettre_de_GarantieService ipm_bon_lettre_de_garantieService;

    @PostMapping(path="/bonlettre")
    public void save(@RequestBody IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie) {
       ipm_bon_lettre_de_garantieService.save(ipm_bon_lettre_de_garantie);
    }
    @RequestMapping(path= "/uploadeOrdonnanceL", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadOrdonn(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_bon_lettre_de_garantieService.AjouterUnFichier(file);
        return "succes";
    }
    @GetMapping(value = "/getbonLettreGByid/{id}")
    public List<IPM_Bon> getBonLettreById(@PathVariable Long id) {
        return ipm_bon_lettre_de_garantieService.getBonLettreGarant(id);
    }
    @GetMapping(value = "/getbonLettreConjByid/{id}")
    public List<IPM_Bon> getBonParmaConjById(@PathVariable Long id) {
        return ipm_bon_lettre_de_garantieService.getBonLettreConj(id);
    }
    @GetMapping(value = "/getbonLettreEnfByid/{id}")
    public List<IPM_Bon> getBonParmaEnfById(@PathVariable Long id) {
        return ipm_bon_lettre_de_garantieService.getBonLettreEnf(id);
    }

    @GetMapping("/bonlettre/{id}")
    public void getById(@PathVariable Long id) {
       ipm_bon_lettre_de_garantieService.getById(id);
    }
}
