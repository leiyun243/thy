package com.ad.thy.service.impl;

import com.ad.thy.dao.MenuDao;
import com.ad.thy.dao.UserDao;
import com.ad.thy.model.UserModel;
import com.ad.thy.service.MenuService;
import com.ad.thy.service.UserService;
import com.ad.thy.util.PageUtil;
import com.ad.thy.vo.MenuVO;
import com.ad.thy.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuVO> selectMenuList(MenuVO menuVO) {

        List<MenuVO> modelList = this.menuDao.selectMenuList(menuVO);
        return modelList;

    }


}
