/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.voyageurguide.controllers;

import com.voyageurguide.facades.FeedbacksFacade;
import com.voyageurguide.facades.TaxiFacade;
import com.voyageurguide.models.Feedbacks;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.GuideProfileModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import com.voyageurguide.viewmodels.TaxiProfileModel;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author 10945
 */
@Named(value = "taxiController")
@SessionScoped
public class TaxiController implements Serializable{

    private Feedbacks feedbacks;
    private PasswordChangeModel passwordChangeModel;
    
    @EJB
    private TaxiFacade taxiFacade;
    @EJB
    private FeedbacksFacade feedbacksFacade;
    
    /**
     * Creates a new instance of TaxiController
     */
    public TaxiController() {
    }
    
    
    public Feedbacks getFeedbacks() {
        if (feedbacks == null) {
            feedbacks = new Feedbacks();
        }
        return feedbacks;
    }

    public FeedbacksFacade getFeedbacksFacade() {
        return feedbacksFacade;
    }
    
    public String getUsername(){
        return SessionUtils.getUserName();
    }

    public TaxiFacade getTaxiFacade() {
        return taxiFacade;
    }
            
    public TaxiProfileModel getProfile(){
        return getTaxiFacade().getMyProfile();
    }
    
    public PasswordChangeModel getPasswordChangeModel() {
        if (passwordChangeModel == null) {
            passwordChangeModel = new PasswordChangeModel();
        }
        return passwordChangeModel;
    }

    public void setPasswordChangeModel(PasswordChangeModel passwordChangeModel) {
        this.passwordChangeModel = passwordChangeModel;
    }
    
    public void setFeedbacks(Feedbacks feedbacks) {
        this.feedbacks = feedbacks;
    }
    
    public String addFeedback(){
        feedbacks.setLoginid(SessionUtils.getLoginId());
        getFeedbacksFacade().create(feedbacks);
        return "";
    }
    
    public String changePassword(){
        return getTaxiFacade().changePassword(passwordChangeModel);
    }
}
