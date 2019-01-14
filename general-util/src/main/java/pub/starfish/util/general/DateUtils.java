package pub.starfish.util.general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <h3>日期工具类</h3>
 * 常量日期格式：
 * <table>
 * <tr><td> 属性名 </td><td> 属性值 </td></tr>
 * <tr><td> shortFormat </td><td> yyyyMMdd </td></tr>
 * <tr><td> longFormat </td><td> yyyyMMddHHmmss </td></tr>
 * <tr><td> webFormat </td><td> yyyy-MM-dd </td></tr>
 * <tr><td> timeFormat </td><td> HHmmss </td></tr>
 * <tr><td> timeFormat2 </td><td> HH:mm:ss </td></tr>
 * <tr><td> monthFormat </td><td> yyyyMM </td></tr>
 * <tr><td> chineseDtFormat </td><td> yyyy年MM月dd日 </td></tr>
 * <tr><td> newFormat </td><td> yyyy-MM-dd HH:mm:ss </td></tr>
 * <tr><td> noSecondFormat </td><td> yyyy-MM-dd HH:mm </td></tr>
 * </table>
 */
public class DateUtils {
    /* 一天的秒数 */
    public final static long ONE_DAY_SECONDS = 86400;
    /* 1秒的毫秒数 */
    public final static long MILLIS_PER_SECOND = 1000L;
    /* 1分的毫秒数 */
    public final static long MILLIS_PER_MINUTE = 60000L;
    /* 一小时的毫秒数 */
    public final static long MILLIS_PER_HOUR = 3600000L;
    /* 一天的毫秒数 */
    public final static long MILLIS_PER_DAY = 86400000L;

    public final static String shortFormat = "yyyyMMdd";
    public final static String longFormat = "yyyyMMddHHmmss";
    public final static String webFormat = "yyyy-MM-dd";
    public final static String timeFormat = "HHmmss";
    public final static String timeFormat2 = "HH:mm:ss";
    public final static String monthFormat = "yyyyMM";
    public final static String chineseDtFormat = "yyyy年MM月dd日";
    public final static String newFormat = "yyyy-MM-dd HH:mm:ss";
    public final static String noSecondFormat = "yyyy-MM-dd HH:mm";

    /**
     * 获得时间格式类 SimpleDateFormat
     */
    public static DateFormat getNewDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 时间格式化成字符串，参数由客户传入
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return getNewDateFormat(pattern).format(date);
    }

    /**
     * 时间格式化成字符串 yyyyMMdd
     */
    public static String formatShortFormat(Date date) {
        return format(date, shortFormat);
    }

    /**
     * 时间格式化成字符串 yyyyMMddHHmmss
     */
    public static String formatLongFormat(Date date) {
        return format(date, longFormat);
    }

    /**
     * 时间格式化成字符串 yyyy-MM-dd
     */
    public static String formatWebFormat(Date date) {
        return format(date, webFormat);
    }

    /**
     * 时间格式化成字符串 HHmmss
     */
    public static String formatTimeFormat(Date date) {
        return format(date, timeFormat);
    }

    /**
     * 时间格式化成字符串 HH:mm:ss
     */
    public static String formatTimeFormat2(Date date) {
        return format(date, timeFormat2);
    }

    /**
     * 时间格式化成字符串 yyyyMM
     */
    public static String formatMonthFormat(Date date) {
        return format(date, monthFormat);
    }

    /**
     * 时间格式化成字符串 yyyy年MM月dd日
     */
    public static String formatChineseDtFormat(Date date) {
        return format(date, chineseDtFormat);
    }

    /**
     * 时间格式化成字符串 yyyy-MM-dd HH:mm:ss
     */
    public static String formatNewFormat(Date date) {
        return format(date, newFormat);
    }

    /**
     * 时间格式化成字符串 yyyy-MM-dd HH:mm
     */
    public static String formatNoSecondFormat(Date date) {
        return format(date, noSecondFormat);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static Date getCurrentDateTime(){
        return new Date();
    }
    /**
     * 字符串格式化成时间，参数由客户传入
     */
    public static Date parse(String dateStr, String pattern) throws ParseException {
        if (StringUtil.isBlank(dateStr)) {
            return null;
        }
        return getNewDateFormat(pattern).parse(dateStr);
    }

    /**
     * 字符串格式化成时间 yyyyMMdd
     */
    public static Date parseShortFormat(String dateStr) throws ParseException {
        return parse(dateStr, shortFormat);
    }

    /**
     * 字符串格式化成时间 yyyyMMddHHmmss
     */
    public static Date parseLongFormat(String dateStr) throws ParseException {
        return parse(dateStr, longFormat);
    }

    /**
     * 字符串格式化成时间 yyyy-MM-dd
     */
    public static Date parseWebFormat(String dateStr) throws ParseException {
        return parse(dateStr, webFormat);
    }

    /**
     * 字符串格式化成时间 HHmmss
     */
    public static Date parseTimeFormat(String dateStr) throws ParseException {
        return parse(dateStr, timeFormat);
    }

    /**
     * 字符串格式化成时间 HH:mm:ss
     */
    public static Date parseTimeFormat2(String dateStr) throws ParseException {
        return parse(dateStr, timeFormat2);
    }

    /**
     * 字符串格式化成时间 yyyyMM
     */
    public static Date parseMonthFormat(String dateStr) throws ParseException {
        return parse(dateStr, monthFormat);
    }

    /**
     * 字符串格式化成时间 yyyy年MM月dd日
     */
    public static Date parseChineseDtFormat(String dateStr) throws ParseException {
        return parse(dateStr, chineseDtFormat);
    }

    /**
     * 字符串格式化成时间 yyyy-MM-dd HH:mm:ss
     */
    public static Date parseNewFormat(String dateStr) throws ParseException {
        return parse(dateStr, newFormat);
    }

    /**
     * 字符串格式化成时间 yyyy-MM-dd HH:mm
     */
    public static Date parseNoSecondFormat(String dateStr) throws ParseException {
        return parse(dateStr, noSecondFormat);
    }

    /**
     * 计算当前时间几天之后的时间
     */
    public static Date addDays(Date date, long days) {
        return addSeconds(date, days * ONE_DAY_SECONDS);
    }

    /**
     * 计算当前时间几小时之后的时间
     */
    public static Date addHours(Date date, long hours) {
        return addMinutes(date, hours * 60);
    }

    /**
     * 计算当前时间几分钟之后的时间
     */
    public static Date addMinutes(Date date, long minutes) {
        return addSeconds(date, minutes * 60);
    }

    /**
     * 计算当前时间几秒后的时间
     */
    public static Date addSeconds(Date date1, long secs) {
        return new Date(date1.getTime() + (secs * 1000));
    }

    /**
     * 取得两个日期间隔秒数
     */
    public static long getDiffSeconds(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        Calendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 1000;
    }

    /**
     * 获取两个日期间隔分数
     */
    public static long getDiffMinutes(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        Calendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (60 * 1000);
    }

    /**
     * 取得两个日期的间隔天数
     */
    public static long getDiffDays(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        Calendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取当前时间后得N个月时间
     * @param date
     * @param n
     * @return String
     */
    public static String getStringDateAfterMonth(Date date , Integer n){
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(date);
        dateStart.add(Calendar.MONTH,n);
        String re=dateStart.get(Calendar.YEAR)
                +"/"+(dateStart.get(Calendar.MONTH)+1)
                +"/"+dateStart.get(Calendar.DAY_OF_MONTH)
                +" "+dateStart.get(Calendar.HOUR_OF_DAY)
                +":"+dateStart.get(Calendar.MINUTE)
                +":"+dateStart.get(Calendar.SECOND);
        return re;
    }
    /**
     * 获取当前时间后得N个月时间
     * @param date
     * @param n
     * @return Date
     */
    public static Date getDateAfterMonth(Date date , Integer n) throws ParseException {
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(date);
        dateStart.add(Calendar.MONTH,n);
        String re=dateStart.get(Calendar.YEAR)
                +"-"+(dateStart.get(Calendar.MONTH)+1)
                +"-"+dateStart.get(Calendar.DAY_OF_MONTH)
                +" "+dateStart.get(Calendar.HOUR_OF_DAY)
                +":"+dateStart.get(Calendar.MINUTE)
                +":"+dateStart.get(Calendar.SECOND);
        return parseNewFormat(re);
    }
}
