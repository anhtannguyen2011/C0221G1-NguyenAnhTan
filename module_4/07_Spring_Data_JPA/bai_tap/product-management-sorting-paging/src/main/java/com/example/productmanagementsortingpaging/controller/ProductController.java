package com.example.productmanagementsortingpaging.controller;

import com.example.productmanagementsortingpaging.model.entity.Product;
import com.example.productmanagementsortingpaging.model.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    IProductService productServiceImpl;

    @RequestMapping("/")
    public ModelAndView showList(@PageableDefault(value = 3)Pageable pageable,
                                 @RequestParam(value = "searchProduct") Optional<String> nameSearch){
        String keyValue = "";
        if(nameSearch.isPresent()){
            keyValue = nameSearch.get();
        }
        Page<Product> productPage = productServiceImpl.findAll(keyValue,pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("productList",productPage);
        modelAndView.addObject("keyValue",keyValue);
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }
    @PostMapping("/product/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect){
        redirect.addFlashAttribute("success","Delete Successfull !");
        productServiceImpl.remove(id);
        return "redirect:/";
    }
    @PostMapping("/product/create")
    public String create(Product product,RedirectAttributes redirect){
        productServiceImpl.save(product);
        redirect.addFlashAttribute("success","Insert Successfull !");
        return "redirect:/";
    }
    @GetMapping("product/view")
    public String viewInformation(@RequestParam int id,Model model){
        model.addAttribute("product",productServiceImpl.findById(id));
        return "view";
    }
    @GetMapping("/product/edit")
    public String editForm(@RequestParam int id,Model model){
        model.addAttribute("products",productServiceImpl.findById(id));
        return "edit";
    }
//    @PostMapping("/product/search")
//    public String searchProduct(@RequestParam String searchProduct,Model model){
//        List<Product> productList = productServiceImpl.seachProduct(searchProduct);
//        model.addAttribute("productList",productList);
//        return "list";
//    }
    @PostMapping(value = "/product/update")
    public String save(Product product){
        productServiceImpl.update(product);
        return "redirect:/";
    }

}
