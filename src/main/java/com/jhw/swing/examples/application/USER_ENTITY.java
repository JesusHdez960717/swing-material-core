/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.examples.application;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class USER_ENTITY {

    private int id;
    private String name;
    private String pass;
    private int access;

    public USER_ENTITY() {
    }

    public USER_ENTITY(int id) {
        this.id = id;
    }

    public USER_ENTITY(String name, String pass, int access) {
        this.name = name;
        this.pass = pass;
        this.access = access;
    }

    public USER_ENTITY(int id, String name, String pass, int access) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

}
