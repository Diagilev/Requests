package com.regcontract.Model;

import javax.jws.soap.SOAPBinding;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabanaus on 10.03.2017.
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;

    @Override
    public boolean equals(Object object) {
        User user = (User) object;
        if (this.email.equals(user.email) && this.password.equals(user.password))
            return true;
        else return false;
    }

    public User(String email, String password) {
    this.email = email;
        this.password = password;
    }


    public User(int id, String name, String surname, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String email) {
        this.email = email;
    }

    public User() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean checkProperties() {
        boolean result = false;
        List<String> list = new ArrayList<String>();
        list.add(this.getName());
        list.add(this.getSurname());
        list.add(this.getEmail());
        list.add(this.getPassword());
        for (String s : list) {
            if (s == null || s == "") {
                result = false;
                break;
            } else result = true;
        }
        return result;
    }
}


