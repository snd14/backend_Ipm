package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Suivie_FactureRepository;
import com.poste.ProjetIPM.entities.IPM_Suivie_Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_Suivie_FactureServiceImpl implements IPM_Suivie_FactureService {
    @Autowired
    IPM_Suivie_FactureRepository ipm_suivie_factureRepository;

    @Override
    public Collection<IPM_Suivie_Facture> getAll() {
        return ipm_suivie_factureRepository.findAll();
    }

    @Override
    public IPM_Suivie_Facture getById(long id) {
        return ipm_suivie_factureRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Suivie_Facture ipm_suivie_facture) {
        ipm_suivie_factureRepository.save(ipm_suivie_facture);
    }

    @Override
    public void update(IPM_Suivie_Facture ipm_suivie_facture) {
        ipm_suivie_factureRepository.save(ipm_suivie_facture);
    }

    @Override
    public void delete(Long id) {
        ipm_suivie_factureRepository.deleteById(id);
    }
}
