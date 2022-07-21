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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author estephany
 */
@Entity
@Table(name = "person", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByPersonId", query = "SELECT p FROM Person p WHERE p.personId = :personId"),
    @NamedQuery(name = "Person.findByPersonName", query = "SELECT p FROM Person p WHERE p.personName = :personName"),
    @NamedQuery(name = "Person.findByPersonLastnameFather", query = "SELECT p FROM Person p WHERE p.personLastnameFather = :personLastnameFather"),
    @NamedQuery(name = "Person.findByPersonLastnameMother", query = "SELECT p FROM Person p WHERE p.personLastnameMother = :personLastnameMother"),
    @NamedQuery(name = "Person.findByPersonDateBirth", query = "SELECT p FROM Person p WHERE p.personDateBirth = :personDateBirth"),
    @NamedQuery(name = "Person.findByPersonUsername", query = "SELECT p FROM Person p WHERE p.personUsername = :personUsername"),
    @NamedQuery(name = "Person.findByPersonPassword", query = "SELECT p FROM Person p WHERE p.personPassword = :personPassword"),
    @NamedQuery(name = "Person.findByPersonState", query = "SELECT p FROM Person p WHERE p.personState = :personState")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private Long personId;
    @Basic(optional = false)
    @Column(name = "person_name", nullable = false, length = 64)
    private String personName;
    @Basic(optional = false)
    @Column(name = "person_lastname_father", nullable = false, length = 64)
    private String personLastnameFather;
    @Basic(optional = false)
    @Column(name = "person_lastname_mother", nullable = false, length = 64)
    private String personLastnameMother;
    @Basic(optional = false)
    @Column(name = "person_date_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date personDateBirth;
    @Basic(optional = false)
    @Column(name = "person_username", nullable = false, length = 32)
    private String personUsername;
    @Basic(optional = false)
    @Column(name = "person_password", nullable = false, length = 64)
    private String personPassword;
    @Basic(optional = false)
    @Column(name = "person_state", nullable = false)
    private Character personState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonRole> personRoleCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private OperatorConcession operatorConcession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<ServiceRating> serviceRatingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<PersonIdentification> personIdentificationCollection;
    @JoinColumn(name = "gender_id", referencedColumnName = "gender_id", nullable = false)
    @ManyToOne(optional = false)
    private PersonGender genderId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<RequirementAlert> requirementAlertCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private DriverVehicle driverVehicle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Incident> incidentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<Announcement> announcementCollection;

    public Person() {
    }

    public Person(Long personId) {
        this.personId = personId;
    }

    public Person(Long personId, String personName, String personLastnameFather, String personLastnameMother, Date personDateBirth, String personUsername, String personPassword, Character personState) {
        this.personId = personId;
        this.personName = personName;
        this.personLastnameFather = personLastnameFather;
        this.personLastnameMother = personLastnameMother;
        this.personDateBirth = personDateBirth;
        this.personUsername = personUsername;
        this.personPassword = personPassword;
        this.personState = personState;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastnameFather() {
        return personLastnameFather;
    }

    public void setPersonLastnameFather(String personLastnameFather) {
        this.personLastnameFather = personLastnameFather;
    }

    public String getPersonLastnameMother() {
        return personLastnameMother;
    }

    public void setPersonLastnameMother(String personLastnameMother) {
        this.personLastnameMother = personLastnameMother;
    }

    public Date getPersonDateBirth() {
        return personDateBirth;
    }

    public void setPersonDateBirth(Date personDateBirth) {
        this.personDateBirth = personDateBirth;
    }

    public String getPersonUsername() {
        return personUsername;
    }

    public void setPersonUsername(String personUsername) {
        this.personUsername = personUsername;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public Character getPersonState() {
        return personState;
    }

    public void setPersonState(Character personState) {
        this.personState = personState;
    }

    public Collection<PersonRole> getPersonRoleCollection() {
        return personRoleCollection;
    }

    public void setPersonRoleCollection(Collection<PersonRole> personRoleCollection) {
        this.personRoleCollection = personRoleCollection;
    }

    public OperatorConcession getOperatorConcession() {
        return operatorConcession;
    }

    public void setOperatorConcession(OperatorConcession operatorConcession) {
        this.operatorConcession = operatorConcession;
    }

    public Collection<ServiceRating> getServiceRatingCollection() {
        return serviceRatingCollection;
    }

    public void setServiceRatingCollection(Collection<ServiceRating> serviceRatingCollection) {
        this.serviceRatingCollection = serviceRatingCollection;
    }

    public Collection<PersonIdentification> getPersonIdentificationCollection() {
        return personIdentificationCollection;
    }

    public void setPersonIdentificationCollection(Collection<PersonIdentification> personIdentificationCollection) {
        this.personIdentificationCollection = personIdentificationCollection;
    }

    public PersonGender getGenderId() {
        return genderId;
    }

    public void setGenderId(PersonGender genderId) {
        this.genderId = genderId;
    }

    public Collection<RequirementAlert> getRequirementAlertCollection() {
        return requirementAlertCollection;
    }

    public void setRequirementAlertCollection(Collection<RequirementAlert> requirementAlertCollection) {
        this.requirementAlertCollection = requirementAlertCollection;
    }

    public DriverVehicle getDriverVehicle() {
        return driverVehicle;
    }

    public void setDriverVehicle(DriverVehicle driverVehicle) {
        this.driverVehicle = driverVehicle;
    }

    public Collection<Incident> getIncidentCollection() {
        return incidentCollection;
    }

    public void setIncidentCollection(Collection<Incident> incidentCollection) {
        this.incidentCollection = incidentCollection;
    }

    public Collection<Announcement> getAnnouncementCollection() {
        return announcementCollection;
    }

    public void setAnnouncementCollection(Collection<Announcement> announcementCollection) {
        this.announcementCollection = announcementCollection;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.Person[ personId=" + personId + " ]";
    }
    
}
