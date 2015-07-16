/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.group3capstone.dao;

import com.swcguild.group3capstone.model.Blog;
import com.swcguild.group3capstone.model.Comment;
import com.swcguild.group3capstone.model.Hashtag;
import com.swcguild.group3capstone.model.User;
import com.swcguild.group3capstone.model.Category;
import com.swcguild.group3capstone.model.StaticPage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.aspectj.util.ConfigParser;

/**
 *
 * @author Jim
 */
public class Group3CapstoneInMemImpl implements Group3CapstoneInterface {

    private Map<Integer, User> userMap = new HashMap<>();
    private Map<Integer, Hashtag> hashtagMap = new HashMap<>();
    private Map<Integer, Comment> commentMap = new HashMap<>();
    private Map<Integer, Blog> blogMap = new HashMap<>();
    private Map<Integer, Category> categoryMap = new HashMap<>();
    private Map<Integer, StaticPage> staticPageMap = new HashMap<>();

    int userCounter = 1;
    int blogCounter = 1;
    int hashtagCounter = 1;
    int commentCounter = 1;
    int categoryCounter = 1;
    int staticPageCounter = 1;
//

    public Group3CapstoneInMemImpl() throws Exception {
        Hashtag h1;
        Hashtag h2;
        Hashtag h3;
        Category c1;
        Category c2;
        Category c3;
        Comment cm1;
        Comment cm2;
        Comment cm3;
        Blog b1;
        Blog b2;
        Blog b3;
        StaticPage s1;
        StaticPage s2;
        StaticPage s3;
        Date myDate = null;

        h1 = new Hashtag();
        h1.setHashtag("#Happy");

        h2 = new Hashtag();
        h2.setHashtag("#Sad");

        h3 = new Hashtag();
        h3.setHashtag("#Mad");

        c1 = new Category();
        c1.setCategory("Propaganda");

        c2 = new Category();
        c2.setCategory("Sale");

        c3 = new Category();
        c3.setCategory("Puppies");

//        b1 = new Blog();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDate = df.parse("2015-01-01");
        } catch (ConfigParser.ParseException e) {
        }
//        b1.setBlogTitle("Fire");
//        b1.setDate(myDate);
//        b1.setContent("Lorem ipsum dolor sit amet, homero putant eleifend te eos, sea ei ceteros legendos "
//                + "prodesset. Usu causae propriae petentium id. Ubique interesset vis ei, velit ignota omnium "
//                + "no pri. No est odio nostrud senserit, cu minim temporibus duo. Clita vidisse minimum et eam, "
//                + "mea ei eruditi debitis, possim melius elaboraret vim in. Ei duo posse tantas contentiones, "
//                + "quis audiam scribentur nec ad, qui eu officiis lobortis oportere.");
//        b1.setUserId(1);
//        b1.setApproved(true);
//        b1.setPublished(true);
//        b1.setBlogId(blogCounter++);
//        blogMap.put(b1.getBlogId(), b1);
//        
//        b2 = new Blog();
//        try {
//            myDate = df.parse("2015-06-11");
//        } catch (ConfigParser.ParseException e) {
//        }
//        b2.setBlogTitle("Ice");        
//        b2.setDate(myDate);
//        b2.setContent("Vis tantas possit invenire id. Est eu esse duis nemore, id clita vocibus pro. Ea soleat "
//                + "persius concludaturque est, no novum denique qui. Sed in munere denique. Pro eu inani quidam. "
//                + "Ne nisl nostrum sed, at dolorem cotidieque quo, te legimus inimicus nam.");
//        b2.setUserId(1);
//        b2.setApproved(true);
//        b2.setPublished(true);
//        b2.setBlogId(blogCounter++);
//        blogMap.put(b2.getBlogId(), b2);
//
//        b3 = new Blog();
//        try {
//            myDate = df.parse("2015-10-03");
//        } catch (ConfigParser.ParseException e) {
//        }
//        b3.setBlogTitle("Earth");        
//        b3.setDate(myDate);
//        b3.setContent("Solum nonumes omittam his an, diam mucius graeci mea ei. Nec cu fuisset albucius indoctum, "
//                + "an sea vide assentior, ne nam nihil aeterno aperiri. Eos ut sint menandri imperdiet, et mei "
//                + "dolor vitae utroque. Doctus scripserit liberavisse eos ea.");
//        b3.setUserId(1);
//        b3.setApproved(true);
//        b3.setPublished(true);
//        b3.setBlogId(blogCounter++);
//        blogMap.put(b3.getBlogId(), b3);

        cm1 = new Comment();
        cm1.setComment("Bacon ipsum dolor amet pork belly pork loin picanha rump shank meatball. "
                + "Drumstick alcatra ball tip, flank pancetta strip steak meatball prosciutto t-bone "
                + "corned beef sirloin spare ribs andouille meatloaf shankle. Short ribs ribeye alcatra "
                + "ground round chicken salami, bresaola pork chop jerky porchetta turkey shank sausage "
                + "ball tip kielbasa. Pig capicola shank landjaeger pork beef ribs sausage tail andouille, "
                + "corned beef pastrami filet mignon. Biltong leberkas pork belly, turducken ground round alcatra "
                + "pig corned beef flank kevin frankfurter shoulder bresaola.");
        cm1.setUserId(1);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDate = df.parse("2015-01-01");
        } catch (ConfigParser.ParseException e) {
        }
        cm1.setCommentDate(myDate);
        cm1.setCmtBlogId(1);

        cm2 = new Comment();
        cm2.setComment("Rump short ribs shoulder prosciutto, pork belly andouille meatball venison. "
                + "Cow ball tip salami spare ribs flank, shank alcatra boudin. Pancetta meatloaf jowl "
                + "frankfurter tail jerky swine. Beef ribs ribeye ham pig shoulder cupim beef pancetta "
                + "chicken ham hock pork loin bresaola sirloin kevin shankle. Bacon brisket porchetta "
                + "tri-tip kevin tail landjaeger rump ham hock. Pork belly tail filet mignon prosciutto "
                + "flank meatloaf tenderloin pig turducken ham hock brisket t-bone short ribs..");
        cm2.setUserId(1);
        try {
            myDate = df.parse("2015-01-01");
        } catch (ConfigParser.ParseException e) {
        }
        cm2.setCommentDate(myDate);
        cm2.setCmtBlogId(1);

        cm3 = new Comment();
        cm3.setComment("Beef ribs strip steak pork flank porchetta landjaeger pastrami ribeye meatloaf. "
                + "Ham hock prosciutto fatback short ribs pork loin, shank shankle flank turducken brisket "
                + "pork meatloaf kevin frankfurter t-bone. Sausage rump flank ham hock salami corned beef, "
                + "bresaola chuck tenderloin. Frankfurter cow shankle pork spare ribs. Shank pastrami prosciutto "
                + "swine doner drumstick ball tip picanha landjaeger shankle hamburger. Andouille chicken tongue "
                + "sirloin, venison ball tip strip steak tenderloin corned beef prosciutto.");
        cm3.setUserId(1);
        try {
            myDate = df.parse("2015-03-01");
        } catch (ConfigParser.ParseException e) {
        }
        cm3.setCommentDate(myDate);
        cm3.setCmtBlogId(1);

        // **********STATIC PAGE SET UP ***********
        s1 = new StaticPage();
        try {
            myDate = df.parse("2015-04-04");
        } catch (ConfigParser.ParseException e) {
        }
        s1.setPageCreationDate(myDate);
        s1.setPageContent("<p> Ouch </p>");
        s1.setPageCreatorId(2);

        s2 = new StaticPage();
        try {
            myDate = df.parse("2014-10-10");
        } catch (ConfigParser.ParseException e) {
        }
        s2.setPageCreationDate(myDate);
        s2.setPageContent("<p> Over the moon </p>");
        s2.setPageCreatorId(1);

        s3 = new StaticPage();
        try {
            myDate = df.parse("2015-07-07");
        } catch (ConfigParser.ParseException e) {
        }
        s3.setPageCreationDate(myDate);
        s3.setPageContent("<p> Lemmings are fun </p>");
        s3.setPageCreatorId(1);
    }

    //    USERS

    @Override
    public void addUser(User user) {
        user.setUserId(userCounter);
        userCounter++;
        userMap.put(blogCounter, user);
    }

    @Override
    public void deleteUser(int userId) {
        userMap.remove(userId);
    }

    @Override
    public void editUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    @Override
    public List<User> getListOfUsers() {
        Collection<User> u = userMap.values();
        return new ArrayList(u);
    }

    // --------------   BLOGS  --------------------
    @Override
    public void addBlog(Blog blog) {
        blog.setBlogId(blogCounter);
        blogMap.put(blogCounter, blog);
        blogCounter++;
    }

    @Override
    public List<Blog> getPartialListOfBlogs(int startBlogId, int numBlogsDisplayed, boolean isUp) {
        //  FEED startBlogId as 1 to n  The method compensates for the true index number
        //  Added at request of pproject leader 22-Jun-2015 from email dated 18-Jun-2015
        List<Blog> nL = new ArrayList<>();
        List<Blog> workPartial = getAllBlogs();

        if (isUp) {
            for (int i = 0; i < numBlogsDisplayed; i++) {
                nL.add(workPartial.get(i + startBlogId - 1));
                return nL;
            }
        } else {
            for (int i = 0; i < numBlogsDisplayed; i++) {
                nL.add(workPartial.get(startBlogId - (i + 1)));
            }
        }
        return nL;
        // project lead requirement for segmented lists of blog posts, starting blogId, number of blogs in list, durection of display
    }

    @Override
    public void deleteBlog(int blogId) {
        blogMap.remove(blogId);
    }

    @Override
    public void editBlog(Blog blog) {
        blogMap.put(blog.getBlogId(), blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        Collection<Blog> b = blogMap.values();
        return new ArrayList(b);
    }

    @Override
    public Blog getBlogById(int blogId) {
        return blogMap.get(blogId);   // use to get approved and published booleans
    }

    @Override
    public List<Blog> getBlogsByHashtagId(int hashtagId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   // use to get list of blogs associated with a hashtag - reverse lookup in bridge table in DB

    @Override
    public List<Blog> getBlogsByCategoryId(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  // use to get list of blogs associated with a category - reverse lookup in bridge table in DB

    @Override
    public int getHighestBlogIdNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // --------------   HASHTAGS   --------------------
    @Override
    public void addHashtag(Hashtag hashtag, int blogId) {
        hashtag.setHashtagId(hashtagCounter);
        hashtagMap.put(hashtagCounter, hashtag);
        hashtagCounter++;
    }

    @Override
    public void addHashtag(Hashtag hashtag) {
        hashtag.setHashtagId(hashtagCounter);
        hashtagMap.put(hashtagCounter, hashtag);
        hashtagCounter++;
    }

    @Override
    public void deleteHashtag(int hashtagId) {
        hashtagMap.remove(hashtagId);
    }

    @Override
    public void editHashtag(Hashtag hashtag) {
        hashtagMap.put(hashtag.getHashtagId(), hashtag);
    }

    @Override
    public List<Hashtag> getListOfHashtags() {
        Collection<Hashtag> h = hashtagMap.values();
        return new ArrayList(h);  // list of all available hashtags
    }

    @Override
    public List<Hashtag> getListOfHashtagsByBlogId(int blogId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // use to get list of hashtags associated with a blog - lookup in bridge table in DB
    }

    //   --------------- CATEGORIES   ----------------
    @Override
    public void addCategory(Category category, int blogId) {
        category.setCategoryId(categoryCounter);
        categoryMap.put(categoryCounter, category);
        categoryCounter++;
    }

    @Override
    public void addCategory(Category category) {
        category.setCategoryId(categoryCounter);
        categoryMap.put(categoryCounter, category);
        categoryCounter++;
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryMap.remove(categoryId);
    }

    @Override
    public void editCategory(Category category) {
        categoryMap.put(category.getCategoryId(), category);
    }

    @Override
    public List<Category> getListOfCategories() {
        Collection<Category> cat = categoryMap.values();
        return new ArrayList(cat);  //  list of all categories
    }

    @Override
    public List<Category> getListOfCategoriesByBlogId(int blogId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // use to get list of hashtags associated with a blog - lookup in bridge table in DB
    }

    // --------------------  COMMENTS  -----------------------
    @Override
    public void addBlogComment(Comment comment, int blogId) {
        comment.setCommentId(commentCounter);
        commentMap.put(commentCounter, comment);
        commentCounter++;
    }

    @Override
    public void deleteBlogComment(int commentId) {
        commentMap.remove(commentId);
    }

    @Override
    public void editBlogComment(Comment comment) {
        commentMap.put(comment.getCommentId(), comment);
    }

    @Override
    public List<Comment> getBlogCommentsByBlogId(int blogId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // use to get list of hashtags associated with a blog - lookup in bridge table in DB
    }

    @Override
    public List<Comment> getListOfComments() {
        Collection<Comment> cmt = commentMap.values();
        return new ArrayList(cmt);  //  list of all categories
    }

    @Override
    public int getHighestBlogCommentIdNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //  ***************  STATIC PAGES ***************
    @Override
    public void addStaticPage(StaticPage staticPage) {
        staticPage.setStaticPageId(staticPageCounter);
        staticPageMap.put(staticPageCounter, staticPage);
        staticPageCounter++;
    }

    @Override
    public void deleteStaticPage(int staticPageId) {
        staticPageMap.remove(staticPageId);
    }

    @Override
    public void editStaticPage(StaticPage staticPage) {
        staticPageMap.put(staticPage.getStaticPageId(), staticPage);
    }

    @Override
    public List<StaticPage> getListOfStaticPages() {
        Collection<StaticPage> sp = staticPageMap.values();
        return new ArrayList(sp);  //  list of all categories
    }

    @Override
    public Category getCategoryById(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hashtag getHashtagById(int hashtagId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
