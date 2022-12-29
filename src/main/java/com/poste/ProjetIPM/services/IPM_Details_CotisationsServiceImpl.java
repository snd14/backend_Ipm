package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_CotisationRepository;
import com.poste.ProjetIPM.Repository.IPM_Details_CotisationsRepository;
import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.entities.IPM_Details_Cotisations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class IPM_Details_CotisationsServiceImpl implements IPM_Details_CotisationsService {
    @Autowired
    IPM_CotisationRepository ipm_cotisationRepository;

    @Autowired
    IPM_Details_CotisationsRepository ipm_details_cotisationsRepository;
    @Override
    public Collection<IPM_Details_Cotisations> getAll() {
        return ipm_details_cotisationsRepository.findAll();
    }

    @Override
    public IPM_Details_Cotisations getById(long id) {
        return ipm_details_cotisationsRepository.findById(id).get();
    }

    @Override
    public List<IPM_Details_Cotisations> save(List<IPM_Details_Cotisations> ipm_details_cotisations) {
        for (int i = 0; i < ipm_details_cotisations.size(); i++) {
            ipm_details_cotisationsRepository.save(ipm_details_cotisations.get(i));

        }
        return ipm_details_cotisations;
    }

//    @Override
//    public List<IPM_Details_Cotisations> getDetailcotisation(IPM_Cotisation ipm_cotisation) {
//        return ipm_details_cotisationsRepository.findByIpmcotisation(ipm_cotisation);
//    }

    @Override
    public void update(IPM_Details_Cotisations ipm_details_cotisations) {
     ipm_details_cotisationsRepository.save(ipm_details_cotisations);
    }
    @Override
    public Collection<IPM_Details_Cotisations> listCotisationById(long id) {
           return  ipm_details_cotisationsRepository.getListCotisation(id);
    }

    @Override
    public void delete(Long id) {
       ipm_details_cotisationsRepository.deleteById(id);
    }

    @Override
    public  Collection<IPM_Details_Cotisations> getCumulCotisation(Integer annee){
        return ipm_details_cotisationsRepository.getCotisationAnnualle(annee);
    }
}
