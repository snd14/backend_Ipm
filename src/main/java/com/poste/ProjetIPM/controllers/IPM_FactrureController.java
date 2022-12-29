package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_FactureRepository;
import com.poste.ProjetIPM.entities.IPM_Facture;
import com.poste.ProjetIPM.services.IPM_FactureService;
import com.poste.ProjetIPM.services.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_FactrureController {
    @Autowired
    IPM_FactureService ipm_factureService;

    @Autowired
    IPM_FactureRepository ipm_factureRepository;

    @GetMapping("/allfacture")
    public Collection<IPM_Facture> getAll()
    {

        return ipm_factureService.getAll();
    }

    @GetMapping("/getfacture/{id}")
    public IPM_Facture getById(@PathVariable Long id) {
        return ipm_factureService.getById(id);
    }
    @GetMapping("/getfactures/{datef}")
    public Collection<IPM_Facture> getBydatefacture(@PathVariable String datef) throws ParseException {
        Date d1= new SimpleDateFormat("dd-MM-yyyy").parse(datef);
        return ipm_factureService.getByDatefacture(d1);
    }

    @GetMapping("/getbyboolean")
    public Collection<IPM_Facture> get(){return  ipm_factureService.getBycertifier(true);
    //System.out.println(ipm_factureService.getBycertifier(true));
    }

    @PostMapping("/facture")
    public Long save(@RequestBody IPM_Facture ipm_facture) {
       //ipm_factureService.save(ipm_facture);
       return ipm_factureService.save(ipm_facture);
    }

    @PutMapping("/updatefacture")
    public void update(@RequestBody IPM_Facture ipm_facture) {
        ipm_factureService.update(ipm_facture);
    }

    @DeleteMapping("/facture/{id}")
    public void delete(@PathVariable Long id) {
        ipm_factureService.delete(id);
    }
///////////////Calcul montant
//    @GetMapping("/calculMontant")
//    public void calcul(IPM_Facture ipm_facture){
//        ipm_factureRepository.getMontantTotal(ipm_facture);
//        System.out.println(  ipm_factureRepository.getMontantTotal(ipm_facture) );
//    }

    @GetMapping("/getCreanceGlobales/{date1}/{date2}")
    public Collection<IPM_Facture> getCreances(@PathVariable  String date1, @PathVariable  String  date2) throws ParseException {
        Date d1=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
        Date d2=new SimpleDateFormat("dd-MM-yyyy").parse(date2);
        return  ipm_factureService.getCreancesGlobales(d1,d2);

    }

}
