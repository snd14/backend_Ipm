package com.poste.ProjetIPM.keycloack;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

public class KeycloakConfig {
    static Keycloak keycloak = null;
  // final static String serverUrl = "http://localhost:8180/auth";
    final static String serverUrl = "http://10.14.14.232:8180/auth";
    public final static String realm= "Digital-Poste";
   final static String clientId = "ipm-backend";
  // public final static String realm= "IPM-Front";
 //  final static String clientId = "backend-ipm";
  //  final static String clientId = "BackEnd_ModulePrincipal_local";
    final static String clientSecret = "8f34dc67-777c-4b40-a3db-004a3edf6c28"; //keycklok IPM en ligne
  //  final static String clientSecret = "0e9f9470-fc9f-4bd0-b471-ebe80c18e47d"; //keyckloak Local
   final static String userName = "diago"; //user en ligne
   final static String password = "1234";    //user en ligne
    //  final static String userName = "fatima";
    //  final static String password = "fatima";

    public KeycloakConfig() {
    }

    public static Keycloak getInstance(){
        if(keycloak == null){

            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(userName)
                    .password(password)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .resteasyClient(new ResteasyClientBuilder()
                            .connectionPoolSize(10)
                            .build()
                    )
                    .build();
        }
        return keycloak;
    }
}
