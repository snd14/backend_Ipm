package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_CotisationRepository;
import com.poste.ProjetIPM.entities.IPM_Categorie;
import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.services.IPM_CotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class IPM_CotisationController {

    @Autowired
    IPM_CotisationService ipm_cotisationService;

    @GetMapping(value = "/cotisation")
    public Collection<IPM_Cotisation> getAll() {
        return ipm_cotisationService.getAll();
    }

    @GetMapping("/cotisation/{id}")
    public IPM_Cotisation getById(@PathVariable Long id) {
        return ipm_cotisationService.getById(id);
    }

    @PostMapping("/cotisation")
    public Long save(@RequestBody IPM_Cotisation ipm_cotisation) {

        return ipm_cotisationService.save(ipm_cotisation);
    }

    @PutMapping("/cotisation")
    public void update(@RequestBody IPM_Cotisation ipm_cotisation) {
        ipm_cotisationService.update(ipm_cotisation);
    }

    @DeleteMapping("/cotisation/{id}")
    public void delete(@PathVariable Long id) {
        ipm_cotisationService.delete(id);
    }

//    /////////////////TODO:Implementation upload file excel
//    @PostMapping(value = "/uploadCotisation")
//    public void uploadFile(@ModelAttribute IPM_Cotisation ipm_cotisation, RedirectAttributes redirectAttributes){
//        boolean isFlag = ipm_cotisationService.saveDataFromUploadFile(ipm_cotisation.getFile());
//        System.out.println(ipm_cotisation);
//        if (isFlag){
//
//            redirectAttributes.addFlashAttribute("successmessage", "File Upload successfull !");
//        } else {
//            redirectAttributes.addFlashAttribute("errormessage", "File Upload not done, Please try again !");
//        }
//    }
}
