/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 10945
 */
@Entity
@Table(name = "rooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r"),
    @NamedQuery(name = "Rooms.findById", query = "SELECT r FROM Rooms r WHERE r.id = :id"),
    @NamedQuery(name = "Rooms.findByHotelid", query = "SELECT r FROM Rooms r WHERE r.hotelid = :hotelid"),
    @NamedQuery(name = "Rooms.findByNoofrooms", query = "SELECT r FROM Rooms r WHERE r.noofrooms = :noofrooms"),
    @NamedQuery(name = "Rooms.findByType", query = "SELECT r FROM Rooms r WHERE r.type = :type"),
    @NamedQuery(name = "Rooms.findByRent", query = "SELECT r FROM Rooms r WHERE r.rent = :rent")})
public class Rooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hotelid")
    private int hotelid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noofrooms")
    private int noofrooms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "rent")
    private String rent;

    public Rooms() {
    }

    public Rooms(Integer id) {
        this.id = id;
    }

    public Rooms(Integer id, int hotelid, int noofrooms, String type, String rent) {
        this.id = id;
        this.hotelid = hotelid;
        this.noofrooms = noofrooms;
        this.type = type;
        this.rent = rent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public int getNoofrooms() {
        return noofrooms;
    }

    public void setNoofrooms(int noofrooms) {
        this.noofrooms = noofrooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
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
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Rooms[ id=" + id + " ]";
    }
    
}
