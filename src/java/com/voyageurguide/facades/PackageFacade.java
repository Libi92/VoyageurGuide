/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Guide;
import com.voyageurguide.models.Hotels;
import com.voyageurguide.models.Package;
import com.voyageurguide.models.Places;
import com.voyageurguide.models.Taxi;
import com.voyageurguide.models.User;
import com.voyageurguide.viewmodels.PackageModel;
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
public class PackageFacade extends AbstractFacade<Package> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PackageFacade() {
        super(Package.class);
    }

    public List<PackageModel> getPackages() {
        List<PackageModel> packages = new ArrayList<>();
        List<Package> packagesList = em.createNamedQuery("Package.findAll").getResultList();

        for (Package package1 : packagesList) {
            List<Places> placeses = new ArrayList<>();
            List<User> guides = new ArrayList<>();
            List<User> taxis = new ArrayList<>();
            List<User> hotels = new ArrayList<>();

            String places = package1.getPlaces();
            String[] allPlaces = places.split(",");

            for (String allPlace : allPlaces) {
                Places places1 = (Places) em.createNamedQuery("Places.findByPlaceid").setParameter("placeid", Integer.parseInt(allPlace)).getSingleResult();
                placeses.add(places1);
            }
            
            List<Integer> guidesList = em.createNamedQuery("Itinerary.findUniqueGuideByPackage").setParameter("packageid", package1.getPackageid()).getResultList();
            for (Integer id : guidesList) {
                User guide = (User) em.createNamedQuery("User.findByLoginid").setParameter("loginid", id).getSingleResult();
                guides.add(guide);
            }
            
            List<Integer> taxiList = em.createNamedQuery("Itinerary.findUniqueTaxiByPackage").setParameter("packageid", package1.getPackageid()).getResultList();
            for (Integer id : taxiList) {
                User taxi = (User) em.createNamedQuery("User.findByLoginid").setParameter("loginid", id).getSingleResult();
                taxis.add(taxi);
            }
            
            List<Integer> hotelList = em.createNamedQuery("Itinerary.findUniqueHotelByPackage").setParameter("packageid", package1.getPackageid()).getResultList();
            for (Integer id : hotelList) {
                User hotel = (User) em.createNamedQuery("User.findByLoginid").setParameter("loginid", id).getSingleResult();
                hotels.add(hotel);
            }

            packages.add(new PackageModel(package1, placeses, guides, taxis, hotels));
        }

        return packages;
    }
}
