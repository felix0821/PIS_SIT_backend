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
public class PersonIdentificationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private long personId;
    @Basic(optional = false)
    @Column(name = "identificaction_document_id", nullable = false)
    private long identificactionDocumentId;

    public PersonIdentificationPK() {
    }

    public PersonIdentificationPK(long personId, long identificactionDocumentId) {
        this.personId = personId;
        this.identificactionDocumentId = identificactionDocumentId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getIdentificactionDocumentId() {
        return identificactionDocumentId;
    }

    public void setIdentificactionDocumentId(long identificactionDocumentId) {
        this.identificactionDocumentId = identificactionDocumentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personId;
        hash += (int) identificactionDocumentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonIdentificationPK)) {
            return false;
        }
        PersonIdentificationPK other = (PersonIdentificationPK) object;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.identificactionDocumentId != other.identificactionDocumentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.PersonIdentificationPK[ personId=" + personId + ", identificactionDocumentId=" + identificactionDocumentId + " ]";
    }
    
}
