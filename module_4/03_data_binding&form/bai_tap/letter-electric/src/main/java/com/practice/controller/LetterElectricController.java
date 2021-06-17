package com.practice.controller;

import com.practice.model.base.LetterElectric;
import com.practice.model.service.ILetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LetterElectricController {
    @Autowired
    ILetterService iLetterService;
    @RequestMapping("")
    public ModelAndView showMainPage(Model model){
        List<String> listLanguage = iLetterService.getListLanguage();
        List<Integer> listPageSize = iLetterService.getListPageSize();
        model.addAttribute("listLanguage",listLanguage);
        model.addAttribute("listPageSize",listPageSize);
        return new ModelAndView("main","letter",new LetterElectric());
    }
    @PostMapping("/update")
    public String update(@ModelAttribute LetterElectric letter, Model model){
        model.addAttribute("letter",letter);
        return "info";
    }
}
