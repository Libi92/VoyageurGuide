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
@Table(name = "announcements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Announcements.findAll", query = "SELECT a FROM Announcements a"),
    @NamedQuery(name = "Announcements.findByAnnouncementid", query = "SELECT a FROM Announcements a WHERE a.announcementid = :announcementid"),
    @NamedQuery(name = "Announcements.findByTitle", query = "SELECT a FROM Announcements a WHERE a.title = :title"),
    @NamedQuery(name = "Announcements.findByDetails", query = "SELECT a FROM Announcements a WHERE a.details = :details")})
public class Announcements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "announcementid")
    private Integer announcementid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "details")
    private String details;

    public Announcements() {
    }

    public Announcements(Integer announcementid) {
        this.announcementid = announcementid;
    }

    public Announcements(Integer announcementid, String title, String details) {
        this.announcementid = announcementid;
        this.title = title;
        this.details = details;
    }

    public Integer getAnnouncementid() {
        return announcementid;
    }

    public void setAnnouncementid(Integer announcementid) {
        this.announcementid = announcementid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (announcementid != null ? announcementid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Announcements)) {
            return false;
        }
        Announcements other = (Announcements) object;
        if ((this.announcementid == null && other.announcementid != null) || (this.announcementid != null && !this.announcementid.equals(other.announcementid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Announcements[ announcementid=" + announcementid + " ]";
    }
    
}
