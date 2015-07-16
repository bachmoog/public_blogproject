/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.model;

import java.util.Date;
import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Jim
 */
public class StaticPage {
    private int staticPageId;
    @NotEmpty(message = "You must supply content for the static page.")
    private String pageContent;
    private int pageCreatorId;
    private Date pageCreationDate;
    @NotEmpty(message = "You must supply a title for the static page.")
    @Length(max = 125, message = "Title may be no more than 125 characters.")
    private String pageTitle;

    public int getStaticPageId() {
        return staticPageId;
    }

    public void setStaticPageId(int staticPageId) {
        this.staticPageId = staticPageId;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }    
    
    public int getPageCreatorId() {
        return pageCreatorId;
    }

    public void setPageCreatorId(int pageCreatorId) {
        this.pageCreatorId = pageCreatorId;
    }

    public Date getPageCreationDate() {
        return pageCreationDate;
    }

    public void setPageCreationDate(Date pageCreationDate) {
        this.pageCreationDate = pageCreationDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.staticPageId;
        hash = 79 * hash + Objects.hashCode(this.pageContent);
        hash = 79 * hash + this.pageCreatorId;
        hash = 79 * hash + Objects.hashCode(this.pageCreationDate);
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
        final StaticPage other = (StaticPage) obj;
        if (this.staticPageId != other.staticPageId) {
            return false;
        }
        if (!Objects.equals(this.pageContent, other.pageContent)) {
            return false;
        }
        if (this.pageCreatorId != other.pageCreatorId) {
            return false;
        }
        if (!Objects.equals(this.pageCreationDate, other.pageCreationDate)) {
            return false;
        }
        return true;
    }
    
    
}
