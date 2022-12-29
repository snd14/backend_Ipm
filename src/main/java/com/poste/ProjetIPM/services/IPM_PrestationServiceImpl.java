package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_PrestationRepository;
import com.poste.ProjetIPM.entities.IPM_Prestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@Service
@Transactional
public class IPM_PrestationServiceImpl implements IPM_PrestationService {

    @Autowired
    IPM_PrestationRepository ipm_prestationRepository;

    @Override
    public Collection<IPM_Prestation> getAll() {
        return ipm_prestationRepository.findAll();
    }

    @Override
    public IPM_Prestation getById(long id) {
        return ipm_prestationRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Prestation ipm_prestation) {
        ipm_prestationRepository.save(ipm_prestation);
    }

    @Override
    public void update(IPM_Prestation ipm_prestation) {
        ipm_prestationRepository.save(ipm_prestation);
    }

    @Override
    public void delete(Long id) {
        ipm_prestationRepository.deleteById(id);
    }




}
