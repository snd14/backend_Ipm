package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Suivie_Bon;
import com.poste.ProjetIPM.entities.IPM_Suivie_Facture;
import com.poste.ProjetIPM.services.IPM_PrestataireService;
import com.poste.ProjetIPM.services.IPM_Suivie_BonService;
import com.poste.ProjetIPM.services.IPM_Suivie_FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_Suivie_FactureController {


    @Autowired
    IPM_Suivie_FactureService ipm_suivie_factureService;

    @GetMapping("/suiviefacture")
    public Collection<IPM_Suivie_Facture> getAll() {
        return ipm_suivie_factureService.getAll();
    }

    @GetMapping("/suiviefacture/{id}")
    public IPM_Suivie_Facture getById(@PathVariable Long id) {
        return ipm_suivie_factureService.getById(id);
    }

    @PostMapping("/suiviefacture")
    public void save(@RequestBody IPM_Suivie_Facture ipm_suivie_facture) {
        ipm_suivie_factureService.save(ipm_suivie_facture);
    }

    @PutMapping("/suiviefacture")
    public void update(@RequestBody IPM_Suivie_Facture ipm_suivie_facture) {
        ipm_suivie_factureService.update(ipm_suivie_facture);
    }

}
