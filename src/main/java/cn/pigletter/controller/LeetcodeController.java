package cn.pigletter.controller;

import cn.pigletter.model.Leetcode;
import cn.pigletter.service.LeetcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LeetcodeController {
    @Autowired
    LeetcodeService leetcodeService;

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
        ModelAndView mv = new ModelAndView("redirect:/leetcode");
        leetcodeService.updateLeetcode(leetcode);
        return mv;
    }

    @PostMapping("/leetcode")
    public ModelAndView addleetcode(Leetcode leetcode){
        ModelAndView mv = new ModelAndView("redirect:/leetcode");
        leetcodeService.insertLeetcode(leetcode);
        return mv;
    }

    @DeleteMapping("/leetcode")
    public String deleteleetcode(int leetcode_id){
        leetcodeService.deleteLeetcodeByID(leetcode_id);
        return "redirect:/admin/console";
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

    @ResponseBody
    @DeleteMapping("/leetcodeMulti")
    public List<Leetcode> delete(@RequestBody Integer[] article_id, HttpServletRequest req){

        for(Integer i:article_id){
            leetcodeService.deleteLeetcodeByID(i);
        }
        List<Leetcode> leetcodes= leetcodeService.selectLeetcodesPage(0,5);
        req.setAttribute("lpg",1);
        return leetcodes;
    }
}
