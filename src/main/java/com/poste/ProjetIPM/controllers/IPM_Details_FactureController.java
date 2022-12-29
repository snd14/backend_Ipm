package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_Details_FactureRepository;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;

import com.poste.ProjetIPM.entities.IPM_Facture;
import com.poste.ProjetIPM.services.IPM_Details_FactureService;
import com.poste.ProjetIPM.services.IPM_FactureService;
import com.poste.ProjetIPM.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Details_FactureController {
    @Autowired
    UploadService uploadService;
    @Autowired
    IPM_FactureService ipm_factureService;
    @Autowired
    IPM_Details_FactureService ipm_details_factureService;
  @Autowired
    IPM_Details_FactureRepository ipm_details_factureRepository;
    @GetMapping("/detailsfactures")
    public Collection<IPM_Details_Facture> getAll() {
        return ipm_details_factureService.getAll();
    }

    @PostMapping("/adddetailsfacture")
    public void createDetailsFcature(@RequestBody List<IPM_Details_Facture> ipm_details_facture) {
//        IPM_Facture ipm_facture=ipm_factureService.getById(ipm_details_facture.getIpm_facture().getIdfacture());
//        ipm_details_facture.setIpm_facture(ipm_facture);
        ipm_details_factureService.save(ipm_details_facture);
        // return  ipm_details_facture;
    }

    @GetMapping("/detailsfact/{id}")
    public IPM_Details_Facture getById(@PathVariable Long id) {
        IPM_Details_Facture ipm_details_facture = ipm_details_factureService.getById(id);
        return ipm_details_facture;
    }

    @GetMapping("/detailsfacture/{id}")
    public Collection<IPM_Details_Facture> getDetailByfacture(@PathVariable Long id) {
        new IPM_Facture();
        IPM_Facture facture;
        facture = ipm_factureService.getById(id);
        return ipm_details_factureService.getDetailFact(facture);
    }

    @PutMapping("/updateList")
    public void update(@RequestBody List<IPM_Details_Facture> ipm_details_facture) {
        ipm_details_factureService.updateListe(ipm_details_facture);
    }

    //put
    @PutMapping("/updateDetail")
    public void update(@RequestBody IPM_Details_Facture ipm_details_facture) {
        ipm_details_factureService.update(ipm_details_facture);

    }

    /////////////////TODO:Implementation upload file excel
    @PostMapping(value = "/fileupload")
    public void uploadFile(@ModelAttribute IPM_Details_Facture ipm_details_facture, RedirectAttributes redirectAttributes) {
        boolean isFlag = uploadService.saveDataFromUploadFile(ipm_details_facture.getFile());
        if (isFlag) {
            redirectAttributes.addFlashAttribute("successmessage", "File Upload successfull !");
        } else {
            redirectAttributes.addFlashAttribute("errormessage", "File Upload not done, Please try again !");
        }
    }

    //Creances Globales par entité
    @GetMapping("/getCreanceGlobaless/{date1}/{date2}/{ident}")
    public Collection<IPM_Details_Facture> getCreances(@PathVariable String date1, @PathVariable String date2, @PathVariable Long ident) throws ParseException {
        Date d1 = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
        Date d2 = new SimpleDateFormat("dd-MM-yyyy").parse(date2);
        return ipm_details_factureService.addListEntity(ident, d1, d2);

    }

    //Situation des charges totales individuelles et par période
    @GetMapping("/getCreanceGlo/{date1}/{date2}")
    public Collection<IPM_Details_Facture> getCreancesBlo(@PathVariable String date1, @PathVariable String date2) throws ParseException {
        Date d1 = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
        Date d2 = new SimpleDateFormat("dd-MM-yyyy").parse(date2);
        return ipm_details_factureService.getCreancesGlo(d1, d2);

    }

    //Situation prestations globals par période et par entité
    @GetMapping("/getGlobalsPrestations/{date1}/{date2}/{idprest}")
    public Collection<IPM_Details_Facture> getPrestationGlobals(@PathVariable String date1, @PathVariable String date2, @PathVariable Long idprest) throws ParseException {
        Date d1 = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
        Date d2 = new SimpleDateFormat("dd-MM-yyyy").parse(date2);
        return ipm_details_factureService.getPrestationGlobals(d1, d2, idprest);

    }
    //Situation prestations individuel par période
    @GetMapping("/getIndividuelPrestations/{date1}/{date2}/{matricule}")
    public Collection<IPM_Details_Facture> getPrestationIndividuel(@PathVariable String date1, @PathVariable String date2, @PathVariable String matricule) throws ParseException {
        Date d1 = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
        Date d2 = new SimpleDateFormat("dd-MM-yyyy").parse(date2);
        return ipm_details_factureService.getPrestationIndividuel(d1, d2, matricule);

    }
    @GetMapping("/factureBynumero/{num}")
    public Collection<IPM_Details_Facture> getPrestationIndividuel(@PathVariable Integer num) throws ParseException {

        return ipm_details_factureService.Duplicata(num);

    }



}
