/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Hotels;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.Package;
import com.voyageurguide.models.Rooms;
import com.voyageurguide.models.User;
import com.voyageurguide.utils.Constants;
import com.voyageurguide.utils.JsfUtil;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.HotelProfileModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
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
public class HotelsFacade extends AbstractFacade<Hotels> {

    @EJB
    private LoginFacade loginFacade;

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HotelsFacade() {
        super(Hotels.class);
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }

    public HotelProfileModel getMyProfile() {
        final int loginId = SessionUtils.getLoginId();
        List<Login> loginList = em.createNamedQuery("Login.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<Hotels> hotelsList = em.createNamedQuery("Hotels.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", loginId).getResultList();

        Login login = null;
        Hotels hotel = null;
        User user = null;
        List<Rooms> roomsList = null;
        if (loginList.size() > 0) {
            login = loginList.get(0);
        }
        if (hotelsList.size() > 0) {
            hotel = hotelsList.get(0);

            roomsList = em.createNamedQuery("Rooms.findByHotelid").setParameter("hotelid", hotel.getHotelid()).getResultList();
        }
        if (userList.size() > 0) {
            user = userList.get(0);
        }

        return new HotelProfileModel(login, user, hotel, roomsList);
    }

    public List<Package> getMyPackages() {
        List<com.voyageurguide.models.Package> packagesList = new ArrayList<>();
        int hotel = SessionUtils.getLoginId();
        List<Integer> distinctPackages = em.createNamedQuery("Itinerary.findUniquePackageByHotel").setParameter("hotel", hotel).getResultList();
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

    public List<HotelProfileModel> getAllHotels() {
        List<HotelProfileModel> models = new ArrayList<>();

        List<Login> hotels = em.createNamedQuery("Login.findByType").setParameter("type", Constants.HOTEL).getResultList();

        for (Login hotel1 : hotels) {

            int loginId = hotel1.getLoginid();
            List<Hotels> hotelsList = em.createNamedQuery("Hotels.findByLoginid").setParameter("loginid", loginId).getResultList();
            List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", loginId).getResultList();

            Hotels hotel = null;
            User user = null;
            List<Rooms> roomsList = null;
            if (hotelsList.size() > 0) {
                hotel = hotelsList.get(0);

                roomsList = em.createNamedQuery("Rooms.findByHotelid").setParameter("hotelid", hotel.getHotelid()).getResultList();
            }
            if (userList.size() > 0) {
                user = userList.get(0);
            }

            models.add(new HotelProfileModel(hotel1, user, hotel, roomsList));
        }

        return models;
    }
}
