/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.User;
import com.voyageurguide.utils.Constants;
import com.voyageurguide.utils.JsfUtil;
import com.voyageurguide.utils.SessionUtils;
import com.voyageurguide.viewmodels.PasswordChangeModel;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author libin
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> {

    @EJB
    private LoginFacade loginFacade;
    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginFacade() {
        super(Login.class);
    }

    public LoginFacade getLoginFacade() {
        return loginFacade;
    }
    
    public String doLogin(Login login){
        List<Login> users = em.createNamedQuery("Login.checkLogin").setParameter("username", login.getUsername()).setParameter("password", login.getPassword()).getResultList();
        if (users.size() > 0) {
            List<User> userList = em.createNamedQuery("User.findByLoginid").setParameter("loginid", users.get(0).getLoginid()).getResultList();
                
            if(userList.size() > 0){
                SessionUtils.saveUser(userList.get(0));
            }
            else{
                SessionUtils.saveUser(null);
            }
            
            return users.get(0).getType();
        }
        else{
            return Constants.EMPTY_RESULT;
        }
        
    }
    
    public String doLogout(){
//        SessionUtils.clearSession();
        
        return "/" + Constants.HOME_PAGE + Constants.REDIRECT;
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
    
}
