package com.ucar.training.entity;


public class User {
    private int uid;
    private int rid;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String hobby;
    private String sign;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public User(){

    }
    public User(String username, String password,String authority, int age, String sex, String hobby, String sign) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.sign = sign;
    }
    @Override
    public int hashCode(){
        final int prime = 37;
        int result = 1;
        result = prime * result + ((username==null)?0:username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        User other = (User) obj;
        if (username == null){
            if (other.username == null)
                return false;
        }else if (!username.equals(other.username))
            return false;

        return true;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() { return hobby; }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


}