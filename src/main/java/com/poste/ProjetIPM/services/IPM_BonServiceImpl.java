package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_BonRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IPM_BonServiceImpl implements IPM_BonService {

    @Autowired
    IPM_BonRepository ipm_bonRepository;

    @Override
    public Collection<IPM_Bon> getAll() {
        return ipm_bonRepository.findAll();
    }

    @Override
    public IPM_Bon getById(long id) {
        return ipm_bonRepository.findById(id).get();
    }

    @Override
    public List<IPM_Bon> getBonById(Long id) {
        return ipm_bonRepository.getEmpById(id);
    }

    @Override
    public void save(IPM_Bon ipm_bon) {
        ipm_bonRepository.save(ipm_bon);
    }

    @Override
    public void update(IPM_Bon ipm_bon) {
        ipm_bonRepository.save(ipm_bon);
    }

    @Override
    public void delete(Long id) {
        ipm_bonRepository.deleteById(id);
    }

    @Override
    public List<IPM_Bon> getPrestataire(Long id) {
        return ipm_bonRepository.getPresById(id);
    }


    @Override
    public List<IPM_Bon> getBonbyperiode(Date date1, Date date2,String typeBon) {
        List<IPM_Bon> ipmBons=new ArrayList<>();
        List<IPM_Bon> ipmBonList=ipm_bonRepository.findByDateEtablissementBetween(date1,date2);
        for (int i = 0; i < ipmBonList.size(); i++) {
            if(ipmBonList.get(i).getDecriminatorValue().equals(typeBon)) {
                ipmBons.add(ipmBonList.get(i));
                System.out.print("Charles");
            }
            System.out.print(typeBon);
        }
        return ipmBons;

    }
    @Override
    public Collection<IPM_Bon> getBonbyperiodeAndType(Date date1, Date date2,Long d3) {
        return ipm_bonRepository.getBonByPeriodeAndtypeBon(date1,date2,d3);
    }

}
