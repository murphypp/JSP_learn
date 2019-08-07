package com.ucar.training.utils;

public class UserUtil {
    /**
     * 将获得的用户爱好拼接成一个字符串
     * @param all
     * @return
     */
    public static String getUserLikes(String[] all){
        StringBuilder stringBuilder = new StringBuilder("");
        for(String x: all){
            stringBuilder.append(x).append(",");
        }
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        return stringBuilder.toString();
    }
}
