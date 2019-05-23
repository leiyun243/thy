package com.ad.thy.dao;

import com.ad.thy.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    Integer insertUser(UserModel model);

    Integer updateUser(UserModel model);

    Integer deleteUser(UserModel model);

    UserModel selectUserOne(UserModel model);

    List<UserModel> selectUserList(UserModel model);

    Integer selectUserListCount(UserModel model);


}
