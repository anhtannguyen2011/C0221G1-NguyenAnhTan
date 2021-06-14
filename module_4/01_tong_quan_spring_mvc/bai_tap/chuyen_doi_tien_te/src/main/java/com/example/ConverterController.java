package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/")
    public String showIndex(){
        return "index";
    }
    @PostMapping("/converter")
    public String convert(@RequestParam int usd, Model model){
        int vnd = usd * 23000;
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "converter";
    }
}
