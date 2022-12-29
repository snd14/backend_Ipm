package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.keycloack.KeyCloakService;
import com.poste.ProjetIPM.Repository.IPM_RoleRepository;
import com.poste.ProjetIPM.Repository.IPM_UtilisateurRepository;
import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import com.poste.ProjetIPM.services.IPM_PrestataireService;
import com.poste.ProjetIPM.services.IPM_UtilisateurService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_UtilisateurController {
    @Autowired
    KeyCloakService keyCloakService;
    @Autowired
    private IPM_UtilisateurService ipm_utilisateurService;
    @Autowired
    private IPM_UtilisateurRepository ipm_utilisateurRepository;

    @GetMapping(value = "/allUser")
    public List<IPM_Utilisateur> getAllUser() {
        return ipm_utilisateurRepository.findAll();
    }

    @GetMapping("/getUser/{id}")
    public  IPM_Utilisateur getUserById(@PathVariable Long id){
        return ipm_utilisateurRepository.findById(id).get();
    }

    @GetMapping(value = "email/{email}")
    public ResponseEntity<IPM_Utilisateur> findUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(ipm_utilisateurService.findUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping(value = "/saveUser")
    public IPM_Utilisateur saveuser(@RequestBody IPM_Utilisateur ipm_utilisateur) {
        try {
            ipm_utilisateurRepository.save(ipm_utilisateur);
            keyCloakService.addUser(ipm_utilisateur);
        } catch (PersistenceException e){
            e.getMessage();
        }
        return ipm_utilisateur;
    }

    @PatchMapping(value = "/{id}")
    public IPM_Utilisateur update(@PathVariable("id")long id , @RequestBody IPM_Utilisateur ipm_utilisateur){
        try{
            String UserId = keyCloakService.getUserIdKeycloak(ipm_utilisateur.getEmail());
            keyCloakService.updateUser(UserId, ipm_utilisateur);
            ipm_utilisateur.setId(id);
            ipm_utilisateurRepository.save(ipm_utilisateur);
        }catch (PersistenceException e){
            e.getMessage();
        }
        return ipm_utilisateur;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id, @RequestBody IPM_Utilisateur ipm_utilisateurr){
        try{
            List<UserRepresentation> user = keyCloakService.getUser(ipm_utilisateurr.getEmail());
            keyCloakService.deleteUser(user.get(0).getId());
            ipm_utilisateurRepository.deleteById(id);
        } catch(Exception e){
            e.getMessage();
            e.getCause();
        }
    }
}
