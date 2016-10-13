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
@Table(name = "userpackage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userpackage.findAll", query = "SELECT u FROM Userpackage u"),
    @NamedQuery(name = "Userpackage.findById", query = "SELECT u FROM Userpackage u WHERE u.id = :id"),
    @NamedQuery(name = "Userpackage.findByLoginid", query = "SELECT u FROM Userpackage u WHERE u.loginid = :loginid"),
    @NamedQuery(name = "Userpackage.findByPlaces", query = "SELECT u FROM Userpackage u WHERE u.places = :places"),
    @NamedQuery(name = "Userpackage.findByDays", query = "SELECT u FROM Userpackage u WHERE u.days = :days"),
    @NamedQuery(name = "Userpackage.findByDate", query = "SELECT u FROM Userpackage u WHERE u.date = :date"),
    @NamedQuery(name = "Userpackage.findByNoofperson", query = "SELECT u FROM Userpackage u WHERE u.noofperson = :noofperson"),
    @NamedQuery(name = "Userpackage.findByPrice", query = "SELECT u FROM Userpackage u WHERE u.price = :price"),
    @NamedQuery(name = "Userpackage.findByStatus", query = "SELECT u FROM Userpackage u WHERE u.status = :status")})
public class Userpackage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginid")
    private int loginid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "places")
    private String places;
    @Basic(optional = false)
    @NotNull
    @Column(name = "days")
    private int days;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noofperson")
    private int noofperson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    public Userpackage() {
    }

    public Userpackage(Integer id) {
        this.id = id;
    }

    public Userpackage(Integer id, int loginid, String places, int days, String date, int noofperson, String price, int status) {
        this.id = id;
        this.loginid = loginid;
        this.places = places;
        this.days = days;
        this.date = date;
        this.noofperson = noofperson;
        this.price = price;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNoofperson() {
        return noofperson;
    }

    public void setNoofperson(int noofperson) {
        this.noofperson = noofperson;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Userpackage)) {
            return false;
        }
        Userpackage other = (Userpackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Userpackage[ id=" + id + " ]";
    }
    
}
