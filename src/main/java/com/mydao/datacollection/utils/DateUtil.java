package com.mydao.datacollection.utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    /**
     * 获取日期时间区间
     * @param date
     * @return
     */
    public static Map<String,Object> getBeforeDate(Date date,Integer num){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(sdf.format(date));
        }catch (Exception e){
            e.printStackTrace();
        }
        Calendar calendar = GregorianCalendar.getInstance();

        calendar.setTime(date);
        int day = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.set(Calendar.HOUR_OF_DAY, day - num);
        String time = sdf.format(calendar.getTime());
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("beginDays",time+" 00:00:00");
        resultMap.put("endDays",time + " 23:59:59");
        return  resultMap;
    }

    /**
     * 获取当前月
     * @param date
     * @return
     */
    public static Integer getMouth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取指定日期24小时区间集合
     * @param date
     * @return
     */
    public static List<Map<String,Object>> getHours(Date date){
        List<Map<String,Object>> resultList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Map<String,Object> map = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        for (int i = 0; i < 24 ; i++){
            map = new HashMap<>();
            if (i==0){
                calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR) - 0);
            }else{
                calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR) - 1);
            }
            String time = sdf.format(calendar.getTime());
            map.put("beginHours",time + ":00:00");
            map.put("endHours",time + ":59:59");
            resultList.add(map);
        }
        return  resultList;
    }

    public static Map<String,Object> getDaysHours(Date date){
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.put("start",sdf.format(date) + " 00:00:00");
        map.put("end",sdf.format(date) + " 23:59:59");
        return map;
    }
}
