package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleId implements Serializable {
    private Long ipm_utilisateur;
    private Long ipm_role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId that = (UserRoleId) o;
        return ipm_utilisateur == that.ipm_utilisateur && ipm_role == that.ipm_role;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(ipm_utilisateur, ipm_role);
    }



}
