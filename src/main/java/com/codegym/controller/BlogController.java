package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ModelAndView listBlog(){
        List<Blog> blogList = blogService.findAll();
        System.out.println(blogList.size());

        ModelAndView mv = new ModelAndView("/list");
        mv.addObject("listBlog", blogList);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("/add");
        mv.addObject("createForm", new Blog());
        return mv;
    }

    @PostMapping("/create/blog")
    public String createBlog (@ModelAttribute("createForm") Blog blog){
        blogService.save( blog);
        return "redirect:/";

    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id ){
        Blog blog = blogService.findById(id);
        ModelAndView mv = new ModelAndView("/edit");
        mv.addObject("editForm", blog);
        return mv;

    }

    @PostMapping("/edit")
    public String editBlog (@ModelAttribute("editForm") Blog blog){
        blogService.save(blog);
        return "redirect:/";

    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete (@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView mv = new ModelAndView("/delete");
        mv.addObject("deleteForm",blog);
        return mv;
    }


    @PostMapping("/delete/blog")
    public String deleteBlog (@ModelAttribute("deleteForm") Blog blog){
        blogService.remove(blog.getId());
        return "redirect: /";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailCustomer(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("detailBlog",blog);
        return modelAndView;
    }

}

