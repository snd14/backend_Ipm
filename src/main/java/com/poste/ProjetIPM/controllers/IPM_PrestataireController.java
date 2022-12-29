package com.poste.ProjetIPM.controllers;


import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Prestation;

import com.poste.ProjetIPM.services.IPM_PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_PrestataireController {
    @Autowired
    IPM_PrestataireService ipm_prestataireService;

    @GetMapping("/allprestataire")
    public Collection<IPM_Prestataire> getAll() {
        return ipm_prestataireService.getAll();
    }

    @GetMapping("/prestataire/{id}")
    public IPM_Prestataire getById(@PathVariable Long id) {
        return ipm_prestataireService.getById(id);
    }
    @GetMapping("/listprestataire/{nom}")
    public List<IPM_Prestataire> listPrest(@PathVariable String nom)
    {
        return ipm_prestataireService.getPrestataireBy(nom);
    }


    @PostMapping("/prestataire")
    public void save(@RequestBody IPM_Prestataire ipm_prestataire)
    {
        String uploadDiir = "/var/www/html/ipmfiles/files/jusificatifs";
        ipm_prestataire.setLettreAgrement(uploadDiir+"/"+ipm_prestataire.getLettreAgrement());
        ipm_prestataireService.save(ipm_prestataire);
    }

    @PutMapping("/prestataireUpdate")
    public void update(@RequestBody IPM_Prestataire ipm_prestataire) {
        ipm_prestataireService.update(ipm_prestataire);
    }

    @DeleteMapping("/prestataire/{id}")
    public void delete(@PathVariable Long id) {
        ipm_prestataireService.delete(id);
    }
//    @GetMapping("/nomType/{nom_prestataire}")
//    public IPM_Prestataire getNomType(@PathVariable String nom_prestataire){
//        return ipm_prestataireService.getNomType(nom_prestataire);
//    }

    @RequestMapping(path= "/lettreAgrement", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadJustif(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_prestataireService.AjouterFichierLettre(file);
        return "succes";
    }
}
