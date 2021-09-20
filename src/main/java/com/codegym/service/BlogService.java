package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.respository.BlogRespository;
import com.codegym.respository.IBlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRespository blogRespository;

    @Override
    public List<Blog> findAll() {
        return blogRespository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRespository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRespository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRespository.remove(id);

    }
}
