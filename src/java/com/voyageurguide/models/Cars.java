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
@Table(name = "cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findByCarid", query = "SELECT c FROM Cars c WHERE c.carid = :carid"),
    @NamedQuery(name = "Cars.findByTaxiid", query = "SELECT c FROM Cars c WHERE c.taxiid = :taxiid"),
    @NamedQuery(name = "Cars.findByCar", query = "SELECT c FROM Cars c WHERE c.car = :car"),
    @NamedQuery(name = "Cars.findByDriver", query = "SELECT c FROM Cars c WHERE c.driver = :driver"),
    @NamedQuery(name = "Cars.findByPhone", query = "SELECT c FROM Cars c WHERE c.phone = :phone"),
    @NamedQuery(name = "Cars.findByRate", query = "SELECT c FROM Cars c WHERE c.rate = :rate"),
    @NamedQuery(name = "Cars.findByPhoto", query = "SELECT c FROM Cars c WHERE c.photo = :photo")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carid")
    private Integer carid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxiid")
    private int taxiid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "car")
    private String car;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "driver")
    private String driver;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "rate")
    private String rate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "photo")
    private String photo;

    public Cars() {
    }

    public Cars(Integer carid) {
        this.carid = carid;
    }

    public Cars(Integer carid, int taxiid, String car, String driver, String phone, String rate, String photo) {
        this.carid = carid;
        this.taxiid = taxiid;
        this.car = car;
        this.driver = driver;
        this.phone = phone;
        this.rate = rate;
        this.photo = photo;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public int getTaxiid() {
        return taxiid;
    }

    public void setTaxiid(int taxiid) {
        this.taxiid = taxiid;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carid != null ? carid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.carid == null && other.carid != null) || (this.carid != null && !this.carid.equals(other.carid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Cars[ carid=" + carid + " ]";
    }
    
}
