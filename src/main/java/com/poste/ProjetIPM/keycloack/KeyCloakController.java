package com.poste.ProjetIPM.keycloack;
import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeyCloakController {
    @Autowired
    KeyCloakService service;

    @PostMapping("/keycklock")
    public String addUser(@RequestBody IPM_Utilisateur ipm_utilisateur){
        service.addUser(ipm_utilisateur);
        return "User Added Successfully.";
    }

//    @GetMapping(path = "/{userName}")
//    public List<UserRepresentation> getUser(@PathVariable("userName") String userName){
//        List<UserRepresentation> user = service.getUser(userName);
//        return user;
//    }

    /*@GetMapping(path = "/{userName}")
    public String getUserId(@PathVariable("userName") String userName){
        List<UserRepresentation> user = service.getUser(userName);
        return user.;
    }*/

    @GetMapping(path = "/all")
    public List<UserRepresentation> getAllUser(){
        List<UserRepresentation> user = service.getAllUser();
        return user;
    }

    @PutMapping(path = "/update/{userId}")
    public String updateUser(@PathVariable("userId") String userId, @RequestBody IPM_Utilisateur ipm_utilisateur){
        service.updateUser(userId, ipm_utilisateur);
        return "User Details Updated Successfully.";
    }

    @DeleteMapping(path = "/delete/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        service.deleteUser(userId);
        return "User Deleted Successfully.";
    }

    @GetMapping(path = "/verification-link/{userId}")
    public String sendVerificationLink(@PathVariable("userId") String userId){
        service.sendVerificationLink(userId);
        return "Verification Link Send to Registered E-mail Id.";
    }

    @GetMapping(path = "/reset-password/{userId}")
    public String sendResetPassword(@PathVariable("userId") String userId){
        service.sendResetPassword(userId);
        return "Reset Password Link Send Successfully to Registered E-mail Id.";
    }

    @GetMapping(value = "/getroles")
    public List<String> getAllRoles(){
        return service.getAllRoles();
    }

    @PostMapping(value = "/roles")
    public void addRoles()
    {
        service.addRealmRole("ROLE_TEST", "Description");
    }

    @PostMapping(value = "/addroles")
    public void affectationRole()
    {
        service.addRealmRoleToUser("nazim", "ROLE_TEST");
    }
}
