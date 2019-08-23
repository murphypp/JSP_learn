package com.ucar.training.util;

/**
 * @program:training_servlet
 * @description:字符串工具类
 * @author:linshaoxiong
 * @create:2019-08-23 09:11
 **/
public class StringUtil {
    public static String StringArrayToString(String[] string){
        String tmpStr="";
        for(String str:string){
            tmpStr=tmpStr+","+str;
        }
        tmpStr=tmpStr.replaceFirst(",","");
        return tmpStr;
    }
}
