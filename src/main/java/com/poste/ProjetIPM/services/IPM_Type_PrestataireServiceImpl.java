package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Type_PrestataireRepository;
import com.poste.ProjetIPM.entities.IPM_Type_Prestataire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_Type_PrestataireServiceImpl implements IPM_Type_PrestataireService {
    @Autowired
    IPM_Type_PrestataireRepository ipm_type_prestataireRepository;

    @Override
    public Collection<IPM_Type_Prestataire> getAll() {
        return ipm_type_prestataireRepository.findAll();
    }

    @Override
    public IPM_Type_Prestataire getById(long id) {
        return ipm_type_prestataireRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Type_Prestataire ipm_type_prestataire) {
        ipm_type_prestataireRepository.save(ipm_type_prestataire);
    }

    @Override
    public void update(IPM_Type_Prestataire ipm_type_prestataire) {
        ipm_type_prestataireRepository.save(ipm_type_prestataire);
    }

    @Override
    public void delete(Long id) {
        ipm_type_prestataireRepository.deleteById(id);
    }
}
