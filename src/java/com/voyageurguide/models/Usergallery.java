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
@Table(name = "usergallery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usergallery.findAll", query = "SELECT u FROM Usergallery u"),
    @NamedQuery(name = "Usergallery.findByGalleryid", query = "SELECT u FROM Usergallery u WHERE u.galleryid = :galleryid"),
    @NamedQuery(name = "Usergallery.findByUserid", query = "SELECT u FROM Usergallery u WHERE u.userid = :userid"),
    @NamedQuery(name = "Usergallery.findByPlace", query = "SELECT u FROM Usergallery u WHERE u.place = :place"),
    @NamedQuery(name = "Usergallery.findByTitle", query = "SELECT u FROM Usergallery u WHERE u.title = :title"),
    @NamedQuery(name = "Usergallery.findByDescription", query = "SELECT u FROM Usergallery u WHERE u.description = :description"),
    @NamedQuery(name = "Usergallery.findByImage", query = "SELECT u FROM Usergallery u WHERE u.image = :image"),
    @NamedQuery(name = "Usergallery.findByStatus", query = "SELECT u FROM Usergallery u WHERE u.status = :status")})
public class Usergallery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "galleryid")
    private Integer galleryid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "place")
    private int place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    public Usergallery() {
    }

    public Usergallery(Integer galleryid) {
        this.galleryid = galleryid;
    }

    public Usergallery(Integer galleryid, int userid, int place, String title, String description, String image, int status) {
        this.galleryid = galleryid;
        this.userid = userid;
        this.place = place;
        this.title = title;
        this.description = description;
        this.image = image;
        this.status = status;
    }

    public Integer getGalleryid() {
        return galleryid;
    }

    public void setGalleryid(Integer galleryid) {
        this.galleryid = galleryid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        hash += (galleryid != null ? galleryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usergallery)) {
            return false;
        }
        Usergallery other = (Usergallery) object;
        if ((this.galleryid == null && other.galleryid != null) || (this.galleryid != null && !this.galleryid.equals(other.galleryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Usergallery[ galleryid=" + galleryid + " ]";
    }
    
}
