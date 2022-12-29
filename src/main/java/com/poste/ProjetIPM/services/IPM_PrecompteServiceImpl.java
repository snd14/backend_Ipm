package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_PrecompteRepository;


import com.poste.ProjetIPM.entities.IPM_Facture;
import com.poste.ProjetIPM.entities.IPM_Precompte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IPM_PrecompteServiceImpl implements IPM_PrecompteService {
    @Autowired
    IPM_PrecompteRepository ipm_precompteRepository;

    @Override
    public Collection<IPM_Precompte> getAll() {
        return ipm_precompteRepository.findAll();
    }

    @Override
    public IPM_Precompte getById(long id) {
        return ipm_precompteRepository.findById(id).get();
    }

    @Override
    public void save(IPM_Precompte ipm_precompte) {

        ipm_precompteRepository.save(ipm_precompte);
    }
    @Override
    public String AjouterLettreAgr(MultipartFile file) throws IOException {
        String uploadDir = "C:/MesDossiers/Lettre-agrement/";
        File fileName = new File(uploadDir+""+file.getOriginalFilename());
        // Create File
        boolean fileCreated = fileName.createNewFile();

        return "Succes";
    }
    @Override
    public Collection<IPM_Precompte>  getByDatePrecompte(Date date){
        return  ipm_precompteRepository.findByDatePrecompte(date);
    }

    @Override
    public List<IPM_Precompte> save(List<IPM_Precompte> ipm_precompte) {
        for (int i = 0; i < ipm_precompte.size(); i++) {
            ipm_precompteRepository.save(ipm_precompte.get(i));
        }
        return ipm_precompte;
    }


    @Override
    public void update(IPM_Precompte ipm_precompte) {

        ipm_precompteRepository.save(ipm_precompte);
    }

    @Override
    public void delete(Long id) {
        ipm_precompteRepository.deleteById(id);
    }
}
