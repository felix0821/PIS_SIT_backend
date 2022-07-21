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
@Table(name = "operator_concession", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"person_id", "giz_concession"})})
@NamedQueries({
    @NamedQuery(name = "OperatorConcession.findAll", query = "SELECT o FROM OperatorConcession o"),
    @NamedQuery(name = "OperatorConcession.findByPersonId", query = "SELECT o FROM OperatorConcession o WHERE o.personId = :personId"),
    @NamedQuery(name = "OperatorConcession.findByGizConcession", query = "SELECT o FROM OperatorConcession o WHERE o.gizConcession = :gizConcession"),
    @NamedQuery(name = "OperatorConcession.findByPersonConcessionState", query = "SELECT o FROM OperatorConcession o WHERE o.personConcessionState = :personConcessionState")})
public class OperatorConcession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "person_id", nullable = false)
    private Long personId;
    @Basic(optional = false)
    @Column(name = "giz_concession", nullable = false)
    private long gizConcession;
    @Basic(optional = false)
    @Column(name = "person_concession_state", nullable = false)
    private Character personConcessionState;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public OperatorConcession() {
    }

    public OperatorConcession(Long personId) {
        this.personId = personId;
    }

    public OperatorConcession(Long personId, long gizConcession, Character personConcessionState) {
        this.personId = personId;
        this.gizConcession = gizConcession;
        this.personConcessionState = personConcessionState;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public long getGizConcession() {
        return gizConcession;
    }

    public void setGizConcession(long gizConcession) {
        this.gizConcession = gizConcession;
    }

    public Character getPersonConcessionState() {
        return personConcessionState;
    }

    public void setPersonConcessionState(Character personConcessionState) {
        this.personConcessionState = personConcessionState;
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
        if (!(object instanceof OperatorConcession)) {
            return false;
        }
        OperatorConcession other = (OperatorConcession) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.OperatorConcession[ personId=" + personId + " ]";
    }
    
}
