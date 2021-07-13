package com.example.exampletest.controller;

import com.example.exampletest.model.service.IProductService;
import com.example.exampletest.model.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    IProductTypeService productTypeService;
    @GetMapping("/customers")
    public String show(){
        return "list";
    }
    @GetMapping("/")
    public String showList(@PageableDefault(value = 7) Pageable pageable, @RequestParam("manufacture")Optional<String> from,
                           @RequestParam("used") Optional<String> to, @RequestParam(value = "type",required = false) Integer id, Model model){
        String keyFrom = "";
        String keyTo = "";
        Integer keyType = null;
//        Integer  = "";
//        String keyFrom = "";
        model.addAttribute("typeList",this.productTypeService.findAdd());
        if(from.isPresent() && to.isPresent() && !from.get().equals("") && !to.get().equals("")){
            keyFrom = from.get();
            keyTo = to.get();
            keyType = id;
            model.addAttribute("productList",this.productService.findDateAndType(keyFrom,keyTo,keyType,pageable));
        }else if(to.isPresent() && !to.get().equals("") && from.get().equals("")) {
            keyTo = to.get();
            keyType = id;
            model.addAttribute("productList",this.productService.findDateUsed(keyTo,keyType,pageable));
        }else if(from.isPresent()  && !from.get().equals("") && to.get().equals("")){
            keyFrom = from.get();
            keyType = id;
            model.addAttribute("productList",this.productService.findDateManufature(keyFrom,keyType,pageable));
        }else if (from.isPresent() && to.isPresent() && from.get().equals("") && to.get().equals("")){
            keyType = id;
            model.addAttribute("productList",this.productService.findAllType(id,pageable));
        }else {
            model.addAttribute("productList",this.productService.findAll(keyFrom,keyTo,keyType,pageable));
        }

        model.addAttribute("keyFrom",keyFrom);
        model.addAttribute("keyTo",keyTo);
        model.addAttribute("keyType",keyType);
        return "index";


    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer[]> checkbox){
        Integer[] checkBox ;
        if(checkbox.isPresent()){
            checkBox = checkbox.get();
            for(int i = 0 ; i < checkBox.length ; i++){
                this.productService.delete(checkBox[i]);
            }
        }
        return "redirect:/";
    }

    @GetMapping("/view")
    public String showView(@RequestParam int id,Model model){
        model.addAttribute("data",this.productService.showProduct(id));
        return "index";
    }
}
