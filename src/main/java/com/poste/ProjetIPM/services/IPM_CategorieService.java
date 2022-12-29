package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Categorie;

import java.util.Collection;

public interface IPM_CategorieService {

    Collection<IPM_Categorie> getAll();

    IPM_Categorie getById(long id);

    void save(IPM_Categorie ipm_categorie);

    void update(IPM_Categorie ipm_categorie);

    void delete(Long id);
}
