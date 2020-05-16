package cn.pigletter.controller;

import cn.pigletter.model.Article;
import cn.pigletter.model.Leetcode;
import cn.pigletter.model.User;
import cn.pigletter.service.ArticleService;
import cn.pigletter.service.LeetcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



public class ALController {
    @Autowired
    ArticleService articleService;

    @Autowired
    LeetcodeService leetcodeService;

    /*
    控制台
     */
    @RequestMapping("/console")
    public ModelAndView getconsole(@RequestParam(value = "apg",defaultValue="1") int apg, @RequestParam(value = "lpg",defaultValue="1") int lpg, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("admin/console");
//        文章
//        mv.addObject("articles",articleService.selectArticlesPage(5*(apg-1),5));
//        mv.addObject("apages",articleService.selectArticlesPageNum(5));
        User user= (User)request.getSession().getAttribute("user");
        mv.addObject("articles",articleService.selectArticlesPageUser(5*(apg-1),5,user.getUser_id()));
        mv.addObject("apages",articleService.selectArticlesPageNumUser(5,user.getUser_id()));
        mv.addObject("apg",apg);
//        力扣
        mv.addObject("leetcodes",leetcodeService.selectLeetcodesPage(5*(lpg-1),5));
        mv.addObject("lpages",leetcodeService.selectLeetcodesPageNum(5));
        mv.addObject("lpg",lpg);
        return mv;
    }

    @RequestMapping("/articleAdd")
    public ModelAndView getArticle(){
        ModelAndView mv = new ModelAndView("admin/articleAdd");
        return mv;
    }

    @RequestMapping("/articleAdd/{id}")
    public ModelAndView getArticleID(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("admin/articleAdd");
        mv.addObject("article",articleService.selectArticleByID(id));
        return mv;
    }

    @RequestMapping("/leetcodeAdd")
    public ModelAndView getLeetcode(){
        ModelAndView mv = new ModelAndView("admin/leetcodeAdd");
        return mv;
    }

    @RequestMapping("/leetcodeAdd/{id}")
    public ModelAndView getLeetcodeID(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("admin/leetcodeAdd");
        mv.addObject("leetcode",leetcodeService.selectLeetcodeByID(id));
        return mv;
    }
    /*
    ====================================================================================================================
     以下是article
     */

    @PostMapping("/article")
    public ModelAndView add(Article article, HttpServletRequest request){
        ModelAndView mv;
        mv = new ModelAndView("redirect:/article");
        articleService.insertArticle(article);
//        mv.addObject("articles",articleService.selectArticles());
//        mv.addObject("apages",articleService.selectArticlesPageNum(5));
        return mv;
    }

    @PutMapping("/article")
    public ModelAndView update(Article article){
        ModelAndView mv;
        mv = new ModelAndView("redirect:/article");
        articleService.updateArticle(article);
//        mv.addObject("articles",articleService.selectArticles());
//        mv.addObject("apages",articleService.selectArticlesPageNum(5));
        return mv;
    }

    @GetMapping("/article")
    public ModelAndView show(@RequestParam(value = "apg",defaultValue="1") int apg){
        ModelAndView mv = new ModelAndView("articles");
//        mv.addObject("articles",articleService.selectArticles());
        mv.addObject("articles",articleService.selectArticlesPage(5*(apg-1),5));
        mv.addObject("apages",articleService.selectArticlesPageNum(5));
        mv.addObject("apg",apg);
        return mv;
    }


    @DeleteMapping("/article")
    public String delete(int article_id){
        articleService.deleteArticleByID(article_id);
        return "redirect:/console";
    }


    /*
    ====================================================================================================================
     以下是leetcode
     */
    @GetMapping("/leetcode")
    public ModelAndView showleetcode(@RequestParam(value = "lpg",defaultValue="1") int lpg){
        ModelAndView mv = new ModelAndView("leetcodes");
//        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        mv.addObject("leetcodes",leetcodeService.selectLeetcodesPage(5*(lpg-1),5));
        mv.addObject("lpages",leetcodeService.selectLeetcodesPageNum(5));
        mv.addObject("lpg",lpg);
        return mv;
    }

    @PutMapping("/leetcode")
    public ModelAndView updateleetcode(Leetcode leetcode){
        ModelAndView mv = new ModelAndView("leetcodes");
        leetcodeService.updateLeetcode(leetcode);
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        mv.addObject("lpages",leetcodeService.selectLeetcodesPageNum(5));
        return mv;
    }

    @PostMapping("/leetcode")
    public ModelAndView addleetcode(Leetcode leetcode){
        ModelAndView mv = new ModelAndView("leetcodes");
        leetcodeService.insertLeetcode(leetcode);
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        mv.addObject("lpages",leetcodeService.selectLeetcodesPageNum(5));
        return mv;
    }

    @DeleteMapping("/leetcode")
    public String deleteleetcode(int leetcode_id){
        leetcodeService.deleteLeetcodeByID(leetcode_id);
        return "redirect:/console";
    }

    //========================================================================
    //page-ajax-leetcodes

    @ResponseBody
    @RequestMapping("/ooo")
    public List<Leetcode> getleetcodes(@RequestParam(value = "lpg",defaultValue="1") int lpg, HttpServletRequest req){
        List<Leetcode> leetcodes= leetcodeService.selectLeetcodesPage(5*(lpg-1),5);
        req.setAttribute("lpg",lpg);
        return leetcodes;
    }

}