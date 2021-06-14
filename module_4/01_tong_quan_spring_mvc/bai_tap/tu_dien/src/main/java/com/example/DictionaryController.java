package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String showForm(){
        return "index";
    }
    @PostMapping("dictionary")
    public String translate(@RequestParam String search, Model model){
        Map<String,String> dicMap = new HashMap<>();
        dicMap.put("Hello","Xin Chào");
        dicMap.put("Red","Đỏ");
        dicMap.put("Yellow","Vàng");
        dicMap.put("Thanks","Cảm ơn");
        String result = dicMap.get(search);
        if(result == null){
            model.addAttribute("message","Not found");
            return "index";
        }else {
            model.addAttribute("result",result);
            return "dictionary";
        }
    }
}
