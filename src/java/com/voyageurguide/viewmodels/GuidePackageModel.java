/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.utils.CalenderUtil;

/**
 *
 * @author libin
 */
public class GuidePackageModel {
    private String name;
    private String date;
    private int entries;
    private String description;
    private CalenderUtil.Calander calander;
    
    
    public GuidePackageModel(String name, String date, int entries, String description){
        this.name = name;
        this.date = date;
        this.entries = entries;
        this.description = description;
        
        setCalender();
    }
    
    private void setCalender(){
        this.calander = CalenderUtil.getCalender(date);
    }

    public String getName() {
        return name;
    }

    public int getEntries() {
        return entries;
    }

    public String getDescription() {
        return description;
    }

    public CalenderUtil.Calander getCalander() {
        return calander;
    }
    
    
}
