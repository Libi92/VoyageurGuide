/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.District;
import com.voyageurguide.utils.JsfUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author libin
 */
@Stateless
public class DistrictFacade extends AbstractFacade<District> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DistrictFacade() {
        super(District.class);
    }
    
    public SelectItem[] getDistricts(){
        Map districts = findAll().stream().collect(Collectors.toMap(dist -> dist.getDistrictid(), dist -> dist.getDistrict()));
        return JsfUtil.getSelectItems(districts, true);
    }
    
}
