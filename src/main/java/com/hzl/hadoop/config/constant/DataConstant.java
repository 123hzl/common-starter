package com.hzl.hadoop.config.constant;

/**
 * description
 * 日期相关常量
 *
 * @author hzl 2020/01/19 6:44 PM
 */
public interface DataConstant {


	// ---------------------------------------------------常规模式---------------------------------------------------------------
	/**
	 * yy-MM-dd
	 */
	String DATESIM = "yy-MM-dd";
	/**
	 * yyyy-MM-dd
	 */
	String DATE = "yyyy-MM-dd";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	String DATETIME = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy-MM-dd HH:mm
	 */
	String DATETIME_MM = "yyyy-MM-dd HH:mm";
	/**
	 * yyyy-MM-dd HH:mm:ss.SSS
	 */
	String DATETIME_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	/**
	 * HH:mm
	 */
	String TIME = "HH:mm";
	/**
	 * HH:mm:ss
	 */
	String TIME_SS = "HH:mm:ss";


	//  ---------------------------------------------------系统时间格式 ---------------------------------------------------
	/**
	 * yyyy/MM/dd
	 */
	String SYS_DATE = "yyyy/MM/dd";
	/**
	 * yyyy/MM/dd HH:mm:ss
	 */
	String SYS_DATETIME = "yyyy/MM/dd HH:mm:ss";
	/**
	 * yyyy/MM/dd HH:mm
	 */
	String SYS_DATETIME_MM = "yyyy/MM/dd HH:mm";
	/**
	 * yyyy/MM/dd HH:mm:ss.SSS
	 */
	String SYS_DATETIME_SSS = "yyyy/MM/dd HH:mm:ss.SSS";


	// ---------------------------------------------------无连接符模式---------------------------------------------------
	/**
	 * yyyyMMdd
	 */
	String NONE_DATE = "yyyyMMdd";
	/**
	 * yyyyMMddHHmmss
	 */
	String NONE_DATETIME = "yyyyMMddHHmmss";
	/**
	 * yyyyMMddHHmm
	 */
	String NONE_DATETIME_MM = "yyyyMMddHHmm";
	/**
	 * yyyyMMddHHmmssSSS
	 */
	String NONE_DATETIME_SSS = "yyyyMMddHHmmssSSS";

	/**
	 * EEE MMM dd HH:mm:ss 'CST' yyyy
	 */
	String CST_DATETIME = "EEE MMM dd HH:mm:ss 'CST' yyyy";

	//--------------时区-------------

	//东八区
	String GMT = "GMT+8:00";

	String SHANGHAI ="Asia/Shanghai";
}
