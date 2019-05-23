package com.ad.thy.vo;

import com.ad.thy.model.UserModel;
import com.ad.thy.util.PublicFun;

import java.util.Date;
import java.util.List;

public class MenuVO {

    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private Integer menuParentId;
    private Integer menuLv;
    private Integer menuSort;
    private Boolean isDelete;
    private String instruction;

    private List<MenuVO> subMenuList;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Integer getMenuLv() {
        return menuLv;
    }

    public void setMenuLv(Integer menuLv) {
        this.menuLv = menuLv;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<MenuVO> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuVO> subMenuList) {
        this.subMenuList = subMenuList;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuParentId=" + menuParentId +
                ", menuLv=" + menuLv +
                ", menuSort=" + menuSort +
                ", isDelete=" + isDelete +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
