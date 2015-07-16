/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.controller;

import com.swcguild.group3capstone.dao.Group3CapstoneInterface;
import com.swcguild.group3capstone.model.Blog;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/adminBlog"})
public class AdminBlogController {
    
    Group3CapstoneInterface blogDAO;
    
    @Inject
    public AdminBlogController(Group3CapstoneInterface blogDAO) {
        this.blogDAO = blogDAO;
    }
    
    @RequestMapping(value="/open/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Blog openBlog(@PathVariable("id") int blogId){ //need to get blog Object AND go to EachBlog page
        return null;
    }
    
    @RequestMapping(value="/publish/{id}", method=RequestMethod.PUT)
    public String publish(@PathVariable("id") int blogId, Blog publishBlog) {
        Blog unpublishBlog = blogDAO.getBlogById(blogId);
        unpublishBlog.setPublished(true);
        unpublishBlog.setApproved(true);
        return "redirect:admin";
    }
    
    @RequestMapping(value="/unpublish/{id}", method=RequestMethod.GET)
    public String unpublish(@PathVariable("id") int blogId){
        
        Blog unpublishBlog = blogDAO.getBlogById(blogId);
        unpublishBlog.setPublished(false);
        unpublishBlog.setApproved(false);
        return "redirect:admin";
    }
    
    @RequestMapping(value="/cancel", method=RequestMethod.GET)
    public String cancel(){
        // clear tinyMCE 
        return "redirect:admin";
    }
    
    @RequestMapping(value="/createDraft", method=RequestMethod.POST)
    public String createDraft(@Valid @RequestBody Blog blog){
        blog.setPublished(false);
        blog.setApproved(false);
        return "redirect:admin";
    }
    
    
}
