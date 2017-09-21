package com.ht;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
	private static final String YEARMONTHDAYHOURMINUTESECONDTEMPLATE = "yyyyMMddhhmmss";
	
	private static SimpleDateFormat df_ymd=new SimpleDateFormat(YEAR_MONTH_DAY_TEMPLATE);
	private static SimpleDateFormat df_ymdhms=new SimpleDateFormat(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_TEMPLATE);
	private static SimpleDateFormat df_ymdhms_no=new SimpleDateFormat(YEARMONTHDAYHOURMINUTESECONDTEMPLATE);
	
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
	 * @Title: getNowTime
	 * @Description: ��ȡString��ʽ�ģ������yyyy-MM-dd HH:mm:ss
	 * @return
	 * @return: String
	 */
	public static String getNowTime(){
		return df_ymdhms.format(new Date());
	}
	/**
	 * 
	 * @Title: getNowTimeToNo
	 * @Description:  ��ȡString��ʽ�ģ����ڵ�yyyyMMddHHmmss
	 * @return
	 * @return: String
	 */
	public static String getNowTimeToNo(){
		return df_ymdhms_no.format(new Date());
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
	 * @Description: yyyy-MM-dd ��ʽ�ַ���ת��ΪDate��ʽ
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date parseYMDStrForDate(String dateStr) throws ParseException{
		return df_ymd.parse(dateStr);
	}
	/**
	 * 
	 * @Title: parseYMDHMSStrForDate
	 * @Description: yyyy-MM-dd hh:mm:ss��ʽ�ַ���ת��ΪDate��ʽ
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date parseYMDHMSStrForDate(String dateStr) throws ParseException{
		return df_ymdhms.parse(dateStr);
	}
	/**
	 * 
	 * @Title: parseDate
	 * @Description: dateStr���ڸ�ʽ���ַ�����ת��Ϊformat��ʽ��Date
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws ParseException
	 * @return: Date
	 */
	public static Date parseDate(String dateStr,String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateStr);
	}
	/**
	 * 
	 * @Title: getAmOrPm
	 * @Description: ��ȡָ�������������绹������
	 * @param date
	 * @return
	 * @return: Integer
	 */
	public static Integer getAmOrPm(Date date){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
	    @SuppressWarnings("static-access")
		Integer int_date = cal.get(cal.AM_PM);
		return int_date;
	}
	/**
	 * 
	 * @Title: addTimeByDays
	 * @Description: ��ǰʱ��+ָ������
	 * @param days
	 * @return
	 * @return: String
	 */
	public static String addTimeByDays(int days){
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return df_ymd.format(cal.getTime());
	}
	/**
	 * 
	 * @Title: addTimeByDays
	 * @Description: ָ�������ַ���+����
	 * @param dateStr
	 * @param days
	 * @return
	 * @throws ParseException
	 * @return: String
	 */
	public static String addTimeByDays(String dateStr,int days) throws ParseException{
		Calendar cal=Calendar.getInstance();
		cal.setTime(parseYMDStrForDate(dateStr));
		cal.add(Calendar.DAY_OF_MONTH, days);
		return df_ymd.format(cal.getTime());
	}
	/**
	 * 
	 * @Title: addTimeByHours
	 * @Description: ָ��ʱ��+hours
	 * @param date
	 * @param hours
	 * @return
	 * @return: Date
	 */
	public static Date addTimeByHours(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.HOUR, hours);
		return calendar.getTime();
	}
	/**
	 * 
	 * @Title: addTimeByMinutes
	 * @Description: ָ������+minutes
	 * @param date
	 * @param minutes
	 * @return
	 * @return: Date
	 */
	public static Date addTimeByMinutes(Date date, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}
	/**
	 * 
	 * @Title: addTimeByMonths
	 * @Description:ָ������+months
	 * @param date
	 * @param months
	 * @return
	 * @return: Date
	 */
	public static Date addTimeByMonths(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	/**
	 * 
	 * @Title: addTimeByYears
	 * @Description: ָ��ʱ��+years
	 * @param date
	 * @param years
	 * @return
	 * @return: Date
	 */
	public static Date addTimeByYears(Date date, int years) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.add(Calendar.YEAR, years);
		return calendar.getTime();
	}
	/**
	 * 
	 * @Title: subtractTimeByMonth
	 * @Description: ָ������-months
	 * @param date
	 * @param months
	 * @return
	 * @return: Date
	 */
	public static Date subtractTimeByMonth(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - months);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @Title: subtractTimeByDays
	 * @Description: ָ��ʱ��-days
	 * @param date
	 * @param days
	 * @return
	 * @return: Date
	 */
	public static Date subtractTimeByDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - days);
		return calendar.getTime();
	}
	/**
	 * 
	 * @Title: subtractTimeByHours
	 * @Description: ָ��ʱ��-hours
	 * @param date
	 * @param hours
	 * @return
	 * @return: Date
	 */
	public static Date subtractTimeByHours(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date.getTime());
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) - hours);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @Title: getBetweenDate
	 * @Description: ��ȡ��������֮������ ������������
	 * @param from
	 * @param to
	 * @return
	 * @throws ParseException
	 * @return: List<String>
	 */
	public static List<String> getBetweenDate(String from,String to) throws ParseException{
		 List<String> rtnlist=new ArrayList<String>();
		 Date  fdate=parseYMDStrForDate(from);
		 Date  edate=parseYMDStrForDate(to);
		 //�����ʼ���ڱȽ������ڴ� ��������
        if(edate.getTime()<fdate.getTime()){
       	 Date date=fdate;
       	 fdate=edate;
       	 edate=date;
        }		 
		 Calendar ca1=Calendar.getInstance();
		 ca1.setTime(fdate);
		 Calendar ca2=Calendar.getInstance();
		 ca2.setTime(edate);
		 
		 long count=(ca2.getTimeInMillis()-ca1.getTimeInMillis())/86400000;
		 rtnlist.add(formatDateToYMDStr(ca1.getTime()));
		 for(long i=0;i<count;i++){
			   ca1.add(Calendar.DAY_OF_YEAR, 1);
			   rtnlist.add(formatDateToYMDStr(ca1.getTime()));
		 }
		 return rtnlist;
	}
	/**
	 * 
	 * @Title: subDaysBetweenTwoDate
	 * @Description: ����������������
	 * @param longdate
	 * @param shortdate
	 * @return
	 * @return: int
	 */
	public static int subDaysBetweenTwoDate(Date longdate,Date shortdate){
		if(null == longdate || null == shortdate){
			return -1;
		}else{
			return (int)(longdate.getTime() - shortdate.getTime())/86400000; 
		}
	}
	/**
	 * 
	 * @Title: subMinsBetweenTwoDate
	 * @Description: �����������ķ�����
	 * @param longdate
	 * @param shortdate
	 * @return
	 * @return: int
	 */
	public static int subMinsBetweenTwoDate(Date longdate,Date shortdate){
		if(null == longdate || null == shortdate){
			return -1;
		}else{
			return (int)(longdate.getTime() - shortdate.getTime())/60000; 
		}
	}
	
	/**
	 * 
	 * @Title: getWeek
	 * @Description: ��ȡ���ܼ�
	 * @param weekday
	 * @return
	 * @return: String
	 */
	public static String getWeek(int weekday){
		String dayNames[] = {"������","����һ","���ڶ�","������","������","������","������"};
		return dayNames[weekday];
	}
	/**
	 * 
	 * @Title: todayWeek
	 * @Description: �������ܼ�
	 * @return
	 * @return: String
	 */
	public static String todayWeek(){
		String weekString = "";
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date); 
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		weekString = getWeek(dayOfWeek - 1);
		return weekString;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws ParseException {
		System.out.println(todayWeek());
		
	}
	
}
