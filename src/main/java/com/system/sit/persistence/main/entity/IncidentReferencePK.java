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
public class IncidentReferencePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "entity_reference_id", nullable = false)
    private long entityReferenceId;
    @Basic(optional = false)
    @Column(name = "report_id", nullable = false)
    private long reportId;

    public IncidentReferencePK() {
    }

    public IncidentReferencePK(long entityReferenceId, long reportId) {
        this.entityReferenceId = entityReferenceId;
        this.reportId = reportId;
    }

    public long getEntityReferenceId() {
        return entityReferenceId;
    }

    public void setEntityReferenceId(long entityReferenceId) {
        this.entityReferenceId = entityReferenceId;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) entityReferenceId;
        hash += (int) reportId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncidentReferencePK)) {
            return false;
        }
        IncidentReferencePK other = (IncidentReferencePK) object;
        if (this.entityReferenceId != other.entityReferenceId) {
            return false;
        }
        if (this.reportId != other.reportId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.IncidentReferencePK[ entityReferenceId=" + entityReferenceId + ", reportId=" + reportId + " ]";
    }
    
}
