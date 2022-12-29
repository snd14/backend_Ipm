package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_StatutEmploye;

import java.util.Collection;

public interface IPM_StatutEmployeService {
    Collection<IPM_StatutEmploye> getAll();
    boolean userExist(int userId);
    IPM_StatutEmploye updateStatu(IPM_StatutEmploye ipm_statutEmploye);
    void update(IPM_StatutEmploye ipm_statutEmploye);
}
