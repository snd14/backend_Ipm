package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Prestation;
import com.poste.ProjetIPM.entities.IPM_Type_Prestataire;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public interface IPM_PrestataireRepository extends JpaRepository<IPM_Prestataire, Long> {

//    @Query(value = "select p from  IPM_Prestataire p ,IPM_Type_Prestataire tp where p.ipm_type_prestataire.id_type_prestataire=:id and p.ipm_type_prestataire.id_type_prestataire=tp.id_type_prestataire")
//    List<IPM_Prestataire> getIPM_PrestataireById(@Param("id") Long id);

    //IPM_Prestataire findByNomprestataire(String nom_type_prestaire);

        @Query(value = "select p from  IPM_Prestataire p ,IPM_Type_Prestataire tp where p.ipm_type_prestataire.nom_type_prestaire=:nom and p.ipm_type_prestataire.nom_type_prestaire=tp.nom_type_prestaire")
     List<IPM_Prestataire> getIPM_PrestataireByIdL(@Param("nom") String nom);

    //List<IPM_Prestataire> findByNameContains(@Param("nom") String nom);

}
