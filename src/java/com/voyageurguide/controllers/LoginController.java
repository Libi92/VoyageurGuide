/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.controllers;

import com.voyageurguide.facades.LoginFacade;
import com.voyageurguide.models.Login;
import com.voyageurguide.utils.Constants;
import com.voyageurguide.utils.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author libin
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable{

    private Login login;
    @EJB
    private LoginFacade loginFacade;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public Login getLogin() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }
    
    public String doLogin(){
        String result = getLoginFacade().doLogin(login);
        if (result.equals(Constants.EMPTY_RESULT)) {
            JsfUtil.addErrorMessage("Login Failed");
                        
            recreateModels();
            return "index";
        }
        else{
            final String name = String.format("/%s/index" + Constants.REDIRECT, result);
            JsfUtil.addSuccessMessage("Login Success");
            
            recreateModels();
            return name;
        }
        
    }
    
    public String doLogout(){
        
        return getLoginFacade().doLogout();
    }
    
    private void recreateModels(){
        login = new Login();
    }
    
}
