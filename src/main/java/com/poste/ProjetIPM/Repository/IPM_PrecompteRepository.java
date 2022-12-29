package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Precompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
public interface IPM_PrecompteRepository extends JpaRepository<IPM_Precompte, Long>
{
       //@Query(value = "select c from  IPM_Precompte c,IPM_Employe e  where c.datePrecompte=:datePrecompte and  c.ipm_employe.idemp=e.idemp")*/
    List<IPM_Precompte> findByDatePrecompte(Date date);
}
