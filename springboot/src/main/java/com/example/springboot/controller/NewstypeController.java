package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.entity.News;
import com.example.springboot.entity.Newstype;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.NewstypeMapper;
import com.example.springboot.service.NewstypeService;
import org.springframework.ui.Model;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newstype")
public class NewstypeController {
    @Autowired
    private NewstypeService newstypeService;
    @Autowired
    private NewstypeMapper newstypeMapper;



    @GetMapping
    public List<Newstype> findAll(){
        return newstypeMapper.findAll();
    }

    @PostMapping
    public boolean save(@RequestBody Newstype newstype){
        return newstypeService.save(newstype);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return newstypeService.removeById(id);
    }


    @GetMapping("/page")    // 分页查询接口
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String typename) {
        pageNum = (pageNum - 1) * pageSize;
        typename = "%" + typename + "%";
        List<Newstype> data = newstypeMapper.selectPage(pageNum, pageSize, typename);
        Integer total = newstypeMapper.selectTotal(typename);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

}
