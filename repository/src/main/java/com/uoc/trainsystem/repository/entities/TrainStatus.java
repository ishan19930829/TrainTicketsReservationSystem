/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoc.trainsystem.repository.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "train_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainStatus.findAll", query = "SELECT t FROM TrainStatus t"),
    @NamedQuery(name = "TrainStatus.findById", query = "SELECT t FROM TrainStatus t WHERE t.id = :id"),
    @NamedQuery(name = "TrainStatus.findByStartTime", query = "SELECT t FROM TrainStatus t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "TrainStatus.findByEndTime", query = "SELECT t FROM TrainStatus t WHERE t.endTime = :endTime")})
public class TrainStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Train trainId;

    public TrainStatus() {
    }

    public TrainStatus(Integer id) {
        this.id = id;
    }

    public TrainStatus(Integer id, Date startTime, Date endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Train getTrainId() {
        return trainId;
    }

    public void setTrainId(Train trainId) {
        this.trainId = trainId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainStatus)) {
            return false;
        }
        TrainStatus other = (TrainStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uoc.trainsystem.repository.entities.TrainStatus[ id=" + id + " ]";
    }
    
}
