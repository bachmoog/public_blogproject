/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.group3capstone.controller;

import com.swcguild.group3capstone.dao.Group3CapstoneInterface;
import com.swcguild.group3capstone.model.Blog;
import com.swcguild.group3capstone.model.Category;
import com.swcguild.group3capstone.model.Comment;
import com.swcguild.group3capstone.model.Hashtag;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/home"})
public class HomeController {

    private Group3CapstoneInterface blogDAO;
    private int blogID;

    @Inject
    public HomeController(Group3CapstoneInterface blogDAO) {
        this.blogDAO = blogDAO;
    }

    @RequestMapping(value = "/getPosts", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getPosts() {
        //return blogDAO.getPartialListOfBlogs(blogID, 5, false); //true=up, false=down (I think...)
        return blogDAO.getAllBlogs(); //true=up, false=down (I think...)
    }

    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    @ResponseBody
    public List<Hashtag> getTags() {
        return blogDAO.getListOfHashtags();
    }

    @RequestMapping(value = "/getComments", method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getComments() {
        return blogDAO.getBlogCommentsByBlogId(blogID);
    }

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getCategories() {
        return blogDAO.getListOfCategories();
    }

    @RequestMapping(value = "/getArchives", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getArchives() {
        return null;
    }

//    @RequestMapping(value="/gotoPost/{id}", method=RequestMethod.GET)
//    @ResponseBody
//    public Blog gotoPost(@PathVariable("id") int blogId){
//        
//        
//        
//        return blogDAO.getBlogById(blogId);
//    }
    @RequestMapping(value = "/EachBlog/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String gotoPost(@PathVariable("id") int blogId, HttpServletRequest req, Model model) {
        
        blogDAO.getBlogById(blogId);
        
        return "/EachBlog";
    }

    @RequestMapping(value = "/gotoComments/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Blog gotoComments(@PathVariable("id") int blogId) {

        return null;
    }

}
