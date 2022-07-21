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
@Table(name = "giz_entity_reference", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "GizEntityReference.findAll", query = "SELECT g FROM GizEntityReference g"),
    @NamedQuery(name = "GizEntityReference.findByEntityReferenceId", query = "SELECT g FROM GizEntityReference g WHERE g.entityReferenceId = :entityReferenceId"),
    @NamedQuery(name = "GizEntityReference.findByEntityReferenceState", query = "SELECT g FROM GizEntityReference g WHERE g.entityReferenceState = :entityReferenceState"),
    @NamedQuery(name = "GizEntityReference.findByEntityReferenceName", query = "SELECT g FROM GizEntityReference g WHERE g.entityReferenceName = :entityReferenceName")})
public class GizEntityReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "entity_reference_id", nullable = false)
    private Long entityReferenceId;
    @Basic(optional = false)
    @Column(name = "entity_reference_state", nullable = false)
    private Character entityReferenceState;
    @Basic(optional = false)
    @Column(name = "entity_reference_name", nullable = false, length = 64)
    private String entityReferenceName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gizEntityReference")
    private Collection<IncidentReference> incidentReferenceCollection;

    public GizEntityReference() {
    }

    public GizEntityReference(Long entityReferenceId) {
        this.entityReferenceId = entityReferenceId;
    }

    public GizEntityReference(Long entityReferenceId, Character entityReferenceState, String entityReferenceName) {
        this.entityReferenceId = entityReferenceId;
        this.entityReferenceState = entityReferenceState;
        this.entityReferenceName = entityReferenceName;
    }

    public Long getEntityReferenceId() {
        return entityReferenceId;
    }

    public void setEntityReferenceId(Long entityReferenceId) {
        this.entityReferenceId = entityReferenceId;
    }

    public Character getEntityReferenceState() {
        return entityReferenceState;
    }

    public void setEntityReferenceState(Character entityReferenceState) {
        this.entityReferenceState = entityReferenceState;
    }

    public String getEntityReferenceName() {
        return entityReferenceName;
    }

    public void setEntityReferenceName(String entityReferenceName) {
        this.entityReferenceName = entityReferenceName;
    }

    public Collection<IncidentReference> getIncidentReferenceCollection() {
        return incidentReferenceCollection;
    }

    public void setIncidentReferenceCollection(Collection<IncidentReference> incidentReferenceCollection) {
        this.incidentReferenceCollection = incidentReferenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entityReferenceId != null ? entityReferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GizEntityReference)) {
            return false;
        }
        GizEntityReference other = (GizEntityReference) object;
        if ((this.entityReferenceId == null && other.entityReferenceId != null) || (this.entityReferenceId != null && !this.entityReferenceId.equals(other.entityReferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.GizEntityReference[ entityReferenceId=" + entityReferenceId + " ]";
    }
    
}
