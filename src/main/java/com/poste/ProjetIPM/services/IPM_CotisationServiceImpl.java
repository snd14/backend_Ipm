package com.poste.ProjetIPM.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.poste.ProjetIPM.Repository.IPM_CotisationRepository;
import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.entities.IPM_Details_Cotisations;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
@Transactional
public class IPM_CotisationServiceImpl implements IPM_CotisationService {
    @Autowired
    IPM_CotisationRepository ipm_cotisationRepository;

    @Override
    public Collection<IPM_Cotisation> getAll() {
        return ipm_cotisationRepository.findAll();
    }

    @Override
    public IPM_Cotisation getById(long id) {
        return ipm_cotisationRepository.findById(id).get();
    }



    @Override
    public Long save(IPM_Cotisation ipm_cotisation) {
        IPM_Cotisation ipm_cotisation1=ipm_cotisationRepository.save(ipm_cotisation);
        return ipm_cotisation1.getIdCotisation();
    }

    @Override
    public void update(IPM_Cotisation ipm_cotisation) {
        ipm_cotisationRepository.save(ipm_cotisation);
    }

    @Override
    public void delete(Long id) {
        ipm_cotisationRepository.deleteById(id);
    }


    // Lire le format de fichier Excel




}
