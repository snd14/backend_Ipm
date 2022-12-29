/*package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Beneficiaire;
import com.poste.ProjetIPM.services.IPM_BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class IPM_BeneficiaireController {

    @Autowired
    IPM_BeneficiaireService ipm_beneficiaireService;

    @GetMapping(value = "/beneficiaire")
    public Collection<IPM_Beneficiaire> getAll(){
        return ipm_beneficiaireService.getAll();
    }

    @GetMapping("/beneficiaire/{id}")
    public IPM_Beneficiaire getById(@PathVariable Long id){
        return ipm_beneficiaireService.getById(id);
    }

    @PostMapping("/beneficiaire")
    public void save(@RequestBody IPM_Beneficiaire ipm_beneficiaire){
        ipm_beneficiaireService.save(ipm_beneficiaire);
    }

    @PutMapping("/beneficiaire")
    public void update(@RequestBody IPM_Beneficiaire ipm_beneficiaire){
        ipm_beneficiaireService.update(ipm_beneficiaire);
    }

    @DeleteMapping("/beneficiaire/{id}")
    public  void delete(@PathVariable Long id){
        ipm_beneficiaireService.delete(id);
    }
}
*/
