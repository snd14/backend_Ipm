package com.poste.ProjetIPM.keycloack;

import com.poste.ProjetIPM.entities.IPM_Role;
import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import lombok.AllArgsConstructor;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.poste.ProjetIPM.keycloack.KeycloakConfig.*;

@AllArgsConstructor
@Service
public class KeyCloakService {



    //////////////////Add User
    public void addUser(IPM_Utilisateur ipm_utilisateur){
        CredentialRepresentation credential = Credentials
                .createPasswordCredentials(ipm_utilisateur.getPassword());
               // .createPasswordCredentials("123456");
        UserRepresentation newUser = new UserRepresentation();
        newUser.setUsername(ipm_utilisateur.getLogin());
        newUser.setFirstName(ipm_utilisateur.getPrenom());
        newUser.setLastName(ipm_utilisateur.getNom());
        newUser.setEmail(ipm_utilisateur.getEmail());
        newUser.setCredentials(Collections.singletonList(credential));
        newUser.setEnabled(true);

        UsersResource instance = getInstance();
        instance.create(newUser);
    }

    public List<UserRepresentation> getUser(String userName){
        UsersResource usersResource = getInstance();
        List<UserRepresentation> user = usersResource.search(userName, true);
        return user;
    }

    public List<UserRepresentation> getAllUser(){
        UsersResource usersResource = getInstance();
        List<UserRepresentation> user = usersResource.list();
        return user;
    }

    public void updateUser(String userId, IPM_Utilisateur ipm_utilisateur){
        CredentialRepresentation credential = Credentials
                .createPasswordCredentials(ipm_utilisateur.getPassword());
        UserRepresentation newUser = new UserRepresentation();
        newUser.setUsername(ipm_utilisateur.getEmail());
        newUser.setFirstName(ipm_utilisateur.getPrenom());
        newUser.setLastName(ipm_utilisateur.getNom());
        newUser.setEmail(ipm_utilisateur.getEmail());
        newUser.setCredentials(Collections.singletonList(credential));
        newUser.setEnabled(true);

        UsersResource usersResource = getInstance();
        usersResource.get(userId).update(newUser);

    }

    public void deleteUser(String userId){
        UsersResource usersResource = getInstance();
        usersResource.get(userId)
                .remove();
    }

    public void sendVerificationLink(String userId){
        UsersResource usersResource = getInstance();
        usersResource.get(userId)
                .sendVerifyEmail();
    }

    public void sendResetPassword(String userId){
        UsersResource usersResource = getInstance();

        usersResource.get(userId)
                .executeActionsEmail(Arrays.asList("UPDATE_PASSWORD"));
    }

    public UsersResource getInstance(){
        return KeycloakConfig.getInstance().realm(realm).users();
    }

    /**
     * obtenir tous les rôles disponibles pour le client particulier enregistré dans notre serveur keycloak
     * @return availableRoles
     */
    public List<String> getAllRoles(){
        List<String> availableRoles = KeycloakConfig.getInstance()
                .realm(realm)
                .roles()
                .list()
                .stream()
                .map(role -> role.getName())
                .collect(Collectors.toList());
        return availableRoles;
    }

    /**
     * méthode pour ajouter un nouveau rôle client
     * @param new_role_name
     */
    public void addRealmRole(String new_role_name, String role_description){
        if(!getAllRoles().contains(new_role_name)){
            RoleRepresentation roleRep = new  RoleRepresentation();
            roleRep.setName(new_role_name);
            roleRep.setDescription(role_description);
            KeycloakConfig.getInstance().realm(realm)
                    .roles()
                    .create(roleRep);
        }
    }

    /**
     * méthode pour supprimer un rôle client
     * @param //new_role_name
     */
    public void deleteRealmRole(String roleName){
        if(!getAllRoles().contains(roleName)){
            KeycloakConfig.getInstance().realm(realm)
                    .roles()
                    .deleteRole(roleName);
        }
    }

    /**
     * méthode pour ajouter un rôle client spécifié par son nom à un utilisateur spécifié par un nom d'utilisateur
     * @param userName
     * @param role_name
     */
    public void addRealmRoleToUser(String userName, String role_name){
        String userId = KeycloakConfig.getInstance()
                .realm(realm)
                .users()
                .search(userName)
                .get(0)
                .getId();
        UserResource user = KeycloakConfig.getInstance()
                .realm(realm)
                .users()
                .get(userId);
        List<RoleRepresentation> roleToAdd = new LinkedList<>();
        roleToAdd.add(KeycloakConfig.getInstance()
                .realm(realm)
                .roles()
                .get(role_name)
                .toRepresentation()
        );
        user.roles().realmLevel().add(roleToAdd);
    }

    /**
     * méthode pour supprimer un rôle client spécifié par son nom à un utilisateur spécifié par un nom d'utilisateur
     * @param userName
     * @param role_name
     */
    public void removeRealmRoleToUser(String userName, String role_name){
        String userId = KeycloakConfig.getInstance()
                .realm(realm)
                .users()
                .search(userName)
                .get(0)
                .getId();
        UserResource user = KeycloakConfig.getInstance()
                .realm(realm)
                .users()
                .get(userId);
        List<RoleRepresentation> roleToAdd = new LinkedList<>();
        roleToAdd.add(KeycloakConfig.getInstance()
                .realm(realm)
                .roles()
                .get(role_name)
                .toRepresentation()
        );
        user.roles().realmLevel().remove(roleToAdd);
    }


    public String getUserIdKeycloak(String userName){
        String userId = KeycloakConfig.getInstance()
                .realm(realm)
                .users()
                .search(userName)
                .get(0)
                .getId();
        return userId;
    }
}
