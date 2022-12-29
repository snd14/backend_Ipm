package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Type_ServiceRepository;
import com.poste.ProjetIPM.entities.IPM_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_Type_ServiceServiceImpl implements IPM_Type_ServiceService {

    @Autowired
    IPM_Type_ServiceRepository ipm_type_serviceRepository;

    @Override
    public Collection<IPM_Entity> getAll() {
        return ipm_type_serviceRepository.findAll();
    }

    @Override
    public IPM_Entity getById(long id) {
        return ipm_type_serviceRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Entity ipm_entity) {
        ipm_type_serviceRepository.save(ipm_entity);
    }

    @Override
    public void update(IPM_Entity ipm_entity) {
        ipm_type_serviceRepository.save(ipm_entity);
    }

    @Override
    public void delete(Long id) {
        ipm_type_serviceRepository.deleteById(id);
    }
}
