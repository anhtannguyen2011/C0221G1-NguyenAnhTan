package com.example.blogsortpage.controller;

import com.example.blogsortpage.model.entity.Blog;
import com.example.blogsortpage.model.service.IBlogService;
import com.example.blogsortpage.model.service.ICateloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICateloryService cateloryService;

    @RequestMapping(value = "/")
    public ModelAndView showListBlog(@RequestParam(name ="page" , required = false, defaultValue = "0") Integer page,
                               @RequestParam(name="size", required = false,defaultValue = "3") Integer size,
                               @RequestParam(name="sort",required = false,defaultValue = "ASC") String sort,
                               @RequestParam(name = "nameSearch")Optional<String>  nameSearch){
        Page<Blog> blogPage;
        Sort sortable = null;
        Pageable pageable = null;
        if(sort.equals("ASC")){
            sortable = Sort.by("dateBlog").ascending();
        }
        if(sort.equals("DESC")){
            sortable = Sort.by("dateBlog").descending();
        }
        pageable = PageRequest.of(page,size,sortable);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("revertSort",sort.equals("ASC") ? "DESC" : "ASC");
        if(nameSearch.isPresent()){
            blogPage = this.blogService.findAllByNameBlogContaining(nameSearch.get(),pageable);
        }else {
            blogPage = this.blogService.findAll(pageable);
        }
        modelAndView.addObject("blogList",blogPage);
        return modelAndView;
    }
    @GetMapping(value = "/create-blog/create")
    public String showCreateBlog(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("cateloryList",cateloryService.findAll());
        return "blog/create";
    }
    @PostMapping(value = "/blog-create")
    public String createBlog(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping(value = "/edit-blog/edit")
    public String showEditBlog(@RequestParam int id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        model.addAttribute("cateloryList",this.cateloryService.findAll());
        return "blog/edit";
    }
    @PostMapping(value = "/blog-edit")
    public String editBlog(@ModelAttribute Blog blog){
        this.blogService.update(blog);
        Date date = new Date(System.currentTimeMillis());
        blog.setDateBlog(date);
        return "redirect:/";
    }
    @GetMapping(value = "/view-blog/view")
    public String showViewBlog(@RequestParam int id,Model model){
        model.addAttribute("blog", this.blogService.findById(id));
        return "blog/view";
    }
    @GetMapping(value = "/delete-blog/view")
    public String deleteBlog(@RequestParam int id){
        this.blogService.delete(id);
        return "redirect:/";
    }
}
