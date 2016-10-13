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
@Table(name = "guidebooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guidebooking.findAll", query = "SELECT g FROM Guidebooking g"),
    @NamedQuery(name = "Guidebooking.findById", query = "SELECT g FROM Guidebooking g WHERE g.id = :id"),
    @NamedQuery(name = "Guidebooking.findByGuideid", query = "SELECT g FROM Guidebooking g WHERE g.guideid = :guideid"),
    @NamedQuery(name = "Guidebooking.findByDate", query = "SELECT g FROM Guidebooking g WHERE g.date = :date"),
    @NamedQuery(name = "Guidebooking.findByStatus", query = "SELECT g FROM Guidebooking g WHERE g.status = :status"),
    @NamedQuery(name = "Guidebooking.findByPackage1", query = "SELECT g FROM Guidebooking g WHERE g.package1 = :package1"),
    @NamedQuery(name = "Guidebooking.findByGuideStatus", query = "SELECT g FROM Guidebooking g WHERE g.status = :status and g.guideid = :guideid")})
public class Guidebooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guideid")
    private int guideid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "package")
    private int package1;

    public Guidebooking() {
    }

    public Guidebooking(Integer id) {
        this.id = id;
    }

    public Guidebooking(Integer id, int guideid, String date, int status, int package1) {
        this.id = id;
        this.guideid = guideid;
        this.date = date;
        this.status = status;
        this.package1 = package1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGuideid() {
        return guideid;
    }

    public void setGuideid(int guideid) {
        this.guideid = guideid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPackage1() {
        return package1;
    }

    public void setPackage1(int package1) {
        this.package1 = package1;
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
        if (!(object instanceof Guidebooking)) {
            return false;
        }
        Guidebooking other = (Guidebooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Guidebooking[ id=" + id + " ]";
    }
    
}
