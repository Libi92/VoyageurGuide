/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.facades;

import com.voyageurguide.handlers.AbstractFacade;
import com.voyageurguide.models.Taluk;
import com.voyageurguide.utils.JsfUtil;
import java.util.Map;
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
public class TalukFacade extends AbstractFacade<Taluk> {

    @PersistenceContext(unitName = "VoyageurGuidePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TalukFacade() {
        super(Taluk.class);
    }
    
    public SelectItem[] getTaluks(Integer district){
        Map items = findAll().stream().filter(item -> district.equals(item.getDistrictid())).collect(Collectors.toMap(item -> item.getTalukid(), item -> item.getTaluk()));
        return JsfUtil.getSelectItems(items, true);
    }
    
}
