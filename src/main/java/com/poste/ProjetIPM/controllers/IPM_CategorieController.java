package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Categorie;

import com.poste.ProjetIPM.services.IPM_CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_CategorieController {

    @Autowired
    IPM_CategorieService ipm_categorieService;

    @GetMapping(value = "/categorie")
    public Collection<IPM_Categorie> getAll() {
        return ipm_categorieService.getAll();
    }

    @GetMapping("/categorie/{id}")
    public IPM_Categorie getById(@PathVariable Long id) {
        return ipm_categorieService.getById(id);
    }

    @PostMapping("/categorie")
    public void save(@RequestBody IPM_Categorie ipm_categorie) {
        ipm_categorieService.save(ipm_categorie);
    }

    @PutMapping("/categorie")
    public void update(@RequestBody IPM_Categorie ipm_categorie) {
        ipm_categorieService.update(ipm_categorie);
    }

    @DeleteMapping("/categorie/{id}")
    public void delete(@PathVariable Long id) {
        ipm_categorieService.delete(id);
    }
}
