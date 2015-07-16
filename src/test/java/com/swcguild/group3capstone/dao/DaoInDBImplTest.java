//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.swcguild.group3capstone.dao;
//
//import com.swcguild.group3capstone.model.Category;
//import com.swcguild.group3capstone.model.Hashtag;
//import com.swcguild.group3capstone.model.User;
//import java.util.List;
//import static junit.framework.TestCase.assertEquals;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author Jim
// */
//public class DaoInDBImplTest {
//
//    private Group3CapstoneInterface dao;
//
//    public DaoInDBImplTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//
//        ApplicationContext ctx
//                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//
//        dao = (Group3CapstoneInterface) ctx.getBean("Group3CapstoneInterface");
//
//        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        cleaner.execute("delete from hashtags");
//
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    @Test
//    public void HashtagReadWriteTest() {
//        // single Hashtag tests --------------------
//        Hashtag h4 = new Hashtag();
//        h4.setHashtag("Orange");
//        dao.addHashtag(h4);
//
//        List<Hashtag> hlist = dao.getListOfHashtags();
//        assertEquals(1, hlist.size());
//        assertEquals(h4.getHashtag(), hlist.get(0).getHashtag());
//
//        dao.deleteHashtag(hlist.get(0).getHashtagId());
//        List<Hashtag> hlist2 = dao.getListOfHashtags();
//        assertEquals(0, hlist2.size());
//
//        //  ---------------  multiple hashtags added -------------
//        Hashtag h1 = new Hashtag();
//        h1.setHashtag("Happy");
//        dao.addHashtag(h1);
//        List<Hashtag> hlist3 = dao.getListOfHashtags();
//        assertEquals(h1.getHashtag(), hlist3.get(0).getHashtag());
//        assertEquals(h1.getHashtagId(), hlist3.get(0).getHashtagId());
//
//        Hashtag h2 = new Hashtag();
//        h2.setHashtag("Sad");
//        dao.addHashtag(h2);
//        List<Hashtag> hlist3a = dao.getListOfHashtags();
////        System.out.println("Index# 0 " + hlist3a.get(0).getHashtagId());
////        System.out.println("Index of hashtags " + hlist3a.get(0).getHashtag()); 
////        System.out.println("Index# 1 " + hlist3a.get(1).getHashtagId());       
////        System.out.println("Index of hashtags " + hlist3a.get(1).getHashtag());
//        assertEquals(h1.getHashtag(), hlist3a.get(0).getHashtag());
//        assertEquals(h1.getHashtagId(), hlist3a.get(0).getHashtagId());
//        assertEquals(h2.getHashtag(), hlist3a.get(1).getHashtag());
//        assertEquals(h2.getHashtagId(), hlist3a.get(1).getHashtagId());
//        assertEquals(2, hlist3a.size());
//
//        Hashtag h3 = new Hashtag();
//        h3.setHashtag("Mad");
//        dao.addHashtag(h3);
//        List<Hashtag> hlist3b = dao.getListOfHashtags();
//
////       Hashtags are returned by Index (sorted by Hashtag)
//        assertEquals(3, hlist3b.size());
//
//        h3.setHashtag("Monkey");
//        dao.editHashtag(h3);
//
//        List<Hashtag> hlist4 = dao.getListOfHashtags();
//
////        System.out.println("Index# 0 " + hlist4.get(0).getHashtagId());
////        System.out.println("Index of hashtags " + hlist4.get(0).getHashtag()); 
////        System.out.println("Index# 1 " + hlist4.get(1).getHashtagId());       
////        System.out.println("Index of hashtags " + hlist4.get(1).getHashtag());
////        System.out.println("Index# 2 " + hlist4.get(2).getHashtagId());       
////        System.out.println("Index of hashtags " + hlist4.get(2).getHashtag());        
//        assertEquals(h1.getHashtag(), hlist4.get(0).getHashtag());
//        assertEquals(h1.getHashtagId(), hlist4.get(0).getHashtagId());
//        assertEquals(h2.getHashtag(), hlist4.get(2).getHashtag());
//        assertEquals(h2.getHashtagId(), hlist4.get(2).getHashtagId());
//        assertEquals(h3.getHashtag(), hlist4.get(1).getHashtag());
//        assertEquals(h3.getHashtag(), hlist4.get(1).getHashtag());
//
//        dao.deleteHashtag(h3.getHashtagId());
//        List<Hashtag> hlist5 = dao.getListOfHashtags();
////        System.out.println("Index# 0 " + hlist5.get(0).getHashtagId());        
////        System.out.println("Index of hashtags " + hlist5.get(0).getHashtag()); 
////        System.out.println("Index# 1 " + hlist5.get(1).getHashtagId());       
////        System.out.println("Index of hashtags " + hlist5.get(1).getHashtag());        
//        assertEquals(2, hlist5.size());
//        assertEquals(h1.getHashtag(), hlist5.get(0).getHashtag());
//        assertEquals(h2.getHashtag(), hlist5.get(1).getHashtag());
//    }
//    
//     @Test
//     public void UserReadWriteTest() {
// //         single Category tests --------------------
////
////        User u4 = new User();
////        u4.setUserName("JimmyJohns");
////        u4.setPasssWord("Camelopardalis");
////        u4.setEnabled(Boolean.TRUE);
////        dao.addUser(u4);    
////        
////        List<User> ulist = dao.getListOfUsers();
//// //         Note test and test2 users exist in the table with links to authorities        
////        assertEquals(3, ulist.size());
////        assertEquals(u4.getUserId(), ulist.get(0).getUserId());
////        assertEquals(u4.getUserName(), ulist.get(0).getUserName());
////        assertEquals(u4.getPasssWord(), ulist.get(0).getPasssWord());
////        assertEquals(u4.getEnabled(), ulist.get(0).getEnabled());
////        
////        dao.deleteUser(u4.getUserId());
////        List<User> ulist2 = dao.getListOfUsers();
////        assertEquals(0, ulist2.size());        
//
////    @Test
////    public void CategoryReadWriteTest() {
//////         single Category tests --------------------
////        Category c1 = new Category();
////        c1.setCategory("Propaganda");
////
////        Category c2 = new Category();
////        c2.setCategory("Sale");
////        
////        Category c3 = new Category();
////        c3.setCategory("Puppies");
////
////        Category c4 = new Category();
////        c4.setCategory("These Prices Are INSANE!");
////        dao.addCategory(c4);    
////        
////        List<Category> hlist = dao.getListOfCategories();
////        assertEquals(1, hlist.size());
////        assertEquals(c4.getCategory(), hlist.get(0).getCategory());
////
////        dao.deleteCategory(1);
////        List<Category> clist2 = dao.getListOfCategories();
////        assertEquals(0, clist2.size());
////
////        //  ---------------  multiple Category added -------------
////
////                User u1 = new User();
////        u1.setUserName("BillJohnson");
////        u1.setPasssWord("Blowfish");
////        u1.setEnabled(Boolean.TRUE);
////
////        User u2 = new User();
////        u1.setUserName("HowardJohnson");
////        u1.setPasssWord("Stingray");
////        u1.setEnabled(Boolean.TRUE);
////        
////        User u3 = new User();
////        u1.setUserName("JimmyJohnson");
////        u1.setPasssWord("Carp123");
////        u1.setEnabled(Boolean.FALSE);
//        
////        List<Category> clist3 = dao.getListOfCategories();
////
////        assertEquals(3, clist3.size());
////        assertTrue(c1.getCategory() == clist3.get(0).getCategory());
////        assertTrue(c2.getCategory() == clist3.get(1).getCategory());
////        assertTrue(c3.getCategory() == clist3.get(2).getCategory());
////
////        c3.setCategory("Monkey");
////        dao.editCategory(c3);
////
////        List<Category> clist4 = dao.getListOfCategories();
////        assertTrue(c3.getCategory() == clist4.get(2).getCategory());
////
////        dao.deleteCategory(3);
////        List<Category> clist5 = dao.getListOfCategories();
////        assertEquals(2, clist5.size());
////        assertTrue(c1.getCategory() == clist5.get(0).getCategory());
////        assertTrue(c3.getCategory() == clist5.get(1).getCategory());
//    }
//}
//
