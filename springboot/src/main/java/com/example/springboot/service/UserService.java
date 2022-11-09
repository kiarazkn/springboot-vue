package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.controller.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {


    public boolean saveUser(User user) {
//        if (user.getId() == null) {
//            save(user);  // mybatis-plus提供的方法，表示新增插入数据
//        }else {
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    }



    public boolean login(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        queryWrapper.eq("password", userDto.getPassword());
        List<User> list = list(queryWrapper);
        return list.size() != 0;
    }

    public boolean register(UserDto userDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userDto.getUsername());
        queryWrapper.eq("password", userDto.getPassword());
        queryWrapper.eq("nickname", userDto.getNickname());
        queryWrapper.eq("email", userDto.getEmail());
        queryWrapper.eq("phone", userDto.getPhone());
        List<User> list = list(queryWrapper);
        return list.size() != 0;
    }


//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user){
//        if(user.getId() == null){   // user没有id则表示是新增
//            return userMapper.insert(user);
//        }else {    // 否则则为更新
//            return userMapper.update(user);
//        }
//    }

}
