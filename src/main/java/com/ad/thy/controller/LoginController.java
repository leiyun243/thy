package com.ad.thy.controller;

import com.ad.thy.annotation.SysLogAnnotation;
import com.ad.thy.model.UserModel;
import com.ad.thy.service.MenuService;
import com.ad.thy.service.UserService;
import com.ad.thy.util.*;
import com.ad.thy.vo.MenuVO;
import com.ad.thy.vo.UserVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/noAuth")
    public String noAuth() {
        return "/html/no_auth";
    }

    @RequestMapping("/login")
    public String toLogin2() {
        return "login";
    }

    @SysLogAnnotation(logName = "登录",logContent = "用户登录系统")
    @RequestMapping("/logon")
    @ResponseBody
    public String logon(HttpServletRequest request, HttpServletResponse response){
        AjaxObject ajaxObject = AjaxObject.newOk();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(StringUtils.isEmpty(username)){
            return AjaxObject.newError("请输入用户名").toString();
        }

        if(StringUtils.isEmpty(password)){
            return AjaxObject.newError("请输入密码").toString();
        }

        UserVO paramVO = new UserVO();
        paramVO.setUsername(username);
        //密码再次md5加密(密码经过2次md5加密后存入数据库)
//        try {
//            password = MD5.md5Encode(password);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
        paramVO.setPassword(password);
        paramVO = userService.selectUserOne(paramVO);
        if(paramVO == null){
            return AjaxObject.newError("用户名或密码错误").toString();
        }

        request.getSession().setAttribute("user_info",paramVO);

        //登录成功后，创建cookie
        CookieUtil.addCookie(response,"rzks",paramVO.getUserUUID(),3600*2);

        String json_str = JSONObject.toJSONString(paramVO);

        redisUtil.set("user_"+paramVO.getUserId(),json_str,3600);

        return ajaxObject.toString();
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVrifyCode")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {

        try {

            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);

            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法

        } catch (Exception e) {

            System.out.println("获取验证码失败>>>> "+e.getMessage());
        }
    }

    /**
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/matchVrifyCode")
    @ResponseBody
    public String matchVrifyCode(HttpServletRequest request, HttpServletResponse response){
        AjaxObject ajaxObject = AjaxObject.newOk();

        String sessionVrifyKey = RandomValidateCodeUtil.RANDOMCODEKEY;

//        String vrifyCode = (String) request.getSession().getAttribute("vrifyCode");
        String vrifyCode = (String) request.getSession().getAttribute(sessionVrifyKey);
        String matchCode = request.getParameter("vrifyCode");

        System.out.println("vrifyCode "+vrifyCode);
        System.out.println("matchCode "+matchCode);

        if (!vrifyCode.equals(matchCode)) {
            ajaxObject = AjaxObject.newError("验证码错误");
        }
        return ajaxObject.toString();
    }

    @RequestMapping("index")
    public String toIndex(HttpServletRequest request, HttpServletResponse response){

        //登录成功后的跳转,这里要验证cookie是否存在
        String userUUID = CookieUtil.getCookieValue(request,"rzks");
        if(StringUtils.isEmpty(userUUID)){
            //注销用户的信息,重新登录

            return "redirect:/login";
        }
        //获取用户权限

        UserVO userVO = new UserVO();
        userVO.setUserUUID(userUUID);
        userVO = this.userService.selectUserOne(userVO);

        //查询用户id，查询角色，查询权限

        List<MenuVO> menuList = (List<MenuVO>)request.getSession().getAttribute("menuList");
        if(menuList == null){

            System.err.println("我来查菜单来");

            menuList = new ArrayList<>();

            List<MenuVO> dataList = this.menuService.selectMenuList(new MenuVO());

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

        }

        request.setAttribute("menuList",menuList);


        String json_str = redisUtil.get("user_"+userVO.getUserId());
        System.out.println("json_str="+json_str);

        UserVO pasVo = JSONObject.parseObject(json_str,UserVO.class);
        System.err.println("id="+pasVo.getUserId());


        return "index";
    }

    @RequestMapping("/welcome")
    public String toWelcome(){

        return "/html/welcome";
    }

}
