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
@Table(name = "train")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Train.findAll", query = "SELECT t FROM Train t"),
    @NamedQuery(name = "Train.findById", query = "SELECT t FROM Train t WHERE t.id = :id"),
    @NamedQuery(name = "Train.findByTrainNo", query = "SELECT t FROM Train t WHERE t.trainNo = :trainNo"),
    @NamedQuery(name = "Train.findByName", query = "SELECT t FROM Train t WHERE t.name = :name"),
    @NamedQuery(name = "Train.findByDescription", query = "SELECT t FROM Train t WHERE t.description = :description")})
public class Train implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "train_no")
    private int trainNo;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainId")
    private Collection<TrainStatus> trainStatusCollection;
    @JoinColumn(name = "train_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TrainType trainTypeId;

    public Train() {
    }

    public Train(Integer id) {
        this.id = id;
    }

    public Train(Integer id, int trainNo, String name) {
        this.id = id;
        this.trainNo = trainNo;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<TrainStatus> getTrainStatusCollection() {
        return trainStatusCollection;
    }

    public void setTrainStatusCollection(Collection<TrainStatus> trainStatusCollection) {
        this.trainStatusCollection = trainStatusCollection;
    }

    public TrainType getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(TrainType trainTypeId) {
        this.trainTypeId = trainTypeId;
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
        if (!(object instanceof Train)) {
            return false;
        }
        Train other = (Train) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uoc.trainsystem.repository.entities.Train[ id=" + id + " ]";
    }
    
}
