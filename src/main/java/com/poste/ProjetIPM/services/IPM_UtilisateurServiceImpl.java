package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_UtilisateurRepository;
import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class IPM_UtilisateurServiceImpl implements IPM_UtilisateurService {
   @Autowired
   private IPM_UtilisateurRepository ipm_utilisateurRepository;
    @Override
    public IPM_Utilisateur findUserByEmail(String email) {
        return findUserByEmail(email);
    }
    /**
     * Vérifie si un utilisateur existe
     * @param userId
     * @return True or False
     */
    @Override
    public boolean userExist(Long userId) {
        return ipm_utilisateurRepository.findById(userId).isPresent();
    }

    @Override
    public IPM_Utilisateur findUserById(Long userId) {
        return ipm_utilisateurRepository.findById(userId).get();
    }

    @Override
    public IPM_Utilisateur updateUser(IPM_Utilisateur user) {
        return ipm_utilisateurRepository.save(user);
    }

    @Override
    public List<IPM_Utilisateur> getUserByStructureId(int structureId) {
        return null;
    }
}
