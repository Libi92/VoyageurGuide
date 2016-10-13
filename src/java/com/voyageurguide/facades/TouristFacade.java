/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Guide;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.Places;
import com.voyageurguide.models.Tourist;
import com.voyageurguide.models.User;
import com.voyageurguide.utils.JsfUtil;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.GuideProfileModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import com.voyageurguide.viewmodels.TouristProfileModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author libin
 */
@Stateless
public class TouristFacade extends AbstractFacade<Tourist> {

    @EJB
    private LoginFacade loginFacade;
    @EJB
    private PlacesFacade placesFacade;
    
    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TouristFacade() {
        super(Tourist.class);
    }
    
    public List<Tourist> getUnRegistered(){
        List<Login> logins = em.createNamedQuery("Login.findByStatus").setParameter("status", 0).getResultList();
        List<Tourist> tourists = new ArrayList<>();
        for (Login login : logins) {
            Tourist tourist = (Tourist) em.createNamedQuery("Tourist.findByLoginid").setParameter("loginid", login.getLoginid()).getResultList().get(0);
            tourists.add(tourist);
        }
        return tourists;
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }

    public PlacesFacade getPlacesFacade() {
        return placesFacade;
    }
    
    public TouristProfileModel getMyProfile() {
        final int loginId = SessionUtils.getLoginId();
        List<Login> loginList = em.createNamedQuery("Login.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<Tourist> touristList = em.createNamedQuery("Tourist.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", loginId).getResultList();

        Login login = null;
        Tourist tourist = null;
        User user = null;
        if (loginList.size() > 0) {
            login = loginList.get(0);
        }
        if (touristList.size() > 0) {
            tourist = touristList.get(0);
        }
        if (userList.size() > 0) {
            user = userList.get(0);
        }

        return new TouristProfileModel(login, user, tourist);
    }

    public String changePassword(PasswordChangeModel passwordChangeModel) {
        List<Login> loginList = em.createNamedQuery("Login.findByLoginid").setParameter("loginid", SessionUtils.getLoginId()).getResultList();
        if (loginList.size() > 0) {
            Login login = loginList.get(0);
            if (login.getPassword().equals(passwordChangeModel.getOldPassword())) {
                login.setPassword(passwordChangeModel.getNewPassword());

                getLoginFacade().edit(login);
                JsfUtil.addSuccessMessage("Edit Success");
                return "";
            }
        }
        JsfUtil.addErrorMessage("Edit Failed");
        return "";
    }

    public SelectItem[] getPlaces() {
        Map placesMap;
        List<Places> places = getPlacesFacade().findAll();
        
        placesMap = places.stream().collect(Collectors.toMap(place -> place.getPlaceid(), place -> place.getPlace()));
        
        return JsfUtil.getSelectItems(placesMap, true);
    }
}
