/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.system.sit.persistence.main.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author estephany
 */
@Entity
@Table(name = "driver_vehicle", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"person_id", "giz_vehicle"})})
@NamedQueries({
    @NamedQuery(name = "DriverVehicle.findAll", query = "SELECT d FROM DriverVehicle d"),
    @NamedQuery(name = "DriverVehicle.findByPersonId", query = "SELECT d FROM DriverVehicle d WHERE d.personId = :personId"),
    @NamedQuery(name = "DriverVehicle.findByGizVehicle", query = "SELECT d FROM DriverVehicle d WHERE d.gizVehicle = :gizVehicle"),
    @NamedQuery(name = "DriverVehicle.findByDriverVehicleState", query = "SELECT d FROM DriverVehicle d WHERE d.driverVehicleState = :driverVehicleState")})
public class DriverVehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private Long personId;
    @Basic(optional = false)
    @Column(name = "giz_vehicle", nullable = false)
    private long gizVehicle;
    @Basic(optional = false)
    @Column(name = "driver_vehicle_state", nullable = false)
    private Character driverVehicleState;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public DriverVehicle() {
    }

    public DriverVehicle(Long personId) {
        this.personId = personId;
    }

    public DriverVehicle(Long personId, long gizVehicle, Character driverVehicleState) {
        this.personId = personId;
        this.gizVehicle = gizVehicle;
        this.driverVehicleState = driverVehicleState;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public long getGizVehicle() {
        return gizVehicle;
    }

    public void setGizVehicle(long gizVehicle) {
        this.gizVehicle = gizVehicle;
    }

    public Character getDriverVehicleState() {
        return driverVehicleState;
    }

    public void setDriverVehicleState(Character driverVehicleState) {
        this.driverVehicleState = driverVehicleState;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DriverVehicle)) {
            return false;
        }
        DriverVehicle other = (DriverVehicle) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.DriverVehicle[ personId=" + personId + " ]";
    }
    
}
