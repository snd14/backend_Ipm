package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface IPM_Details_FactureRepository  extends JpaRepository<IPM_Details_Facture,Long> {
    IPM_Facture findByFileName(String fileName);

    List<IPM_Details_Facture> findByIpmFacture(IPM_Facture ipmFacture);
    //situation des créances globales par période par entité
   // List<IPM_Details_Facture> findByDateSaisieBetween(Date d1, Date d2);
    @Query(value = "SELECT new IPM_Details_Facture(c.ipm_employe,c.ipmFacture,SUM(c.part_patient),SUM(c.part_ipm),SUM(c.montant_facture)) from IPM_Details_Facture  c where c.ipmFacture.dateSaisie BETWEEN :d1 and :d2 and c.ipm_employe.ipmEntity.idEntity=:identity GROUP BY c.ipm_employe,c.ipmFacture")
    Collection<IPM_Details_Facture> getDateByEntity(@Param("d1") Date d1 ,@Param("d2") Date d2,@Param("identity") Long identity);
    //la situation des charges totales individuelles et par période
    @Query(value = "SELECT new IPM_Details_Facture(c.ipm_employe,c.ipmFacture,SUM(c.part_patient),SUM(c.part_ipm),SUM(c.montant_facture)) from IPM_Details_Facture  c where c.ipmFacture.dateSaisie BETWEEN :d1 and :d2 GROUP BY c.ipm_employe,c.ipmFacture")
    Collection<IPM_Details_Facture> getDateCr(@Param("d1") Date d1 ,@Param("d2") Date d2);
    //Collection<IPM_Details_Facture> findByIpmfacture(IPM_Conjoint _Facture ipmfacture);
    //situation globals des prestations

    @Query(value = "SELECT new IPM_Details_Facture(c.part_patient,c.part_ipm,c.montant_facture,c.ipm_employe,c.ipmFacture,c.ipm_prestation) from IPM_Details_Facture  c where c.ipmFacture.dateSaisie BETWEEN :d1 and :d2 and c.ipm_prestation.code_prestation=:d3 ")
    Collection<IPM_Details_Facture> getGlobalsPrestations(@Param("d1") Date d1 ,@Param("d2") Date d2,@Param("d3") Long d3);
    //Duplicata facture
    @Query(value = "SELECT new IPM_Details_Facture(c.part_patient,c.part_ipm,c.montant_facture,c.ipm_employe,c.ipmFacture,c.ipm_prestation) from IPM_Details_Facture  c where c.ipmFacture.numerofacture=:d3 ")
    Collection<IPM_Details_Facture> getDuplicataFacture(@Param("d3") Integer d3);
    //Siuation individuels des prestations
    @Query(value = "SELECT   new IPM_Details_Facture(c.part_patient,c.part_ipm,c.montant_facture,c.ipm_employe,c.ipmFacture,c.ipm_prestation) from IPM_Details_Facture  c  where c.ipmFacture.dateSaisie BETWEEN :d1 and :d2 and c.ipm_employe.matricule=:matricule")
    Collection<IPM_Details_Facture> getIndividuelPrestations(@Param("d1") Date d1 ,@Param("d2") Date d2, @Param("matricule")  String matricule);



}

