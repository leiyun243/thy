package com.ad.thy.service.impl;

import com.ad.thy.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ad.thy.dao.UserDao;
import com.ad.thy.model.UserModel;
import com.ad.thy.service.UserService;
import com.ad.thy.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer insertUser(UserVO userVO) {
        //vo转model
        UserModel model = new UserModel(userVO);
        return this.userDao.insertUser(model);
    }

    @Override
    public Integer updateUser(UserVO userVO) {
        UserModel model = new UserModel(userVO);
        return this.userDao.updateUser(model);
    }

    @Override
    public Integer deleteUser(UserVO userVO) {
        return null;
    }

    @Override
    public UserVO selectUserOne(UserVO userVO) {
        UserModel model = new UserModel(userVO);
        model = this.userDao.selectUserOne(model);
        if(model == null){
            return null;
        }
        return new UserVO(model);
    }

    @Override
    public List<UserVO> selectUserList(UserVO userVO) {
        System.out.println("查询所有用户信息");
        UserModel model = new UserModel(userVO);
        List<UserModel> modelList = this.userDao.selectUserList(model);
        if(modelList.isEmpty()){
            return null;
        }

        return swapList(modelList);

    }

    protected List<UserVO> swapList(List<UserModel> modelList){

        if (modelList == null || modelList.size() == 0){
            return null;
        }

        List<UserVO> voList = new ArrayList<>();
        for (UserModel item : modelList) {
            UserVO vo = new UserVO(item);
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public List<UserVO> selectUserPage(UserVO userVO, PageUtil page) {
        UserModel model = new UserModel(userVO);
        Integer count = this.userDao.selectUserListCount(model);
        page.setTotalCount(count);
        if(count > 0){
            PageHelper.startPage(page.getPageNo(),page.getPageSize());
            PageInfo<UserModel> pageInfo = new PageInfo<>(this.userDao.selectUserList(model));
            return swapList(pageInfo.getList());
        }
        return null;
    }
}
