package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Type_Prestataire;
import com.poste.ProjetIPM.services.IPM_PrestataireService;
import com.poste.ProjetIPM.services.IPM_Type_PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Type_PrestataireController {
    @Autowired
    IPM_Type_PrestataireService ipm_type_prestataireService;

    @GetMapping("/alltypeprestataire")
    public Collection<IPM_Type_Prestataire> getAll() {
        return ipm_type_prestataireService.getAll();
    }

    @GetMapping("/typeprestataire/{id}")
    public IPM_Type_Prestataire getById(@PathVariable Long id) {
        return ipm_type_prestataireService.getById(id);
    }

    @PostMapping("/typeprestataire")
    public void save(@RequestBody IPM_Type_Prestataire ipm_type_prestataire) {
        ipm_type_prestataireService.save(ipm_type_prestataire);
    }

    @PutMapping("/typeprestataire")
    public void update(@RequestBody IPM_Type_Prestataire ipm_type_prestataire) {
        ipm_type_prestataireService.update(ipm_type_prestataire);
    }

    @DeleteMapping("/typeprestataire/{id}")
    public void delete(@PathVariable Long id) {
        ipm_type_prestataireService.delete(id);
    }
}
