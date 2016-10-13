/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyageurguide.viewmodels;

import com.voyageurguide.models.Hotels;
import com.voyageurguide.models.Login;
import com.voyageurguide.models.Rooms;
import com.voyageurguide.models.User;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 10945
 */
public class HotelProfileModel {

    private final Login login;
    private final User user;
    private final Hotels hotel;
    private final List<Rooms> roomsList;

    public HotelProfileModel(Login login, User user, Hotels hotel, List<Rooms> roomsList) {
        this.login = login;
        this.user = user;
        this.hotel = hotel;
        this.roomsList = roomsList;
    }

    public Login getLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }

    public Hotels getHotel() {
        return hotel;
    }

    public List<Rooms> getRoomsList() {
        return roomsList;
    }

    public int getACSingleRoomsCount() {
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.AC_SINGLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getNoofrooms();
            }
            return 0;
        }
        return 0;
    }

    public int getACDoubleRoomsCount() {
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.AC_DOUBLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getNoofrooms();
            }
            return 0;
        }
        return 0;
    }

    public int getNonACSingleRoomsCount() {
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.NON_AC_SINGLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getNoofrooms();
            }
            return 0;
        }
        return 0;
    }

    public int getNonACDoubleRoomsCount() {
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.NON_AC_DOUBLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getNoofrooms();
            }
            return 0;
        }
        return 0;
    }

    public int getDormetayCount() {
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.DORMETRY.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getNoofrooms();
            }
            return 0;
        }
        return 0;
    }
    
    public String getACSingleRent(){
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.AC_SINGLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getRent();
            }
            return "0";
        }
        return "0";
    }
    
    public String getACDoubleRent(){
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.AC_DOUBLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getRent();
            }
            return "0";
        }
        return "0";
    }
    
    public String getNonACSingleRent(){
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.NON_AC_SINGLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getRent();
            }
            return "0";
        }
        return "0";
    }
    
    public String getNonACDoubleRent(){
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.NON_AC_DOUBLE.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getRent();
            }
            return "0";
        }
        return "0";
    }
    
    public String getDormetryRent(){
        if (roomsList != null) {
            final List<Rooms> acrooms = roomsList.stream().filter(room -> room.getType().equals(RoomType.DORMETRY.value)).collect(Collectors.toList());
            if (acrooms != null && !acrooms.isEmpty()) {
                return acrooms.get(0).getRent();
            }
            return "0";
        }
        return "0";
    }

    enum RoomType {
        AC_SINGLE("AC-SINGLE"),
        NON_AC_SINGLE("NON-AC-SINGLE"),
        AC_DOUBLE("AC-DOUBLE"),
        NON_AC_DOUBLE("NON-AC-DOUBLE"),
        DORMETRY("DORMETRY");

        private String value;

        private RoomType(String value) {
            this.value = value;
        }
    }

}
