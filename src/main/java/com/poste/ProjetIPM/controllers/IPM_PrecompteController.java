package com.poste.ProjetIPM.controllers;


import com.poste.ProjetIPM.entities.IPM_Precompte;

import com.poste.ProjetIPM.services.IPM_PrecompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_PrecompteController {
    @Autowired
    IPM_PrecompteService ipm_precompteService;

    @GetMapping("/precompte")
    public Collection<IPM_Precompte> getAll() {
        return ipm_precompteService.getAll();
    }

    @GetMapping("/precompte/{id}")
    public IPM_Precompte getById(@PathVariable Long id) {
        return ipm_precompteService.getById(id);
    }
    @RequestMapping(path= "/uploadlettre", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadLettre(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_precompteService.AjouterLettreAgr(file);
        return "succes";
    }
    @GetMapping("/datePrecompte/{datePrecompte}")
    public Collection<IPM_Precompte> getDate(@PathVariable String datePrecompte) throws ParseException {
        Date date =new SimpleDateFormat("yyyy-MM-dd").parse(datePrecompte);
        return ipm_precompteService.getByDatePrecompte(date);
    }

    @PutMapping("/precompte")
    public void update(@RequestBody IPM_Precompte ipm_precompte) {
        ipm_precompteService.update(ipm_precompte);
    }

    @DeleteMapping("/precompte/{id}")
    public void delete(@PathVariable Long id) {
        ipm_precompteService.delete(id);
    }
    @PostMapping("/precompte")
    public void save(@RequestBody List<IPM_Precompte> ipm_precompte)
    {
        ipm_precompteService.save(ipm_precompte);
    }


}
