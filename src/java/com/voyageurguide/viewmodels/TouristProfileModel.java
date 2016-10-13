/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.Login;
import com.voyageurguide.models.Tourist;
import com.voyageurguide.models.User;

/**
 *
 * @author libin
 */
public class TouristProfileModel {
    private Login login;
    private User user;
    private Tourist tourist;
    
    public TouristProfileModel(Login login, User user, Tourist tourist){
        this.login = login;
        this.user = user;
        this.tourist = tourist;
    }

    public Login getLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }

    public Tourist getTourist() {
        return tourist;
    }
    
    
}
