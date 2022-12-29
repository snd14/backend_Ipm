package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPM_UtilisateurRepository extends JpaRepository<IPM_Utilisateur, Long> {

    @Query(value = "select u from IPM_Utilisateur u where u.email=:email")
    IPM_Utilisateur findUserByEmail(@Param("email") String email);

}
