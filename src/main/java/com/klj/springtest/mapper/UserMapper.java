package com.klj.springtest.mapper;

import com.klj.springtest.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author klj
 * @Title: UserMapper
 * @Description: TODO
 * @date 2018/10/1616:08
 */
@Mapper
public interface UserMapper {
    User selectByPrimaryKey(int id);
    List<User> selectAll();
    void insert(User user);
}
