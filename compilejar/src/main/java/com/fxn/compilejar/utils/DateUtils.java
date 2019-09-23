package com.fxn.compilejar.utils;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateUtils {

    /**
     * 转换时间戳输入例如
     * （1402733340）输出（"2014年06月14日16时09分00秒"）
     *
     * @param time
     */
    public static String millis2String(long time, String type) {
        SimpleDateFormat sdr = new SimpleDateFormat(type);
        return TimeUtils.millis2String(time, sdr);
    }

    /**
     * 转换时间戳输入例如
     * （"2014年06月14日16时09分00秒"）输出（1402733340）
     * "yyyy-MM-dd HH:mm:ss
     */
    public static long string2Millis(String time, String type) {
        SimpleDateFormat sdr = new SimpleDateFormat(type);
        return TimeUtils.string2Millis(time, sdr);
    }

    /**
     * 获取当前时间戳
     */
    public static long getNowMills() {
        return TimeUtils.getNowMills();
    }

    /**
     * 获取当前时间 字符串
     * 例如（"2014年06月14日16时09分00秒"）
     * yyyy-MM-dd HH:mm:ss
     */
    public static String getNowString(String type) {
        SimpleDateFormat sdr = new SimpleDateFormat(type);
        return TimeUtils.getNowString(sdr);
    }

    //获取 格式为 yyyy-MM-dd HH:mm:ss  时间字符串
    public static String getCurrentData() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    //获取 格式为 yyyy-MM-dd   时间字符串
    public static String getCurrent() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    //获取 格式为 yyyy年MM月dd日   时间字符串
    public static String getCurrentFont() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    //获取 格式为 HH:mm   时间字符串
    public static String getTimeCurrent() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
    /**
     * 判断2个时间大小
     * yyyy-MM-dd HH:mm 格式（自己可以修改成想要的时间格式）
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getTimeCompareSize(String startTime, String endTime){
        int i=0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//年-月-日 时-分
        try {
            Date date1 = dateFormat.parse(startTime);//开始时间
            Date date2 = dateFormat.parse(endTime);//结束时间
            // 1 结束时间小于开始时间 2 开始时间与结束时间相同 3 结束时间大于开始时间
            if (date2.getTime()<date1.getTime()){
                i= 1;
            }else if (date2.getTime()>=date1.getTime()){
                i= 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  i;
    }

    /**
     * 通过毫秒值，手动计算日期间的相关的值    当前日期和输入日期计算天数
     * 如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
     *
     * @throws ParseException
     */
    public static long daysOfTwo(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //跨年不会出现问题
        //如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
        Date fDate = sdf.parse(millis2String(getNowMills(), "yyyy-MM-dd"));
        Date oDate = sdf.parse(time);
        long days = (oDate.getTime() - fDate.getTime()) / (1000 * 3600 * 24);
        return days;
    }

    /**
     * 通过毫秒值，手动计算日期间的相关的值    当前日期和输入日期计算天数
     * 如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
     *
     * @throws ParseException
     */
    public static long daysOfTwo1(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //跨年不会出现问题
        //如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
        Date fDate = sdf.parse(millis2String(getNowMills(), "yyyy-MM-dd HH:mm"));
        Date oDate = sdf.parse(time);
        long days = (oDate.getTime() - fDate.getTime()) / (1000 * 3600 * 24);
        return days;
    }

    /**
     * 通过毫秒值，手动计算日期间的相关的值    当前日期和输入日期计算天数
     * time  少的日期   time1  多的日期
     *
     * @throws ParseException
     */
    public static long daysOfTwos(String time, String time1) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //跨年不会出现问题
        //如果时间为：2016-03-18 11:59:59 和 2016-03-19 00:00:01的话差值为 0
        Date fDate = sdf.parse(time1);
        Date oDate = sdf.parse(time);
        long days = (oDate.getTime() - fDate.getTime()) / (1000 * 3600 * 24);
        return days;
    }
    //获取 格式为 HH:mm   时间字符串
    public static String getCurrentHouse() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
    //获取 格式为 yyyy-MM  时间字符串
    public static String getCurrentYearMouth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
    //获取 当前时间 转为 long
    public static long getCurrentLong() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
            Date date = new Date(System.currentTimeMillis());
            String d = simpleDateFormat.format(date);
            return simpleDateFormat.parse(d).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 获取指定年月的第一天
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH,firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定年月的最后一天
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth1(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
    /**
     * 两个时间相差多少小时
     * @param str1
     * @param str2
     * @return
     * @throws Exception
     */
    public static long getDistanceHours(String str1, String str2) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        long days=0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = (diff / (60 * 60 * 1000) - days * 24);
        } catch (android.net.ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    //根据日期判断星期几
    public static String getWeek(String pTime) {
        if(StringUtils.isEmpty(pTime)){
            return "";
        }
        String Week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "星期天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "星期一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "星期二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "星期三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "星期四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "星期五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "星期六";
        }
        return Week;
    }

    //比较两个日期大小
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("HH:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() >= dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    //两个日期相差的天数
    public static long dateDifDay(String startTime, String endTime) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        try {
            // 获得两个时间的毫秒时间差异
            diff = sd.parse(endTime).getTime()
                    - sd.parse(startTime).getTime();
            day = diff / nd;// 计算差多少天
            long hour = diff % nd / nh;// 计算差多少小时
            long min = diff % nd % nh / nm;// 计算差多少分钟
            long sec = diff % nd % nh % nm / ns;// 计算差多少秒
            // 输出结果
            System.out.println("时间相差：" + day + "天" + hour + "小时" + min
                    + "分钟" + sec + "秒。");
            if (day>=1) {
                return day;
            }else {
                if (day==0) {
                    return 1;
                }else {
                    return 0;
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;

    }
    /**
     *
     * @param time  1541569323155
     * @return 2018-11-07 13:42:03
     */
    public static String getDate2String(long time) {
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return format.format(date);
    }
    /**
     * 判断手机号是否符合规范
     *
     * @param phoneNo 输入的手机号
     * @return
     */
    public static boolean isPhoneNumber(String phoneNo) {
        if (TextUtils.isEmpty(phoneNo)) {
            return false;
        }
        if (phoneNo.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if (!PhoneNumberUtils.isISODigit(phoneNo.charAt(i))) {
                    return false;
                }
            }
            Pattern p = Pattern.compile("^((13[^4,\\D])" + "|(134[^9,\\D])" +
                    "|(14[5,7])" +
                    "|(15[^4,\\D])" +
                    "|(17[3,6-8])" +
                    "|(18[0-9]))\\d{8}$");
            Matcher m = p.matcher(phoneNo);
            return m.matches();
        }
        return false;
    }

    /**
     * 保留两位小数
     *  并乘以100
     */
    public static String isDecimalFormat(String str) {
        DecimalFormat df = new DecimalFormat("#.00");
        double s1 = Double.parseDouble(str);
        if(ObjectUtils.isNotEmpty(str)){
            if(str.equals("")||str.equals("0.00")){
                return "0";
            }else {
                return df.format(s1 * 100);
            }
        } else {
            return "0";
        }
    }


    /**
     * 保留两位小数
     */
    public static String isDecimalFormat1(String str) {
        DecimalFormat df = new DecimalFormat("#.00");
        double s1 = Double.parseDouble(str);
        if(ObjectUtils.isNotEmpty(str)){
            if(str.equals("")||str.equals("0.0")||str.equals("0")){
                return "0";
            }else {
                return df.format(s1);
            }
        } else {
            return "0";
        }
    }

    /**
     * 保留两位小数
     *  并乘以10000
     */
    public static String isDecimalFormat2(String str) {
        DecimalFormat df = new DecimalFormat("#.00");
        double s1 = Double.parseDouble(str);
        if(ObjectUtils.isNotEmpty(str)){
            if(str.equals("")||str.equals("0.00")||str.equals("0")){
                return "0";
            }else {
                return df.format(s1 / 10000);
            }
        } else {
            return "0";
        }
    }
}
