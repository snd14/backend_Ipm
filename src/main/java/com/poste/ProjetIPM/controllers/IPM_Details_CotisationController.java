package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.entities.IPM_Details_Cotisations;
import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import com.poste.ProjetIPM.services.IPM_CotisationService;
import com.poste.ProjetIPM.services.IPM_Details_CotisationsService;
import com.poste.ProjetIPM.services.IPM_Details_remboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Details_CotisationController {
    @Autowired
    IPM_CotisationService ipm_cotisationService;
    @Autowired
    IPM_Details_CotisationsService ipm_details_cotisationsService;
    @GetMapping("/detailscotisation")
    public Collection<IPM_Details_Cotisations> getAll() {
        return ipm_details_cotisationsService.getAll();
    }
    @PostMapping("/adddetailscotisation")
    public void addDetail (@RequestBody List<IPM_Details_Cotisations> ipmDetailsCotisations) {
        ipm_details_cotisationsService.save(ipmDetailsCotisations);

    }
    @DeleteMapping("/deletDetailcotisation/{id}")
    public void delete (@PathVariable Long id){
        ipm_details_cotisationsService.delete(id);

    }
    @GetMapping("/listcotisation/{id}")
    public Collection<IPM_Details_Cotisations> getListById(@PathVariable Long id) {
        return ipm_details_cotisationsService.listCotisationById(id);
    }

   @GetMapping("/detailscotisation/{id}")
    public IPM_Details_Cotisations getById(@PathVariable Long id){
         return ipm_details_cotisationsService.getById(id);
    }

//    @GetMapping("/Detailcotisation/{id}")
//    public Collection<IPM_Details_Cotisations> getDetailBycotisation(@PathVariable Long id) {
//        new IPM_Cotisation();
//        IPM_Cotisation cotisation;
//        cotisation=ipm_cotisationService.getById(id);
//        return ipm_details_cotisationsService.getDetailcotisation(cotisation);
//
//    }

    @PutMapping("/updatedetails")
    public void update(@RequestBody IPM_Details_Cotisations ipmDetailsCotisations){
        ipm_details_cotisationsService.update(ipmDetailsCotisations);
    }
      //Situation annuelle des cotisations avec un cumul par mois
    @GetMapping("/cumulCotisation/{annee}")
    public Collection<IPM_Details_Cotisations> getCumuls(@PathVariable Integer annee){
        return ipm_details_cotisationsService.getCumulCotisation(annee);
    }
}
