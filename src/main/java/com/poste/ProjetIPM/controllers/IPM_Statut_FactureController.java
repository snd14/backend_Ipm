package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Service;
import com.poste.ProjetIPM.entities.IPM_Statut_Facture;
import com.poste.ProjetIPM.services.IPM_Statut_FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Statut_FactureController {

    @Autowired
    IPM_Statut_FactureService ipm_statut_factureService;

    @GetMapping("/satutFacture")
    public Collection<IPM_Statut_Facture> getAll() {
        return ipm_statut_factureService.getAll();
    }

    @GetMapping("/satutFacture/{id}")
    public IPM_Statut_Facture getById(@PathVariable Long id) {
        return ipm_statut_factureService.getById(id);
    }

    @PostMapping("/satutFacture")
    public void save(@RequestBody IPM_Statut_Facture ipm_statut_facture) {
        ipm_statut_factureService.save(ipm_statut_facture);
    }

    @PutMapping("/satutFacture")
    public void update(@RequestBody IPM_Statut_Facture ipm_statut_facture) {
        ipm_statut_factureService.update(ipm_statut_facture);
    }

    @DeleteMapping("/satutFacture/{id}")
    public void delete(@PathVariable Long id) {
        ipm_statut_factureService.delete(id);
    }
}
