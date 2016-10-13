/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.Usergallery;

/**
 *
 * @author libin
 */
public class GalleryModel {
    private Usergallery gallery;
    private String user;
    private String place;
    
    public GalleryModel(Usergallery gallery, String user, String place){
        this.gallery = gallery;
        this.user = user;
        this.place = place;
    }

    public Usergallery getGallery() {
        return gallery;
    }

    public String getUser() {
        return user;
    }

    public String getPlace() {
        return place;
    }
    
    
}
