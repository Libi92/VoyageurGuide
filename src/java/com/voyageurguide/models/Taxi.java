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
@Table(name = "taxi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxi.findAll", query = "SELECT t FROM Taxi t"),
    @NamedQuery(name = "Taxi.findByTaxiid", query = "SELECT t FROM Taxi t WHERE t.taxiid = :taxiid"),
    @NamedQuery(name = "Taxi.findByLoginid", query = "SELECT t FROM Taxi t WHERE t.loginid = :loginid"),
    @NamedQuery(name = "Taxi.findByPlace", query = "SELECT t FROM Taxi t WHERE t.place = :place"),
    @NamedQuery(name = "Taxi.findByOwner", query = "SELECT t FROM Taxi t WHERE t.owner = :owner"),
    @NamedQuery(name = "Taxi.findByOwnercontact", query = "SELECT t FROM Taxi t WHERE t.ownercontact = :ownercontact"),
    @NamedQuery(name = "Taxi.findByContact", query = "SELECT t FROM Taxi t WHERE t.contact = :contact"),
    @NamedQuery(name = "Taxi.findByLicense", query = "SELECT t FROM Taxi t WHERE t.license = :license"),
    @NamedQuery(name = "Taxi.findByVehicles", query = "SELECT t FROM Taxi t WHERE t.vehicles = :vehicles")})
public class Taxi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "taxiid")
    private Integer taxiid;
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
    @Column(name = "owner")
    private String owner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ownercontact")
    private String ownercontact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "contact")
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "license")
    private String license;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicles")
    private int vehicles;

    public Taxi() {
    }

    public Taxi(Integer taxiid) {
        this.taxiid = taxiid;
    }

    public Taxi(Integer taxiid, int loginid, String place, String owner, String ownercontact, String contact, String license, int vehicles) {
        this.taxiid = taxiid;
        this.loginid = loginid;
        this.place = place;
        this.owner = owner;
        this.ownercontact = ownercontact;
        this.contact = contact;
        this.license = license;
        this.vehicles = vehicles;
    }

    public Integer getTaxiid() {
        return taxiid;
    }

    public void setTaxiid(Integer taxiid) {
        this.taxiid = taxiid;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnercontact() {
        return ownercontact;
    }

    public void setOwnercontact(String ownercontact) {
        this.ownercontact = ownercontact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxiid != null ? taxiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxi)) {
            return false;
        }
        Taxi other = (Taxi) object;
        if ((this.taxiid == null && other.taxiid != null) || (this.taxiid != null && !this.taxiid.equals(other.taxiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Taxi[ taxiid=" + taxiid + " ]";
    }
    
}
