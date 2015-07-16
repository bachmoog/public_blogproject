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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import org.aspectj.util.ConfigParser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jim
 */
public class DaoInMemImplTest {

    private Group3CapstoneInterface dao;
    private Hashtag h1;
    private Hashtag h2;
    private Hashtag h3;
    private Category c1;
    private Category c2;
    private Category c3;
    private Comment cm1;
    private Comment cm2;
    private Comment cm3;
    private Blog b1;
    private Blog b2;
    private Blog b3;
    private StaticPage s1;
    private StaticPage s2;
    private StaticPage s3;
    Date myDate;

    public DaoInMemImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws java.text.ParseException {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("blogDAO", Group3CapstoneInterface.class);

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

        b1 = new Blog();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDate = df.parse("2015-01-01");
        } catch (ParseException e) {
        }
        b1.setBlogTitle("Title b1");
        b1.setDate(myDate);
        b1.setContent("Lorem ipsum dolor sit amet, homero putant eleifend te eos, sea ei ceteros legendos "
                + "prodesset. Usu causae propriae petentium id. Ubique interesset vis ei, velit ignota omnium "
                + "no pri. No est odio nostrud senserit, cu minim temporibus duo. Clita vidisse minimum et eam, "
                + "mea ei eruditi debitis, possim melius elaboraret vim in. Ei duo posse tantas contentiones, "
                + "quis audiam scribentur nec ad, qui eu officiis lobortis oportere.");
        b1.setUserId(1);
        b1.setApproved(true);
        b1.setPublished(true);

        b2 = new Blog();
        try {
            myDate = df.parse("2015-06-11");
        } catch (ParseException e) {
        }
        b2.setBlogTitle("Title b2");
        b2.setDate(myDate);
        b2.setContent("Vis tantas possit invenire id. Est eu esse duis nemore, id clita vocibus pro. Ea soleat "
                + "persius concludaturque est, no novum denique qui. Sed in munere denique. Pro eu inani quidam. "
                + "Ne nisl nostrum sed, at dolorem cotidieque quo, te legimus inimicus nam.");
        b2.setUserId(1);
        b2.setApproved(true);
        b2.setPublished(true);

        b3 = new Blog();
        try {
            myDate = df.parse("2015-10-03");
        } catch (ParseException e) {
        }
        b3.setBlogTitle("Title b3");
        b3.setDate(myDate);
        b3.setContent("Solum nonumes omittam his an, diam mucius graeci mea ei. Nec cu fuisset albucius indoctum, "
                + "an sea vide assentior, ne nam nihil aeterno aperiri. Eos ut sint menandri imperdiet, et mei "
                + "dolor vitae utroque. Doctus scripserit liberavisse eos ea.");
        b3.setUserId(1);
        b3.setApproved(true);
        b3.setPublished(true);

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
        } catch (ParseException e) {
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
        } catch (ParseException e) {
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
        } catch (ParseException e) {
        }
        cm3.setCommentDate(myDate);
        cm3.setCmtBlogId(1);

        // **********STATIC PAGE SET UP ***********
        s1 = new StaticPage();
        try {
            myDate = df.parse("2015-04-04");
        } catch (ParseException e) {
        }
        s1.setPageCreationDate(myDate);
        s1.setPageContent("<p> Ouch </p>");
        s1.setPageCreatorId(2);

        s2 = new StaticPage();
        try {
            myDate = df.parse("2014-10-10");
        } catch (ParseException e) {
        }
        s2.setPageCreationDate(myDate);
        s2.setPageContent("<p> Over the moon </p>");
        s2.setPageCreatorId(1);

        s3 = new StaticPage();
        try {
            myDate = df.parse("2015-07-07");
        } catch (ParseException e) {
        }
        s3.setPageCreationDate(myDate);
        s3.setPageContent("<p> Lemmings are fun </p>");
        s3.setPageCreatorId(1);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void HashtagReadWriteTest() {
        // single Hashtag tests --------------------
        Hashtag h4 = new Hashtag();
        h4.setHashtag("Purple");

        dao.addHashtag(h4, 1);

        List<Hashtag> hlist = dao.getListOfHashtags();
        assertEquals(1, hlist.size());
        assertTrue(h4.getHashtag() == hlist.get(0).getHashtag());

        dao.deleteHashtag(1);
        List<Hashtag> hlist2 = dao.getListOfHashtags();
        assertEquals(0, hlist2.size());

        //  ---------------  multiple hashtags added -------------
        dao.addHashtag(h1, 1);
        dao.addHashtag(h2, 2);
        dao.addHashtag(h3, 1);

        List<Hashtag> hlist3 = dao.getListOfHashtags();

        assertEquals(3, hlist3.size());
        assertTrue(h1.getHashtag() == hlist3.get(0).getHashtag());
        assertTrue(h2.getHashtag() == hlist3.get(1).getHashtag());
        assertTrue(h3.getHashtag() == hlist3.get(2).getHashtag());

        h3.setHashtag("#Monkey");
        dao.editHashtag(h3);

        List<Hashtag> hlist4 = dao.getListOfHashtags();
        assertTrue(h3.getHashtag() == hlist4.get(2).getHashtag());

        dao.deleteHashtag(3);
        List<Hashtag> hlist5 = dao.getListOfHashtags();
        assertEquals(2, hlist5.size());
        assertTrue(h1.getHashtag() == hlist5.get(0).getHashtag());
        assertTrue(h3.getHashtag() == hlist5.get(1).getHashtag());
    }

    @Test
    public void CategoryReadWriteTest() {
        // single Hashtag tests --------------------
        Category c4 = new Category();
        c4.setCategory("These Prices Are INSANE!");

        dao.addCategory(c4, 1);

        List<Category> hlist = dao.getListOfCategories();
        assertEquals(1, hlist.size());
        assertTrue(c4.getCategory() == hlist.get(0).getCategory());

        dao.deleteCategory(1);
        List<Category> clist2 = dao.getListOfCategories();
        assertEquals(0, clist2.size());

        //  ---------------  multiple hashtags added -------------
        dao.addCategory(c1, 1);
        dao.addCategory(c2, 2);
        dao.addCategory(c3, 1);

        List<Category> clist3 = dao.getListOfCategories();

        assertEquals(3, clist3.size());
        assertTrue(c1.getCategory() == clist3.get(0).getCategory());
        assertTrue(c2.getCategory() == clist3.get(1).getCategory());
        assertTrue(c3.getCategory() == clist3.get(2).getCategory());

        c3.setCategory("Monkey");
        dao.editCategory(c3);

        List<Category> clist4 = dao.getListOfCategories();
        assertTrue(c3.getCategory() == clist4.get(2).getCategory());

        dao.deleteCategory(3);
        List<Category> clist5 = dao.getListOfCategories();
        assertEquals(2, clist5.size());
        assertTrue(c1.getCategory() == clist5.get(0).getCategory());
        assertTrue(c3.getCategory() == clist5.get(1).getCategory());
    }

    @Test
    public void CommentsReadWriteTest() throws java.text.ParseException {
        // single Hashtag tests --------------------
        Comment cm4 = new Comment();
        cm4 = new Comment();
        cm4.setComment("Meatloaf meatball sirloin prosciutto turkey. Fatback pig bresaola, pancetta "
                + "sirloin short ribs brisket ham hock alcatra turducken. Prosciutto short loin kevin "
                + "jerky, doner strip steak t-bone alcatra short ribs cow sausage brisket ham jowl "
                + "porchetta. Rump salami cow shank. Andouille beef ribs frankfurter drumstick brisket "
                + "strip steak sirloin landjaeger jerky pig. Doner swine pig spare ribs hamburger. "
                + "Beef chicken shankle sirloin bacon beef ribs ham drumstick salami cupim.");
        cm4.setUserId(1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDate = df.parse("2014-01-01");
        } catch (ParseException e) {
        }
        cm4.setCommentDate(myDate);
        cm4.setCmtBlogId(1);

        dao.addBlogComment(cm4, 1);

        List<Comment> cmtList = dao.getListOfComments();
        assertTrue(cm4.getComment() == cmtList.get(0).getComment());
        assertTrue(cm4.getCmtBlogId() == cmtList.get(0).getCmtBlogId());
        assertTrue(cm4.getUserId() == cmtList.get(0).getUserId());
        assertTrue(cm4.getCommentDate() == cmtList.get(0).getCommentDate());

        dao.deleteBlogComment(1);
        List<Comment> cmList2 = dao.getListOfComments();
        assertEquals(0, cmList2.size());

        //  ---------------  multiple hashtags added -------------
        dao.addBlogComment(cm1, 1);
        dao.addBlogComment(cm2, 2);
        dao.addBlogComment(cm3, 1);

        List<Comment> cmList3 = dao.getListOfComments();

        assertEquals(3, cmList3.size());
        assertTrue(cm1.getComment() == cmList3.get(0).getComment());
        assertTrue(cm1.getCmtBlogId() == cmList3.get(0).getCmtBlogId());
        assertTrue(cm1.getUserId() == cmList3.get(0).getUserId());
        assertTrue(cm1.getCommentDate() == cmList3.get(0).getCommentDate());

        assertTrue(cm2.getComment() == cmList3.get(1).getComment());
        assertTrue(cm2.getCmtBlogId() == cmList3.get(1).getCmtBlogId());
        assertTrue(cm2.getUserId() == cmList3.get(1).getUserId());
        assertTrue(cm2.getCommentDate() == cmList3.get(1).getCommentDate());

        assertTrue(cm3.getComment() == cmList3.get(2).getComment());
        assertTrue(cm3.getCmtBlogId() == cmList3.get(2).getCmtBlogId());
        assertTrue(cm3.getUserId() == cmList3.get(2).getUserId());
        assertTrue(cm3.getCommentDate() == cmList3.get(2).getCommentDate());

        cm2.setComment("Fatback pig bresaola, pancetta "
                + "sirloin short ribs brisket ham hock alcatra turducken. Prosciutto short loin kevin "
                + "jerky, doner strip steak t-bone alcatra short ribs cow sausage brisket ham jowl "
                + "porchetta. Rump salami cow shank. Andouille beef ribs frankfurter drumstick brisket "
                + "strip steak sirloin landjaeger jerky pig. ");
        dao.editBlogComment(cm2);

        List<Comment> cmList4 = dao.getListOfComments();
        assertTrue(cm3.getComment() == cmList4.get(2).getComment());

        dao.deleteBlogComment(3);
        List<Comment> cmList5 = dao.getListOfComments();
        assertEquals(2, cmList5.size());

        assertTrue(cm1.getComment() == cmList5.get(0).getComment());
        assertTrue(cm1.getCmtBlogId() == cmList5.get(0).getCmtBlogId());
        assertTrue(cm1.getUserId() == cmList5.get(0).getUserId());
        assertTrue(cm1.getCommentDate() == cmList5.get(0).getCommentDate());

        assertTrue(cm3.getComment() == cmList5.get(1).getComment());
        assertTrue(cm3.getCmtBlogId() == cmList5.get(1).getCmtBlogId());
        assertTrue(cm3.getUserId() == cmList5.get(1).getUserId());
        assertTrue(cm3.getCommentDate() == cmList5.get(1).getCommentDate());
    }

    @Test
    public void BlogReadWriteTest() throws java.text.ParseException {
        // single Hashtag tests --------------------
        Blog b4 = new Blog();
        b4 = new Blog();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDate = df.parse("2015-01-01");
        } catch (ParseException e) {
        }
        b4.setBlogTitle("Title b4");
        b4.setDate(myDate);
        b4.setContent("Solum nonumes omittam his an, diam mucius graeci mea ei. Nec cu fuisset albucius indoctum, "
                + "an sea vide assentior, ne nam nihil aeterno aperiri. Eos ut sint menandri imperdiet, et mei "
                + "dolor vitae utroque. Doctus scripserit liberavisse eos ea.");
        b4.setUserId(1);
        b4.setApproved(true);
        b4.setPublished(false);

        dao.addBlog(b4);

        List<Blog> blist = dao.getAllBlogs();
        assertEquals(1, blist.size());
        assertTrue(b4.getBlogId() == blist.get(0).getBlogId());
        assertTrue(b4.getBlogTitle() == blist.get(0).getBlogTitle());
        assertTrue(b4.getContent() == blist.get(0).getContent());
        assertTrue(b4.getDate() == blist.get(0).getDate());
        assertTrue(b4.getUserId() == blist.get(0).getUserId());
        assertTrue(b4.isApproved() == blist.get(0).isApproved());
        assertTrue(b4.isPublished() == blist.get(0).isPublished());

        dao.deleteBlog(1);
        List<Blog> blist2 = dao.getAllBlogs();
        assertEquals(0, blist2.size());

        //  ---------------  multiple blogs added -------------
        dao.addBlog(b1);
        dao.addBlog(b2);
        dao.addBlog(b3);

        List<Blog> blist3 = dao.getAllBlogs();

        assertEquals(3, blist3.size());

        assertTrue(b1.getBlogId() == blist3.get(0).getBlogId());
        assertTrue(b1.getBlogTitle() == blist.get(0).getBlogTitle());
        assertTrue(b1.getContent() == blist3.get(0).getContent());
        assertTrue(b1.getDate() == blist3.get(0).getDate());
        assertTrue(b1.getUserId() == blist3.get(0).getUserId());
        assertTrue(b1.isApproved() == blist3.get(0).isApproved());
        assertTrue(b1.isPublished() == blist3.get(0).isPublished());

        assertTrue(b2.getBlogId() == blist3.get(1).getBlogId());
        assertTrue(b2.getBlogTitle() == blist.get(0).getBlogTitle());
        assertTrue(b2.getContent() == blist3.get(1).getContent());
        assertTrue(b2.getDate() == blist3.get(1).getDate());
        assertTrue(b2.getUserId() == blist3.get(1).getUserId());
        assertTrue(b2.isApproved() == blist3.get(1).isApproved());
        assertTrue(b2.isPublished() == blist3.get(1).isPublished());

        assertTrue(b3.getBlogId() == blist3.get(2).getBlogId());
        assertTrue(b3.getBlogTitle() == blist.get(0).getBlogTitle());
        assertTrue(b3.getContent() == blist3.get(2).getContent());
        assertTrue(b3.getDate() == blist3.get(2).getDate());
        assertTrue(b3.getUserId() == blist3.get(2).getUserId());
        assertTrue(b3.isApproved() == blist3.get(2).isApproved());
        assertTrue(b3.isPublished() == blist3.get(2).isPublished());

        b3.setContent("Space, the final frontier.  These are the voyages of the Starship Enterprise.  "
                + "It's 5 year mission, to explore stragne new worlds, to seekout new life and new civilizations.  "
                + "To boldly go where no man has gone before.");
        b3.setPublished(true);
        dao.editCategory(c3);

        List<Blog> blist4 = dao.getAllBlogs();
        assertTrue(b3.getContent() == blist4.get(2).getContent());
        assertTrue(b3.getBlogTitle() == blist4.get(2).getBlogTitle());
        assertTrue(b3.isPublished() == blist4.get(2).isPublished());

        dao.deleteBlog(3);
        List<Blog> clist5 = dao.getAllBlogs();
        assertEquals(2, clist5.size());
        assertTrue(b1.getContent() == clist5.get(0).getContent());
        assertTrue(b3.getContent() == clist5.get(1).getContent());
    }

    @Test
    public void StaticPageReadWriteTest() throws java.text.ParseException {
        // single Hashtag tests --------------------
        StaticPage s4 = new StaticPage();
        s4 = new StaticPage();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDate = df.parse("2015-03-03");
        } catch (ParseException e) {
        }
        s4.setPageCreationDate(myDate);
        s4.setPageContent("<p> The quick brown for </p>");
        s4.setPageCreatorId(1);

        dao.addStaticPage(s4);

        List<StaticPage> stList = dao.getListOfStaticPages();
        assertEquals(1, stList.size());
        assertTrue(s4.getStaticPageId() == stList.get(0).getStaticPageId());
        assertTrue(s4.getPageContent() == stList.get(0).getPageContent());
        assertTrue(s4.getPageCreationDate() == stList.get(0).getPageCreationDate());
        assertTrue(s4.getPageCreatorId() == stList.get(0).getPageCreatorId());

        dao.deleteStaticPage(1);
        List<StaticPage> stList2 = dao.getListOfStaticPages();
        assertEquals(0, stList2.size());
//
////        //  ---------------  multiple blogs added -------------
        dao.addStaticPage(s1);
        dao.addStaticPage(s2);
        dao.addStaticPage(s3);

        List<StaticPage> stList3 = dao.getListOfStaticPages();

        assertEquals(3, stList3.size());

        assertTrue(s1.getStaticPageId() == stList3.get(0).getStaticPageId());
        assertTrue(s1.getPageContent() == stList3.get(0).getPageContent());
        assertTrue(s1.getPageCreationDate() == stList3.get(0).getPageCreationDate());
        assertTrue(s1.getPageCreatorId() == stList3.get(0).getPageCreatorId());

        assertTrue(s2.getStaticPageId() == stList3.get(1).getStaticPageId());
        assertTrue(s2.getPageContent() == stList3.get(1).getPageContent());
        assertTrue(s2.getPageCreationDate() == stList3.get(1).getPageCreationDate());
        assertTrue(s2.getPageCreatorId() == stList3.get(1).getPageCreatorId());

        assertTrue(s3.getStaticPageId() == stList3.get(2).getStaticPageId());
        assertTrue(s3.getPageContent() == stList3.get(2).getPageContent());
        assertTrue(s3.getPageCreationDate() == stList3.get(2).getPageCreationDate());
        assertTrue(s3.getPageCreatorId() == stList3.get(2).getPageCreatorId());

        s3.setPageContent("Space, the final frontier.  These are the voyages of the Starship Enterprise.  "
                + "It's 5 year mission, to explore stragne new worlds, to seekout new life and new civilizations.  "
                + "To boldly go where no man has gone before.");
        dao.editStaticPage(s3);

        List<StaticPage> stList4 = dao.getListOfStaticPages();
        assertTrue(s3.getPageContent() == stList4.get(2).getPageContent());

        dao.deleteStaticPage(3);
        List<StaticPage> stList5 = dao.getListOfStaticPages();
        assertEquals(2, stList5.size());
        assertTrue(s1.getPageContent() == stList5.get(0).getPageContent());
        assertTrue(s3.getPageContent() == stList5.get(1).getPageContent());
    }

}
