/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.District;
import com.voyageurguide.models.Gallary;
import com.voyageurguide.models.Places;
import com.voyageurguide.viewmodels.PlacesModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 10945
 */
@Stateless
public class PlacesFacade extends AbstractFacade<Places> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlacesFacade() {
        super(Places.class);
    }

    public List<PlacesModel> getPlaces() {
        List<PlacesModel> placesModels = new ArrayList<>();
        final List<Places> placesList = em.createNamedQuery("Places.findAll").getResultList();
        for (Places place : placesList) {
            final List<District> districtList = em.createNamedQuery("District.findByDistrictid").setParameter("districtid", place.getDistrict()).getResultList();
            final List<Gallary> images = em.createNamedQuery("Gallary.findByPlaceid").setParameter("placeid", place.getPlaceid()).getResultList();
            Gallary image;
            if (images == null || images.isEmpty()) {
                image = null;
            }
            else{
                image = images.get(0);
            }
            PlacesModel model = new PlacesModel(place, districtList.get(0), image);
            placesModels.add(model);
        }
        
        return placesModels;
    }

    public List<Places> getAll() {
        final List<Places> placesList = em.createNamedQuery("Places.findAll").getResultList();
//        placesList.stream().map(place -> place.getPlace()).collect(Collectors.toList());
        return placesList;
    }
    
    
}
