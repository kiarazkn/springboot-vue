package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "t_newstype")
public class Newstype {
    @TableId(type = IdType.AUTO)
    private Integer id ;
    private String typename ;

    private List<News> newsList;
}
