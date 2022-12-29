package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPM_Bon_Lettre_de_GarantieRepository extends JpaRepository<IPM_Bon_Lettre_de_Garantie,Long> {
    @Query(value = "select b from  IPM_Bon_Lettre_de_Garantie b ,IPM_Employe e where b.ipm_employe.idemp=:id and b.ipm_employe.idemp=e.idemp")
    List<IPM_Bon> getEmpLettreById(@Param("id") Long id);
    @Query(value = "select b from  IPM_Bon_Lettre_de_Garantie b ,IPM_Conjoint e where b.ipm_conjoint.idconj=:id and b.ipm_conjoint.idconj=e.idconj")
    List<IPM_Bon> getConjLettreById(@Param("id") Long id);
    @Query(value = "select b from  IPM_Bon_Lettre_de_Garantie b ,IPM_Enfant e where b.ipm_enfant.idenf=:id and b.ipm_enfant.idenf=e.idenf")
    List<IPM_Bon> getEnfLettreById(@Param("id") Long id);
}
