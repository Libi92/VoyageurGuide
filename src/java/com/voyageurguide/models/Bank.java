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
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findById", query = "SELECT b FROM Bank b WHERE b.id = :id"),
    @NamedQuery(name = "Bank.findByLoginid", query = "SELECT b FROM Bank b WHERE b.loginid = :loginid"),
    @NamedQuery(name = "Bank.findByBank", query = "SELECT b FROM Bank b WHERE b.bank = :bank"),
    @NamedQuery(name = "Bank.findByCardtype", query = "SELECT b FROM Bank b WHERE b.cardtype = :cardtype"),
    @NamedQuery(name = "Bank.findByAccountno", query = "SELECT b FROM Bank b WHERE b.accountno = :accountno"),
    @NamedQuery(name = "Bank.findByBranch", query = "SELECT b FROM Bank b WHERE b.branch = :branch"),
    @NamedQuery(name = "Bank.findByAmount", query = "SELECT b FROM Bank b WHERE b.amount = :amount"),
    @NamedQuery(name = "Bank.findByPin", query = "SELECT b FROM Bank b WHERE b.pin = :pin")})
public class Bank implements Serializable {

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
    @Column(name = "bank")
    private String bank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "cardtype")
    private String cardtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "accountno")
    private String accountno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "branch")
    private String branch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "amount")
    private String amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "pin")
    private String pin;

    public Bank() {
    }

    public Bank(Integer id) {
        this.id = id;
    }

    public Bank(Integer id, int loginid, String bank, String cardtype, String accountno, String branch, String amount, String pin) {
        this.id = id;
        this.loginid = loginid;
        this.bank = bank;
        this.cardtype = cardtype;
        this.accountno = accountno;
        this.branch = branch;
        this.amount = amount;
        this.pin = pin;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.voyageurguide.models.Bank[ id=" + id + " ]";
    }
    
}
