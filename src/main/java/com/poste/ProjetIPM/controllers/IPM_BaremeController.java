package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Bareme;
import com.poste.ProjetIPM.services.IPM_BaremeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_BaremeController {
    @Autowired
    IPM_BaremeService ipm_baremeService;

    @GetMapping("/bareme")
    public Collection<IPM_Bareme> getAll() {
        return ipm_baremeService.getAll();
    }

    @GetMapping("/bareme/{id}")
    public IPM_Bareme getById(@PathVariable Long id) {
        return ipm_baremeService.getById(id);
    }

    @PostMapping("/bareme")
    public void save(@RequestBody IPM_Bareme ipm_bareme) {
        ipm_baremeService.save(ipm_bareme);
    }

    @PutMapping("/bareme")
    public void update(@RequestBody IPM_Bareme ipm_bareme) {
        ipm_baremeService.update(ipm_bareme);
    }

    @DeleteMapping("/bareme/{id}")
    public void delete(@PathVariable Long id) {
        ipm_baremeService.delete(id);
    }

}
