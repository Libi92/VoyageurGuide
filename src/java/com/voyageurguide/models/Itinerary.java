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
@Table(name = "itinerary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinerary.findAll", query = "SELECT i FROM Itinerary i"),
    @NamedQuery(name = "Itinerary.findById", query = "SELECT i FROM Itinerary i WHERE i.id = :id"),
    @NamedQuery(name = "Itinerary.findByPackageid", query = "SELECT i FROM Itinerary i WHERE i.packageid = :packageid"),
    @NamedQuery(name = "Itinerary.findByPlace", query = "SELECT i FROM Itinerary i WHERE i.place = :place"),
    @NamedQuery(name = "Itinerary.findByHotel", query = "SELECT i FROM Itinerary i WHERE i.hotel = :hotel"),
    @NamedQuery(name = "Itinerary.findByTaxi", query = "SELECT i FROM Itinerary i WHERE i.taxi = :taxi"),
    @NamedQuery(name = "Itinerary.findByGuide", query = "SELECT i FROM Itinerary i WHERE i.guide = :guide"),
    @NamedQuery(name = "Itinerary.findByDate", query = "SELECT i FROM Itinerary i WHERE i.date = :date"),
    @NamedQuery(name = "Itinerary.findUniquePackageByGuide", query = "SELECT DISTINCT i.packageid FROM Itinerary i WHERE i.guide = :guide"),
    @NamedQuery(name = "Itinerary.findUniquePackageByHotel", query = "SELECT DISTINCT i.packageid FROM Itinerary i WHERE i.hotel = :hotel"),
    @NamedQuery(name = "Itinerary.findUniqueHotelByPackage", query = "SELECT DISTINCT i.hotel FROM Itinerary i WHERE i.packageid = :packageid"),
    @NamedQuery(name = "Itinerary.findUniqueGuideByPackage", query = "SELECT DISTINCT i.guide FROM Itinerary i WHERE i.packageid = :packageid"),
    @NamedQuery(name = "Itinerary.findUniqueTaxiByPackage", query = "SELECT DISTINCT i.taxi FROM Itinerary i WHERE i.packageid = :packageid"),
    @NamedQuery(name = "Itinerary.findByType", query = "SELECT i FROM Itinerary i WHERE i.type = :type")})
public class Itinerary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "packageid")
    private int packageid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hotel")
    private int hotel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxi")
    private int taxi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guide")
    private int guide;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "date")
    private String date;
    @Column(name = "type")
    private Integer type;

    public Itinerary() {
    }

    public Itinerary(Integer id) {
        this.id = id;
    }

    public Itinerary(Integer id, int packageid, String place, int hotel, int taxi, int guide, String date) {
        this.id = id;
        this.packageid = packageid;
        this.place = place;
        this.hotel = hotel;
        this.taxi = taxi;
        this.guide = guide;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPackageid() {
        return packageid;
    }

    public void setPackageid(int packageid) {
        this.packageid = packageid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getTaxi() {
        return taxi;
    }

    public void setTaxi(int taxi) {
        this.taxi = taxi;
    }

    public int getGuide() {
        return guide;
    }

    public void setGuide(int guide) {
        this.guide = guide;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        if (!(object instanceof Itinerary)) {
            return false;
        }
        Itinerary other = (Itinerary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Itinerary[ id=" + id + " ]";
    }
    
}
