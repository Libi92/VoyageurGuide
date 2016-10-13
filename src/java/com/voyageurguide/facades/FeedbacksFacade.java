/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Feedbacks;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.User;
import com.voyageurguide.viewmodels.FeedbacksModel;
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
public class FeedbacksFacade extends AbstractFacade<Feedbacks> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FeedbacksFacade() {
        super(Feedbacks.class);
    }
    
    public List<FeedbacksModel> getFeedbacks(){
        List<FeedbacksModel> feedbacksModels = new ArrayList<>();
        List<Feedbacks> feedbackses = findAll();
        for (Feedbacks feedbackse : feedbackses) {
            Login login = (Login) em.createNamedQuery("Login.findByLoginid").setParameter("loginid", feedbackse.getLoginid()).getSingleResult();
            User user = (User) em.createNamedQuery("User.findByLoginid").setParameter("loginid", feedbackse.getLoginid()).getSingleResult();
            
            FeedbacksModel model = new FeedbacksModel(feedbackse, login.getType(), user.getFirstname());
            feedbacksModels.add(model);
        }
        
        return feedbacksModels;
    }
    
}
