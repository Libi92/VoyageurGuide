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
@Table(name = "places")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Places.findAll", query = "SELECT p FROM Places p"),
    @NamedQuery(name = "Places.findByPlaceid", query = "SELECT p FROM Places p WHERE p.placeid = :placeid"),
    @NamedQuery(name = "Places.findByPlace", query = "SELECT p FROM Places p WHERE p.place = :place"),
    @NamedQuery(name = "Places.findByDescription", query = "SELECT p FROM Places p WHERE p.description = :description"),
    @NamedQuery(name = "Places.findByDistrict", query = "SELECT p FROM Places p WHERE p.district = :district"),
    @NamedQuery(name = "Places.findByTaluk", query = "SELECT p FROM Places p WHERE p.taluk = :taluk"),
    @NamedQuery(name = "Places.findByLatitude", query = "SELECT p FROM Places p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Places.findByLongitude", query = "SELECT p FROM Places p WHERE p.longitude = :longitude")})
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "placeid")
    private Integer placeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "district")
    private int district;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taluk")
    private int taluk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "latitude")
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "longitude")
    private String longitude;

    public Places() {
    }

    public Places(Integer placeid) {
        this.placeid = placeid;
    }

    public Places(Integer placeid, String place, String description, int district, int taluk, String latitude, String longitude) {
        this.placeid = placeid;
        this.place = place;
        this.description = description;
        this.district = district;
        this.taluk = taluk;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getTaluk() {
        return taluk;
    }

    public void setTaluk(int taluk) {
        this.taluk = taluk;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeid != null ? placeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Places)) {
            return false;
        }
        Places other = (Places) object;
        if ((this.placeid == null && other.placeid != null) || (this.placeid != null && !this.placeid.equals(other.placeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Places[ placeid=" + placeid + " ]";
    }
    
}
