package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Remboursement;
import com.poste.ProjetIPM.services.IPM_RemboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_RemboursementController {

    @Autowired
    IPM_RemboursementService ipm_remboursementService;

    @GetMapping("/remboursement")
    public Collection<IPM_Remboursement> getAll() {
        return ipm_remboursementService.getAll();
    }


    @GetMapping("/remboursement/{id}")
    public IPM_Remboursement getById(@PathVariable Long id) {
        return ipm_remboursementService.getById(id);
    }

    @PostMapping("/remboursement")
    public Long save(@RequestBody IPM_Remboursement ipm_remboursement) {
        return ipm_remboursementService.save(ipm_remboursement);
    }

    @PutMapping("/upremboursement")
    public void update(@RequestBody IPM_Remboursement ipm_remboursement) {
        ipm_remboursementService.update(ipm_remboursement);
    }

    @DeleteMapping("/remboursement/{id}")
    public void delete(@PathVariable Long id) {
        ipm_remboursementService.delete(id);
    }
}
