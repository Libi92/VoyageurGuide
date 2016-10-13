/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.Guide;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.User;

/**
 *
 * @author 10945
 */
public class GuideProfileModel {
    private Login login;
    private User user;
    private Guide guide;

    public GuideProfileModel(Login login, User user, Guide guide){
        this.login = login;
        this.user = user;
        this.guide = guide;
    }

    public Login getLogin() {
        return login;
    }
    
    public User getUser() {
        return user;
    }

    public Guide getGuide() {
        return guide;
    }
}
