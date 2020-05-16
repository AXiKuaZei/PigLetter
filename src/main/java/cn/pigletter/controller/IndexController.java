package cn.pigletter.controller;

import cn.pigletter.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    @RequestMapping({"/","index"})
    public ModelAndView getconsole(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("articles",articleService.selectArticlesPage(0,7));
        return mv;
    }
}
