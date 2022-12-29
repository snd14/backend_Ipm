package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
@Repository
public interface IPM_BonRepository extends JpaRepository<IPM_Bon, Long> {
    //Collection<IPM_Bon>findAll();
    @Query(value = "select b from  IPM_Bon b ,IPM_Employe e where b.ipm_employe.idemp=:id and b.ipm_employe.idemp=e.idemp")
    List<IPM_Bon> getEmpById(@Param("id") Long id);

    @Query(value = "select b from  IPM_Bon b ,IPM_Prestataire p where b.ipm_prestataire.code_prestataire=:id and b.ipm_prestataire.code_prestataire=p.code_prestataire")
    List<IPM_Bon> getPresById(@Param("id") Long id);
    //la situation des bons par période
    //@Query(value = "SELECT * from IPM_Bon where date_etablissement BETWEEN :d1 and :d2 ",nativeQuery = true)
    List<IPM_Bon> findByDateEtablissementBetween(Date d1 , Date d2);
    //la situation des bons par période et types bon
    @Query(value = "SELECT  new IPM_Bon(c.ipm_employe,c.ipm_prestataire,c.ipm_prestation) from IPM_Bon c  where c.dateEtablissement BETWEEN :d1 and :d2 and c.ipm_prestation.code_prestation=:d4")
    Collection<IPM_Bon> getBonByPeriodeAndtypeBon(@Param("d1") Date d1 , @Param("d2") Date d2, @Param("d4") Long d4);

}
