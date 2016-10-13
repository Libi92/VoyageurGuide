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
@Table(name = "tourist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tourist.findAll", query = "SELECT t FROM Tourist t"),
    @NamedQuery(name = "Tourist.findByTouristid", query = "SELECT t FROM Tourist t WHERE t.touristid = :touristid"),
    @NamedQuery(name = "Tourist.findByLoginid", query = "SELECT t FROM Tourist t WHERE t.loginid = :loginid"),
    @NamedQuery(name = "Tourist.findByAge", query = "SELECT t FROM Tourist t WHERE t.age = :age"),
    @NamedQuery(name = "Tourist.findByDob", query = "SELECT t FROM Tourist t WHERE t.dob = :dob"),
    @NamedQuery(name = "Tourist.findByGender", query = "SELECT t FROM Tourist t WHERE t.gender = :gender"),
    @NamedQuery(name = "Tourist.findByNationality", query = "SELECT t FROM Tourist t WHERE t.nationality = :nationality")})
public class Tourist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "touristid")
    private Integer touristid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loginid")
    private int loginid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "age")
    private String age;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "dob")
    private String dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nationality")
    private String nationality;

    public Tourist() {
    }

    public Tourist(Integer touristid) {
        this.touristid = touristid;
    }

    public Tourist(Integer touristid, int loginid, String age, String dob, String gender, String nationality) {
        this.touristid = touristid;
        this.loginid = loginid;
        this.age = age;
        this.dob = dob;
        this.gender = gender;
        this.nationality = nationality;
    }

    public Integer getTouristid() {
        return touristid;
    }

    public void setTouristid(Integer touristid) {
        this.touristid = touristid;
    }

    public int getLoginid() {
        return loginid;
    }

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (touristid != null ? touristid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tourist)) {
            return false;
        }
        Tourist other = (Tourist) object;
        if ((this.touristid == null && other.touristid != null) || (this.touristid != null && !this.touristid.equals(other.touristid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Tourist[ touristid=" + touristid + " ]";
    }
    
}
