/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.controller;

import com.swcguild.group3capstone.dao.Group3CapstoneInterface;
import com.swcguild.group3capstone.model.Blog;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/admin2"})
public class Admin2Controller {
    
    Group3CapstoneInterface blogDAO;
    
    @Inject
    public Admin2Controller(Group3CapstoneInterface blogDAO){
        this.blogDAO = blogDAO;
    }
    
    @RequestMapping(value="/openDraft/{id}", method=RequestMethod.GET)
    @ResponseBody public Blog openDraft(@PathVariable("id") int blogId){
        return null;
    }
    
    @RequestMapping(value="deleteDraft/{id}", method=RequestMethod.DELETE)
    public void deleteDraft(@PathVariable("id") int blogId){
        
    }
}
