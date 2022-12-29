package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Entity;
import com.poste.ProjetIPM.entities.IPM_Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface IPM_ServiceRepository extends JpaRepository<IPM_Service, Long> {
    Collection<IPM_Service> findByIpmEntity(IPM_Entity ipmEntity);
}
