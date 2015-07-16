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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jim
 */
public class Group3CapstoneDBImplMike implements Group3CapstoneInterface {

    private Map<Integer, User> userMap = new HashMap<>();
    private Map<Integer, Hashtag> hashtagMap = new HashMap<>();
    private Map<Integer, Comment> commentMap = new HashMap<>();
    private Map<Integer, Blog> blogMap = new HashMap<>();
    private Map<Integer, Category> categoryMap = new HashMap<>();
    private Map<Integer, StaticPage> staticPageMap = new HashMap<>();

    //     USERS  
    private static final String SQL_INSERT_USER
        = "INSERT INTO users (username, password, enabled) VALUES (?,?,?)";

    private static final String SQL_DELETE_USER_FROM_AUTHORITIES
        = "DELETE FROM authorities WHERE username=?";

    private static final String SQL_DELETE_USER
        = "DELETE FROM users WHERE user_id=?";

    private static final String SQL_UPDATE_USER
        = "UPDATE users SET username=?, password=?, enabled=? WHERE user_id = ?";

    private static final String SQL_GET_LAST_USER_ID
        = "SELECT MAX(user_id) FROM users";

    private static final String SQL_SELECT_USER
        = "SELECT * FROM users WHERE user_id=?";

    private static final String SQL_SELECT_ALL_USERS
        = "SELECT * FROM users";

    private static final String SQL_SELECT_LAST_USER_ID
        = "SELECT * FROM users WHERE ORDER BY user_id DESC LIMIT 1";
    
    //       HASHTAGS 
    private static final String SQL_INSERT_HASHTAG
        = "INSERT INTO hashtags (hashtag) VALUES (?)";

    private static final String SQL_DELETE_HASHTAG
        = "DELETE FROM hashtags WHERE hashtag_id=?";

    private static final String SQL_UPDATE_HASHTAG
        = "UPDATE hashtags SET hashtag=? WHERE hashtag_id = ?";

    private static final String SQL_GET_LAST_HASHTAG_ID
        = "SELECT MAX(hashtag_id) FROM hashtags";

    private static final String SQL_GET_ALL_HASHTAGS
        = "SELECT * FROM hashtags";

    private static final String SQL_SELECT_HASHTAG
        = "SELECT * FROM hashtags WHERE hashtag_id=?";

    private static final String SQL_CHECK_HASHTAG_EXISTS
        = "SELECT COUNT(hashtag) FROM hashtags WHERE hashtag = ?";
    // returns 0 if does not exist

    private static final String SQL_GET_HASHTAG_BY_HASHTAG
        = "SELECT * FROM hashtags WHERE hashtag=?";

    private static final String SQL_SELECT_LAST_HASHTAG_ID
        = "SELECT * FROM hashtags WHERE ORDER BY hashtag_id DESC LIMIT 1";

    //     CATEGORIES  
    private static final String SQL_INSERT_CATEGORY
        = "INSERT INTO categories (category) VALUES (?)";

    private static final String SQL_GET_LAST_CATEGORY_ID
        = "SELECT MAX(category_id) FROM categories"; // can add As maximum_id

    private static final String SQL_DELETE_CATEGORY
        = "DELETE FROM categories WHERE category_id=?";

    private static final String SQL_UPDATE_CATEGORY
        = "UPDATE categories SET category=? WHERE category_id = ?";

    private static final String SQL_SELECT_CATEGORY
        = "SELECT * FROM categories WHERE category_id = ?";

    private static final String SQL_SELECT_LAST_CATEGORY_ID
        = "SELECT * FROM categories WHERE ORDER BY category_id DESC LIMIT 1";

    private static final String SQL_GET_ALL_CATEGORIES
        = "SELECT * FROM categories";

    private static final String SQL_CHECK_CATEGORY_EXISTS
        = "SELECT COUNT(category) FROM categories WHERE category = ?";
    // returns 0 if does not exist

    //     STATIC PAGES  
    private static final String SQL_INSERT_STATIC_PAGE
            = "INSERT INTO static_pages (page_content, user_id, page_title) VALUES (?,?,?)";

    private static final String SQL_DELETE_STATIC_PAGE
        = "DELETE FROM static_pages WHERE static_page_id=?";

    private static final String SQL_UPDATE_STATIC_PAGE
        = "UPDATE static_pages SET page_content = ?, user_id = ?, date_created = ?, page_title = ? WHERE static_page_id = ?";

    private static final String SQL_SELECT_STATIC_PAGE
        = "SELECT * FROM static_pages WHERE static_page_id=?";

    private static final String SQL_SELECT_LAST_STATIC_PAGE_ID
        = "SELECT * FROM static_pages WHERE ORDER BY static_page_id DESC LIMIT 1";

    private static final String SQL_GET_ALL_STATIC_PAGES
        = "SELECT * FROM static_pages";

//          BLOGS
    private static final String SQL_INSERT_BLOG
        = "INSERT INTO blogs (blog_title, blog_content, user_id, published, approved) VALUES (?,?,?,?,?)";

    private static final String SQL_DELETE_BLOG
        = "DELETE FROM blogs WHERE blog_id=?";

    private static final String SQL_UPDATE_BLOG
        = "UPDATE blogs SET blog_title = ?, blog_content = ?, user_id = ?, published = ?, "
        + "approved = ? WHERE blog_id = ?";

    private static final String SQL_SELECT_BLOG_BY_BLOG_ID
        = "SELECT * FROM blogs WHERE blog_id=?";

    private static final String SQL_GET_BLOGS_BY_CATEGORY_ID
        = "SELECT * FROM blogs AS b JOIN blog_category_bridge AS bcb USING (blog_id) WHERE category_id=?";

    private static final String SQL_SELECT_ALL_BLOGS
        = "SELECT * FROM blogs ORDER BY blog_date DESC";

    private static final String SQL_SELECT_LAST_BLOG_ID
        = "SELECT * FROM blogs WHERE ORDER BY blog_id DESC LIMIT 1";

    private static final String SQL_IS_BLOG_RELATED_TO_CATEGORY_IN_BRIDGE
        = "SELECT blog_id FROM blog_category_bridge WHERE category_id=?";  // if blog_id not associated with cat_id - get empty set

    private static final String SQL_IS_BLOG_RELATED_TO_HASHTAG_IN_BRIDGE
        = "SELECT blog_id FROM blog_hashtag_bridge WHERE hashtag_id=?";  // if blog_id not associated with cat_id - get empty set

//          COMMENTS  
    private static final String SQL_SELECT_COMMENT
        = "SELECT * FROM comments WHERE comment_id=?";

    private static final String SQL_GET_LIST_OF_COMMENTS
        = "SELECT * FROM comments";

    private static final String SQL_GET_COMMENTS_ASSOCIATED_WITH_BLOG_ID_
        = "SELECT * FROM comments WHERE blog_id = ?";

    private static final String SQL_SELECT_LAST_COMMENT_ID
        = "SELECT * FROM comments WHERE ORDER BY comment_id DESC LIMIT 1";

    private static final String SQL_INSERT_COMMENT
        = "INSERT INTO comments (comment, user_id, date, blog_id)VALUES (?,?,?,?)";

    private static final String SQL_DELETE_COMMENT
        = "DELETE FROM comments WHERE comment_id=?";

    private static final String SQL_UPDATE_COMMENT
        = "UPDATE comments SET (comment = ?, user_id = ?, date, blog_id=?) "
        + "WHERE comment_id = ?";

    private static final String SQL_DELETE_COMMENT_BY_BLOG_ID //Mike Adams, 6-28-15
        = "DELETE FROM comments WHERE blog_id = ?";

//          BLOG_HASHTAG_BRIDGE
    private static final String SQL_GET_HASHTAGS_ASSOCIATED_WITH_BLOG_ID
        = "SELECT * FROM hashtags JOIN blog_hashtag_bridge USING (hashtag_id) WHERE blog_id = ?";

    private static final String SQL_GET_BLOGS_BY_HASHTAG_ID
        = "SELECT * FROM blogs AS b JOIN blog_hashtag_bridge AS bcb USING (blog_id) WHERE hashtag_id = ?";

    private static final String SQL_INSERT_BLOG_HASHTAG
        = "INSERT INTO blog_hashtag_bridge (blog_id, hashtag_id) VALUES (?,?)";

    private static final String SQL_DELETE_BLOG_HASHTAG_BY_BLOG_ID
        = "DELETE FROM blog_hashtag_bridge WHERE blog_id = ?";  // removes all specific blog_id#s from bridge

    private static final String SQL_DELETE_BLOG_HASHTAG_BY_HASHTAG_ID
        = "DELETE FROM blog_hashtag_bridge WHERE hashtag_id = ?";  // removes all specific category_id#s from bridge

    private static final String SQL_SELECT_BLOG_HASHTAG_BY_BLOG
        = "SELECT * FROM blog_hashtag_bridge WHERE blog_id = ?";  // generic call

    private static final String SQL_SELECT_HASHTAG_IDS_FROM_BLOG_HASHTAG_BY_BLOG
        = "SELECT hashtag_id FROM `blog_hashtag_bridge` WHERE blog_id = ?";

    private static final String SQL_SELECT_BLOG_HASHTAG_BY_HASHTAG
        = "SELECT * FROM blog_hashtag_bridge WHERE hashtag_id = ?";  // generic call

    private static final String SQL_SELECT_FROM_BLOG_HASHTAG_BY_LAST_BLOG_ID
        = "SELECT * FROM blog_hashtag_bridge WHERE ORDER BY blog_id DESC LIMIT 1";   // call by last entry

    private static final String SQL_SELECT_FROM_BLOG_HASHTAG_BY_LAST_HASHTAG_ID
        = "SELECT * FROM blog_hashtag_bridge WHERE ORDER BY hashtag_id DESC LIMIT 1";    // call by last entry

//          BLOG_CATEGORY_BRIDGE 
    private static final String SQL_INSERT_BLOG_CATEGORY
        = "INSERT INTO blog_category_bridge (blog_id, category_id) VALUES (?,?)";

    private static final String SQL_GET_CATEGORIES_ASSOCIATED_WITH_BLOG_ID_
        = "SELECT * FROM categories JOIN blog_category_bridge USING (category_id) WHERE blog_id = ?";

    private static final String SQL_DELETE_BLOG_CATEGORY_BY_BLOG_ID
        = "DELETE FROM blog_category_bridge WHERE blog_id=?";  // removes all specific blog_id#s from bridge

    private static final String SQL_DELETE_BLOG_CATEGORY_BY_CATEGORY
        = "DELETE FROM blog_category_bridge WHERE category_id=?";  // removes all specific category_id#s from bridge

    private static final String SQL_SELECT_BLOG_CATEGORY_BY_BLOG
        = "SELECT * FROM blog_category_bridge WHERE blog_id=?";  // generic call

    private static final String SQL_SELECT_BLOG_CATEGORY_BY_CATEGORY
        = "SELECT * FROM blog_category_bridge WHERE category_id=?";  // generic call

    private static final String SQL_SELECT_FROM_BLOG_CATEGORY_BY_LAST_BLOG_ID
        = "SELECT * FROM blog_category_bridge WHERE ORDER BY blog_id DESC LIMIT 1";  // call by last entry

    private static final String SQL_SELECT_FROM_BLOG_CATEGORY_BY_LAST_CATEGORY_ID
        = "SELECT * FROM blog_category_bridge WHERE ORDER BY category_id DESC LIMIT 1";   // call by last entry 

    private static final String SQL_SELECT_CATEGORY_IDS_FROM_BLOG_CATEGORY_BY_BLOG
        = "SELECT category_id FROM `blog_category_bridge` WHERE blog_id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

// @@@@@@@@@@@@@@@@@   USERS  @@@@@@@@@@@@@@@@@@@@@@@@@    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addUser(User user) {
        //       needs a transaction and the highest ID number
        jdbcTemplate.update(SQL_INSERT_USER,
            user.getUserName(),
            user.getPasssWord(),
            user.getEnabled());
        user.setUserId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID() FROM users", Integer.class));
        // lsetID must be gathered immediately after the insert user - note transaction wrapper
    }

    @Override
    public void deleteUser(int userId) {
//        // this requires deletion of blog(s), the user, and the user in the authorities
//        // no delete user will be performed
//        try {
//            User currentUser = jdbcTemplate.queryForObject(SQL_SELECT_USER, userId);
//        catch (EmptyResultDataAccessException e) {
//                };        
//        }
        //// Currently Broken
//        jdbcTemplate.update(SQL_DELETE_USER_FROM_AUTHORITIES, currentUser.getUserName());
//        jdbcTemplate.update(SQL_DELETE_USER, userId);
    }

    @Override
    public void editUser(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER,
            user.getUserId(),
            user.getUserName(),
            user.getPasssWord(),
            user.getEnabled());
    }

    @Override
    public List<User> getListOfUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new UserMapper());
    }

    public User getUserById(int userId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_USER, new UserMapper(), userId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // @@@@@@@@@@@@@@@@@   CATEGORIES  @@@@@@@@@@@@@@@@@@@@@@@@@ 
    // user to transfer to catetegory table, returnc categoryId, adds to blog_category_bridge table 

    @Override
    public Category getCategoryById(int categoryId) {
        Category newCat = new Category();
        newCat = jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY, new CategoryMapper(), categoryId);
        return newCat;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addCategory(Category category, int blogId) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY, category.getCategory());
        category.setCategoryId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        jdbcTemplate.update(SQL_INSERT_BLOG_CATEGORY, blogId, category.getCategoryId());
    }

    // use to load the datecory into the category table - returns categoryId
    @Override
    public void addCategory(Category category) {
        jdbcTemplate.update(SQL_INSERT_CATEGORY,
            category.getCategory());
        category.setCategoryId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void deleteCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    @Override
    public void editCategory(Category category) {
        jdbcTemplate.update(SQL_UPDATE_CATEGORY,
            category.getCategoryId(),
            category.getCategory());
    }

    @Override
    public List<Category> getListOfCategoriesByBlogId(int blogId) {
        List<Category> dummy = new ArrayList<>();
        return dummy; // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    }

    @Override
    public List<Category> getListOfCategories() {
        return jdbcTemplate.query(SQL_GET_ALL_CATEGORIES, new CategoryMapper());
    }

    @Override
    public Hashtag getHashtagById(int hashtagId) {
        Hashtag newHash = new Hashtag();
        newHash = jdbcTemplate.queryForObject(SQL_SELECT_HASHTAG, new HashtagMapper(), hashtagId);
        return newHash;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addHashtag(Hashtag hashtag, int blogId) {
        jdbcTemplate.update(SQL_INSERT_HASHTAG,
            hashtag.getHashtag());
        hashtag.setHashtagId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        jdbcTemplate.update(SQL_INSERT_BLOG_HASHTAG, blogId, hashtag.getHashtagId());
    }

    @Override
    public void addHashtag(Hashtag hashtag) {
        jdbcTemplate.update(SQL_INSERT_HASHTAG,
            hashtag.getHashtag());
        hashtag.setHashtagId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
//        jdbcTemplate.update(SQL_INSERT_BLOG_HASHTAG, hashtag.getHashtagId()); 
    }

    @Override
    public void deleteHashtag(int hashtagId) {
        jdbcTemplate.update(SQL_DELETE_BLOG_HASHTAG_BY_HASHTAG_ID, hashtagId);
        jdbcTemplate.update(SQL_DELETE_HASHTAG, hashtagId);
    }

    @Override
    public void editHashtag(Hashtag hashtag) {
        jdbcTemplate.update(SQL_UPDATE_HASHTAG,
            hashtag.getHashtag(),
            hashtag.getHashtagId());
    }

    @Override
    public List<Hashtag> getListOfHashtagsByBlogId(int blogId) {
        List<Hashtag> dummy = new ArrayList<>();
        return dummy;  // @@@@@@@@@@@@@@@@@@@@@@@@@
    }   // **************************** NEEDS NEW CALL *****************************

    @Override
    public List<Hashtag> getListOfHashtags() {
        return jdbcTemplate.query(SQL_GET_ALL_HASHTAGS, new HashtagMapper());
    }

    // @@@@@@@@@@@@@@@@@@@  COMMENTS  @@@@@@@@@@@@@@@@@@@@@@@@
    @Override
    public void addBlogComment(Comment comment, int blogId) {
        jdbcTemplate.update(SQL_INSERT_COMMENT,
            comment.getComment(),
            comment.getUserId(),
            comment.getCommentDate(),
            comment.getCmtBlogId());
        comment.setCommentId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID() FROM hashtags", Integer.class));
    }

    @Override
    public void deleteBlogComment(int commentId) {
        jdbcTemplate.update(SQL_DELETE_COMMENT, commentId);
    }

    @Override
    public void editBlogComment(Comment comment) {
        jdbcTemplate.update(SQL_UPDATE_COMMENT,
            comment.getCommentId());
    }

    @Override
    public List<Comment> getBlogCommentsByBlogId(int blogId) {
        List<Comment> dummy = new ArrayList<>();
        return dummy;  // @@@@@@@@@@@@@@@@@@@@@@@@@@@
    }

    @Override
    public List<Comment> getListOfComments() {
        List<Comment> cmtList = new ArrayList<>();
        try {
            cmtList = jdbcTemplate.query(SQL_GET_LIST_OF_COMMENTS, new CommentMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return cmtList;
    }

    @Override
    public int getHighestBlogCommentIdNumber() {
        int empty = 0;
        return empty; //@@@@@@@@@@@@@@@@@@@@@@
    }

    // @@@@@@@@@@@@@@@@@@@  STATIC PAGES @@@@@@@@@@@@@@@@@@@@@@@@   
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addStaticPage(StaticPage staticPage) {
        jdbcTemplate.update(SQL_INSERT_STATIC_PAGE,
                staticPage.getPageContent(),
                staticPage.getPageCreatorId(),
                staticPage.getPageTitle());
        staticPage.setStaticPageId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void deleteStaticPage(int staticPageId) {
        jdbcTemplate.update(SQL_DELETE_STATIC_PAGE, staticPageId);
    }

    @Override
    public void editStaticPage(StaticPage staticPage) {
        jdbcTemplate.update(SQL_UPDATE_STATIC_PAGE,
            staticPage.getPageContent(),
            staticPage.getPageCreatorId(),
            staticPage.getPageCreationDate(),
            staticPage.getPageTitle(),
            staticPage.getStaticPageId());
    }

    @Override
    public List<StaticPage> getListOfStaticPages() {
        return jdbcTemplate.query(SQL_GET_ALL_STATIC_PAGES, new StaticPageMapper());
    }

// @@@@@@@@@@@@@@@@@@@  BLOGS @@@@@@@@@@@@@@@@@@@@@@@@
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addBlog(Blog blog) {
        jdbcTemplate.update(SQL_INSERT_BLOG,
            blog.getBlogTitle(),
            //blog.getDate(),
            blog.getContent(),
            blog.getUserId(),
            blog.isApproved(),
            blog.isPublished());
        blog.setBlogId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        // contains unassigned hashtags and categories
        // iterate through list of blog's hashtag objects
        jdbcTemplate.update(SQL_DELETE_BLOG_HASHTAG_BY_BLOG_ID, blog.getBlogId());  // should not be necessary        
        for (Hashtag ht : blog.getHashList()) {
            String currentHashtag = ht.getHashtag();
            // if hashtag already exists, get id
            try {
                ht = jdbcTemplate.queryForObject(SQL_GET_HASHTAG_BY_HASHTAG, new HashtagMapper(), currentHashtag);

            } catch (EmptyResultDataAccessException e) {
                addHashtag(ht);
                jdbcTemplate.queryForObject(SQL_GET_HASHTAG_BY_HASHTAG, new HashtagMapper(), currentHashtag);
            }
            jdbcTemplate.update(SQL_INSERT_BLOG_HASHTAG, blog.getBlogId(), ht.getHashtagId());
        }
        jdbcTemplate.update(SQL_DELETE_BLOG_CATEGORY_BY_BLOG_ID, blog.getBlogId());  // should not be necessary         
        for (Category c : blog.getCatList()) {
            jdbcTemplate.update(SQL_INSERT_BLOG_CATEGORY, blog.getBlogId(), c.getCategoryId());  // addCategory gets a categoryId and loads blog_category_bridge
        }
    }

    @Override
    public void deleteBlog(int blogId) {
        jdbcTemplate.update(SQL_DELETE_BLOG_HASHTAG_BY_BLOG_ID, blogId);
        jdbcTemplate.update(SQL_DELETE_BLOG_CATEGORY_BY_BLOG_ID, blogId);
        jdbcTemplate.update(SQL_DELETE_COMMENT_BY_BLOG_ID, blogId); //Mike Adams, 6-28-15
        jdbcTemplate.update(SQL_DELETE_BLOG, blogId);
        // logical sequence - the blog_hashtag_bridge record(s) will be deleted
        // the blog_category_bridge record(s) will be deleted
        // the hashtag resord(s) will be deleted
        // will leave categot in place for now
        // delete the blog
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void editBlog(Blog blog) {
        // assume current list of hashtags is correct
        // delete blog_hashtag_bridge entries
        jdbcTemplate.update(SQL_DELETE_BLOG_HASHTAG_BY_BLOG_ID, blog.getBlogId());

        // add revised hashtag list into blog_hashtag_bridge
        for (Hashtag ht : blog.getHashList()) {
            String currentHashtag = ht.getHashtag();
            // if hashtag already exists, get id
            try {
                ht = jdbcTemplate.queryForObject(SQL_GET_HASHTAG_BY_HASHTAG, new HashtagMapper(), currentHashtag);
            } catch (EmptyResultDataAccessException e) {
                addHashtag(ht);
                jdbcTemplate.queryForObject(SQL_GET_HASHTAG_BY_HASHTAG, new HashtagMapper(), currentHashtag);
            }
            jdbcTemplate.update(SQL_INSERT_BLOG_HASHTAG, blog.getBlogId(), ht.getHashtagId());
        }

        jdbcTemplate.update(SQL_DELETE_BLOG_CATEGORY_BY_BLOG_ID, blog.getBlogId());  // will be necessary
        for (Category c : blog.getCatList()) {
            jdbcTemplate.update(SQL_INSERT_BLOG_CATEGORY, blog.getBlogId(), c.getCategoryId());  // addCategory gets a categoryId and loads blog_category_bridge
        }
        jdbcTemplate.update(SQL_UPDATE_BLOG, blog.getBlogTitle(), blog.getContent(), blog.getUserId(), blog.isPublished(), blog.isApproved(), blog.getBlogId());

        // logical sequence
        // use bridge table to get lists of hashtags and categories (objects) from the appropriate table
        // delete blog_hashtag_bridge record(s)
        // delete blog_category_bridge record(s)
        // add new hashtag or category to appropriate table Lookup (compare texts in the tables)
        // add hashtag(s) or category(ies) as needed to the lists
        // post the changed blog to the record
        // add the appropriate record(s) to the hashtag and category bridge tables
    }

    @Override
    public Blog getBlogById(int blogId) {
        Blog newBlog = new Blog();
        newBlog = jdbcTemplate.queryForObject(SQL_SELECT_BLOG_BY_BLOG_ID, new BlogMapper(), blogId);
        newBlog.setHashList(jdbcTemplate.query(SQL_GET_HASHTAGS_ASSOCIATED_WITH_BLOG_ID, new HashtagMapper(), blogId));
        newBlog.setCatList(jdbcTemplate.query(SQL_GET_CATEGORIES_ASSOCIATED_WITH_BLOG_ID_, new CategoryMapper(), blogId));
        newBlog.setComList(jdbcTemplate.query(SQL_GET_COMMENTS_ASSOCIATED_WITH_BLOG_ID_, new CommentMapper(), blogId));
        return newBlog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> blogList = new ArrayList<>();
        try {
            blogList = jdbcTemplate.query(SQL_SELECT_ALL_BLOGS, new BlogMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        for (Blog blg : blogList) {
            Blog newBlog = new Blog();
            newBlog.setHashList(jdbcTemplate.query(SQL_GET_HASHTAGS_ASSOCIATED_WITH_BLOG_ID, new HashtagMapper(), newBlog.getBlogId()));
            newBlog.setCatList(jdbcTemplate.query(SQL_GET_CATEGORIES_ASSOCIATED_WITH_BLOG_ID_, new CategoryMapper(), newBlog.getBlogId()));
            newBlog.setComList(jdbcTemplate.query(SQL_GET_COMMENTS_ASSOCIATED_WITH_BLOG_ID_, new CommentMapper(), newBlog.getBlogId()));
        }
        return blogList;
    }

    @Override
    public List<Blog> getBlogsByCategoryId(int categoryId) {
        List<Blog> blogCatList = new ArrayList<>();
        try {
            blogCatList = jdbcTemplate.query(SQL_GET_BLOGS_BY_CATEGORY_ID, new BlogMapper(), categoryId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        for (Blog blg : blogCatList) {
            Blog newBlog = new Blog();
            newBlog.setHashList(jdbcTemplate.query(SQL_GET_HASHTAGS_ASSOCIATED_WITH_BLOG_ID, new HashtagMapper(), newBlog.getBlogId()));
            newBlog.setCatList(jdbcTemplate.query(SQL_GET_CATEGORIES_ASSOCIATED_WITH_BLOG_ID_, new CategoryMapper(), newBlog.getBlogId()));
            newBlog.setComList(jdbcTemplate.query(SQL_GET_COMMENTS_ASSOCIATED_WITH_BLOG_ID_, new CommentMapper(), newBlog.getBlogId()));
        }
        return blogCatList;
    }

    @Override
    public List<Blog> getBlogsByHashtagId(int hashtagId) {
        List<Blog> blogHashList = new ArrayList<>();
        try {
            blogHashList = jdbcTemplate.query(SQL_GET_BLOGS_BY_HASHTAG_ID, new BlogMapper(), hashtagId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        for (Blog blg : blogHashList) {
            Blog newBlog = new Blog();
            newBlog.setHashList(jdbcTemplate.query(SQL_GET_HASHTAGS_ASSOCIATED_WITH_BLOG_ID, new HashtagMapper(), newBlog.getBlogId()));
            newBlog.setCatList(jdbcTemplate.query(SQL_GET_CATEGORIES_ASSOCIATED_WITH_BLOG_ID_, new CategoryMapper(), newBlog.getBlogId()));
            newBlog.setComList(jdbcTemplate.query(SQL_GET_COMMENTS_ASSOCIATED_WITH_BLOG_ID_, new CommentMapper(), newBlog.getBlogId()));
        }
        return blogHashList;
    }        // use to get list of hashtags associated with a blog - lookup in DB

    @Override
    public List<Blog> getPartialListOfBlogs(int blogId, int numBlogsDisplayed, boolean isUp
    ) {
        List<Blog> dummy = new ArrayList<>();
        return dummy;  // @@@@@@@@@@@@@@@@@@@@@@@@
    }

    @Override
    public int getHighestBlogIdNumber() {
        int empty = 0;
        return empty;  // @@@@@@@@@@@@@@@@@@@@

    }

    public static final class UserMapper implements ParameterizedRowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUserName(rs.getString("username"));
            user.setPasssWord(rs.getString("password"));
            user.setEnabled(rs.getBoolean("enabled"));
//            user.setUserRoleId(rs.getString("user_role_id"));
            return user;
        }
    }

    public static final class HashtagMapper implements ParameterizedRowMapper<Hashtag> {

        @Override
        public Hashtag mapRow(ResultSet rs, int i) throws SQLException {
            Hashtag hashtag = new Hashtag();
            hashtag.setHashtagId(rs.getInt("hashtag_id"));
            hashtag.setHashtag(rs.getString("hashtag"));
            return hashtag;
        }
    }

    public static final class CategoryMapper implements ParameterizedRowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setCategoryId(rs.getInt("category_id"));
            category.setCategory(rs.getString("category"));
            return category;
        }
    }

    public static final class BlogMapper implements ParameterizedRowMapper<Blog> {

        @Override
        public Blog mapRow(ResultSet rs, int i) throws SQLException {
            Blog blog = new Blog();
            blog.setBlogTitle(rs.getString("blog_title"));
            blog.setBlogId(rs.getInt("blog_id"));
            blog.setDate(rs.getDate("blog_date"));
            blog.setContent(rs.getString("blog_content"));
            blog.setUserId(rs.getInt("user_id"));
            blog.setPublished(rs.getBoolean("published"));
            blog.setApproved(rs.getBoolean("approved"));
            return blog;
        }
    }

    public static final class StaticPageMapper implements ParameterizedRowMapper<StaticPage> {

        @Override
        public StaticPage mapRow(ResultSet rs, int i) throws SQLException {
            StaticPage staticPage = new StaticPage();
            staticPage.setStaticPageId(rs.getInt("static_page_id"));
            staticPage.setPageContent(rs.getString("page_content"));
            staticPage.setPageCreatorId(rs.getInt("user_id"));
            staticPage.setPageCreationDate(rs.getDate("date_created"));
            staticPage.setPageTitle(rs.getString("page_title"));
            return staticPage;
        }
    }

    public static final class CommentMapper implements ParameterizedRowMapper<Comment> {

        @Override
        public Comment mapRow(ResultSet rs, int i) throws SQLException {
            Comment comment = new Comment();
            comment.setCmtBlogId(rs.getInt("comment_id"));
            comment.setComment(rs.getString("comment"));
            comment.setUserId(rs.getInt("user_id"));
            comment.setCmtBlogId(rs.getInt("blog_id"));
            return comment;
        }
    }
}
