package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_Details_remboursementRepository;
import com.poste.ProjetIPM.Repository.IPM_RemboursementRepository;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Facture;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Service
public class IPM_Details_remboursementServiceImpl implements IPM_Details_remboursementService {
    @Autowired
    IPM_RemboursementRepository ipm_remboursementRepository;
    @Autowired
    IPM_Details_remboursementRepository ipmDetailsRemboursementRepository;

    @Override
    public Collection<IPM_Details_remboursement> getAll() {
        return ipmDetailsRemboursementRepository.findAll();
    }

    @Override
    public IPM_Details_remboursement getById(long id) {
        return ipmDetailsRemboursementRepository.findById(id).get();
    }

    @Override
    public List<IPM_Details_remboursement> save( List<IPM_Details_remboursement> ipmDetailremboursement) {
        for (int i = 0; i < ipmDetailremboursement.size(); i++) {
            ipmDetailsRemboursementRepository.save(ipmDetailremboursement.get(i));

        }
        return ipmDetailremboursement;
    }


    @Override
    public List <IPM_Details_remboursement> getDetailrembourse(IPM_Remboursement ipmRemboursement){
        return ipmDetailsRemboursementRepository.findByIpmRemboursement(ipmRemboursement);
    }


    @Override
    public void update(IPM_Details_remboursement ipmDetailremboursement) {
        ipmDetailsRemboursementRepository.save(ipmDetailremboursement);
    }

    @Override
    public void delete(Long id) {
        ipmDetailsRemboursementRepository.deleteById(id);
    }
    @Override
    public Collection<IPM_Details_remboursement> getIndividuelRembour(Date date1, Date date2, String matricule) {
        return ipmDetailsRemboursementRepository.getRemboursementIndividuel(date1,date2, matricule);
    }

}
