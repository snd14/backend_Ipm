package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.time.YearMonth;
import java.util.Collection;
import java.util.List;

@Repository
public interface IPM_Details_CotisationsRepository extends JpaRepository<IPM_Details_Cotisations,Long> {
   // List<IPM_Details_Cotisations> findByIpmcotisation(IPM_Cotisation ipmCotisation);

    @Query(value = "SELECT  new IPM_Details_Cotisations(i.ipm_employe,i.ipm_cotisation) from IPM_Details_Cotisations  i where function('YEAR',i.ipm_cotisation.date)=:annne")
    Collection<IPM_Details_Cotisations> getCotisationAnnualle(@Param("annne") Integer annne);
    @Query(value = "SELECT  new IPM_Details_Cotisations(i.id_Det_Coti,i.ipm_employe,i.ipm_cotisation,i.montant) from IPM_Details_Cotisations  i where i.ipm_cotisation.idCotisation=:idCoti")
    List<IPM_Details_Cotisations> getListCotisation(@Param("idCoti") Long idCoti);

}
