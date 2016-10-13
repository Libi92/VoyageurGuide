/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.controllers;

import com.voyageurguide.facades.FeedbacksFacade;
import com.voyageurguide.facades.HotelsFacade;
import com.voyageurguide.models.Feedbacks;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.HotelProfileModel;
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
@Named(value = "hotelController")
@SessionScoped
public class HotelController implements Serializable {

    private Feedbacks feedbacks;
    private PasswordChangeModel passwordChangeModel;
    
    @EJB
    private HotelsFacade hotelsFacade;
    @EJB
    private FeedbacksFacade feedbacksFacade;
    
    public HotelController() {
    }
    
    public String getUsername(){
        return SessionUtils.getUserName();
    }

    public HotelsFacade getHotelsFacade() {
        return hotelsFacade;
    }
    
    public FeedbacksFacade getFeedbacksFacade() {
        return feedbacksFacade;
    }
    
    public Feedbacks getFeedbacks() {
        if (feedbacks == null) {
            feedbacks = new Feedbacks();
        }
        return feedbacks;
    }

    public PasswordChangeModel getPasswordChangeModel() {
        if (passwordChangeModel == null) {
            passwordChangeModel = new PasswordChangeModel();
        }
        return passwordChangeModel;
    }
    
    public void setFeedbacks(Feedbacks feedbacks) {
        this.feedbacks = feedbacks;
    }
    
    public List<com.voyageurguide.models.Package> getMyPackages(){
        return getHotelsFacade().getMyPackages();
    }
    
    public HotelProfileModel getProfile(){
        return getHotelsFacade().getMyProfile();
    }
    
    public String addFeedback(){
        feedbacks.setLoginid(SessionUtils.getLoginId());
        getFeedbacksFacade().create(feedbacks);
        return "";
    }
    
    public String changePassword(){
        return getHotelsFacade().changePassword(passwordChangeModel);
    }
}
