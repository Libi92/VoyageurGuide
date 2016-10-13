/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Guide;
import com.voyageurguide.models.Guidebooking;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.User;
import com.voyageurguide.models.Userpackage;
import com.voyageurguide.utils.JsfUtil;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.GuidePackageModel;
import com.voyageurguide.viewmodels.GuideProfileModel;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author libin
 */
@Stateless
public class GuideFacade extends AbstractFacade<Guide> {

    @EJB
    private LoginFacade loginFacade;

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuideFacade() {
        super(Guide.class);
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }

    public List<com.voyageurguide.models.Package> getMyPackages() {
        List<com.voyageurguide.models.Package> packagesList = new ArrayList<>();
        int guide = SessionUtils.getLoginId();
        List<Integer> distinctPackages = em.createNamedQuery("Itinerary.findUniquePackageByGuide").setParameter("guide", guide).getResultList();
        for (Integer package1 : distinctPackages) {
            List<com.voyageurguide.models.Package> packages = em.createNamedQuery("Package.findByPackageid").setParameter("packageid", package1).getResultList();
            if (packages.size() > 0) {
                packagesList.add(packages.get(0));
            }
        }
        return packagesList;
    }

    public GuideProfileModel getMyProfile() {
        final int loginId = SessionUtils.getLoginId();
        List<Login> loginList = em.createNamedQuery("Login.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<Guide> guideList = em.createNamedQuery("Guide.findByLoginid").setParameter("loginid", loginId).getResultList();
        List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", loginId).getResultList();

        Login login = null;
        Guide guide = null;
        User user = null;
        if (loginList.size() > 0) {
            login = loginList.get(0);
        }
        if (guideList.size() > 0) {
            guide = guideList.get(0);
        }
        if (userList.size() > 0) {
            user = userList.get(0);
        }

        return new GuideProfileModel(login, user, guide);
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

    public List<GuideProfileModel> getAllGuides() {
        List<GuideProfileModel> models = new ArrayList<>();

        List<Guide> guides = findAll();

        for (Guide guide : guides) {
            List<Login> loginList = em.createNamedQuery("Login.findByLoginid").setParameter("loginid", guide.getLoginid()).getResultList();
            List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", guide.getLoginid()).getResultList();

            Login login = null;
            User user = null;
            if (loginList.size() > 0) {
                login = loginList.get(0);
            }
            if (userList.size() > 0) {
                user = userList.get(0);
            }
            
            models.add(new GuideProfileModel(login, user, guide));
        }

        return models;
    }

    public List<GuidePackageModel> getMyBookings() {
        List<GuidePackageModel> models = new ArrayList<>();
        
        int loginId = SessionUtils.getLoginId();
        List<Guidebooking> guideAdminbookings = em.createNamedQuery("Guidebooking.findByGuideStatus").setParameter("status", 1).setParameter("guideid", loginId).getResultList();
        
        for (Guidebooking guidebooking : guideAdminbookings) {
            List<com.voyageurguide.models.Package> packageList = em.createNamedQuery("Package.findByPackageid").setParameter("packageid", guidebooking.getPackage1()).getResultList();
            if (!packageList.isEmpty()) {
                com.voyageurguide.models.Package package1 = packageList.get(0);
                models.add(new GuidePackageModel(package1.getName(), package1.getDate(), package1.getDays(), package1.getDescription()));
            }
        }
        
        List<Guidebooking> guideUserbookings = em.createNamedQuery("Guidebooking.findByGuideStatus").setParameter("status", 0).setParameter("guideid", loginId).getResultList();
        
        for (Guidebooking guidebooking : guideUserbookings) {
            List<Userpackage> packageList = em.createNamedQuery("Userpackage.findById").setParameter("id", guidebooking.getPackage1()).getResultList();
            if (!packageList.isEmpty()) {
                Userpackage package1 = packageList.get(0);
                models.add(new GuidePackageModel("User Package", package1.getDate(), package1.getDays(), package1.getPlaces()));
            }
        }
        
        return models;
    }
}
