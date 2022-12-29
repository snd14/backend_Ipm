package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Statut_BonRepository;
import com.poste.ProjetIPM.entities.IPM_Statut_Bon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_Statut_BonServiceImpl implements IPM_Statut_BonService {
    @Autowired
    IPM_Statut_BonRepository ipm_statut_bonRepository;

    @Override
    public Collection<IPM_Statut_Bon> getAll() {
        return ipm_statut_bonRepository.findAll();
    }

    @Override
    public IPM_Statut_Bon getById(long id) {
        return ipm_statut_bonRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Statut_Bon ipm_statut_bon) {
        ipm_statut_bonRepository.save(ipm_statut_bon);
    }

    @Override
    public void update(IPM_Statut_Bon ipm_statut_bon) {
        ipm_statut_bonRepository.save(ipm_statut_bon);
    }

    @Override
    public void delete(Long id) {
        ipm_statut_bonRepository.deleteById(id);
    }
}
