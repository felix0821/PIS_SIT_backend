/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.sit.persistence.main.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author estephany
 */
@Embeddable
public class PersonRolePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;

    public PersonRolePK() {
    }

    public PersonRolePK(long personId, long roleId) {
        this.personId = personId;
        this.roleId = roleId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personId;
        hash += (int) roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonRolePK)) {
            return false;
        }
        PersonRolePK other = (PersonRolePK) object;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.PersonRolePK[ personId=" + personId + ", roleId=" + roleId + " ]";
    }
    
}
