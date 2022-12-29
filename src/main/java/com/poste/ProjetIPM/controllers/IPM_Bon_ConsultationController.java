package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Consultation;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import com.poste.ProjetIPM.services.IPM_Bon_ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_Bon_ConsultationController {
    @Autowired
    IPM_Bon_ConsultationService ipm_bon_consultationService;
    @PostMapping(value="/bonconsult")
    public void save(@RequestBody IPM_Bon_Consultation ipm_bon_consultation) {
        ipm_bon_consultationService.save(ipm_bon_consultation);
    }
    @GetMapping(value = "/getbonConsultByid/{id}")
    public List<IPM_Bon> getBonConsultById(@PathVariable Long id) {
        return ipm_bon_consultationService.getBonConsultation(id);
    }
    @GetMapping(value = "/getbonConsConjByid/{id}")
    public List<IPM_Bon> getBonConsaConjById(@PathVariable Long id) {
        return ipm_bon_consultationService.getBonConjCons(id);
    }
    @GetMapping(value = "/getbonConsEnfByid/{id}")
    public List<IPM_Bon> getBonConsEnfById(@PathVariable Long id) {
        return ipm_bon_consultationService.getBonEnfCons(id);
    }

}
