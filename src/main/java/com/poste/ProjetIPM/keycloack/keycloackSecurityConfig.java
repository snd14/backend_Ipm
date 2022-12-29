package com.poste.ProjetIPM.keycloack;

import lombok.RequiredArgsConstructor;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@EnableWebSecurity
@RequiredArgsConstructor
@KeycloakConfiguration
public class keycloackSecurityConfig extends KeycloakWebSecurityConfigurerAdapter{
    // Stratégie de gestion de la sessions
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    // Gérer les utilisateurs et leurs roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }
    // Les droits d'accès
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
       http.cors();
       // http.authorizeRequests().antMatchers("**").authenticated();
       http.authorizeRequests().antMatchers("**").permitAll(); //Ne necessite aucune authentification
        //http.authorizeRequests().antMatchers("**").authenticated();
      //  http.authorizeRequests().antMatchers("**").permitAll(); //Ne necessite aucune authentification

        //http.authorizeRequests().antMatchers("**").authenticated(); // necessite une authentification
        //http.authorizeRequests().antMatchers("/dg_TypeStructure/**").authenticated(); // necessite une authentification
        //http.authorizeRequests().antMatchers("**").hasAuthority("agent"); // necessite le role MANAGER
        //http.authorizeRequests().antMatchers(HttpMethod.POST, "/dg_Drp/**").hasAnyAuthority("ADMIN");
    }



}
