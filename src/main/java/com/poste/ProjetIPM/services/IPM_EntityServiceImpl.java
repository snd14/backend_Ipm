package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_EntityRepository;
import com.poste.ProjetIPM.entities.IPM_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_EntityServiceImpl implements IPM_EntityService {

    @Autowired
    IPM_EntityRepository ipm_entityRepository;

    @Override
    public Collection<IPM_Entity> getAll() {
        return ipm_entityRepository.findAll();
    }

    @Override
    public IPM_Entity getById(long id) {
        return ipm_entityRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Entity ipm_entity) {
        ipm_entityRepository.save(ipm_entity);
    }

    @Override
    public void update(IPM_Entity ipm_entity) {
        ipm_entityRepository.save(ipm_entity);
    }

    @Override
    public void delete(Long id) {
        ipm_entityRepository.deleteById(id);
    }
}
