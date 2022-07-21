/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.sit.persistence.main.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author estephany
 */
@Entity
@Table(name = "role_access", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "RoleAccess.findAll", query = "SELECT r FROM RoleAccess r"),
    @NamedQuery(name = "RoleAccess.findByRoleId", query = "SELECT r FROM RoleAccess r WHERE r.roleAccessPK.roleId = :roleId"),
    @NamedQuery(name = "RoleAccess.findByResourceId", query = "SELECT r FROM RoleAccess r WHERE r.roleAccessPK.resourceId = :resourceId"),
    @NamedQuery(name = "RoleAccess.findByRoleAccess", query = "SELECT r FROM RoleAccess r WHERE r.roleAccess = :roleAccess")})
public class RoleAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleAccessPK roleAccessPK;
    @Basic(optional = false)
    @Column(name = "role_access", nullable = false)
    private Character roleAccess;
    @JoinColumn(name = "resource_id", referencedColumnName = "resource_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resource resource;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public RoleAccess() {
    }

    public RoleAccess(RoleAccessPK roleAccessPK) {
        this.roleAccessPK = roleAccessPK;
    }

    public RoleAccess(RoleAccessPK roleAccessPK, Character roleAccess) {
        this.roleAccessPK = roleAccessPK;
        this.roleAccess = roleAccess;
    }

    public RoleAccess(long roleId, long resourceId) {
        this.roleAccessPK = new RoleAccessPK(roleId, resourceId);
    }

    public RoleAccessPK getRoleAccessPK() {
        return roleAccessPK;
    }

    public void setRoleAccessPK(RoleAccessPK roleAccessPK) {
        this.roleAccessPK = roleAccessPK;
    }

    public Character getRoleAccess() {
        return roleAccess;
    }

    public void setRoleAccess(Character roleAccess) {
        this.roleAccess = roleAccess;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleAccessPK != null ? roleAccessPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleAccess)) {
            return false;
        }
        RoleAccess other = (RoleAccess) object;
        if ((this.roleAccessPK == null && other.roleAccessPK != null) || (this.roleAccessPK != null && !this.roleAccessPK.equals(other.roleAccessPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.RoleAccess[ roleAccessPK=" + roleAccessPK + " ]";
    }
    
}
