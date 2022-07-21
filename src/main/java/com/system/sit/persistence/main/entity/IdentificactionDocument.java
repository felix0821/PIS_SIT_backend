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
@Table(name = "identificaction_document", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "IdentificactionDocument.findAll", query = "SELECT i FROM IdentificactionDocument i"),
    @NamedQuery(name = "IdentificactionDocument.findByIdentificactionDocumentId", query = "SELECT i FROM IdentificactionDocument i WHERE i.identificactionDocumentId = :identificactionDocumentId"),
    @NamedQuery(name = "IdentificactionDocument.findByIdentificactionDocumentState", query = "SELECT i FROM IdentificactionDocument i WHERE i.identificactionDocumentState = :identificactionDocumentState"),
    @NamedQuery(name = "IdentificactionDocument.findByIdentificactionDocumentName", query = "SELECT i FROM IdentificactionDocument i WHERE i.identificactionDocumentName = :identificactionDocumentName")})
public class IdentificactionDocument implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificaction_document_id", nullable = false)
    private Long identificactionDocumentId;
    @Basic(optional = false)
    @Column(name = "identificaction_document_state", nullable = false)
    private Character identificactionDocumentState;
    @Basic(optional = false)
    @Column(name = "identificaction_document_name", nullable = false, length = 32)
    private String identificactionDocumentName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificactionDocument")
    private Collection<PersonIdentification> personIdentificationCollection;

    public IdentificactionDocument() {
    }

    public IdentificactionDocument(Long identificactionDocumentId) {
        this.identificactionDocumentId = identificactionDocumentId;
    }

    public IdentificactionDocument(Long identificactionDocumentId, Character identificactionDocumentState, String identificactionDocumentName) {
        this.identificactionDocumentId = identificactionDocumentId;
        this.identificactionDocumentState = identificactionDocumentState;
        this.identificactionDocumentName = identificactionDocumentName;
    }

    public Long getIdentificactionDocumentId() {
        return identificactionDocumentId;
    }

    public void setIdentificactionDocumentId(Long identificactionDocumentId) {
        this.identificactionDocumentId = identificactionDocumentId;
    }

    public Character getIdentificactionDocumentState() {
        return identificactionDocumentState;
    }

    public void setIdentificactionDocumentState(Character identificactionDocumentState) {
        this.identificactionDocumentState = identificactionDocumentState;
    }

    public String getIdentificactionDocumentName() {
        return identificactionDocumentName;
    }

    public void setIdentificactionDocumentName(String identificactionDocumentName) {
        this.identificactionDocumentName = identificactionDocumentName;
    }

    public Collection<PersonIdentification> getPersonIdentificationCollection() {
        return personIdentificationCollection;
    }

    public void setPersonIdentificationCollection(Collection<PersonIdentification> personIdentificationCollection) {
        this.personIdentificationCollection = personIdentificationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificactionDocumentId != null ? identificactionDocumentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificactionDocument)) {
            return false;
        }
        IdentificactionDocument other = (IdentificactionDocument) object;
        if ((this.identificactionDocumentId == null && other.identificactionDocumentId != null) || (this.identificactionDocumentId != null && !this.identificactionDocumentId.equals(other.identificactionDocumentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.IdentificactionDocument[ identificactionDocumentId=" + identificactionDocumentId + " ]";
    }
    
}
