/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.model;

import java.util.Objects;

/**
 *
 * @author Jim
 */
public class User {
    private int userId;
    private String userName;
    private String passsWord;
    private Boolean enabled;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasssWord() {
        return passsWord;
    }

    public void setPasssWord(String passsWord) {
        this.passsWord = passsWord;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.userId;
        hash = 53 * hash + Objects.hashCode(this.userName);
        hash = 53 * hash + Objects.hashCode(this.passsWord);
        hash = 53 * hash + Objects.hashCode(this.enabled);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.passsWord, other.passsWord)) {
            return false;
        }
        if (!Objects.equals(this.enabled, other.enabled)) {
            return false;
        }
        return true;
    }
    
    
}