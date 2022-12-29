package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Prestation;
import com.poste.ProjetIPM.services.IPM_PrestataireService;
import com.poste.ProjetIPM.services.IPM_PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_PrestationController {
    @Autowired
    IPM_PrestationService ipm_prestationService;

    @GetMapping("/prestation")
    public Collection<IPM_Prestation> getAll() {
        return ipm_prestationService.getAll();
    }

    @GetMapping("/prestation/{id}")
    public IPM_Prestation getById(@PathVariable Long id) {
        return ipm_prestationService.getById(id);
    }

    @PostMapping("/prestation")
    public void save(@RequestBody IPM_Prestation ipm_prestation)
    {
        ipm_prestationService.save(ipm_prestation);
    }

    @PutMapping("/prestation")
    public void update(@RequestBody IPM_Prestation ipm_prestation) {
        ipm_prestationService.update(ipm_prestation);
    }

    @DeleteMapping("/prestation/{id}")
    public void delete(@PathVariable Long id) {
        ipm_prestationService.delete(id);
    }
}
