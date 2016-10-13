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
@Table(name = "gallary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gallary.findAll", query = "SELECT g FROM Gallary g"),
    @NamedQuery(name = "Gallary.findByGallaryid", query = "SELECT g FROM Gallary g WHERE g.gallaryid = :gallaryid"),
    @NamedQuery(name = "Gallary.findByPlaceid", query = "SELECT g FROM Gallary g WHERE g.placeid = :placeid"),
    @NamedQuery(name = "Gallary.findByImage", query = "SELECT g FROM Gallary g WHERE g.image = :image")})
public class Gallary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gallaryid")
    private Integer gallaryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "placeid")
    private int placeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "image")
    private String image;

    public Gallary() {
    }

    public Gallary(Integer gallaryid) {
        this.gallaryid = gallaryid;
    }

    public Gallary(Integer gallaryid, int placeid, String image) {
        this.gallaryid = gallaryid;
        this.placeid = placeid;
        this.image = image;
    }

    public Integer getGallaryid() {
        return gallaryid;
    }

    public void setGallaryid(Integer gallaryid) {
        this.gallaryid = gallaryid;
    }

    public int getPlaceid() {
        return placeid;
    }

    public void setPlaceid(int placeid) {
        this.placeid = placeid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gallaryid != null ? gallaryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gallary)) {
            return false;
        }
        Gallary other = (Gallary) object;
        if ((this.gallaryid == null && other.gallaryid != null) || (this.gallaryid != null && !this.gallaryid.equals(other.gallaryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Gallary[ gallaryid=" + gallaryid + " ]";
    }
    
}
