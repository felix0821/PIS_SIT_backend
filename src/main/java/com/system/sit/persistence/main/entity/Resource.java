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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author estephany
 */
@Entity
@Table(name = "resource", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"resource_name", "resource_url"})})
@NamedQueries({
    @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
    @NamedQuery(name = "Resource.findByResourceId", query = "SELECT r FROM Resource r WHERE r.resourceId = :resourceId"),
    @NamedQuery(name = "Resource.findByResourceName", query = "SELECT r FROM Resource r WHERE r.resourceName = :resourceName"),
    @NamedQuery(name = "Resource.findByResourceUrl", query = "SELECT r FROM Resource r WHERE r.resourceUrl = :resourceUrl"),
    @NamedQuery(name = "Resource.findByResourceType", query = "SELECT r FROM Resource r WHERE r.resourceType = :resourceType"),
    @NamedQuery(name = "Resource.findByResourceState", query = "SELECT r FROM Resource r WHERE r.resourceState = :resourceState")})
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "resource_id", nullable = false)
    private Long resourceId;
    @Basic(optional = false)
    @Column(name = "resource_name", nullable = false, length = 64)
    private String resourceName;
    @Basic(optional = false)
    @Column(name = "resource_url", nullable = false, length = 128)
    private String resourceUrl;
    @Basic(optional = false)
    @Column(name = "resource_type", nullable = false)
    private Character resourceType;
    @Basic(optional = false)
    @Column(name = "resource_state", nullable = false)
    private Character resourceState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resource")
    private Collection<RoleAccess> roleAccessCollection;

    public Resource() {
    }

    public Resource(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Resource(Long resourceId, String resourceName, String resourceUrl, Character resourceType, Character resourceState) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceType = resourceType;
        this.resourceState = resourceState;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Character getResourceType() {
        return resourceType;
    }

    public void setResourceType(Character resourceType) {
        this.resourceType = resourceType;
    }

    public Character getResourceState() {
        return resourceState;
    }

    public void setResourceState(Character resourceState) {
        this.resourceState = resourceState;
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
        hash += (resourceId != null ? resourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.resourceId == null && other.resourceId != null) || (this.resourceId != null && !this.resourceId.equals(other.resourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.Resource[ resourceId=" + resourceId + " ]";
    }
    
}
