package com.ucar.training.entity;

public class User {
    private String username;
    private String realname;
    private boolean privileges;
    private int age;
    private String sex;
    private String password;
    private String phone;
    private String email;
    private String[] hobby;
    private String sign;

    public User() {

    }

    public User(String username, String password, String email, String realname, int age, String sex, String phone,String privileges) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.realname=realname;
        this.age= age;
        this.sex=sex;
        this.phone=phone;
        if(privileges.equals("1"))
        {
            this.privileges=true;
        }
    }

    public boolean isPrivileges(){
        return privileges;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHobby(String[] hobby) {
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
}
