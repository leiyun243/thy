package com.ad.thy.model;

import com.ad.thy.vo.UserVO;

import java.util.Date;

public class UserModel {

    private Integer userId;
    private String userUUID;
    private String username;
    private String password;
    private String realName;
    private String department;
    private String userPhone;
    private String userEmail;
    private Boolean isAdmin;
    private Integer creatorId;
    private String creatorName;
    private Date creatorTime;

    public UserModel() {

    }

    public UserModel(UserVO userVO) {
        this.userId = userVO.getUserId();
        this.userUUID = userVO.getUserUUID();
        this.username = userVO.getUsername();
        this.password = userVO.getPassword();
        this.realName = userVO.getRealName();
        this.department = userVO.getDepartment();
        this.userPhone = userVO.getUserPhone();
        this.userEmail = userVO.getUserEmail();
        this.isAdmin = userVO.getAdmin();
        this.creatorId = userVO.getCreatorId();
        this.creatorName = userVO.getCreatorName();
        this.creatorTime = userVO.getCreatorTime();
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }
}
