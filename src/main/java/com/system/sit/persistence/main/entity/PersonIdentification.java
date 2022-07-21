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
@Table(name = "person_identification", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "PersonIdentification.findAll", query = "SELECT p FROM PersonIdentification p"),
    @NamedQuery(name = "PersonIdentification.findByPersonId", query = "SELECT p FROM PersonIdentification p WHERE p.personIdentificationPK.personId = :personId"),
    @NamedQuery(name = "PersonIdentification.findByIdentificactionDocumentId", query = "SELECT p FROM PersonIdentification p WHERE p.personIdentificationPK.identificactionDocumentId = :identificactionDocumentId"),
    @NamedQuery(name = "PersonIdentification.findByIdentificationValue", query = "SELECT p FROM PersonIdentification p WHERE p.identificationValue = :identificationValue")})
public class PersonIdentification implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonIdentificationPK personIdentificationPK;
    @Basic(optional = false)
    @Column(name = "identification_value", nullable = false, length = 64)
    private String identificationValue;
    @JoinColumn(name = "identificaction_document_id", referencedColumnName = "identificaction_document_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private IdentificactionDocument identificactionDocument;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    public PersonIdentification() {
    }

    public PersonIdentification(PersonIdentificationPK personIdentificationPK) {
        this.personIdentificationPK = personIdentificationPK;
    }

    public PersonIdentification(PersonIdentificationPK personIdentificationPK, String identificationValue) {
        this.personIdentificationPK = personIdentificationPK;
        this.identificationValue = identificationValue;
    }

    public PersonIdentification(long personId, long identificactionDocumentId) {
        this.personIdentificationPK = new PersonIdentificationPK(personId, identificactionDocumentId);
    }

    public PersonIdentificationPK getPersonIdentificationPK() {
        return personIdentificationPK;
    }

    public void setPersonIdentificationPK(PersonIdentificationPK personIdentificationPK) {
        this.personIdentificationPK = personIdentificationPK;
    }

    public String getIdentificationValue() {
        return identificationValue;
    }

    public void setIdentificationValue(String identificationValue) {
        this.identificationValue = identificationValue;
    }

    public IdentificactionDocument getIdentificactionDocument() {
        return identificactionDocument;
    }

    public void setIdentificactionDocument(IdentificactionDocument identificactionDocument) {
        this.identificactionDocument = identificactionDocument;
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
        hash += (personIdentificationPK != null ? personIdentificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIdentification)) {
            return false;
        }
        PersonIdentification other = (PersonIdentification) object;
        if ((this.personIdentificationPK == null && other.personIdentificationPK != null) || (this.personIdentificationPK != null && !this.personIdentificationPK.equals(other.personIdentificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.PersonIdentification[ personIdentificationPK=" + personIdentificationPK + " ]";
    }
    
}
