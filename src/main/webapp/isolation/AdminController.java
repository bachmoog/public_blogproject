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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/admin"})
public class AdminController {
    
    Group3CapstoneInterface blogDAO;
    
    @Inject
    public AdminController(Group3CapstoneInterface blogDAO) {
        this.blogDAO = blogDAO;
    }
    
    
    @RequestMapping(value="/addBlog", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String addBlog(Blog blog){  // go to tinyMCE editor
        blogDAO.addBlog(blog);
        return "redirect:AddBlog";
    }
    
    @RequestMapping(value="/editBlog/{id}", method=RequestMethod.PUT)
    public void editBlog(@Valid @RequestBody @PathVariable("id") int blogID, Blog updatedBlog){
        updatedBlog.setBlogId(blogID);
        blogDAO.editBlog(updatedBlog);
    }
    
    @RequestMapping(value="/deleteBlog/{id}", method=RequestMethod.DELETE)
    public void deleteBlog(@PathVariable("id") int blogID){
        blogDAO.deleteBlog(blogID);
    }
    
}
