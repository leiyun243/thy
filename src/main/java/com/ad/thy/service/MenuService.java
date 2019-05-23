package com.ad.thy.service;

import com.ad.thy.util.PageUtil;
import com.ad.thy.vo.MenuVO;
import com.ad.thy.vo.UserVO;

import java.util.List;

public interface MenuService {

    List<MenuVO> selectMenuList(MenuVO menuVO);

}
