/*package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_BeneficiaireRepository;
import com.poste.ProjetIPM.entities.IPM_Beneficiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_BeneficiaireServiceImpl implements IPM_BeneficiaireService {

    @Autowired
    IPM_BeneficiaireRepository ipm_beneficiaireRepository;
    @Override
    public Collection<IPM_Beneficiaire> getAll() {

        return ipm_beneficiaireRepository.findAll();
    }

    @Override
    public IPM_Beneficiaire getById(long id) {

        return ipm_beneficiaireRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Beneficiaire ipm_beneficiaire) {
        ipm_beneficiaireRepository.save(ipm_beneficiaire);
    }

    @Override
    public void update(IPM_Beneficiaire ipm_beneficiaire) {
        ipm_beneficiaireRepository.save(ipm_beneficiaire);
    }

    @Override
    public void delete(Long id) {
        ipm_beneficiaireRepository.deleteById(id);
    }
}
*/
