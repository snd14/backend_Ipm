package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Suivie_BonRepository;
import com.poste.ProjetIPM.entities.IPM_Suivie_Bon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_Suivie_BonServiceImpl implements IPM_Suivie_BonService {
    @Autowired
    IPM_Suivie_BonRepository ipm_suivie_bonRepository;

    @Override
    public Collection<IPM_Suivie_Bon> getAll() {
        return ipm_suivie_bonRepository.findAll();
    }

    @Override
    public IPM_Suivie_Bon getById(long id) {
        return ipm_suivie_bonRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Suivie_Bon ipm_suivie_bon) {
        ipm_suivie_bonRepository.save(ipm_suivie_bon);
    }

    @Override
    public void update(IPM_Suivie_Bon ipm_suivie_bon) {
        ipm_suivie_bonRepository.save(ipm_suivie_bon);

    }

    @Override
    public void delete(Long id) {
        ipm_suivie_bonRepository.deleteById(id);

    }
}
