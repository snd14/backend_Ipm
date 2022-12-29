package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Entity;
import com.poste.ProjetIPM.services.IPM_Type_ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Type_ServiceController {

    @Autowired
    IPM_Type_ServiceService ipm_type_serviceService;

    @GetMapping("/typeservice")
    public Collection<IPM_Entity> getAll() {
        return ipm_type_serviceService.getAll();
    }

    @GetMapping("/typeservice/{id}")
    public IPM_Entity getById(@PathVariable Long id) {
        return ipm_type_serviceService.getById(id);
    }

    @PostMapping("/typeservice")
    public void save(@RequestBody IPM_Entity ipm_entity) {
        ipm_type_serviceService.save(ipm_entity);
    }

    @PutMapping("/typeservice")
    public void update(@RequestBody IPM_Entity ipm_entity) {
        ipm_type_serviceService.update(ipm_entity);
    }

    @DeleteMapping("/typeservice/{id}")
    public void delete(@PathVariable Long id) {
        ipm_type_serviceService.delete(id);
    }
}
