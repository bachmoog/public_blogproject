/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Jim
 */
public class Hashtag {
    private int hashtagId;
    @NotEmpty(message = "You must supply a name for the hashtag.")
    @Length(max = 50, message = "Hashtag may be no more than 50 characters.")
    private String hashtag;

    public int getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(int hashtagId) {
        this.hashtagId = hashtagId;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.hashtagId;
        hash = 13 * hash + Objects.hashCode(this.hashtag);
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
        final Hashtag other = (Hashtag) obj;
        if (this.hashtagId != other.hashtagId) {
            return false;
        }
        if (!Objects.equals(this.hashtag, other.hashtag)) {
            return false;
        }
        return true;
    }
    
}
