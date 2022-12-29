package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_RoleRepository;
import com.poste.ProjetIPM.Repository.IPM_UserRoleRepository;
import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import com.poste.ProjetIPM.keycloack.KeyCloakService;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import com.poste.ProjetIPM.entities.IPM_Role;
import com.poste.ProjetIPM.entities.IPM_UserRole;
import com.poste.ProjetIPM.services.IPM_RoleService;
import com.poste.ProjetIPM.services.IPM_RoleServiceImpl;
import com.poste.ProjetIPM.services.IPM_UserRoleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_RoleController {

    @Autowired
    IPM_UserRoleServiceImpl ipm_userRoleService;
    @Autowired
    IPM_RoleServiceImpl ipm_roleService;
    @Autowired
    IPM_RoleRepository ipm_roleRepository;
    @Autowired
    KeyCloakService keyCloakService;
    @Autowired
    IPM_UserRoleRepository ipm_userRoleRepository;
    @GetMapping("/AllUserRole")
    public Collection<IPM_UserRole> getAllRole() {
        return ipm_userRoleService.getAllUserRole();
    }
    @GetMapping("/AllRoles")
    public Collection<IPM_Role> getRole() {
        return ipm_roleService.getAll();
    }
    /**
     * Affectation d'un role
     * userRole
     */
    @PostMapping(value = "/saveRole")
    public IPM_Role saveRole(@RequestBody IPM_Role ipm_role) {
        IPM_Role role = null;
        try{
            keyCloakService.addRealmRole(ipm_role.getTypeRole(), ipm_role.getDescription());
            role=ipm_roleRepository.save(ipm_role);

        } catch (Exception e){
            e.getMessage();
            e.getCause();
        }
        return role;
    }
/////////////////////Ajouter user et affecté role
    @PostMapping(value = "/roleAddUser")
    public IPM_UserRole affectRoleToUser(@RequestBody IPM_UserRole ipm_userRole){
        IPM_UserRole ipm_userRole1=null;
        String username = ipm_userRole.getIpm_utilisateur().getLogin();
        String roleName = ipm_userRole.getIpm_role().getTypeRole();
        try{
           ipm_userRole1= ipm_userRoleService.saveUserRole(ipm_userRole);
           keyCloakService.addRealmRoleToUser(username, roleName);
        } catch (Exception e){
            e.getCause();
            e.getMessage();
        }
        return  ipm_userRole1;
    }

    @PostMapping(value = "/affectGroupRoleToUser")
    public void affectGroupRoleToUser(@RequestBody List<IPM_UserRole> userRoles){
        ipm_userRoleService.affectGroupRoleToUser(userRoles);
    }

    @DeleteMapping(value ="/deleteUser")
    public void deleteRoleFromUser(@RequestBody IPM_UserRole userRole){
        String username = userRole.getIpm_utilisateur().getEmail();
        String roleName = userRole.getIpm_role().getTypeRole();
        try{
            keyCloakService.removeRealmRoleToUser(username, roleName);
            ipm_userRoleService.deleteUserRole(userRole);
        }  catch(Exception e){
            e.getCause();
            e.getMessage();
        }
    }

    @PatchMapping(value ="deleteGroupRoleToUser")
    public void  deleteGroupRoleToUser(@RequestBody List<IPM_UserRole> userRoles){
        ipm_userRoleService.deleteGroupRoleToUser(userRoles);
    }
}
