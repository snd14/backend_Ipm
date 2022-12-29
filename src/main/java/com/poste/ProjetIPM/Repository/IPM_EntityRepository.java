package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPM_EntityRepository extends JpaRepository<IPM_Entity, Long> {
}
