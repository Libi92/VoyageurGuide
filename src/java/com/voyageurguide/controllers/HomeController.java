/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.controllers;

import com.voyageurguide.facades.DistrictFacade;
import com.voyageurguide.facades.GuideFacade;
import com.voyageurguide.facades.HotelsFacade;
import com.voyageurguide.facades.PackageFacade;
import com.voyageurguide.facades.PlacesFacade;
import com.voyageurguide.facades.TaxiFacade;
import com.voyageurguide.facades.UsergalleryFacade;
import com.voyageurguide.models.District;
import com.voyageurguide.utils.CurrencyConvertor;
import com.voyageurguide.utils.JsfUtil;
import com.voyageurguide.viewmodels.GalleryModel;
import com.voyageurguide.viewmodels.GuideProfileModel;
import com.voyageurguide.viewmodels.HotelProfileModel;
import com.voyageurguide.viewmodels.PackageModel;
import com.voyageurguide.viewmodels.PlacesModel;
import com.voyageurguide.viewmodels.TaxiProfileModel;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

/**
 *
 * @author libin
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable {

    private String fromCurrency;
    private String toCurrency;
    private String fromValue;
    private String toValue;
    
    @EJB
    private UsergalleryFacade usergalleryFacade;
    @EJB
    private HotelsFacade hotelsFacade;
    @EJB
    private DistrictFacade districtFacade;
    @EJB
    private GuideFacade guideFacade;
    @EJB
    private TaxiFacade taxiFacade;
    @EJB
    private PlacesFacade placesFacade;
    @EJB
    private PackageFacade packageFacade;
    
    /**
     * Creates a new instance of HomeController
     */
    public HomeController() {
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }
    
    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getFromValue() {
        return fromValue;
    }

    public void setFromValue(String fromValue) {
        this.fromValue = fromValue;
    }

    public String getToValue() {
        return toValue;
    }

    public void setToValue(String toValue) {
        this.toValue = toValue;
    }
    
    public UsergalleryFacade getUsergalleryFacade() {
        return usergalleryFacade;
    }

    public HotelsFacade getHotelsFacade() {
        return hotelsFacade;
    }

    public DistrictFacade getDistrictFacade() {
        return districtFacade;
    }

    public GuideFacade getGuideFacade() {
        return guideFacade;
    }

    public TaxiFacade getTaxiFacade() {
        return taxiFacade;
    }

    public PlacesFacade getPlacesFacade() {
        return placesFacade;
    }

    public PackageFacade getPackageFacade() {
        return packageFacade;
    }
    
    public List<GalleryModel> getGallery(){
        return getUsergalleryFacade().getGallery();
    }
    
    public List<HotelProfileModel> getAllHotels(){
        return getHotelsFacade().getAllHotels();
    }
    
    public List<District> getAllDistricts(){
        return getDistrictFacade().findAll();
    }
    
    public List<GuideProfileModel> getAllGuides(){
        return getGuideFacade().getAllGuides();
    }
    
    public List<TaxiProfileModel> getAllTaxi(){
        return getTaxiFacade().getAllTaxi();
    }
    
    public List<PlacesModel> getPlaces(){        
        return getPlacesFacade().getPlaces();
    }
    
    public SelectItem[] getCurrencyItems(){
        return JsfUtil.getSelectItems(CurrencyConvertor.getCurrencies(), true);
    }
    
    public String getConvertedValue(){
        if (fromCurrency == null && toCurrency == null) {
            return "0";
        }
        return CurrencyConvertor.convert(fromCurrency, toCurrency, Double.parseDouble(fromValue)) + "";
    }
    
    public List<PackageModel> getPackages(){
        return getPackageFacade().getPackages();
    }
}
