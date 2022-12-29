package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface IPM_Bon_PharmaceutiqueRepository extends JpaRepository<IPM_Bon_Pharmaceutique, Long> {
    @Query(value = "select b from  IPM_Bon_Pharmaceutique b ,IPM_Employe e where b.ipm_employe.idemp=:id and b.ipm_employe.idemp=e.idemp")
    List<IPM_Bon> getEmpPharmById(@Param("id") Long id);
    @Query(value = "select b from  IPM_Bon_Pharmaceutique b ,IPM_Conjoint e where b.ipm_conjoint.idconj=:id and b.ipm_conjoint.idconj=e.idconj")
    List<IPM_Bon> getConjPharmById(@Param("id") Long id);
    @Query(value = "select b from  IPM_Bon_Pharmaceutique b ,IPM_Enfant e where b.ipm_enfant.idenf=:id and b.ipm_enfant.idenf=e.idenf")
    List<IPM_Bon> getEnfPharmById(@Param("id") Long id);
}
