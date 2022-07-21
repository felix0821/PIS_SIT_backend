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
@Table(name = "service_rating", catalog = "de2frp0gc891pi", schema = "MLMPKGIQOGDBQT")
@NamedQueries({
    @NamedQuery(name = "ServiceRating.findAll", query = "SELECT s FROM ServiceRating s"),
    @NamedQuery(name = "ServiceRating.findByRatingId", query = "SELECT s FROM ServiceRating s WHERE s.ratingId = :ratingId"),
    @NamedQuery(name = "ServiceRating.findByGizVehicleId", query = "SELECT s FROM ServiceRating s WHERE s.gizVehicleId = :gizVehicleId"),
    @NamedQuery(name = "ServiceRating.findByRatingScore", query = "SELECT s FROM ServiceRating s WHERE s.ratingScore = :ratingScore"),
    @NamedQuery(name = "ServiceRating.findByRatingComment", query = "SELECT s FROM ServiceRating s WHERE s.ratingComment = :ratingComment"),
    @NamedQuery(name = "ServiceRating.findByRatingTimestamp", query = "SELECT s FROM ServiceRating s WHERE s.ratingTimestamp = :ratingTimestamp")})
public class ServiceRating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rating_id", nullable = false)
    private Long ratingId;
    @Basic(optional = false)
    @Column(name = "giz_vehicle_id", nullable = false)
    private long gizVehicleId;
    @Basic(optional = false)
    @Column(name = "rating_score", nullable = false)
    private int ratingScore;
    @Column(name = "rating_comment", length = 256)
    private String ratingComment;
    @Basic(optional = false)
    @Column(name = "rating_timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ratingTimestamp;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false)
    @ManyToOne(optional = false)
    private Person personId;

    public ServiceRating() {
    }

    public ServiceRating(Long ratingId) {
        this.ratingId = ratingId;
    }

    public ServiceRating(Long ratingId, long gizVehicleId, int ratingScore, Date ratingTimestamp) {
        this.ratingId = ratingId;
        this.gizVehicleId = gizVehicleId;
        this.ratingScore = ratingScore;
        this.ratingTimestamp = ratingTimestamp;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public long getGizVehicleId() {
        return gizVehicleId;
    }

    public void setGizVehicleId(long gizVehicleId) {
        this.gizVehicleId = gizVehicleId;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }

    public Date getRatingTimestamp() {
        return ratingTimestamp;
    }

    public void setRatingTimestamp(Date ratingTimestamp) {
        this.ratingTimestamp = ratingTimestamp;
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
        hash += (ratingId != null ? ratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceRating)) {
            return false;
        }
        ServiceRating other = (ServiceRating) object;
        if ((this.ratingId == null && other.ratingId != null) || (this.ratingId != null && !this.ratingId.equals(other.ratingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.system.sit.persistence.main.entity.ServiceRating[ ratingId=" + ratingId + " ]";
    }
    
}
