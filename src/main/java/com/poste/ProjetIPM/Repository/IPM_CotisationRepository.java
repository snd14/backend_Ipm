package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface IPM_CotisationRepository extends JpaRepository<IPM_Cotisation, Long> {
   // IPM_Cotisation findByFileName(String fileName);


}
