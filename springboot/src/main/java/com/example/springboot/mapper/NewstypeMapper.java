package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.News;
import com.example.springboot.entity.Newstype;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NewstypeMapper extends BaseMapper<User> {
    @Select("select * from t_newstype")
    public List<Newstype> findAll();


    @Insert("insert into t_newstype(typename) values(#{typename})")
    boolean insert(Newstype newstype);

    @Update("update t_newstype set typename=#{typename} where id=#{id}")
    boolean update(Newstype newstype);

    @Delete("delete from t_newstype where id=#{id}")
    boolean deleteById(@Param("id") Integer id);

    @Select("select * from t_newstype where typename like #{arg2} limit #{arg0},#{arg1}")
    List<Newstype> selectPage(Integer pageNum, Integer pageSize,String typename);

    @Select("select count(*) from t_newstype where typename like concat('%',#{typename},'%')")
    Integer selectTotal(String typename);
}
