/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.model;

//Test comment from Mike Adams
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Jim
 */
public class Blog {

    private int blogId;
    @NotEmpty(message = "You must supply a title for the blog.")
    @Length(max = 100, message = "Title must be no more than 100 characters in length.")
    private String blogTitle;
    private Date date;
    @NotEmpty(message = "You must supply content for the blog.")
    private String content;
    private int userId;
    private boolean published;
    private boolean approved;
    private List<Hashtag> hashList = new ArrayList<>();
    private List<Category> catList = new ArrayList<>();
    private List<Comment> comList = new ArrayList<>();

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public List<Hashtag> getHashList() {
        return hashList;
    }

    public void setHashList(List<Hashtag> hashList) {
        this.hashList = hashList;
    }

    public List<Category> getCatList() {
        return catList;
    }

    public void setCatList(List<Category> catList) {
        this.catList = catList;
    }

    public List<Comment> getComList() {
        return comList;
    }

    public void setComList(List<Comment> comList) {
        this.comList = comList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.blogId;
        hash = 79 * hash + Objects.hashCode(this.date);
        hash = 79 * hash + Objects.hashCode(this.content);
        hash = 79 * hash + this.userId;
        hash = 79 * hash + (this.published ? 1 : 0);
        hash = 79 * hash + (this.approved ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.hashList);
        hash = 79 * hash + Objects.hashCode(this.catList);
        hash = 79 * hash + Objects.hashCode(this.comList);
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
        final Blog other = (Blog) obj;
        if (this.blogId != other.blogId) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.published != other.published) {
            return false;
        }
        if (this.approved != other.approved) {
            return false;
        }
        if (!Objects.equals(this.hashList, other.hashList)) {
            return false;
        }
        if (!Objects.equals(this.catList, other.catList)) {
            return false;
        }
        if (!Objects.equals(this.comList, other.comList)) {
            return false;
        }
        return true;
    }

}
