/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Bank;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author libin
 */
@Stateless
public class BankFacade extends AbstractFacade<Bank> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BankFacade() {
        super(Bank.class);
    }
    
    public void save(Bank bank){
        bank.setAmount("10000");
        
        Random random = new Random();
        String pin = "";
        for (int i = 0; i < 4; i++) {
            pin += random.nextInt(9);
        }
        
        bank.setPin(pin);
        
        create(bank);
    }
    
}
