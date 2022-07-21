/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.sit.persistence.main.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author estephany
 */
@Entity
@Table(name = "incident", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "Incident.findAll", query = "SELECT i FROM Incident i"),
    @NamedQuery(name = "Incident.findByReportId", query = "SELECT i FROM Incident i WHERE i.reportId = :reportId"),
    @NamedQuery(name = "Incident.findByIncidentContent", query = "SELECT i FROM Incident i WHERE i.incidentContent = :incidentContent"),
    @NamedQuery(name = "Incident.findByIncidentDate", query = "SELECT i FROM Incident i WHERE i.incidentDate = :incidentDate"),
    @NamedQuery(name = "Incident.findByIncidentTimestamp", query = "SELECT i FROM Incident i WHERE i.incidentTimestamp = :incidentTimestamp")})
public class Incident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "report_id", nullable = false)
    private Long reportId;
    @Basic(optional = false)
    @Column(name = "incident_content", nullable = false, length = 256)
    private String incidentContent;
    @Basic(optional = false)
    @Column(name = "incident_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date incidentDate;
    @Column(name = "incident_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incidentTimestamp;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incident")
    private Collection<IncidentReference> incidentReferenceCollection;

    public Incident() {
    }

    public Incident(Long reportId) {
        this.reportId = reportId;
    }

    public Incident(Long reportId, String incidentContent, Date incidentDate) {
        this.reportId = reportId;
        this.incidentContent = incidentContent;
        this.incidentDate = incidentDate;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getIncidentContent() {
        return incidentContent;
    }

    public void setIncidentContent(String incidentContent) {
        this.incidentContent = incidentContent;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Date getIncidentTimestamp() {
        return incidentTimestamp;
    }

    public void setIncidentTimestamp(Date incidentTimestamp) {
        this.incidentTimestamp = incidentTimestamp;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
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
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incident)) {
            return false;
        }
        Incident other = (Incident) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.Incident[ reportId=" + reportId + " ]";
    }
    
}
