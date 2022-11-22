/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoc.trainsystem.repository.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findById", query = "SELECT l FROM Location l WHERE l.id = :id")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<TrainStatus> trainStatusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<TicketPrice> ticketPriceCollection;
    @JoinColumn(name = "end_station_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Station endStationId;
    @JoinColumn(name = "start_station_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Station startStationId;

    public Location() {
    }

    public Location(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<TrainStatus> getTrainStatusCollection() {
        return trainStatusCollection;
    }

    public void setTrainStatusCollection(Collection<TrainStatus> trainStatusCollection) {
        this.trainStatusCollection = trainStatusCollection;
    }

    @XmlTransient
    public Collection<TicketPrice> getTicketPriceCollection() {
        return ticketPriceCollection;
    }

    public void setTicketPriceCollection(Collection<TicketPrice> ticketPriceCollection) {
        this.ticketPriceCollection = ticketPriceCollection;
    }

    public Station getEndStationId() {
        return endStationId;
    }

    public void setEndStationId(Station endStationId) {
        this.endStationId = endStationId;
    }

    public Station getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(Station startStationId) {
        this.startStationId = startStationId;
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
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uoc.trainsystem.repository.entities.Location[ id=" + id + " ]";
    }
    
}
