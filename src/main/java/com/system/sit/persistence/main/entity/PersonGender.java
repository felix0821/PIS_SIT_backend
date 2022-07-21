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
@Table(name = "person_gender", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "PersonGender.findAll", query = "SELECT p FROM PersonGender p"),
    @NamedQuery(name = "PersonGender.findByGenderId", query = "SELECT p FROM PersonGender p WHERE p.genderId = :genderId"),
    @NamedQuery(name = "PersonGender.findByGenderState", query = "SELECT p FROM PersonGender p WHERE p.genderState = :genderState"),
    @NamedQuery(name = "PersonGender.findByGenderName", query = "SELECT p FROM PersonGender p WHERE p.genderName = :genderName")})
public class PersonGender implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gender_id", nullable = false, length = 1)
    private String genderId;
    @Basic(optional = false)
    @Column(name = "gender_state", nullable = false)
    private Character genderState;
    @Basic(optional = false)
    @Column(name = "gender_name", nullable = false, length = 32)
    private String genderName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genderId")
    private Collection<Person> personCollection;

    public PersonGender() {
    }

    public PersonGender(String genderId) {
        this.genderId = genderId;
    }

    public PersonGender(String genderId, Character genderState, String genderName) {
        this.genderId = genderId;
        this.genderState = genderState;
        this.genderName = genderName;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public Character getGenderState() {
        return genderState;
    }

    public void setGenderState(Character genderState) {
        this.genderState = genderState;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genderId != null ? genderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonGender)) {
            return false;
        }
        PersonGender other = (PersonGender) object;
        if ((this.genderId == null && other.genderId != null) || (this.genderId != null && !this.genderId.equals(other.genderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.PersonGender[ genderId=" + genderId + " ]";
    }
    
}
