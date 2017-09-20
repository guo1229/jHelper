package com.ht;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateHelper
 * @Description: ���ڹ�����
 * @author: huchenghao
 * @date: 2017��9��20�� ����6:57:23
 */
public class DateHelper {
	private static final String YEAR_MONTH_DAY_TEMPLATE = "yyyy-MM-dd";
	private static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_TEMPLATE = "yyyy-MM-dd hh:mm:ss";
	
	private static SimpleDateFormat df_ymd=new SimpleDateFormat(YEAR_MONTH_DAY_TEMPLATE);
	private static SimpleDateFormat df_ymdhms=new SimpleDateFormat(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_TEMPLATE);
	
	/**
	 * 
	 * @Title: longTimeForYMDHMSStr
	 * @Description: long���͵�ʱ���ת��Ϊyyyy-MM-dd hh:mm:ss��ʽ���ַ���
	 * @param currentTimeMillis
	 * @return
	 * @return: String
	 */
	public static String longTimeForYMDHMSStr(Long currentTimeMillis){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(currentTimeMillis);
		return  df_ymdhms.format(calendar.getTime());
	}
	/**
	 * 
	 * @Title: formatDateToYMDHMSStr
	 * @Description: Date��ʽ����ת��Ϊyyyy-MM-dd hh:mm:ss��ʽ���ַ���
	 * @param date
	 * @return
	 * @return: String
	 */
	public static String formatDateForYMDHMSStr(Date date){
		return df_ymdhms.format(date);
	}
	/**
	 * 
	 * @Title: formatDateToYMDStr
	 * @Description: Date��ʽ����ת��Ϊyyyy-MM-dd��ʽ���ַ���
	 * @param date
	 * @return
	 * @return: String
	 */
	public static String formatDateToYMDStr(Date date){
		return df_ymd.format(date);
	}
	/**
	 * 
	 * @Title: formatDate
	 * @Description: Date��ʽ����ת��Ϊformat��ʽ���ַ���
	 * @param date
	 * @param format
	 * @return
	 * @return: String
	 */
	public static String formatDate(Date date,String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	/**
	 * 
	 * @Title: getTodayStr
	 * @Description: ��ȡString��ʽ�ģ����������
	 * @return
	 * @return: String
	 */
	public static String getTodayStr(){
		return df_ymd.format(new Date());
	}
	/**
	 * 
	 * @Title: comparDate
	 * @Description: �Ƚ�����Date�Ĵ�С��1>2:1;1<2:0;1=null || 2== null:-1
	 * @param date1
	 * @param date2
	 * @return
	 * @return: int
	 */
	public static int comparDate(Date date1,Date date2){
		if(null == date1 || null == date2){
			return -1;
		}else if(date1.getTime() > date2.getTime()){
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 * 
	 * @Title: parseYMDStrForDate
	 * @Description: TODO
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date parseYMDStrForDate(String dateStr) throws ParseException{
		return df_ymd.parse(dateStr);
	}
	
	
	
	
}
