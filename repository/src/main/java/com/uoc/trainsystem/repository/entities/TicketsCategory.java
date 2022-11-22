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
@Table(name = "tickets_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketsCategory.findAll", query = "SELECT t FROM TicketsCategory t"),
    @NamedQuery(name = "TicketsCategory.findById", query = "SELECT t FROM TicketsCategory t WHERE t.id = :id"),
    @NamedQuery(name = "TicketsCategory.findByName", query = "SELECT t FROM TicketsCategory t WHERE t.name = :name"),
    @NamedQuery(name = "TicketsCategory.findByCode", query = "SELECT t FROM TicketsCategory t WHERE t.code = :code")})
public class TicketsCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketsCategoryId")
    private Collection<TicketPrice> ticketPriceCollection;

    public TicketsCategory() {
    }

    public TicketsCategory(Integer id) {
        this.id = id;
    }

    public TicketsCategory(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<TicketPrice> getTicketPriceCollection() {
        return ticketPriceCollection;
    }

    public void setTicketPriceCollection(Collection<TicketPrice> ticketPriceCollection) {
        this.ticketPriceCollection = ticketPriceCollection;
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
        if (!(object instanceof TicketsCategory)) {
            return false;
        }
        TicketsCategory other = (TicketsCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uoc.trainsystem.repository.entities.TicketsCategory[ id=" + id + " ]";
    }
    
}
