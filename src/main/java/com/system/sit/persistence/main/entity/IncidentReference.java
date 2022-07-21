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
@Table(name = "incident_reference", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "IncidentReference.findAll", query = "SELECT i FROM IncidentReference i"),
    @NamedQuery(name = "IncidentReference.findByEntityReferenceId", query = "SELECT i FROM IncidentReference i WHERE i.incidentReferencePK.entityReferenceId = :entityReferenceId"),
    @NamedQuery(name = "IncidentReference.findByReportId", query = "SELECT i FROM IncidentReference i WHERE i.incidentReferencePK.reportId = :reportId"),
    @NamedQuery(name = "IncidentReference.findByGizReferenceId", query = "SELECT i FROM IncidentReference i WHERE i.gizReferenceId = :gizReferenceId")})
public class IncidentReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IncidentReferencePK incidentReferencePK;
    @Basic(optional = false)
    @Column(name = "giz_reference_id", nullable = false)
    private long gizReferenceId;
    @JoinColumn(name = "entity_reference_id", referencedColumnName = "entity_reference_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GizEntityReference gizEntityReference;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Incident incident;

    public IncidentReference() {
    }

    public IncidentReference(IncidentReferencePK incidentReferencePK) {
        this.incidentReferencePK = incidentReferencePK;
    }

    public IncidentReference(IncidentReferencePK incidentReferencePK, long gizReferenceId) {
        this.incidentReferencePK = incidentReferencePK;
        this.gizReferenceId = gizReferenceId;
    }

    public IncidentReference(long entityReferenceId, long reportId) {
        this.incidentReferencePK = new IncidentReferencePK(entityReferenceId, reportId);
    }

    public IncidentReferencePK getIncidentReferencePK() {
        return incidentReferencePK;
    }

    public void setIncidentReferencePK(IncidentReferencePK incidentReferencePK) {
        this.incidentReferencePK = incidentReferencePK;
    }

    public long getGizReferenceId() {
        return gizReferenceId;
    }

    public void setGizReferenceId(long gizReferenceId) {
        this.gizReferenceId = gizReferenceId;
    }

    public GizEntityReference getGizEntityReference() {
        return gizEntityReference;
    }

    public void setGizEntityReference(GizEntityReference gizEntityReference) {
        this.gizEntityReference = gizEntityReference;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidentReferencePK != null ? incidentReferencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncidentReference)) {
            return false;
        }
        IncidentReference other = (IncidentReference) object;
        if ((this.incidentReferencePK == null && other.incidentReferencePK != null) || (this.incidentReferencePK != null && !this.incidentReferencePK.equals(other.incidentReferencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.IncidentReference[ incidentReferencePK=" + incidentReferencePK + " ]";
    }
    
}
