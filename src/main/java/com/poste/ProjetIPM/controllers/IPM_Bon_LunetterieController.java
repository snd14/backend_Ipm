package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Lunetterie;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import com.poste.ProjetIPM.services.IPM_Bon_LunetterieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Bon_LunetterieController {
    @Autowired
    IPM_Bon_LunetterieService ipm_bon_lunetterieService;
    @PostMapping(value="/bonLunetterie")
    public void save(@RequestBody IPM_Bon_Lunetterie ipm_bon_lunetterie) {
        ipm_bon_lunetterieService.save(ipm_bon_lunetterie);
    }
    @GetMapping(value="/lunette")
    public Collection<IPM_Bon_Lunetterie> getlunett(){

        return ipm_bon_lunetterieService.getAll();
    }
    @RequestMapping(path= "/uploadeOrdonnanceLu", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadOrdonn(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_bon_lunetterieService.AjouterUnFichier(file);
        return "succes";
    }
    @RequestMapping(path= "/uploadeDevitLu", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadDebit(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_bon_lunetterieService.AjouterUnDevit(file);
        return "succes";
    }
    @GetMapping(value = "/getbonLunetterieByid/{id}")
    public List<IPM_Bon> getBonLunetterieById(@PathVariable Long id) {
        return ipm_bon_lunetterieService.getBonLunetterie(id);
    }
    @GetMapping(value = "/getbonLunetteConjByid/{id}")
    public List<IPM_Bon> getBonParmaConjById(@PathVariable Long id) {
        return ipm_bon_lunetterieService.getBonLunetteConj(id);
    }
    @GetMapping(value = "/getbonLunetteEnfByid/{id}")
    public List<IPM_Bon> getBonParmaEnfById(@PathVariable Long id) {
        return ipm_bon_lunetterieService.getBonLunetteEnf(id);
    }
}
