package cn.pigletter.controller;

import cn.pigletter.model.User;
import cn.pigletter.service.ArticleService;
import cn.pigletter.service.LeetcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/*")
public class ConsoleController {
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

}
