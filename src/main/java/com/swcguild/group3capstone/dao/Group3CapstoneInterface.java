/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.dao;

import com.swcguild.group3capstone.model.Blog;
import com.swcguild.group3capstone.model.Category;
import com.swcguild.group3capstone.model.Comment;
import com.swcguild.group3capstone.model.Hashtag;
import com.swcguild.group3capstone.model.StaticPage;
import com.swcguild.group3capstone.model.User;
import java.util.List;


/**
 *
 * @author Jim
 */
public interface Group3CapstoneInterface {
 
    public void addUser(User user);    
    public void deleteUser(int userId);
    public void editUser(User user);
    public List<User> getListOfUsers();    
    
    public void addCategory(Category category, int blogId);
    public void addCategory(Category category);
    public void deleteCategory(int categoryId);
    public void editCategory(Category category);
    public List<Category> getListOfCategoriesByBlogId(int blogId);
    public List<Category> getListOfCategories();
    public Category getCategoryById(int categoryId);
            
    public void addBlog(Blog blog);    
    public void deleteBlog(int blogId);
    public void editBlog(Blog blog);
    public Blog getBlogById(int blogId);
    public List<Blog> getAllBlogs();
    public List<Blog> getBlogsByCategoryId(int categoryId);
    public List<Blog> getBlogsByHashtagId(int hashtagId);        // use to get list of hashtags associated with a blog - lookup in DB
    public List<Blog> getPartialListOfBlogs(int blogId, int numBlogsDisplayed, boolean isUp);
    public int getHighestBlogIdNumber();
    
    public void addHashtag(Hashtag hashtag, int blogId); 
    public void addHashtag(Hashtag hashtag);
    public void deleteHashtag(int hashtagId);
    public void editHashtag(Hashtag hashtag);
    public List<Hashtag> getListOfHashtagsByBlogId(int blogId);
    public List<Hashtag> getListOfHashtags();   
    public Hashtag getHashtagById(int hashtagId);
    
    public void addBlogComment(Comment comment, int blogId);    
    public void deleteBlogComment(int commentId);
    public void editBlogComment(Comment comment);
    public List<Comment> getBlogCommentsByBlogId(int blogId);
    public List<Comment> getListOfComments();
    public int getHighestBlogCommentIdNumber();
    
    public void addStaticPage(StaticPage staticPage);
    public void deleteStaticPage(int staticPageId);
    public void editStaticPage(StaticPage staticPage);
    public List<StaticPage> getListOfStaticPages();    
}
