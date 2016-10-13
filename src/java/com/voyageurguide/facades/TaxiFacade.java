/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Cars;
import com.voyageurguide.models.Guide;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.Taxi;
import com.voyageurguide.models.User;
import com.voyageurguide.utils.JsfUtil;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.GuideProfileModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import com.voyageurguide.viewmodels.TaxiProfileModel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 10945
 */
@Stateless
public class TaxiFacade extends AbstractFacade<Taxi> {

    @EJB
    private LoginFacade loginFacade;

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TaxiFacade() {
        super(Taxi.class);
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }

    public TaxiProfileModel getMyProfile() {

        final int loginId = SessionUtils.getLoginId();
        List<Login> loginList = em.createNamedQuery("Login.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<Taxi> taxiList = em.createNamedQuery("Taxi.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<Cars> cars = null;

        Login login = null;
        Taxi taxi = null;
        User user = null;
        if (loginList.size() > 0) {
            login = loginList.get(0);
        }
        if (taxiList.size() > 0) {
            taxi = taxiList.get(0);
            cars = em.createNamedQuery("Cars.findByTaxiid").setParameter("taxiid", taxi.getTaxiid()).getResultList();
        }
        if (userList.size() > 0) {
            user = userList.get(0);
        }

        return new TaxiProfileModel(login, user, taxi, cars);
    }

    public List<com.voyageurguide.models.Package> getMyPackages() {
        List<com.voyageurguide.models.Package> packagesList = new ArrayList<>();
        int taxi = SessionUtils.getLoginId();
        List<Integer> distinctPackages = em.createNamedQuery("Itinerary.findUniquePackageByTaxi").setParameter("taxi", taxi).getResultList();
        for (Integer package1 : distinctPackages) {
            List<com.voyageurguide.models.Package> packages = em.createNamedQuery("Package.findByPackageid").setParameter("packageid", package1).getResultList();
            if (packages.size() > 0) {
                packagesList.add(packages.get(0));
            }
        }
        return packagesList;
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

    public List<TaxiProfileModel> getAllTaxi() {
        List<TaxiProfileModel> models = new ArrayList<>();
        List<Taxi> taxis = findAll();

        for (Taxi taxi : taxis) {

            List<Login> loginList = em.createNamedQuery("Login.findByLoginid").setParameter("loginid", taxi.getLoginid()).getResultList();
            List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", taxi.getLoginid()).getResultList();
            List<Cars> cars = em.createNamedQuery("Cars.findByTaxiid").setParameter("taxiid", taxi.getLoginid()).getResultList();

            Login login = null;
            User user = null;
            if (loginList.size() > 0) {
                login = loginList.get(0);
            }
            if (userList.size() > 0) {
                user = userList.get(0);
            }
            
            models.add(new TaxiProfileModel(login, user, taxi, cars));
        }

        return models;
    }

}
