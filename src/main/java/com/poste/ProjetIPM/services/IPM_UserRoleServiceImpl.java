package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.keycloack.KeyCloakService;
import com.poste.ProjetIPM.Repository.IPM_UserRoleRepository;
import com.poste.ProjetIPM.entities.IPM_UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPM_UserRoleServiceImpl implements IPM_UserRoleService {
  @Autowired
  IPM_UserRoleRepository ipm_userRoleRepository;
    @Autowired
    KeyCloakService keyCloakService;

    @Override
    public List<IPM_UserRole> getAllUserRole() {
        return ipm_userRoleRepository.findAll();
    }

    @Override
    public IPM_UserRole saveUserRole(IPM_UserRole ipm_userRole) {
        return  ipm_userRoleRepository.save(ipm_userRole);
    }

    @Override
    public void deleteUserRole(IPM_UserRole ipm_userRole) {
     ipm_userRoleRepository.delete(ipm_userRole);

    }

    @Override
    @Transactional
    public void deleteGroupRoleToUser(List<IPM_UserRole> ipm_userRoles) {
        int size = ipm_userRoles.size();
        int counter = 0;

        List<IPM_UserRole> temp = new ArrayList<>();

        for (IPM_UserRole emp : ipm_userRoles) {
            temp.add(emp);

            if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
                for (IPM_UserRole tempEmp : temp){
                    String username = tempEmp.getIpm_utilisateur().getEmail();
                    String roleName = tempEmp.getIpm_role().getTypeRole();
                    keyCloakService.removeRealmRoleToUser(username, roleName);
                }
                ipm_userRoleRepository.deleteAll(temp);
                temp.clear();
            }

            counter++;
        }

    }

    @Override
    @Transactional
    public void affectGroupRoleToUser(List<IPM_UserRole> ipm_userRoles) {
        int size = ipm_userRoles.size();
        int counter = 0;

        List<IPM_UserRole> temp = new ArrayList<>();

        for (IPM_UserRole emp : ipm_userRoles) {
            temp.add(emp);

            if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
                for (IPM_UserRole tempEmp : temp){
                    String username = tempEmp.getIpm_utilisateur().getEmail();
                    String roleName = tempEmp.getIpm_role().getTypeRole();
                    keyCloakService.addRealmRoleToUser(username, roleName);
                }
                ipm_userRoleRepository.saveAll(temp);
                temp.clear();

            }

            counter++;
        }
    }
}
