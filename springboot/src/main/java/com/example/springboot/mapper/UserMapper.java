package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface UserMapper extends BaseMapper<User>{

//    @Select("select * from t_user")
//    List<User> findAll();
//
//    @Insert("insert into t_user(username, password,nickname,email,phone,address) VALUES (#{username}, #{password}," +
//            " #{nickname}, #{email},#{phone}, #{address})")
//    int insert(User user);
//    int update(User user);
//
//    @Delete("delete from t_user where id=#{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from t_user where username like #{arg2} limit #{arg0},#{arg1}")
//    List<User> selectPage(Integer pageNum, Integer pageSize,String username);
//
//    @Select("select count(*) from t_user where username like concat('%',#{username},'%')")
//    Integer selectTotal(String username);
}
