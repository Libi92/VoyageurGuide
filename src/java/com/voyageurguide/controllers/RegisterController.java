/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.controllers;

import com.voyageurguide.facades.BankFacade;
import com.voyageurguide.facades.DistrictFacade;
import com.voyageurguide.facades.GuideFacade;
import com.voyageurguide.facades.LoginFacade;
import com.voyageurguide.facades.TalukFacade;
import com.voyageurguide.facades.TouristFacade;
import com.voyageurguide.facades.UserFacade;
import com.voyageurguide.models.Bank;
import com.voyageurguide.models.District;
import com.voyageurguide.models.Guide;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.Tourist;
import com.voyageurguide.models.User;
import com.voyageurguide.utils.Constants;
import com.voyageurguide.utils.JsfUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.mail.MessagingException;
import javax.servlet.http.Part;

/**
 *
 * @author libin
 */
@Named(value = "registerController")
@SessionScoped
public class RegisterController implements Serializable {

    private String[] qualification;
    private String[] guideQualification;

    private String[] languages;
    private String[] languagesKnown;
    private SelectItem[] districts;
    private SelectItem[] taluk;
    private String selectedDistrict;
    private Part file;

    private Login login;
    private User user;
    private Bank bank;
    private Tourist tourist;
    private Guide guide;
    private District district;

    @EJB
    private LoginFacade loginFacade;
    @EJB
    private UserFacade userFacade;
    @EJB
    private TouristFacade touristFacade;
    @EJB
    private BankFacade bankFacade;
    @EJB
    private GuideFacade guideFacade;
    @EJB
    private DistrictFacade districtFacade;
    @EJB
    private TalukFacade talukFacade;

    /**
     * Creates a new instance of RegisterController
     */
    public RegisterController() {
    }

    public String[] getQualification() {
        if (qualification == null) {
            qualification = new String[]{"Matriculation", "Diploma", "Graduation", "Post Graduation"};
        }
        return qualification;
    }

    public String[] getGuideQualification() {
        return guideQualification;
    }

    public String[] getLanguages() {
        if (languages == null) {
            languages = new String[]{"English", "Malayalam", "Hindi", "Tamil", "Others"};
        }
        return languages;
    }

    public String[] getLanguagesKnown() {
        return languagesKnown;
    }

    public SelectItem[] getDistricts() {
        if (districts == null) {
            districts = getDistrictFacade().getDistricts();
        }
        return districts;
    }

    public String getSelectedDistrict() {
        return selectedDistrict;
    }

    public void setSelectedDistrict(String selectedDistrict) {
        this.selectedDistrict = selectedDistrict;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Login getLogin() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGuideQualification(String[] guideQualification) {
        this.guideQualification = guideQualification;
    }

    public void setLanguagesKnown(String[] languagesKnown) {
        this.languagesKnown = languagesKnown;
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public Tourist getTourist() {
        if (tourist == null) {
            tourist = new Tourist();
        }
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public TouristFacade getTouristFacade() {
        return touristFacade;
    }

    public void setTouristFacade(TouristFacade touristFacade) {
        this.touristFacade = touristFacade;
    }

    public Bank getBank() {
        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankFacade getBankFacade() {
        return bankFacade;
    }

    public void setBankFacade(BankFacade bankFacade) {
        this.bankFacade = bankFacade;
    }

    public Guide getGuide() {
        if (guide == null) {
            guide = new Guide();
        }
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public GuideFacade getGuideFacade() {
        return guideFacade;
    }

    public void setGuideFacade(GuideFacade guideFacade) {
        this.guideFacade = guideFacade;
    }

    public District getDistrict() {
        return district;
    }

    public DistrictFacade getDistrictFacade() {
        return districtFacade;
    }

    public void setDistricts(SelectItem[] districts) {
        this.districts = districts;
    }

    public void setDistrictFacade(DistrictFacade districtFacade) {
        this.districtFacade = districtFacade;
    }

    public SelectItem[] getTaluk() {
        return taluk;
    }

    public TalukFacade getTalukFacade() {
        return talukFacade;
    }

    public void setTaluks() {
        taluk = getTalukFacade().getTaluks(guide.getDistrict());
    }

    public String createUser() {

        getLoginFacade().create(login);
        user.setLoginid(login.getLoginid());
        getUserFacade().create(user);
        return login.getType().toLowerCase();
    }

    public String createTourist() {
        tourist.setLoginid(login.getLoginid());
        bank.setLoginid(login.getLoginid());

        getTouristFacade().create(tourist);
        getBankFacade().save(bank);

        JsfUtil.addSuccessMessage(Constants.REGISTER_SUCCESS);
        recreateModels();
        return Constants.HOME_PAGE;
    }

    public String createGuide() {
        
        guide.setLoginid(login.getLoginid());
        bank.setLoginid(login.getLoginid());
        
        try (InputStream input = file.getInputStream()) {
        Files.copy(input, new File(Constants.UPLOADS_DIR + File.separator + Constants.GUIDE_DIR, getFileName()).toPath());
        } catch (IOException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        guide.setPhoto(getFileName());
        String language = Arrays.asList(languagesKnown).stream().reduce((a, b) -> a + "," + b).get();
        guide.setLanguages(language);
        String qualifications = Arrays.asList(guideQualification).stream().reduce((a, b) -> a + "," + b).get();
        guide.setEducation(qualifications);
        guide.setBank(bank.getBank());
        guide.setBranch(bank.getBranch());
        guide.setAccountno(bank.getAccountno());
        
        getBankFacade().save(bank);
        getGuideFacade().create(guide);
        JsfUtil.addSuccessMessage(Constants.REGISTER_SUCCESS);
        recreateModels();
        return Constants.HOME_PAGE;
    }

    private void recreateModels() {
        login = new Login();
        user = new User();
        tourist = new Tourist();
        bank = new Bank();
    }

    private String getFileName() {
        return user.getFirstname() + "_" + user.getLoginid() + ".jpg";
    }

}
