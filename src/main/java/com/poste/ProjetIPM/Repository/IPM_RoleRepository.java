
package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPM_RoleRepository extends JpaRepository<IPM_Role, Long> {
    IPM_Role findByTypeRole(String roleUser);
}

