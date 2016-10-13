/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author libin
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    public List<User> getUnRegistered(String type) {
        List<Login> logins = em.createNamedQuery("Login.findByTypeStatus").setParameter("status", 0).setParameter("type", type).getResultList();
        List<User> users = new ArrayList<>();
        for (Login login : logins) {
            final List<User> resultList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", login.getLoginid()).getResultList();
            if (resultList.size() > 0) {
                User user = resultList.get(0);
                users.add(user);
            }

        }
        return users;
    }

    public Login userAction(int loginId, int action) {
        Login login = (Login) em.createNamedQuery("Login.findByLoginid").setParameter("loginid", loginId).getResultList().get(0);
        login.setStatus(action);
        
        return login;
    }
}
