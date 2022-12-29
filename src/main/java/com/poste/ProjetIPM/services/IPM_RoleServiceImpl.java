package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.keycloack.KeyCloakService;
import com.poste.ProjetIPM.Repository.IPM_RoleRepository;
import com.poste.ProjetIPM.entities.IPM_Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_RoleServiceImpl implements IPM_RoleService {

    @Autowired
    IPM_RoleRepository ipm_roleRepository;
    @Autowired
    KeyCloakService keyCloakService;
    @Override
    public Collection<IPM_Role> getAll() {
        return ipm_roleRepository.findAll();
    }

    @Override
    public IPM_Role newRole() {
        return null;
    }


}
