package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_EntityRepository;
import com.poste.ProjetIPM.Repository.IPM_ServiceRepository;
import com.poste.ProjetIPM.entities.IPM_Entity;
import com.poste.ProjetIPM.entities.IPM_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_ServiceServiceImpl implements IPM_ServiceService {

    @Autowired
    IPM_ServiceRepository ipm_serviceRepository;

    @Autowired
    IPM_EntityRepository ipm_entityRepository;


    @Override
    public Collection<IPM_Service> getAll() {
        return ipm_serviceRepository.findAll();
    }

    @Override
    public IPM_Service getById(long id) {
        return ipm_serviceRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Service ipm_service) {
        ipm_serviceRepository.save(ipm_service);
    }

    @Override
    public void update(IPM_Service ipm_service) {
        ipm_serviceRepository.save(ipm_service);
    }
    @Override
    public Collection<IPM_Service> getList(IPM_Entity ipmEntity){
        return  ipm_serviceRepository.findByIpmEntity(ipmEntity);

        
    }

    private Collection<IPM_Service> getIpmEntity(Collection<IPM_Service> ipmEntity) {
        return ipmEntity;
    }

    @Override
    public void delete(Long id) {
        ipm_serviceRepository.deleteById(id);
    }
}
