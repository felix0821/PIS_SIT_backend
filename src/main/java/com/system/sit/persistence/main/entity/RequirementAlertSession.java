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
@Table(name = "requirement_alert_session", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "RequirementAlertSession.findAll", query = "SELECT r FROM RequirementAlertSession r"),
    @NamedQuery(name = "RequirementAlertSession.findBySessionId", query = "SELECT r FROM RequirementAlertSession r WHERE r.sessionId = :sessionId"),
    @NamedQuery(name = "RequirementAlertSession.findByGizRoute", query = "SELECT r FROM RequirementAlertSession r WHERE r.gizRoute = :gizRoute"),
    @NamedQuery(name = "RequirementAlertSession.findBySessionTimestamp", query = "SELECT r FROM RequirementAlertSession r WHERE r.sessionTimestamp = :sessionTimestamp")})
public class RequirementAlertSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "session_id", nullable = false)
    private Long sessionId;
    @Basic(optional = false)
    @Column(name = "giz_route", nullable = false)
    private long gizRoute;
    @Basic(optional = false)
    @Column(name = "session_timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sessionTimestamp;
    @JoinColumn(name = "alert_status_id", referencedColumnName = "alert_status_id", nullable = false)
    @ManyToOne(optional = false)
    private RequirementAlertStatus alertStatusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionId")
    private Collection<RequirementAlert> requirementAlertCollection;

    public RequirementAlertSession() {
    }

    public RequirementAlertSession(Long sessionId) {
        this.sessionId = sessionId;
    }

    public RequirementAlertSession(Long sessionId, long gizRoute, Date sessionTimestamp) {
        this.sessionId = sessionId;
        this.gizRoute = gizRoute;
        this.sessionTimestamp = sessionTimestamp;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public long getGizRoute() {
        return gizRoute;
    }

    public void setGizRoute(long gizRoute) {
        this.gizRoute = gizRoute;
    }

    public Date getSessionTimestamp() {
        return sessionTimestamp;
    }

    public void setSessionTimestamp(Date sessionTimestamp) {
        this.sessionTimestamp = sessionTimestamp;
    }

    public RequirementAlertStatus getAlertStatusId() {
        return alertStatusId;
    }

    public void setAlertStatusId(RequirementAlertStatus alertStatusId) {
        this.alertStatusId = alertStatusId;
    }

    public Collection<RequirementAlert> getRequirementAlertCollection() {
        return requirementAlertCollection;
    }

    public void setRequirementAlertCollection(Collection<RequirementAlert> requirementAlertCollection) {
        this.requirementAlertCollection = requirementAlertCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequirementAlertSession)) {
            return false;
        }
        RequirementAlertSession other = (RequirementAlertSession) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.RequirementAlertSession[ sessionId=" + sessionId + " ]";
    }
    
}
