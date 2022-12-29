package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Details_FactureRepository;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IPM_Details_FactureServiceImpl implements IPM_Details_FactureService {
    @Autowired
    IPM_Details_FactureRepository ipm_details_factureRepository;

    @Override
    public Collection<IPM_Details_Facture> getAll() {
        return ipm_details_factureRepository.findAll();
    }

    @Override
    public IPM_Details_Facture getById(long id) {
        return ipm_details_factureRepository.findById(id).get();
    }
    /*
    update liste detail facture
     */
    @Override
    public List<IPM_Details_Facture> updateListe(List<IPM_Details_Facture> ipm_details_factures){
        for (int i = 0; i < ipm_details_factures.size(); i++){
            ipm_details_factureRepository.save(ipm_details_factures.get(i));
        }
        return ipm_details_factures;
    }


    @Override
    public List<IPM_Details_Facture> save(List<IPM_Details_Facture> ipm_details_facture) {
        for (int i = 0; i < ipm_details_facture.size(); i++) {
            ipm_details_factureRepository.save(ipm_details_facture.get(i));

        }
        return ipm_details_facture;
    }

   @Override
    public List <IPM_Details_Facture> getDetailFact(IPM_Facture ipmFacture){
       return ipm_details_factureRepository.findByIpmFacture(ipmFacture);

   }

    @Override
    public void update(IPM_Details_Facture ipm_details_facture) {
          ipm_details_factureRepository.save(ipm_details_facture);
    }
  /*  @Override
    public Collection<IPM_Details_Facture> getCreancesGlobaless(Date date1, Date date2) {
        return ipm_details_factureRepository.findByDateSaisieBetween(date1,date2);

    }*/
    @Override
    public Collection<IPM_Details_Facture> addListEntity(Long idEntity, Date date1, Date date2) {
        return ipm_details_factureRepository.getDateByEntity(date1,date2,idEntity);}
  /*  @Override
    public List<IPM_Details_Facture> addListEntitys(Long idEntity, Date date1, Date date2){
        List<IPM_Details_Facture> ipmFactureList =new ArrayList<>();
        List<IPM_Details_Facture> ipmDetailsFacture =ipm_details_factureRepository.findByDateSaisieBetween(date1,date2);;
        for (int i = 0; i < ipmDetailsFacture.size(); i++) {
            if(ipmDetailsFacture.get(i).getIpm_employe().getIpmEntity().getIdEntity()==idEntity) {
                ipmFactureList.add(ipmDetailsFacture.get(i));
            }
        }
        return ipmFactureList;

    }*/
   /* @Override
    public Collection<IPM_Details_Facture> addListEntity(Long idEntity,Date date1, Date date2){
       return ipm_details_factureRepository.getDateByEntity(date1,date2,idEntity);


    }*/
    @Override
    public Collection<IPM_Details_Facture> Duplicata(Integer num){
       return ipm_details_factureRepository.getDuplicataFacture(num);


    }
    @Override
    public Collection<IPM_Details_Facture> getCreancesGlo(Date date1, Date date2) {
        return ipm_details_factureRepository.getDateCr(date1,date2);
    }


    //Globals prestations
    @Override
    public Collection<IPM_Details_Facture> getPrestationGlobals(Date date1, Date date2, Long d3) {
        return ipm_details_factureRepository.getGlobalsPrestations(date1,date2,d3);
    }

    //Individuels prestations
    @Override
    public Collection<IPM_Details_Facture> getPrestationIndividuel(Date date1, Date date2,String matricule) {
        return ipm_details_factureRepository.getIndividuelPrestations(date1,date2, matricule);
    }
}
