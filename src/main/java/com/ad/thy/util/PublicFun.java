package com.ad.thy.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PublicFun {
	
	
	/**
	 * 转换成String
	 * @param obj 需要转换的对象
	 * @param default_str 默认值
	 * @return
	 */
	public static String convertTo(Object obj,String default_str){
		try {
			if(obj!=null){
				if(obj instanceof String){
					return obj.toString();
				}
				return obj+"";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return default_str;
	}
	
	/**
	 * 转换成float
	 * @param obj 需要转换的对象
	 * @param default_float 默认值
	 * @return
	 */
	public static Float convertTo(Object obj,Float default_float){
		try {
			if(obj!=null){
				return Float.valueOf(obj.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return default_float;
	}
	
	/**
	 * 转换成double
	 * @param obj 需要转换的对象
	 * @param default_double 默认值
	 * @return
	 */
	public static Double convertTo(Object obj,Double default_double){
		try {
			if(obj!=null){
				double dou_num = Double.valueOf(obj.toString()).doubleValue();
				double num = new BigDecimal(dou_num).doubleValue();
				return num;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return default_double;
	}
	
	/**
	 * 转换成int
	 * @param obj 需要转换的对象
	 * @param default_int 默认值
	 * @return
	 */
	public static Integer convertTo(Object obj,Integer default_int){
		try {
			if(obj!=null){
				double dou_num = Double.valueOf(obj.toString()).doubleValue();
				int num = new BigDecimal(dou_num).intValue();
				return num;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return default_int;
	}
	
	/**
	 * 转换成long
	 * @param obj 需要转换的对象
	 * @param default_long 默认值
	 * @return
	 */
	public static Long convertTo(Object obj,Long default_long){
		try {
			if(obj!=null){
				double dou_num = Double.valueOf(obj.toString()).doubleValue();
				long num = new BigDecimal(dou_num).longValue();
				return num;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return default_long;
	}
	
	/**
	 * 保留2位小数
	 * @param obj
	 * @return
	 */
	public static String convertDecimal2(Object obj) {
		if(obj!=null){
			return String.format("%.2f", obj);
		}
		System.out.println("数据保留2位小数错误");
		return "0.00";
	}
	
	/**
	 * 获取当前时间戳(10位数[date.getTime()/1000])
	 * @return
	 */
	public static Long getCurTimeStamp(){
		Date date = new Date();
		return date.getTime()/1000;
	}
	
	/**
	 * 获取当前时间(默认格式yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static String getCurTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurTime(String dateFormate){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间
	 * @return
	 */
	public static String formateDateTime(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 格式日期时间
	 * @return
	 */
	public static String formateDateTime(String dateFormate,Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		return sdf.format(date);
	}

	/**
	 * 左自动补零
	 * @param code [纯数字的字符串]
	 * @param len [生字符串的总长度]
	 * @return 
	 */
	public static String autoGenericCode(String code,int len){
		try {
			String newString = String.format("%0"+len+"d",  Long.parseLong(code));  
			return newString;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.err.println("自动补零失败"+e.getMessage());
		}
		return "";
	}
	

}
