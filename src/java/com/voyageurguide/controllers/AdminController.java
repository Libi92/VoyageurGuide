/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.controllers;

import com.voyageurguide.facades.AnnouncementsFacade;
import com.voyageurguide.facades.DistrictFacade;
import com.voyageurguide.facades.FeedbacksFacade;
import com.voyageurguide.facades.GallaryFacade;
import com.voyageurguide.facades.LoginFacade;
import com.voyageurguide.facades.PackageFacade;
import com.voyageurguide.facades.PlacesFacade;
import com.voyageurguide.facades.TalukFacade;
import com.voyageurguide.facades.TouristFacade;
import com.voyageurguide.facades.UserFacade;
import com.voyageurguide.facades.UsergalleryFacade;
import com.voyageurguide.models.Announcements;
import com.voyageurguide.models.Gallary;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.Places;
import com.voyageurguide.models.User;
import com.voyageurguide.utils.Constants;
import com.voyageurguide.viewmodels.FeedbacksModel;
import com.voyageurguide.viewmodels.GalleryModel;
import com.voyageurguide.viewmodels.PackageModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import com.voyageurguide.viewmodels.PlacesModel;
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
@Named(value = "adminController")
@SessionScoped
public class AdminController implements Serializable {

    private List<Places> allPlaces;
    private String[] selectedPlaces;
    
    private SelectItem[] districts;
    private SelectItem[] taluks;
    private Announcements announcements;
    private Places place;
    private Part file;
    private PasswordChangeModel passwordChangeModel;
    
    @EJB
    private TouristFacade touristFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private LoginFacade loginFacade;
    @EJB
    private PlacesFacade placesFacade;
    @EJB
    private PackageFacade packageFacade; 
    @EJB
    private AnnouncementsFacade announcementsFacade;
    @EJB
    private FeedbacksFacade feedbacksFacade;
    @EJB
    private DistrictFacade districtFacade;
    @EJB
    private TalukFacade talukFacade;
    @EJB
    private GallaryFacade gallaryFacade;
    @EJB
    private UsergalleryFacade usergalleryFacade;
    
    /**
     * Creates a new instance of AdminController
     */
    public AdminController() {
    }

    public SelectItem[] getDistricts() {
        if (districts == null) {
            districts = getDistrictFacade().getDistricts();
        }
        return districts;
    }

    public void setDistricts(SelectItem[] districts) {
        this.districts = districts;
    }

    public SelectItem[] getTaluks() {
        return taluks;
    }

    public void setTaluk() {
        taluks = getTalukFacade().getTaluks(place.getDistrict());
    }

    public Announcements getAnnouncements(){
        if (announcements == null) {
            announcements = new Announcements();
        }
        return announcements;
    }
    
    public void setAnnouncements(Announcements announcements){
        this.announcements = announcements;
    }

    public Places getPlace() {
        if (place == null) {
            place = new Places();
        }
        return place;
    }

    public void setPlace(Places place) {
        this.place = place;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public TouristFacade getTouristFacade() {
        return touristFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }

    public PlacesFacade getPlacesFacade() {
        return placesFacade;
    }

    public PackageFacade getPackageFacade() {
        return packageFacade;
    }

    public AnnouncementsFacade getAnnouncementsFacade() {
        return announcementsFacade;
    }

    public DistrictFacade getDistrictFacade() {
        return districtFacade;
    }

    public TalukFacade getTalukFacade() {
        return talukFacade;
    }
    
    public FeedbacksFacade getFeedbacksFacade() {
        return feedbacksFacade;
    }

    public GallaryFacade getGallaryFacade() {
        return gallaryFacade;
    }

    public UsergalleryFacade getUsergalleryFacade() {
        return usergalleryFacade;
    }
    
    public List<User> getUnregisteredTourist(){
        return getUserFacade().getUnRegistered("Tourist");
    }
    
    public List<User> getUnregisteredGuide(){
        return getUserFacade().getUnRegistered("Guide");
    }
    
    public List<User> getUnregisteredHotel(){
        return getUserFacade().getUnRegistered("Hotel");
    }
    
    public List<User> getUnregisteredTaxi(){
        return getUserFacade().getUnRegistered("Taxi");
    }
    
    public String userAction(int loginId, int action){
        Login login = getUserFacade().userAction(loginId, action);
        getLoginFacade().edit(login);
        return "";
    }
    
    public List<PlacesModel> getPlaces(){        
        return getPlacesFacade().getPlaces();
    }
    
    public List<Places> getAllPlaces(){
        if (allPlaces == null) {
            allPlaces = getPlacesFacade().getAll();
        }
        return allPlaces;
    }

    public String[] getSelectedPlaces() {
        return selectedPlaces;
    }
    
    public List<PackageModel> getAllPackages(){
        return getPackageFacade().getPackages();
    }
    
    public List<Announcements> getAllAnnouncements(){
        return getAnnouncementsFacade().findAll();
    }
    
    public List<FeedbacksModel> getFeedbacks(){
        return getFeedbacksFacade().getFeedbacks();
    }
    
    public String sendAnnouncements(){
        getAnnouncementsFacade().create(announcements);
        
        return "";
    }
    
    public List<GalleryModel> getNonApprovedGallery(){
        return getUsergalleryFacade().getNonApprovedGallery();
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
    
    public String changePassword(){
        return getLoginFacade().changePassword(passwordChangeModel);
    }
    
    public String addPlace(){
        final String fileName = getFileName();
        getPlacesFacade().create(place);
        
        saveFile(fileName);
        
        Gallary gallary = new Gallary();
        gallary.setPlaceid(place.getPlaceid());
        gallary.setImage(fileName);
        
        getGallaryFacade().create(gallary);
        return "";
    }
    
    public String galleryAction(int galleryId, int action){
        getUsergalleryFacade().galleryAction(galleryId, action);
        return "";
    }
    
    public String getFileName(){
        return place.getPlace() + "_" + Calendar.getInstance().getTime().getTime() + ".jpg";
    }
    
    public void saveFile(String filename){
        try (InputStream input = file.getInputStream()) {
        Files.copy(input, new File(Constants.UPLOADS_DIR + File.separator + Constants.PLACES_DIR, filename).toPath());
        } catch (IOException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
