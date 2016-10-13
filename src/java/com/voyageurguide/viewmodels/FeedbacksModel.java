/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.Feedbacks;

/**
 *
 * @author libin
 */
public class FeedbacksModel {
    private Feedbacks feedback;
    private String type;
    private String name;

    public Feedbacks getFeedback() {
        return feedback;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    
    public FeedbacksModel(Feedbacks feedback, String type, String name){
        this.feedback = feedback;
        this.type = type;
        this.name = name;
    }
}
