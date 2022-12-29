package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_StatutEmployeRepository;
import com.poste.ProjetIPM.entities.IPM_StatutEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IPM_StatutEmployeServiceImpl implements IPM_StatutEmployeService {
    @Autowired
    IPM_StatutEmployeRepository ipm_statutEmployeRepository;
    @Override
    public Collection<IPM_StatutEmploye> getAll() {
        return ipm_statutEmployeRepository.findAll();
    }

    @Override
    public boolean userExist(int userId) {
        return false;
    }

    @Override
    public IPM_StatutEmploye updateStatu(IPM_StatutEmploye ipm_statutEmploye) {
        return ipm_statutEmployeRepository.save(ipm_statutEmploye);
    }

    @Override
    public void update(IPM_StatutEmploye ipm_statutEmploye) {
        ipm_statutEmployeRepository.save(ipm_statutEmploye);
    }
}
