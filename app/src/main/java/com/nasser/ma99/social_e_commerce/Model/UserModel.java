package com.nasser.ma99.social_e_commerce.Model;

import java.io.Serializable;

public class UserModel implements Serializable {

    public  String name ,mobile,phone,email,token,id,typeUser;
    public int isValid;

    public UserModel() {
    }

    public UserModel(String name, String mobile, String phone, String email,
                     String token, String id, String typeUser, int isValid) {
        this.name = name;
        this.mobile = mobile;
        this.phone = phone;
        this.email = email;
        this.token = token;
        this.id = id;
        this.typeUser = typeUser;
        this.isValid = isValid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", id='" + id + '\'' +
                ", typeUser='" + typeUser + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
