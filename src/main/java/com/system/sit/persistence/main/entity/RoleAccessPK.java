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
public class RoleAccessPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private long roleId;
    @Basic(optional = false)
    @Column(name = "resource_id", nullable = false)
    private long resourceId;

    public RoleAccessPK() {
    }

    public RoleAccessPK(long roleId, long resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roleId;
        hash += (int) resourceId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleAccessPK)) {
            return false;
        }
        RoleAccessPK other = (RoleAccessPK) object;
        if (this.roleId != other.roleId) {
            return false;
        }
        if (this.resourceId != other.resourceId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.RoleAccessPK[ roleId=" + roleId + ", resourceId=" + resourceId + " ]";
    }
    
}
