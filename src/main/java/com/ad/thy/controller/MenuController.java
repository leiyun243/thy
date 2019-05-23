package com.ad.thy.controller;

import com.ad.thy.annotation.AuthAnnotation;
import com.ad.thy.service.MenuService;
import com.ad.thy.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;

    @AuthAnnotation("/toMenuList")
    @RequestMapping("/toMenuList")
    public String toMenuList(HttpServletRequest request){

        List<MenuVO> dataList = this.menuService.selectMenuList(new MenuVO());

        List<MenuVO> menuList = new ArrayList<>();
        for (MenuVO item: dataList) {
            //添加父菜单
            if(item.getMenuLv() == 1){
                if(item.getSubMenuList() == null){
                    item.setSubMenuList(new ArrayList<>());
                }
                menuList.add(item);
            }else{
                //添加子菜单
                for (MenuVO menu : menuList) {
                    if(menu.getMenuId() == item.getMenuParentId()){
                        menu.getSubMenuList().add(item);
                        break;
                    }
                }
            }
        }

        request.setAttribute("menuList",menuList);

        return "/menu/menu_main";
    }


}
