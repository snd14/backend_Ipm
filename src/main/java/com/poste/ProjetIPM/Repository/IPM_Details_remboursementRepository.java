package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IPM_Details_remboursementRepository extends JpaRepository<IPM_Details_remboursement, Long> {

    List<IPM_Details_remboursement> findByIpmRemboursement(IPM_Remboursement ipmRemboursement);
    //Siuation individuels remboursement
    @Query(value = "SELECT   new IPM_Details_remboursement(c.montant,c.ipm_employe,c.ipmRemboursement) from IPM_Details_remboursement  c  where c.ipmRemboursement.dateRemboursement BETWEEN :d1 and :d2 and c.ipm_employe.matricule=:matricule")
    Collection<IPM_Details_remboursement> getRemboursementIndividuel(@Param("d1") Date d1 , @Param("d2") Date d2, @Param("matricule")  String matricule);

}
