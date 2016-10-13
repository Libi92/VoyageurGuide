/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.Cars;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.Taxi;
import com.voyageurguide.models.User;
import java.util.List;

/**
 *
 * @author 10945
 */
public class TaxiProfileModel {
    private Login login;
    private User user;
    private Taxi taxi;
    private List<Cars> cars;
    
    public TaxiProfileModel(Login login, User user, Taxi taxi, List<Cars> cars){
        this.login = login;
        this.user = user;
        this.taxi = taxi;
        this.cars = cars;
    }

    public Login getLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public List<Cars> getCars() {
        return cars;
    }
    
    public int getNumCars(){
        if (cars == null) {
            return 0;
        }
        return cars.size();
    }
    
    public void setNumCars(int num){
        this.taxi.setVehicles(num);
    }
    
    public Cars getACar(){
        if (cars.isEmpty()) {
            return new Cars();
        }
        return cars.get(0);
    }
}
