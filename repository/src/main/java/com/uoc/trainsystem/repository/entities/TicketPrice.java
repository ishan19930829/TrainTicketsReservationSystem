/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoc.trainsystem.repository.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "ticket_price")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketPrice.findAll", query = "SELECT t FROM TicketPrice t"),
    @NamedQuery(name = "TicketPrice.findById", query = "SELECT t FROM TicketPrice t WHERE t.id = :id"),
    @NamedQuery(name = "TicketPrice.findByPrice", query = "SELECT t FROM TicketPrice t WHERE t.price = :price")})
public class TicketPrice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "tickets_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TicketsCategory ticketsCategoryId;

    public TicketPrice() {
    }

    public TicketPrice(Long id) {
        this.id = id;
    }

    public TicketPrice(Long id, double price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public TicketsCategory getTicketsCategoryId() {
        return ticketsCategoryId;
    }

    public void setTicketsCategoryId(TicketsCategory ticketsCategoryId) {
        this.ticketsCategoryId = ticketsCategoryId;
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
        if (!(object instanceof TicketPrice)) {
            return false;
        }
        TicketPrice other = (TicketPrice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uoc.trainsystem.repository.entities.TicketPrice[ id=" + id + " ]";
    }
    
}
