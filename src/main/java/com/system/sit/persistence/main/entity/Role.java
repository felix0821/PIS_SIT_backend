/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.sit.persistence.main.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author estephany
 */
@Entity
@Table(name = "role", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Role.findByRoleEnvironment", query = "SELECT r FROM Role r WHERE r.roleEnvironment = :roleEnvironment"),
    @NamedQuery(name = "Role.findByRoleState", query = "SELECT r FROM Role r WHERE r.roleState = :roleState"),
    @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role_id", nullable = false)
    private Long roleId;
    @Basic(optional = false)
    @Column(name = "role_environment", nullable = false)
    private Character roleEnvironment;
    @Basic(optional = false)
    @Column(name = "role_state", nullable = false)
    private Character roleState;
    @Basic(optional = false)
    @Column(name = "role_name", nullable = false, length = 64)
    private String roleName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<PersonRole> personRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<RoleAccess> roleAccessCollection;

    public Role() {
    }

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(Long roleId, Character roleEnvironment, Character roleState, String roleName) {
        this.roleId = roleId;
        this.roleEnvironment = roleEnvironment;
        this.roleState = roleState;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Character getRoleEnvironment() {
        return roleEnvironment;
    }

    public void setRoleEnvironment(Character roleEnvironment) {
        this.roleEnvironment = roleEnvironment;
    }

    public Character getRoleState() {
        return roleState;
    }

    public void setRoleState(Character roleState) {
        this.roleState = roleState;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<PersonRole> getPersonRoleCollection() {
        return personRoleCollection;
    }

    public void setPersonRoleCollection(Collection<PersonRole> personRoleCollection) {
        this.personRoleCollection = personRoleCollection;
    }

    public Collection<RoleAccess> getRoleAccessCollection() {
        return roleAccessCollection;
    }

    public void setRoleAccessCollection(Collection<RoleAccess> roleAccessCollection) {
        this.roleAccessCollection = roleAccessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.Role[ roleId=" + roleId + " ]";
    }
    
}
