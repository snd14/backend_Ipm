package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_BaremeRepository;
import com.poste.ProjetIPM.entities.IPM_Bareme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_BaremeServiceImpl implements IPM_BaremeService {
    @Autowired
    IPM_BaremeRepository ipm_baremeRepository;

    @Override
    public Collection<IPM_Bareme> getAll() {
        return ipm_baremeRepository.findAll();
    }

    @Override
    public IPM_Bareme getById(long id) {
        return ipm_baremeRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Bareme ipm_bareme) {
        ipm_baremeRepository.save(ipm_bareme);
    }

    @Override
    public void update(IPM_Bareme ipm_bareme) {
        ipm_baremeRepository.save(ipm_bareme);
    }

    @Override
    public void delete(Long id) {
        ipm_baremeRepository.deleteById(id);
    }
}
