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
@Table(name = "package")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p"),
    @NamedQuery(name = "Package.findByPackageid", query = "SELECT p FROM Package p WHERE p.packageid = :packageid"),
    @NamedQuery(name = "Package.findByName", query = "SELECT p FROM Package p WHERE p.name = :name"),
    @NamedQuery(name = "Package.findByDescription", query = "SELECT p FROM Package p WHERE p.description = :description"),
    @NamedQuery(name = "Package.findByDays", query = "SELECT p FROM Package p WHERE p.days = :days"),
    @NamedQuery(name = "Package.findByPlaces", query = "SELECT p FROM Package p WHERE p.places = :places"),
    @NamedQuery(name = "Package.findByDate", query = "SELECT p FROM Package p WHERE p.date = :date"),
    @NamedQuery(name = "Package.findByMaxno", query = "SELECT p FROM Package p WHERE p.maxno = :maxno"),
    @NamedQuery(name = "Package.findByPrice", query = "SELECT p FROM Package p WHERE p.price = :price"),
    @NamedQuery(name = "Package.findByEntries", query = "SELECT p FROM Package p WHERE p.entries = :entries"),
    @NamedQuery(name = "Package.findByStatus", query = "SELECT p FROM Package p WHERE p.status = :status")})
public class Package implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "packageid")
    private Integer packageid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "days")
    private int days;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "places")
    private String places;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxno")
    private int maxno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entries")
    private int entries;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    public Package() {
    }

    public Package(Integer packageid) {
        this.packageid = packageid;
    }

    public Package(Integer packageid, String name, String description, int days, String places, String date, int maxno, String price, int entries, int status) {
        this.packageid = packageid;
        this.name = name;
        this.description = description;
        this.days = days;
        this.places = places;
        this.date = date;
        this.maxno = maxno;
        this.price = price;
        this.entries = entries;
        this.status = status;
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMaxno() {
        return maxno;
    }

    public void setMaxno(int maxno) {
        this.maxno = maxno;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getEntries() {
        return entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
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
        hash += (packageid != null ? packageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Package)) {
            return false;
        }
        Package other = (Package) object;
        if ((this.packageid == null && other.packageid != null) || (this.packageid != null && !this.packageid.equals(other.packageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Package[ packageid=" + packageid + " ]";
    }
    
}
