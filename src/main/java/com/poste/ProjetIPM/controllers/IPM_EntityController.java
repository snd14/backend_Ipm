package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Entity;
import com.poste.ProjetIPM.services.IPM_EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_EntityController {

    @Autowired
    IPM_EntityService ipm_entityService;

    @GetMapping("/entity")
    public Collection<IPM_Entity> getAll() {
        return ipm_entityService.getAll();
    }

    @GetMapping("/entity/{id}")
    public IPM_Entity getById(@PathVariable Long id) {
        return ipm_entityService.getById(id);
    }

    @PostMapping("/entity")
    public void save(@RequestBody IPM_Entity ipm_entity) {
        ipm_entityService.save(ipm_entity);
    }

    @PutMapping("/entity")
    public void update(@RequestBody IPM_Entity ipm_entity) {
        ipm_entityService.update(ipm_entity);
    }

    @DeleteMapping("/entity/{id}")
    public void delete(@PathVariable Long id) {
        ipm_entityService.delete(id);
    }
}
