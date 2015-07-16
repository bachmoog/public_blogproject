/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.controller;

import com.swcguild.group3capstone.dao.Group3CapstoneInterface;
import com.swcguild.group3capstone.model.Comment;
import javax.inject.Inject;
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
@RequestMapping(value="/blog")
public class BlogController {
    
    private Group3CapstoneInterface blogDAO;
    
    @Inject
    public BlogController(Group3CapstoneInterface blogDAO){
        this.blogDAO = blogDAO;
    }
    
    @RequestMapping(value="/addComment/{id}", method=RequestMethod.POST)
    public void addComment(@PathVariable("id") int blogId, @RequestBody Comment comment){
        
        blogDAO.addBlogComment(comment, blogId);
    }



}
