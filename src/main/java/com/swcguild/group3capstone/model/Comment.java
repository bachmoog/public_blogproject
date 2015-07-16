/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Jim
 */
public class Comment {

    private int commentId;
    private String comment;
    private int userId;
    private Date commentDate;
    private int cmtBlogId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public int getCmtBlogId() {
        return cmtBlogId;
    }

    public void setCmtBlogId(int cmtBlogId) {
        this.cmtBlogId = cmtBlogId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.commentId;
        hash = 67 * hash + Objects.hashCode(this.comment);
        hash = 67 * hash + this.userId;
        hash = 67 * hash + Objects.hashCode(this.commentDate);
        hash = 67 * hash + this.cmtBlogId;
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
        final Comment other = (Comment) obj;
        if (this.commentId != other.commentId) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.commentDate, other.commentDate)) {
            return false;
        }
        if (this.cmtBlogId != other.cmtBlogId) {
            return false;
        }
        return true;
    }

}