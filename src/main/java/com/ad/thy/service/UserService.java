package com.ad.thy.service;

import com.ad.thy.util.PageUtil;
import com.ad.thy.vo.UserVO;

import java.util.List;

public interface UserService {

    Integer insertUser(UserVO userVO);

    Integer updateUser(UserVO userVO);

    Integer deleteUser(UserVO userVO);

    UserVO selectUserOne(UserVO userVO);

    List<UserVO> selectUserList(UserVO userVO);

    List<UserVO> selectUserPage(UserVO userVO, PageUtil page);

}
