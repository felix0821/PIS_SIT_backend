/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.sit.persistence.main.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author estephany
 */
@Entity
@Table(name = "requirement_alert", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "RequirementAlert.findAll", query = "SELECT r FROM RequirementAlert r"),
    @NamedQuery(name = "RequirementAlert.findByAlertId", query = "SELECT r FROM RequirementAlert r WHERE r.alertId = :alertId"),
    @NamedQuery(name = "RequirementAlert.findByAlertTimestamp", query = "SELECT r FROM RequirementAlert r WHERE r.alertTimestamp = :alertTimestamp")})
public class RequirementAlert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "alert_id", nullable = false)
    private Long alertId;
    @Basic(optional = false)
    @Column(name = "alert_timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date alertTimestamp;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;
    @JoinColumn(name = "session_id", referencedColumnName = "session_id", nullable = false)
    @ManyToOne(optional = false)
    private RequirementAlertSession sessionId;

    public RequirementAlert() {
    }

    public RequirementAlert(Long alertId) {
        this.alertId = alertId;
    }

    public RequirementAlert(Long alertId, Date alertTimestamp) {
        this.alertId = alertId;
        this.alertTimestamp = alertTimestamp;
    }

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    public Date getAlertTimestamp() {
        return alertTimestamp;
    }

    public void setAlertTimestamp(Date alertTimestamp) {
        this.alertTimestamp = alertTimestamp;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public RequirementAlertSession getSessionId() {
        return sessionId;
    }

    public void setSessionId(RequirementAlertSession sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertId != null ? alertId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequirementAlert)) {
            return false;
        }
        RequirementAlert other = (RequirementAlert) object;
        if ((this.alertId == null && other.alertId != null) || (this.alertId != null && !this.alertId.equals(other.alertId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.RequirementAlert[ alertId=" + alertId + " ]";
    }
    
}
