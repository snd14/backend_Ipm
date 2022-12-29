package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Service;
import com.poste.ProjetIPM.entities.IPM_Statut_Bon;
import com.poste.ProjetIPM.services.IPM_Statut_BonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Statut_BonController {

    @Autowired
    IPM_Statut_BonService ipm_statut_bonService;

    @GetMapping("/satutBon")
    public Collection<IPM_Statut_Bon> getAll() {
        return ipm_statut_bonService.getAll();
    }

    @GetMapping("/satutBon/{id}")
    public IPM_Statut_Bon getById(@PathVariable Long id) {
        return ipm_statut_bonService.getById(id);
    }

    @PostMapping("/satutBon")
    public void save(@RequestBody IPM_Statut_Bon ipm_statut_bon) {
        ipm_statut_bonService.save(ipm_statut_bon);
    }

    @PutMapping("/satutBon")
    public void update(@RequestBody IPM_Statut_Bon ipm_statut_bon) {
        ipm_statut_bonService.update(ipm_statut_bon);
    }

    @DeleteMapping("/satutBon/{id}")
    public void delete(@PathVariable Long id) {
        ipm_statut_bonService.delete(id);
    }
}
