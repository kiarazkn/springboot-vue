package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "t_news")
public class News {
    @TableId(type = IdType.AUTO)
    private Integer id ,typeid;
    private String title , content ;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 将String ==》Date的格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai") //将Date ==》json字符串的格式
    private Date publishdate;
    private String comefrom ;

}
