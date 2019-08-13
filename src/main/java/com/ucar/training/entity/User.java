package com.ucar.training.entity;


public class User {
    private String username;
    private String password;
    private int age;
    private String sex;
    private String likes;
    private String sign;
    private String authority;

    public User(){

    }
    public User(String username, String password,String authority, int age, String sex, String likes, String sign) {
        this.username = username;
        this.password = password;
        this.authority =authority;
        this.age = age;
        this.sex = sex;
        this.likes = likes;
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

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAuthority() { return authority; }

    public void setAuthority(String authority) { this.authority = authority; }

}