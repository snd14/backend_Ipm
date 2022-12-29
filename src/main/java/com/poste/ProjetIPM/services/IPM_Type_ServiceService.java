package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Entity;

import java.util.Collection;

public interface IPM_Type_ServiceService {

    Collection<IPM_Entity> getAll();

    IPM_Entity getById(long id);

    void save(IPM_Entity ipm_entity);

    void update(IPM_Entity ipm_entity);

    void delete(Long id);
}
