package com.poste.ProjetIPM.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    boolean saveDataFromUploadFile(MultipartFile file);
}
