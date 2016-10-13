/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.District;
import com.voyageurguide.models.Gallary;
import com.voyageurguide.models.Places;

/**
 *
 * @author 10945
 */
public class PlacesModel {
    private Gallary image;
    private Places place;
    private District district;

    public PlacesModel(Places places, District district, Gallary image){
        this.place = places;
        this.district = district;
        this.image = image;
    }
    public Places getPlace() {
        return place;
    }

    public District getDistrict() {
        return district;
    }

    public Gallary getImage() {
        return image;
    }
    
}
