/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Places;
import com.voyageurguide.models.User;
import com.voyageurguide.models.Usergallery;
import com.voyageurguide.viewmodels.GalleryModel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author libin
 */
@Stateless
public class UsergalleryFacade extends AbstractFacade<Usergallery> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsergalleryFacade() {
        super(Usergallery.class);
    }

    public List<GalleryModel> getGallery() {
        List<GalleryModel> models = new ArrayList<>();

        List<Usergallery> usergallerys = findAll();

        for (Usergallery usergallery : usergallerys) {
            if (usergallery.getStatus() == 1) {

                String username = "null";
                String place = "null";

                List<User> users = em.createNamedQuery("User.findByLoginid").setParameter("loginid", usergallery.getUserid()).getResultList();
                if (!users.isEmpty()) {
                    username = users.get(0).getFirstname();
                }

                List<Places> placeses = em.createNamedQuery("Places.findByPlaceid").setParameter("placeid", usergallery.getPlace()).getResultList();
                if (!placeses.isEmpty()) {
                    place = placeses.get(0).getPlace();
                }
                models.add(new GalleryModel(usergallery, username, place));
            }
        }

        return models;
    }
    
    public List<GalleryModel> getNonApprovedGallery(){
        List<GalleryModel> models = new ArrayList<>();

        List<Usergallery> usergallerys = findAll();

        for (Usergallery usergallery : usergallerys) {
            if (usergallery.getStatus() == 0) {

                String username = "null";
                String place = "null";

                List<User> users = em.createNamedQuery("User.findByLoginid").setParameter("loginid", usergallery.getUserid()).getResultList();
                if (!users.isEmpty()) {
                    username = users.get(0).getFirstname();
                }

                List<Places> placeses = em.createNamedQuery("Places.findByPlaceid").setParameter("placeid", usergallery.getPlace()).getResultList();
                if (!placeses.isEmpty()) {
                    place = placeses.get(0).getPlace();
                }
                models.add(new GalleryModel(usergallery, username, place));
            }
        }

        return models;
    }

    public void galleryAction(int galleryId, int action) {
        Usergallery usergallery = find(galleryId);
        usergallery.setStatus(action);
        edit(usergallery);
    }
}
