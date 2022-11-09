package com.example.springboot.mapper;

import com.example.springboot.entity.News;
import com.example.springboot.entity.Newstype;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewsMapper {
    @Select("select * from t_news")
    public List<News> findAll();

    @Insert("insert into t_news(title,typeid,content,comefrom) values(#{title},#{typeid},#{content},#{comefrom})")
    boolean insert(News news);

    @Update("update t_news set title=#{title},typeid=#{typeid},content=#{content},comefrom=#{comefrom} where id=#{id}")
    boolean update(News news);

    @Select("select * from t_news where title like #{arg2} limit #{arg0},#{arg1}")
    List<News> selectPage(Integer pageNum, Integer pageSize, String title);

    @Select("select count(*) from t_news where title like concat('%',#{title},'%')")
    Integer selectTotal(String title);
}
