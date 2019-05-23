package com.ad.thy.controller;

import com.ad.thy.annotation.AuthAnnotation;
import com.ad.thy.annotation.SysLogAnnotation;
import com.ad.thy.util.AjaxObject;
import com.ad.thy.vo.UserVO;
import com.alibaba.fastjson.JSON;
import com.ad.thy.model.UserModel;
import com.ad.thy.service.UserService;
import com.ad.thy.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @AuthAnnotation("/toUserList")
    @RequestMapping("/toUserList")
    public String toUserList(HttpServletRequest request){
        request.setAttribute("page", new PageUtil());
        return "user/user_list";
    }

    @SysLogAnnotation(logName = "查询",logContent = "查询用户列表")
    @RequestMapping("/getUserList")
    @ResponseBody
    public String getUserList(UserVO model, HttpServletRequest request, HttpServletResponse response, PageUtil page){

        List<UserVO> list = this.userService.selectUserPage(model,page);
        System.out.println(list.toString());
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("resultList", list);
        resultMap.put("pager",page);
        return JSON.toJSONString(resultMap);

    }

    @RequestMapping("/toAdd")
    public String toAdd(){

        return "user/user_add";
    }

    @SysLogAnnotation(logName = "新增",logContent = "新增用户")
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(UserVO model, HttpServletRequest request, HttpServletResponse response){
        AjaxObject ajaxObject = AjaxObject.newOk();


        return ajaxObject.toString();

    }
}
