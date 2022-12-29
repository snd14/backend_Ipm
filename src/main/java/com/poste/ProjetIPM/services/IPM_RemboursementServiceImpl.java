package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_RemboursementRepository;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_RemboursementServiceImpl implements IPM_RemboursementService {

    @Autowired
    IPM_RemboursementRepository ipm_remboursementRepository;

    @Override
    public Collection<IPM_Remboursement> getAll() {
        return ipm_remboursementRepository.findAll();
    }

    @Override
    public IPM_Remboursement getById(long id) {
        return ipm_remboursementRepository.findById(id).get();
    }

    @Override
    public Long save(IPM_Remboursement ipm_remboursement) {
        IPM_Remboursement fact= ipm_remboursementRepository.save(ipm_remboursement);
        return fact.getIdRemboursement();
    }

    @Override
    public void update(IPM_Remboursement ipm_remboursement) {
        ipm_remboursementRepository.save(ipm_remboursement);
    }

    @Override
    public void delete(Long id) {
        ipm_remboursementRepository.deleteById(id);
    }
}
