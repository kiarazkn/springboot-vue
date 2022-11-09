package com.example.springboot.controller;

import com.example.springboot.entity.News;
import com.example.springboot.entity.Newstype;
import com.example.springboot.mapper.NewsMapper;
import com.example.springboot.mapper.NewstypeMapper;
import com.example.springboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<News> findAll(){
        return newsMapper.findAll();
    }

    @PostMapping
    public boolean save(@RequestBody News news){
        return newsService.save(news);
    }

    @GetMapping("/page")    // 分页查询接口
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String title) {
        pageNum = (pageNum - 1) * pageSize;
        title = "%" + title + "%";
        List<News> data = newsMapper.selectPage(pageNum, pageSize, title);
        Integer total = newsMapper.selectTotal(title);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
