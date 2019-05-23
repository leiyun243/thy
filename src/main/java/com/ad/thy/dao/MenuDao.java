package com.ad.thy.dao;

import com.ad.thy.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {

    List<MenuVO> selectMenuList(MenuVO menuVO);

}
