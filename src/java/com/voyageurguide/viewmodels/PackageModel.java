/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.Guide;
import com.voyageurguide.models.Hotels;
import com.voyageurguide.models.Package;
import com.voyageurguide.models.Places;
import com.voyageurguide.models.Taxi;
import com.voyageurguide.models.User;
import java.util.List;

/**
 *
 * @author libin
 */
public class PackageModel {
    private com.voyageurguide.models.Package model_package;
    private List<Places> places;
    private List<User> guides;
    private List<User> taxis;
    private List<User> hotels;
    
    public PackageModel(com.voyageurguide.models.Package model_package, List<Places> places, List<User> guides, List<User> taxis, List<User> hotels){
        this.model_package = model_package;
        this.places = places;
        this.guides = guides;
        this.taxis = taxis;
        this.hotels = hotels;
    }

    public Package getModel_package() {
        return model_package;
    }

    public List<Places> getPlaces() {
        return places;
    }

    public List<User> getGuides() {
        return guides;
    }

    public List<User> getTaxis() {
        return taxis;
    }

    public List<User> getHotels() {
        return hotels;
    }
    
    
}
