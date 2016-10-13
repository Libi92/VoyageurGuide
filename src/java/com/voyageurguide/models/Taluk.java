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
@Table(name = "taluk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taluk.findAll", query = "SELECT t FROM Taluk t"),
    @NamedQuery(name = "Taluk.findByTalukid", query = "SELECT t FROM Taluk t WHERE t.talukid = :talukid"),
    @NamedQuery(name = "Taluk.findByDistrictid", query = "SELECT t FROM Taluk t WHERE t.districtid = :districtid"),
    @NamedQuery(name = "Taluk.findByTaluk", query = "SELECT t FROM Taluk t WHERE t.taluk = :taluk")})
public class Taluk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "talukid")
    private Integer talukid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "districtid")
    private int districtid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "taluk")
    private String taluk;

    public Taluk() {
    }

    public Taluk(Integer talukid) {
        this.talukid = talukid;
    }

    public Taluk(Integer talukid, int districtid, String taluk) {
        this.talukid = talukid;
        this.districtid = districtid;
        this.taluk = taluk;
    }

    public Integer getTalukid() {
        return talukid;
    }

    public void setTalukid(Integer talukid) {
        this.talukid = talukid;
    }

    public int getDistrictid() {
        return districtid;
    }

    public void setDistrictid(int districtid) {
        this.districtid = districtid;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talukid != null ? talukid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taluk)) {
            return false;
        }
        Taluk other = (Taluk) object;
        if ((this.talukid == null && other.talukid != null) || (this.talukid != null && !this.talukid.equals(other.talukid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Taluk[ talukid=" + talukid + " ]";
    }
    
}
