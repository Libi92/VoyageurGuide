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
 * @author libin
 */
@Entity
@Table(name = "hotels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotels.findAll", query = "SELECT h FROM Hotels h"),
    @NamedQuery(name = "Hotels.findByHotelid", query = "SELECT h FROM Hotels h WHERE h.hotelid = :hotelid"),
    @NamedQuery(name = "Hotels.findByLoginid", query = "SELECT h FROM Hotels h WHERE h.loginid = :loginid"),
    @NamedQuery(name = "Hotels.findByPlace", query = "SELECT h FROM Hotels h WHERE h.place = :place"),
    @NamedQuery(name = "Hotels.findByNearestcity", query = "SELECT h FROM Hotels h WHERE h.nearestcity = :nearestcity"),
    @NamedQuery(name = "Hotels.findByDistrict", query = "SELECT h FROM Hotels h WHERE h.district = :district"),
    @NamedQuery(name = "Hotels.findByLandmark", query = "SELECT h FROM Hotels h WHERE h.landmark = :landmark"),
    @NamedQuery(name = "Hotels.findByPhoto", query = "SELECT h FROM Hotels h WHERE h.photo = :photo"),
    @NamedQuery(name = "Hotels.findByLatitude", query = "SELECT h FROM Hotels h WHERE h.latitude = :latitude"),
    @NamedQuery(name = "Hotels.findByLongitude", query = "SELECT h FROM Hotels h WHERE h.longitude = :longitude"),
    @NamedQuery(name = "Hotels.findByRooms", query = "SELECT h FROM Hotels h WHERE h.rooms = :rooms")})
public class Hotels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotelid")
    private Integer hotelid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginid")
    private int loginid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nearestcity")
    private String nearestcity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "district")
    private int district;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "landmark")
    private String landmark;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "photo")
    private String photo;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "rooms")
    private int rooms;

    public Hotels() {
    }

    public Hotels(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Hotels(Integer hotelid, int loginid, String place, String nearestcity, int district, String landmark, String photo, String latitude, String longitude, int rooms) {
        this.hotelid = hotelid;
        this.loginid = loginid;
        this.place = place;
        this.nearestcity = nearestcity;
        this.district = district;
        this.landmark = landmark;
        this.photo = photo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rooms = rooms;
    }

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNearestcity() {
        return nearestcity;
    }

    public void setNearestcity(String nearestcity) {
        this.nearestcity = nearestcity;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelid != null ? hotelid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotels)) {
            return false;
        }
        Hotels other = (Hotels) object;
        if ((this.hotelid == null && other.hotelid != null) || (this.hotelid != null && !this.hotelid.equals(other.hotelid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Hotels[ hotelid=" + hotelid + " ]";
    }
    
}
