package com.example.blogwebservice.controller;

import com.example.blogwebservice.model.entity.Blog;
import com.example.blogwebservice.model.entity.Category;
import com.example.blogwebservice.model.service.IBlogService;
import com.example.blogwebservice.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = "/blog")
    public ResponseEntity<List<Blog>> findAllList(){
        List<Blog> blogList = this.blogService.findAll();
        System.err.print(blogList);
        if(blogList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> findByIdCategory(@PathVariable int id){
        Category category = this.categoryService.findById(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getBlogList(),HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findBlog(@PathVariable int id){
        Blog blog = this.blogService.findById(id);
        if( blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> category = this.categoryService.finAll();
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
}
