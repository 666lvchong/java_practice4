package wechat_business.util;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.util
 * @author hehongju
 * @date 2018/1/23 14:58
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hehongju
 * @ClassName FormatUtils
 * @Description 类描述
 * @date 2018/1/23
 */
public class FormatUtils {
    /**
     * dateFormat 日期格式化 yyyy-MM-dd
     */
    private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    /**
     * dateTimeFormat 日期时间格式化 yyyy-MM-dd HH:mm:ss
     */
    private static SimpleDateFormat dateTimeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * timeFormat 时间格式化 HH:mm:ss
     */
    private static SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");


    /**
     * @Title: dateTimeFormat
     * @Description: 日期时间格式化
     * @author hehongju
     * @date 2018-01-23
     * @param  date 日期时间
     */
    public static String dateTimeFormat(Date date){
        System.out.println("121");
        if(date==null){
            System.out.println("122");
            return null;
        }else {
            System.out.println("1223");
            return dateTimeFormat.format(date);
        }
    }
    /**
     * @Title: dateFormat
     * @Description: 日期格式化
     * @author hehongju
     * @date 2018-01-23
     * @param  date 日期时间
     */
    public static String dateFormat(Date date){
        return dateFormat.format(date);
    }
    /**
     * @Title: timeFormat
     * @Description: 时间格式化
     * @author hehongju
     * @date 2018-01-23
     * @param  date 日期时间
     */
    public static String timeFormat(Date date){
        return timeFormat.format(date);
    }
}