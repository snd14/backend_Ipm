package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Role;

import java.util.Collection;

public interface IPM_RoleService {

    Collection<IPM_Role> getAll();

    public IPM_Role newRole();
}
