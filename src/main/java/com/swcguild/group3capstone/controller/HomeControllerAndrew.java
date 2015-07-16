package com.swcguild.group3capstone.controller;

import com.swcguild.group3capstone.dao.Group3CapstoneInterface;
import com.swcguild.group3capstone.model.Blog;
import com.swcguild.group3capstone.model.Category;
import com.swcguild.group3capstone.model.Hashtag;
import com.swcguild.group3capstone.model.StaticPage;
import com.swcguild.group3capstone.model.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author andrew
 */
@Controller

public class HomeControllerAndrew {

    private Group3CapstoneInterface blogDAO;
    Blog blog;

    @Inject
    public HomeControllerAndrew(Group3CapstoneInterface dao) {
        this.blogDAO = dao;

    }

    // This method will be invoked by Spring MVC when it sees a request for
    // ContactListMVC/index.
    @RequestMapping(value = {"/mainPage"}, method = RequestMethod.GET)
    public String displayMainAjaxPage(Model model) {
        // This method does nothing except return the logical name of the 
        // view component (/jsp/home.jsp) that should be invoked in response
        // to this request.
        //Mike Adams: need to filter out unpublished/unapproved blogs (marketing, saved drafts)
        List<Blog> allBlogs = blogDAO.getAllBlogs();
        List<Blog> pubBlogs = new ArrayList<>();

        for (int i = 0; i < allBlogs.size(); i++) {
            if (allBlogs.get(i).isPublished()) {
                pubBlogs.add(allBlogs.get(i));
            }
        }
        model.addAttribute("blogList", pubBlogs);

        /**
         * ********** Mike Adams, Static page functionality code********
         */
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());
        /**
         * ************************************************************
         */
        return "mainPage";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = "AddBlog", method = RequestMethod.GET)
    public String addBlog(HttpServletRequest req, Model model) {
        model.addAttribute("categoryList", blogDAO.getListOfCategories());
        model.addAttribute("hashtagList", blogDAO.getListOfHashtags());
        return "AddBlog";
    }

//    @RequestMapping(value = "post", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createBlog(@RequestBody Blog blog) {
//
//        blogDAO.addBlog(blog);
//
//    }
    @RequestMapping(value = "AddBlog2", method = RequestMethod.POST)
    public String newEntry(HttpServletRequest req, Model model) {
        String y = req.getParameter("title");
        String x = req.getParameter("text");
        String z = req.getParameter("hashtags");
        String[] vals = req.getParameterValues("category");
        int a = Integer.parseInt(req.getParameter("userId"));

        /**
         * *Mike Adams: Submit for approval or publish according to user ******
         */
        boolean b = Boolean.parseBoolean(req.getParameter("published"));
        boolean c = Boolean.parseBoolean(req.getParameter("approved"));

        // Assume user role indicators as follows: 0=visitor, 1=marketing, 2=admin
        int userRole = a;//blogDAO.getListOfUsers().get(a).getUserRoleId();
        if (userRole == 2) {
            b = true;
            c = true;
        } else if (userRole == 1) {
            // b determined by req.getParameter("published")
            c = false;
        }

        /**
         * *******************************************************************
         */
        List<Category> catList = new ArrayList<>();

        if (vals == null) {
            return "redirect:AddBlog";
        }

        for (int i = 0; i < vals.length; i++) {
            Category cat = new Category();
            cat.setCategoryId(Integer.parseInt(vals[i]));
            catList.add(cat);
        }

        if (z != null && z.length() == 0) {
            return "redirect:AddBlog";
        }
        if (y != null && y.length() == 0) {
            return "redirect:AddBlog";
        }
        if (x != null && x.length() == 0) {
            return "redirect:AddBlog";
        }

        z = z.trim();
        String[] tags = z.split(",");
        List<Hashtag> hashList = new ArrayList<>();
        for (int i = 0; i < tags.length; i++) {
            if (tags[i].contains("\r\n") == false) {
                Hashtag tag = new Hashtag();
//                blogDAO.addHashtag(tag);
                tag.setHashtag(tags[i]);
//            tag.setHashtagId(i);
                hashList.add(tag);

            }

        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        Blog blog = new Blog();
        blog.setBlogTitle(y);
        blog.setContent(x);
        blog.setHashList(hashList);
        blog.setCatList(catList);
        blog.setUserId(a);
        blog.setPublished(b);
        blog.setApproved(c);
//        blog.setDate(dateFormat.format(cal.getTime()));
//        blog.setCatList(vals);
        //blog.setHashList(null);
//        

        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("hashList", hashList);
        model.addAttribute("catList", catList);
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);
        blogDAO.addBlog(blog);
        model.asMap().clear();

        return "redirect:mainPage";
    }

    @RequestMapping(value = "ReadBlog", method = RequestMethod.GET)
    public String ReadBlog() {
        return "mainPage";
    }

    @RequestMapping(value = "Admin1", method = RequestMethod.GET)
    public String Admin1() {
        return "Admin1";
    }

    @RequestMapping(value = "Admin2", method = RequestMethod.GET)
    public String Admin2() {
        return "Admin2";
    }

    @RequestMapping(value = {"EachBlog/{id}"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String EachBlog(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogDAO.getBlogById(id));
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());

        return "EachBlog";
    }

    @RequestMapping(value = "/PubBlogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getPubBlogs() {
        //return blogDAO.getAllBlogs();  //Mike Adams: replacing with publish filtering
        List<Blog> allBlogs = blogDAO.getAllBlogs();
        List<Blog> pubBlogs = new ArrayList<>();

        for (int i = 0; i < allBlogs.size(); i++) {
            if (allBlogs.get(i).isPublished()) {
                pubBlogs.add(allBlogs.get(i));
            }
        }

        return pubBlogs;
    }

    @RequestMapping(value = "/Blogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getAllBlogs() {
        return blogDAO.getAllBlogs();  //Mike Adams: replacing with publish filtering

    }

    @RequestMapping(value = "/Categories", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategories() {
        return blogDAO.getListOfCategories();
    }

    @RequestMapping(value = "/Hashtags", method = RequestMethod.GET)
    @ResponseBody
    public List<Hashtag> getAllTags() {
        return blogDAO.getListOfHashtags();
    }

    @RequestMapping(value = "/Category", method = RequestMethod.GET)
    public String addCategory() {
        return "addCategory";
    }

    @RequestMapping(value = "/Category", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void addCategory(@RequestBody Category category) {
//        String x = req.getParameter("category");
//        
//        category = new Category();
//        category.setCategory(x);
//        model.addAttribute("x", x);
        blogDAO.addCategory(category);
    }

    @RequestMapping(value = "/hashTag", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addTag(HttpServletRequest req, Model model, @RequestBody Hashtag hashtag) {

        blogDAO.addHashtag(hashtag);

    }

//    @RequestMapping(value="EachBlog/cat?categoryId={id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public String displayCat(HttpServletRequest req, Model model){
//        int id = Integer.parseInt(req.getParameter("id"));
//        
//        return "mainPage";
//    }
    @RequestMapping(value = "/EachBlog/cat", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String catSearch(HttpServletRequest req, Model model) {
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String x = "All blogs associated with category:";

        List<Blog> allBlogs = blogDAO.getBlogsByCategoryId(categoryId);
        List<Blog> pubBlogs = new ArrayList<>();

        for (int i = 0; i < allBlogs.size(); i++) {
            if (allBlogs.get(i).isPublished()) {
                pubBlogs.add(allBlogs.get(i));
            }
        }

        model.addAttribute("blogList", pubBlogs);

        model.addAttribute("category", blogDAO.getCategoryById(categoryId));
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());
        model.addAttribute("x", x);
        return "mainPage";

    }

    @RequestMapping(value = "/EachBlog/tag", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String tagSearch(HttpServletRequest req, Model model) {
        int hashtagId = Integer.parseInt(req.getParameter("hashtagId"));
        String y = "All blogs associated with hashtag: #";
        //model.addAttribute("blogList", blogDAO.getBlogsByHashtagId(hashtagId));

        List<Blog> allBlogs = blogDAO.getBlogsByHashtagId(hashtagId);
        List<Blog> pubBlogs = new ArrayList<>();

        for (int i = 0; i < allBlogs.size(); i++) {
            if (allBlogs.get(i).isPublished()) {
                pubBlogs.add(allBlogs.get(i));
            }
        }

        model.addAttribute("blogList", pubBlogs);

        model.addAttribute("hashtag", blogDAO.getHashtagById(hashtagId));
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());
        model.addAttribute("y", y);
        return "mainPage";
    }

    @RequestMapping(value = "/Category/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable("id") int id) {
        blogDAO.deleteCategory(id);
    }

    @RequestMapping(value = "/Blog/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable("id") int id) {
        blogDAO.deleteBlog(id);
    }

    @RequestMapping(value = "/EditBlog/{id}", method = RequestMethod.POST)
    public String editBlog(@PathVariable("id") int id, @ModelAttribute Blog blog, HttpServletRequest req, Model model) {

        String y = req.getParameter("title");
        String x = req.getParameter("text");
        String z = req.getParameter("hashtags");
        String[] vals = req.getParameterValues("category");
        if (vals == null) {
            model.addAttribute("blog", blogDAO.getBlogById(id));
            model.addAttribute("categoryList", blogDAO.getListOfCategories());
            model.addAttribute("hashtagList", blogDAO.getListOfHashtags());

            return "EditBlog";
        }
        List<Category> catList = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            Category cat = new Category();
            cat.setCategoryId(Integer.parseInt(vals[i]));
            catList.add(cat);
        }

        if (y != null && y.length() == 0) {
            model.addAttribute("blog", blogDAO.getBlogById(id));
            model.addAttribute("categoryList", blogDAO.getListOfCategories());
            model.addAttribute("hashtagList", blogDAO.getListOfHashtags());

            return "EditBlog";
        }
        if (x != null && x.length() == 0) {
            model.addAttribute("blog", blogDAO.getBlogById(id));
            model.addAttribute("categoryList", blogDAO.getListOfCategories());
            model.addAttribute("hashtagList", blogDAO.getListOfHashtags());

            return "EditBlog";
        }
        if (z != null && z.length() == 0) {
            model.addAttribute("blog", blogDAO.getBlogById(id));
            model.addAttribute("categoryList", blogDAO.getListOfCategories());
            model.addAttribute("hashtagList", blogDAO.getListOfHashtags());

            return "EditBlog";
        }
        z = z.trim();
        String[] tags = z.split(",");
        List<Hashtag> hashList = new ArrayList<>();
        for (int i = 0; i < tags.length; i++) {

            tags[i] = tags[i].trim();
            if (tags[i].contains("\r\n") == false) {
                Hashtag tag = new Hashtag();
                tag.setHashtag(tags[i]);
//            tag.setHashtagId(i);
                hashList.add(tag);
            }

        }

        blog.setUserId(2); // this is hard-wiring.  Should be pulled from model
        blog.setBlogTitle(y);
        blog.setContent(x);
        blog.setHashList(hashList);
        blog.setCatList(catList);
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("hashList", hashList);
        model.addAttribute("catList", catList);
        blog.setBlogId(id);
        blogDAO.editBlog(blog);

        model.asMap().clear();

        return "redirect:/Admin1";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String backToIndex() {
        return "mainPage";
    }

    @RequestMapping(value = "/EditBlog/{id}", method = RequestMethod.GET)
    public String goToEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogDAO.getBlogById(id));
        model.addAttribute("categoryList", blogDAO.getListOfCategories());
        model.addAttribute("hashtagList", blogDAO.getListOfHashtags());
        return "EditBlog";
    }

    @RequestMapping(value = "/AdminStaticPage", method = RequestMethod.GET)
    public String adminStaticPage(HttpServletRequest req, Model model) {
        return "AdminStaticPage";
    }

    @RequestMapping(value = "/CreateStaticPage", method = RequestMethod.GET)
    public String createStaticPage(HttpServletRequest req, Model model) {

        return "AddStaticPage";
    }

    @RequestMapping(value = "/AddStaticPage", method = RequestMethod.POST)
    public String addStaticPage(HttpServletRequest req, Model model) {
        /**
         * ********** Mike Adams, Static page functionality code********
         */
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());
        /**
         * ************************************************************
         */

        StaticPage staticPage = new StaticPage();
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Calendar cal = Calendar.getInstance();
         staticPage.setPageCreationDate(dateFormat.format(cal.getTime()));*/
        String staticPageContent = req.getParameter("pageContentText");
        String staticPageTitle = req.getParameter("title");
        if (staticPageContent != null && staticPageContent.length() == 0) {
            return "AddStaticPage";
        }
        if (staticPageTitle != null && staticPageTitle.length() == 0) {
            return "AddStaticPage";
        }
        staticPage.setPageContent(staticPageContent);
        staticPage.setPageTitle(staticPageTitle);
        staticPage.setPageCreatorId(1);
        staticPage.setStaticPageId(staticPage.getStaticPageId());

        model.addAttribute("staticPage", staticPage);

        blogDAO.addStaticPage(staticPage);

        return "AdminStaticPage";
    }

    @RequestMapping(value = "/ReadStaticPage/{id}", method = RequestMethod.GET)
    public String readStaticPage(@PathVariable("id") int staticPageId, HttpServletRequest req, Model model) {
        /**
         * ********** Mike Adams, Static page functionality code********
         */
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());
        /**
         * ************************************************************
         */
        List<StaticPage> pageList = blogDAO.getListOfStaticPages();
        StaticPage page = new StaticPage();
        /*List<StaticPage> pages = pageList.stream()
         .filter(page -> 
         {return page.getStaticPageId() == staticPageId;
         })
         .collect(Collectors.toList());
         StaticPage page = pages.get(0);*/

        for (int i = 0; i < pageList.size(); i++) {
            if (pageList.get(i).getStaticPageId() == staticPageId) {
                page = pageList.get(i);
            }
        }

        model.addAttribute("staticPage", page);

        return "ReadStaticPage";
    }

    @RequestMapping(value = "EditStaticPage/{id}", method = RequestMethod.GET)
    public String editStaticPage(@PathVariable("id") int staticPageId, HttpServletRequest req, Model model) {

        /**
         * ********** Mike Adams, Static page functionality code********
         */
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());
        /**
         * ************************************************************
         */
        List<StaticPage> pageList = blogDAO.getListOfStaticPages();
        StaticPage page = new StaticPage();
        String pageTitle = "";
        int pageCreatorId = 0;
        /*List<StaticPage> pages = pageList.stream()
         .filter(page -> 
         {return page.getStaticPageId() == staticPageId;
         })
         .collect(Collectors.toList());
         */
        for (int i = 0; i < pageList.size(); i++) {
            if (pageList.get(i).getStaticPageId() == staticPageId) {
                page = pageList.get(i);
                pageCreatorId = page.getPageCreatorId();
            }
        }

        model.addAttribute("pageCreatorId", pageCreatorId);
        model.addAttribute("staticPage", page);

        return "EditStaticPage";
    }

    @RequestMapping(value = "EditStaticPage/{id}", method = RequestMethod.POST)
    public String updateStaticPage(@PathVariable("id") int staticPageId, @ModelAttribute("staticPage") StaticPage updatedPage, Model model, HttpServletRequest req) {

        /**
         * ********** Mike Adams, Static page functionality code********
         */
        model.addAttribute("staticPageList", blogDAO.getListOfStaticPages());
        /**
         * ************************************************************
         */
        List<StaticPage> pages = blogDAO.getListOfStaticPages();
        StaticPage page = new StaticPage();
        int pageCreatorId = 0;

        //updatedPage = pages.get(staticPageId);
        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).getStaticPageId() == staticPageId) {
                page = pages.get(i);
                pageCreatorId = page.getPageCreatorId();
            }
        }
        updatedPage.setPageTitle(req.getParameter("title"));

        updatedPage.setPageCreatorId(pageCreatorId);
        updatedPage.setStaticPageId(staticPageId);
        blogDAO.editStaticPage(updatedPage);

        return "redirect:/AdminStaticPage";
    }

    @RequestMapping(value = "StaticPages", method = RequestMethod.GET)
    @ResponseBody
    public List<StaticPage> getAllStaticPages() {
        return blogDAO.getListOfStaticPages();
    }

    @RequestMapping(value = "StaticPage/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStaticPage(@PathVariable("id") int id) {
        blogDAO.deleteStaticPage(id);  // deletes according to Map key, not List index
    }

    @RequestMapping(value = "MarketingBlogs", method = RequestMethod.GET)
    @ResponseBody
    public List getMarketingBlogs() {

        List<Blog> allBlogs = blogDAO.getAllBlogs();
        List<Blog> marketBlogs = new ArrayList<>();

        for (int i = 0; i < allBlogs.size(); i++) {
            if (allBlogs.get(i).isApproved() == false && allBlogs.get(i).isPublished() == false) {
                marketBlogs.add(allBlogs.get(i));
            }
        }
        //model.addAttribute("blogList", marketBlogs); 

        return marketBlogs;
    }

    @RequestMapping(value = "SavedDrafts", method = RequestMethod.GET)
    @ResponseBody
    public List getSavedDrafts() {

        List<Blog> allBlogs = blogDAO.getAllBlogs();
        List<Blog> savedDrafts = new ArrayList<>();

        for (int i = 0; i < allBlogs.size(); i++) {
            if (allBlogs.get(i).isApproved() == true && allBlogs.get(i).isPublished() == false) {
                savedDrafts.add(allBlogs.get(i));
            }
        }

        return savedDrafts;
    }

    @RequestMapping(value = "publish/{id}/{status}", method = RequestMethod.GET)
    public String publish(@PathVariable("id") int id, @PathVariable("status") boolean status) {

        Blog blog = blogDAO.getBlogById(id);
        blog.setPublished(status);
        blogDAO.editBlog(blog);
        return "AdminStaticPage";
    }
}
