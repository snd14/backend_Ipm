package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Statut_FactureRepository;
import com.poste.ProjetIPM.entities.IPM_Statut_Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_Statut_FactureServiceImpl implements IPM_Statut_FactureService {
    @Autowired
    IPM_Statut_FactureRepository ipm_statut_factureRepository;

    @Override
    public Collection<IPM_Statut_Facture> getAll() {
        return ipm_statut_factureRepository.findAll();
    }

    @Override
    public IPM_Statut_Facture getById(long id) {
        return ipm_statut_factureRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Statut_Facture ipm_statut_facture) {
        ipm_statut_factureRepository.save(ipm_statut_facture);
    }

    @Override
    public void update(IPM_Statut_Facture ipm_statut_facture) {
        ipm_statut_factureRepository.save(ipm_statut_facture);
    }

    @Override
    public void delete(Long id) {
        ipm_statut_factureRepository.deleteById(id);
    }
}
