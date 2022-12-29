package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_CatgorieRepository;
import com.poste.ProjetIPM.entities.IPM_Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class IPM_CategorieServiceImpl implements IPM_CategorieService {

    @Autowired
    IPM_CatgorieRepository ipm_catgorieRepository;

    @Override
    public Collection<IPM_Categorie> getAll() {
        return ipm_catgorieRepository.findAll();
    }

    @Override
    public IPM_Categorie getById(long id) {
        return ipm_catgorieRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Categorie ipm_categorie) {
        ipm_catgorieRepository.save(ipm_categorie);
    }

    @Override
    public void update(IPM_Categorie ipm_categorie) {
        ipm_catgorieRepository.save(ipm_categorie);
    }

    @Override
    public void delete(Long id) {
        ipm_catgorieRepository.deleteById(id);
    }
}
