package com.example.springboot.service;


import com.example.springboot.entity.Newstype;
import com.example.springboot.mapper.NewstypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewstypeService {
    @Autowired
    NewstypeMapper newstypeMapper;


//    public boolean saveNewstype(Newstype newstype) {
//        return newstypeMapper.insert(newstype);
//    }

    public boolean save(Newstype newstype){
        if(newstype.getId() == null){   // user没有id则表示是新增
            return newstypeMapper.insert(newstype);
        }else {    // 否则则为更新
            return newstypeMapper.update(newstype);
        }
    }

    public boolean removeById(Integer id){
        return newstypeMapper.deleteById(id);
    }


}
