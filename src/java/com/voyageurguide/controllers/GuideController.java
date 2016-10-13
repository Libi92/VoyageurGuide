/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.controllers;

import com.voyageurguide.facades.FeedbacksFacade;
import com.voyageurguide.facades.GuideFacade;
import com.voyageurguide.models.Feedbacks;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.GuidePackageModel;
import com.voyageurguide.viewmodels.GuideProfileModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author 10945
 */
@Named(value = "guideController")
@SessionScoped
public class GuideController implements Serializable {

    private Feedbacks feedbacks;
    private PasswordChangeModel passwordChangeModel;
    
    @EJB
    private GuideFacade guideFacade;
    @EJB
    private FeedbacksFacade feedbacksFacade;
    
    public GuideController() {
    }

    public GuideFacade getGuideFacade() {
        return guideFacade;
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
    
    public List<com.voyageurguide.models.Package> getMyPackages(){
        return getGuideFacade().getMyPackages();
    }
    
    public GuideProfileModel getMyProfile(){
        return getGuideFacade().getMyProfile();
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
        return getGuideFacade().changePassword(passwordChangeModel);
    }
    
    public List<GuidePackageModel> getMyBookings(){
        return getGuideFacade().getMyBookings();
    }
}
