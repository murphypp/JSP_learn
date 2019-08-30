package com.ucar.training.entity;

public class User {
    private int uid;
    private String username;
    private String realname;
    private int age;
    private String sex;
    private String password;
    private String phone;
    private String email;
    private String hobby;
    private String sign;
    private int rid;

    public User() {

    }

    public User(String username, String password, String email, String realname, int age, String sex, String phone,String hobby,String sign) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.realname=realname;
        this.age= age;
        this.sex=sex;
        this.phone=phone;
        this.hobby=hobby;
        this.sign=sign;
    }

    public User(String username, String password, String email, String realname, int age, String sex, String phone,String hobby,String sign,int rid) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.realname=realname;
        this.age= age;
        this.sex=sex;
        this.phone=phone;
        this.hobby=hobby;
        this.sign=sign;
        this.rid=rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getHobby() {
        return hobby;
    }
    public void setSex(String  sex) {
        this.sex = sex;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public String getRealname(){
        return realname;
    }
    public int getAge(){
        return age;
    }
    public String getSex(){
        return sex;
    }
    public String getPassword (){
        return password;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public String getSign(){
        return sign;
    }
    public int getRid() {
        return rid;
    }
    public void setRid(int rid) {
        this.rid= rid;
    }


}
