/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.controllers;

import com.voyageurguide.facades.FeedbacksFacade;
import com.voyageurguide.facades.TouristFacade;
import com.voyageurguide.facades.UsergalleryFacade;
import com.voyageurguide.models.Feedbacks;
import com.voyageurguide.models.Usergallery;
import com.voyageurguide.utils.Constants;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.GalleryModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import com.voyageurguide.viewmodels.TouristProfileModel;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;

/**
 *
 * @author libin
 */
@Named(value = "touristController")
@SessionScoped
public class TouristController implements Serializable {

    private Feedbacks feedbacks;
    private PasswordChangeModel passwordChangeModel;
    private Part file;
    
    private Usergallery gallery;
    
    @EJB
    private TouristFacade touristFacade;
    @EJB
    private FeedbacksFacade feedbacksFacade;
    @EJB
    private UsergalleryFacade usergalleryFacade;
    
    /**
     * Creates a new instance of TouristController
     */
    public TouristController() {
    }

    
    public TouristFacade getTouristFacade() {
        return touristFacade;
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

    public UsergalleryFacade getUsergalleryFacade() {
        return usergalleryFacade;
    }
    
    public TouristProfileModel getProfile(){
        return getTouristFacade().getMyProfile();
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
        return getTouristFacade().changePassword(passwordChangeModel);
    }
    
    public SelectItem[] getPlaces(){
        return getTouristFacade().getPlaces();
    }

    public Usergallery getGallery() {
        if (gallery == null) {
            gallery = new Usergallery();
        }
        return gallery;
    }

    public void setGallery(Usergallery gallery) {
        this.gallery = gallery;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public String saveGallery(){
        
        try (InputStream input = file.getInputStream()) {
        Files.copy(input, new File(Constants.UPLOADS_DIR + File.separator + Constants.USER_PHOTO_DIR, getFileName()).toPath());
        } catch (IOException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gallery.setStatus(0);
        gallery.setUserid(SessionUtils.getLoginId());
        getUsergalleryFacade().create(gallery);
        
        return "";
    }
    
    public List<GalleryModel> getUserGallery(){
        return getUsergalleryFacade().getGallery();
    }
    
    public String getUserName(){
        return SessionUtils.getUserName();
    }
    
    private String getFileName() {
        return Calendar.getInstance().getTimeInMillis() + "_" + SessionUtils.getLoginId() + ".jpg";
    }
    
    
}
