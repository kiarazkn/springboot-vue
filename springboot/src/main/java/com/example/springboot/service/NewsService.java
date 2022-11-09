package com.example.springboot.service;

import com.example.springboot.entity.News;
import com.example.springboot.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public boolean save(News newstype){
        if(newstype.getId() == null){   // user没有id则表示是新增
            return newsMapper.insert(newstype);
        }else {    // 否则则为更新
            return newsMapper.update(newstype);
        }
    }

}
