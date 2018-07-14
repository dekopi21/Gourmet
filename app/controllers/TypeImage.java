/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author NIKABOU
 */
public enum TypeImage {
    CATEGORIES("/data/CATEGORIES"),
    PLATS("/data/PLATS"),
    UTILISATEURS("/data/UTILISATEURS"),
    RESTAURANT("/data/RESTAURANTS"),
    MENU("/data/MENU");


    private String name;

    TypeImage(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}


