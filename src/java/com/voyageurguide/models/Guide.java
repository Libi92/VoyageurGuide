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
@Table(name = "guide")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guide.findAll", query = "SELECT g FROM Guide g"),
    @NamedQuery(name = "Guide.findByGuideid", query = "SELECT g FROM Guide g WHERE g.guideid = :guideid"),
    @NamedQuery(name = "Guide.findByLoginid", query = "SELECT g FROM Guide g WHERE g.loginid = :loginid"),
    @NamedQuery(name = "Guide.findByAge", query = "SELECT g FROM Guide g WHERE g.age = :age"),
    @NamedQuery(name = "Guide.findByDob", query = "SELECT g FROM Guide g WHERE g.dob = :dob"),
    @NamedQuery(name = "Guide.findByGender", query = "SELECT g FROM Guide g WHERE g.gender = :gender"),
    @NamedQuery(name = "Guide.findByNationality", query = "SELECT g FROM Guide g WHERE g.nationality = :nationality"),
    @NamedQuery(name = "Guide.findByWage", query = "SELECT g FROM Guide g WHERE g.wage = :wage"),
    @NamedQuery(name = "Guide.findByPlace", query = "SELECT g FROM Guide g WHERE g.place = :place"),
    @NamedQuery(name = "Guide.findByAccountno", query = "SELECT g FROM Guide g WHERE g.accountno = :accountno"),
    @NamedQuery(name = "Guide.findByBank", query = "SELECT g FROM Guide g WHERE g.bank = :bank"),
    @NamedQuery(name = "Guide.findByBranch", query = "SELECT g FROM Guide g WHERE g.branch = :branch"),
    @NamedQuery(name = "Guide.findByEducation", query = "SELECT g FROM Guide g WHERE g.education = :education"),
    @NamedQuery(name = "Guide.findByLanguages", query = "SELECT g FROM Guide g WHERE g.languages = :languages"),
    @NamedQuery(name = "Guide.findByDistrict", query = "SELECT g FROM Guide g WHERE g.district = :district"),
    @NamedQuery(name = "Guide.findByTaluk", query = "SELECT g FROM Guide g WHERE g.taluk = :taluk"),
    @NamedQuery(name = "Guide.findByPhoto", query = "SELECT g FROM Guide g WHERE g.photo = :photo")})
public class Guide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "guideid")
    private Integer guideid;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "wage")
    private String wage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "accountno")
    private String accountno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "bank")
    private String bank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "branch")
    private String branch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "education")
    private String education;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "languages")
    private String languages;
    @Basic(optional = false)
    @NotNull
    @Column(name = "district")
    private int district;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taluk")
    private int taluk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "photo")
    private String photo;

    public Guide() {
    }

    public Guide(Integer guideid) {
        this.guideid = guideid;
    }

    public Guide(Integer guideid, int loginid, String age, String dob, String gender, String nationality, String wage, String place, String accountno, String bank, String branch, String education, String languages, int district, int taluk, String photo) {
        this.guideid = guideid;
        this.loginid = loginid;
        this.age = age;
        this.dob = dob;
        this.gender = gender;
        this.nationality = nationality;
        this.wage = wage;
        this.place = place;
        this.accountno = accountno;
        this.bank = bank;
        this.branch = branch;
        this.education = education;
        this.languages = languages;
        this.district = district;
        this.taluk = taluk;
        this.photo = photo;
    }

    public Integer getGuideid() {
        return guideid;
    }

    public void setGuideid(Integer guideid) {
        this.guideid = guideid;
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

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getTaluk() {
        return taluk;
    }

    public void setTaluk(int taluk) {
        this.taluk = taluk;
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
        hash += (guideid != null ? guideid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guide)) {
            return false;
        }
        Guide other = (Guide) object;
        if ((this.guideid == null && other.guideid != null) || (this.guideid != null && !this.guideid.equals(other.guideid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Guide[ guideid=" + guideid + " ]";
    }
    
}
