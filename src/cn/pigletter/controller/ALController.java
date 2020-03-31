package cn.pigletter.controller;

import cn.pigletter.model.Article;
import cn.pigletter.model.Leetcode;
import cn.pigletter.service.ArticleService;
import cn.pigletter.service.LeetcodeService;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ALController {
    @Autowired
    ArticleService articleService;

    @Autowired
    LeetcodeService leetcodeService;

    /*
    控制台
     */
    @RequestMapping("/console")
    public ModelAndView getconsole(){
        ModelAndView mv = new ModelAndView("admin/console");
        mv.addObject("articles",articleService.selectArticles());
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
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
    public ModelAndView add(Article article){
        ModelAndView mv;
        mv = new ModelAndView("articles");
        articleService.insertArticle(article);
        mv.addObject("articles",articleService.selectArticles());
        return mv;
    }

    @PutMapping("/article")
    public ModelAndView update(Article article){
        ModelAndView mv;
        mv = new ModelAndView("articles");
        articleService.updateArticle(article);
        mv.addObject("articles",articleService.selectArticles());
        return mv;
    }

    @GetMapping("/article")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView("articles");
        mv.addObject("articles",articleService.selectArticles());
        return mv;
    }


    @DeleteMapping("/article")
    public ModelAndView delete(int article_id){
        ModelAndView mv = new ModelAndView("/admin/console");
        articleService.deleteArticleByID(article_id);
        mv.addObject("articles",articleService.selectArticles());
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        return mv;
    }


    /*
    ====================================================================================================================
     以下是leetcode
     */
    @GetMapping("/leetcode")
    public ModelAndView showleetcode(){
        ModelAndView mv = new ModelAndView("leetcodes");
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        return mv;
    }

    @PutMapping("/leetcode")
    public ModelAndView updateleetcode(Leetcode leetcode){
        ModelAndView mv = new ModelAndView("leetcodes");
        leetcodeService.updateLeetcode(leetcode);
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        return mv;
    }

    @PostMapping("/leetcode")
    public ModelAndView addleetcode(Leetcode leetcode){
        ModelAndView mv = new ModelAndView("leetcodes");
        leetcodeService.insertLeetcode(leetcode);
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        return mv;
    }

    @DeleteMapping("/leetcode")
    public ModelAndView deleteleetcode(int leetcode_id){
        ModelAndView mv = new ModelAndView("admin/console");
        leetcodeService.deleteLeetcodeByID(leetcode_id);
        mv.addObject("articles",articleService.selectArticles());
        mv.addObject("leetcodes",leetcodeService.selectLeetcodes());
        return mv;
    }



}