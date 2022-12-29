package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_StatutEmploye;
import com.poste.ProjetIPM.services.IPM_StatutEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_StatutEmployeController {
    @Autowired
    private IPM_StatutEmployeService ipm_statutEmployeService;

    @GetMapping("/statutEmploye")
    public Collection<IPM_StatutEmploye> getSatut(){
        return ipm_statutEmployeService.getAll();
    }
    @PutMapping("/updateStatut")
    public void updateStatut(@RequestBody IPM_StatutEmploye ipm_statutEmploye){
        ipm_statutEmployeService.update(ipm_statutEmploye);
    }
}
