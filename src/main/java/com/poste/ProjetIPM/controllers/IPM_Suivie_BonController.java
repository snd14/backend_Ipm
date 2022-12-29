package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Suivie_Bon;
import com.poste.ProjetIPM.services.IPM_PrestataireService;
import com.poste.ProjetIPM.services.IPM_Suivie_BonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_Suivie_BonController {
    @Autowired
    IPM_Suivie_BonService ipm_suivie_bonService;

    @GetMapping("/suiviebon")
    public Collection<IPM_Suivie_Bon> getAll() {
        return ipm_suivie_bonService.getAll();
    }

    @GetMapping("/suiviebon/{id}")
    public IPM_Suivie_Bon getById(@PathVariable Long id) {
        return ipm_suivie_bonService.getById(id);
    }

    @PostMapping("/suiviebon")
    public void save(@RequestBody IPM_Suivie_Bon ipm_suivie_bon) {
        ipm_suivie_bonService.save(ipm_suivie_bon);
    }

    @PutMapping("/suiviebon")
    public void update(@RequestBody IPM_Suivie_Bon ipm_suivie_bon) {
        ipm_suivie_bonService.update(ipm_suivie_bon);
    }

    @DeleteMapping("/suiviebon/{id}")
    public void delete(@PathVariable Long id) {
        ipm_suivie_bonService.delete(id);
    }
}
