package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_UserRole;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IPM_UserRoleService {
    List<IPM_UserRole> getAllUserRole();
/* List<Dg_UserRole> getUserRoleByUserId(int id);

    List<Dg_UserRole> getUserUserByRoleId(int id);*/

    IPM_UserRole saveUserRole(IPM_UserRole ipm_userRole);

    void deleteUserRole(IPM_UserRole ipm_userRole);

    void deleteGroupRoleToUser(@RequestBody List<IPM_UserRole> ipm_userRoles);

    void affectGroupRoleToUser(@RequestBody List<IPM_UserRole> ipm_userRoles);

}
