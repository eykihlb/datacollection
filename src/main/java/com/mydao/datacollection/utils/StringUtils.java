package com.mydao.datacollection.utils;

public class StringUtils {

    public static String getStr(String str){
        try {
            if (str == "" || str == null || "0".equals(str.trim())){
                return  "";
            }
            String result = "";
            int len = str.trim().length();
            for (int i = 0 ; i < len/7 ; i++){
                result += str.substring(i*6,i*6+7).substring(0,1) == "0" ? "1": str.substring(i*6,i*6+7).substring(0,1) +"|"+str.substring(i*6,i*6+7).substring(1,7)+"+";
            }
            return result.substring(0,result.length()-1);
        }catch (Exception e){
            return "";
        }
    }
}
