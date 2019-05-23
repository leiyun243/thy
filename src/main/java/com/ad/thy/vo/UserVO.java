package com.ad.thy.vo;

import com.ad.thy.model.UserModel;
import com.ad.thy.util.PublicFun;

import java.util.Date;

public class UserVO {

    private Integer userId;
    private String userUUID;
    private String username;
    private String password;
    private String rePassword;
    private String realName;
    private String department;
    private String userPhone;
    private String userEmail;
    private Boolean isAdmin;
    private Integer creatorId;
    private String creatorName;
    private Date creatorTime;
    private String creatorTimeStr;

    public UserVO() {

    }

    public UserVO(UserModel userModel) {
        this.userId = userModel.getUserId();
        this.userUUID = userModel.getUserUUID();
        this.username = userModel.getUsername();
        this.password = userModel.getPassword();
        this.realName = userModel.getRealName();
        this.department = userModel.getDepartment();
        this.userPhone = userModel.getUserPhone();
        this.userEmail = userModel.getUserEmail();
        this.isAdmin = userModel.getAdmin();
        this.creatorId = userModel.getCreatorId();
        this.creatorName = userModel.getCreatorName();
        this.creatorTime = userModel.getCreatorTime();
        this.creatorTimeStr = PublicFun.formateDateTime(userModel.getCreatorTime());
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
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
        this.creatorTimeStr = PublicFun.formateDateTime(this.creatorTime);
    }

    public String getCreatorTimeStr() {
        return creatorTimeStr;
    }

    public void setCreatorTimeStr(String creatorTimeStr) {
        this.creatorTimeStr = creatorTimeStr;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", userUUID='" + userUUID + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rePassword='" + rePassword + '\'' +
                ", realName='" + realName + '\'' +
                ", department='" + department + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", isAdmin=" + isAdmin +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", creatorTime=" + creatorTime +
                ", creatorTimeStr='" + creatorTimeStr + '\'' +
                '}';
    }
}
