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
@Table(name = "announcement", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "Announcement.findAll", query = "SELECT a FROM Announcement a"),
    @NamedQuery(name = "Announcement.findByAnnouncementId", query = "SELECT a FROM Announcement a WHERE a.announcementId = :announcementId"),
    @NamedQuery(name = "Announcement.findByAnnouncementContent", query = "SELECT a FROM Announcement a WHERE a.announcementContent = :announcementContent"),
    @NamedQuery(name = "Announcement.findByAnnouncementTimestamp", query = "SELECT a FROM Announcement a WHERE a.announcementTimestamp = :announcementTimestamp")})
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "announcement_id", nullable = false)
    private Long announcementId;
    @Basic(optional = false)
    @Column(name = "announcement_content", nullable = false, length = 256)
    private String announcementContent;
    @Basic(optional = false)
    @Column(name = "announcement_timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date announcementTimestamp;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;

    public Announcement() {
    }

    public Announcement(Long announcementId) {
        this.announcementId = announcementId;
    }

    public Announcement(Long announcementId, String announcementContent, Date announcementTimestamp) {
        this.announcementId = announcementId;
        this.announcementContent = announcementContent;
        this.announcementTimestamp = announcementTimestamp;
    }

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public Date getAnnouncementTimestamp() {
        return announcementTimestamp;
    }

    public void setAnnouncementTimestamp(Date announcementTimestamp) {
        this.announcementTimestamp = announcementTimestamp;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (announcementId != null ? announcementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Announcement)) {
            return false;
        }
        Announcement other = (Announcement) object;
        if ((this.announcementId == null && other.announcementId != null) || (this.announcementId != null && !this.announcementId.equals(other.announcementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.Announcement[ announcementId=" + announcementId + " ]";
    }
    
}
