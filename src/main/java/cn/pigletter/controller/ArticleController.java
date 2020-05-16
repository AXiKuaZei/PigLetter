package cn.pigletter.controller;

import cn.pigletter.model.Article;
import cn.pigletter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /*
    ====================================================================================================================
     以下是article
     */

    @PostMapping("/article")
    public ModelAndView add(Article article, HttpServletRequest request){
        ModelAndView mv;
        mv = new ModelAndView("redirect:/article");
        articleService.insertArticle(article);
        return mv;
    }

    @PutMapping("/article")
    public ModelAndView update(Article article){
        ModelAndView mv;
        mv = new ModelAndView("redirect:/article");
        articleService.updateArticle(article);
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
        return "redirect:/admin/console";
    }


    @DeleteMapping("/article/{article_id}")
    public void deleteA(@PathVariable("article_id") int article_id){
        articleService.deleteArticleByID(article_id);
    }


    @DeleteMapping("/articleMulti")
    public String delete(@RequestBody Integer[] article_id){
        for(Integer i:article_id){
            articleService.deleteArticleByID(i);
        }
        return "redirect:/admin/console";
    }

}
