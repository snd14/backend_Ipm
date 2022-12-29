package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_FactureRepository;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class IPM_FactureServiceImpl implements IPM_FactureService {

    @Autowired
    IPM_FactureRepository ipm_factureRepository;

    @Override
    public Collection<IPM_Facture> getAll() {
        return ipm_factureRepository.findAll();
    }

    @Override
    public IPM_Facture getById(long id) {
        return ipm_factureRepository.findByIdfacture(id);
    }
    @Override
    public Collection<IPM_Facture>  getBycertifier(boolean certifier){
        return  ipm_factureRepository.findByCertifier(certifier);
    }
    @Override
    public Collection<IPM_Facture>  getByDatefacture(Date date){
        return  ipm_factureRepository.findByDateFacture(date);
    }

    @Override
    public Long save(IPM_Facture ipm_facture) {

       IPM_Facture fact= ipm_factureRepository.save(ipm_facture);

       return fact.getIdfacture();


    }

    @Override
    public void update(IPM_Facture ipm_facture) {
        ipm_factureRepository.save(ipm_facture);
    }

    @Override
    public void delete(Long id) {
        ipm_factureRepository.deleteById(id);
    }

    @Override
    public Collection<IPM_Facture> getCreancesGlobales(Date date1, Date date2) {
        return ipm_factureRepository.findByDateSaisieBetween(date1,date2);
    }
}
