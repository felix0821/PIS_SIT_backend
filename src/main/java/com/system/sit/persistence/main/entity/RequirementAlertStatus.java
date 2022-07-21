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
@Table(name = "requirement_alert_status", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "RequirementAlertStatus.findAll", query = "SELECT r FROM RequirementAlertStatus r"),
    @NamedQuery(name = "RequirementAlertStatus.findByAlertStatusId", query = "SELECT r FROM RequirementAlertStatus r WHERE r.alertStatusId = :alertStatusId"),
    @NamedQuery(name = "RequirementAlertStatus.findByAlertStatusState", query = "SELECT r FROM RequirementAlertStatus r WHERE r.alertStatusState = :alertStatusState"),
    @NamedQuery(name = "RequirementAlertStatus.findByAlertStatusName", query = "SELECT r FROM RequirementAlertStatus r WHERE r.alertStatusName = :alertStatusName")})
public class RequirementAlertStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "alert_status_id", nullable = false)
    private Long alertStatusId;
    @Basic(optional = false)
    @Column(name = "alert_status_state", nullable = false)
    private Character alertStatusState;
    @Basic(optional = false)
    @Column(name = "alert_status_name", nullable = false, length = 64)
    private String alertStatusName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alertStatusId")
    private Collection<RequirementAlertSession> requirementAlertSessionCollection;

    public RequirementAlertStatus() {
    }

    public RequirementAlertStatus(Long alertStatusId) {
        this.alertStatusId = alertStatusId;
    }

    public RequirementAlertStatus(Long alertStatusId, Character alertStatusState, String alertStatusName) {
        this.alertStatusId = alertStatusId;
        this.alertStatusState = alertStatusState;
        this.alertStatusName = alertStatusName;
    }

    public Long getAlertStatusId() {
        return alertStatusId;
    }

    public void setAlertStatusId(Long alertStatusId) {
        this.alertStatusId = alertStatusId;
    }

    public Character getAlertStatusState() {
        return alertStatusState;
    }

    public void setAlertStatusState(Character alertStatusState) {
        this.alertStatusState = alertStatusState;
    }

    public String getAlertStatusName() {
        return alertStatusName;
    }

    public void setAlertStatusName(String alertStatusName) {
        this.alertStatusName = alertStatusName;
    }

    public Collection<RequirementAlertSession> getRequirementAlertSessionCollection() {
        return requirementAlertSessionCollection;
    }

    public void setRequirementAlertSessionCollection(Collection<RequirementAlertSession> requirementAlertSessionCollection) {
        this.requirementAlertSessionCollection = requirementAlertSessionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertStatusId != null ? alertStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequirementAlertStatus)) {
            return false;
        }
        RequirementAlertStatus other = (RequirementAlertStatus) object;
        if ((this.alertStatusId == null && other.alertStatusId != null) || (this.alertStatusId != null && !this.alertStatusId.equals(other.alertStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.RequirementAlertStatus[ alertStatusId=" + alertStatusId + " ]";
    }
    
}
