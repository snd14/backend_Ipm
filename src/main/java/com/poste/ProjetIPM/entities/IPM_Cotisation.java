package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Cotisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCotisation;
    private Double montant_totals;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date date;

    public Long getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(Long idCotisation) {
        this.idCotisation = idCotisation;
    }



//    public IPM_Employe getIpm_employe() {
//        return ipm_employe;
//    }
//
//    public void setIpm_employe(IPM_Employe ipm_employe) {
//        this.ipm_employe = ipm_employe;
//    }

  //  private String cumul_cotisation;
    @JsonIgnore
    @OneToMany(mappedBy = "ipm_cotisation")
    private List<IPM_Details_Cotisations> ipm_details_cotisations;
//    @ManyToOne
//    private IPM_Employe ipm_employe;
  //  private String matricule;
   // private String fileName;
 /*   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_cotisation;*/
    /*@Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public IPM_Cotisation(String matricule , String fileName,Date date_cotisation) {
        this.matricule = matricule;
        this.fileName = fileName;
        this.date_cotisation= date_cotisation;


    }*/
    /*@OneToMany(mappedBy = "ipm_cotisation")
    private List<IPM_Categorie> ipm_categories;*/


}
