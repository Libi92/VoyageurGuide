/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.utils;

import com.voyageurguide.models.User;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 10945
 */
public class SessionUtils {

    public static final String USER = "user";

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
    
    public static void saveUser(User user) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        if (user != null) {
            session.setAttribute(USER, user);
            System.out.println("Username Save : " + user.getFirstname());
        }

    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        final User user = (User) session.getAttribute(USER);
        if (user != null) {
            return user.getFirstname();
        }
        else{
            return "null";
        }
        
    }

    public static int getLoginId() {
        HttpSession session = getSession();
        if (session != null) {
            final User user = (User) session.getAttribute(USER);
            return user.getLoginid();
        } else {
            return -1;
        }
    }

    public static void clearSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

        session.setAttribute(USER, null);
    }
}
