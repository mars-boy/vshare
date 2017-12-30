package com.marsboy.vshare.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateFormat {

	private DateFormat() {
	}

	public static String getDate() {
		String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(date);
	}
	
	public static String getCurrentDateInSQLFormat() {
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		return modifiedDate;
	}
	
	public static String convertDate(String dateField){
		String res="";
		try{
			if(dateField !=null && !dateField.equals("")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dt = sdf.parse(dateField);
				sdf.applyPattern("dd-MM-yyyy");
				res = sdf.format(dt);
			} else {
				res = null;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	public static String convertDateTime(String dateField){
		String res="";
		try{
			if(dateField !=null && !dateField.equals("")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date dt = sdf.parse(dateField);
				/* Changed from HH:mm aa to hh:mm a to fix time from 24 hours to 12 hours
				 * before 22:30 PM after applying 10:30 PM*/
				sdf.applyPattern("dd-MM-yyyy hh:mm a");
				res = sdf.format(dt);
			} else {
				res = null;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
	
	public static String getCurrentDateInDDMMYYY(){
		String pattern = "dd-MM-yyyy";
		String dateInString =new SimpleDateFormat(pattern).format(new Date());
		return dateInString;
	}
	
	public static Date getSQLDateFromStringDate(String dateField){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = null;
		try {
			dt = sdf.parse(dateField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public static Date getSQLDateFromStringDateOnlyDate(String dateField){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
			dt = sdf.parse(dateField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public static Date getJavaDate(){
		 Calendar currenttime = Calendar.getInstance();
		    Date sqldate = new Date((currenttime.getTime()).getTime());
		    return sqldate;
	}
	
	public static String convertTimeFormat(String time) {
		String res = "";
		try {
			Date date = new SimpleDateFormat("hh:mm aa").parse(time);
			res = new SimpleDateFormat("HH:mm").format(date);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static String convertTimeFormatReverse(String time) {
		String res = "";
		try {
			Date date = new SimpleDateFormat("HH:mm").parse(time);
			res = new SimpleDateFormat("hh:mm aa").format(date);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static String convertDateInSQLFormat(String dateField) {
		String res = "";
		try {
			if (dateField != null && !dateField.equals("")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date dt = sdf.parse(dateField);
				sdf.applyPattern("yyyy-MM-dd");
				res = sdf.format(dt);
			} else {
				res = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static List<String> getTimeZones() {
		List<String> l = new ArrayList<String>();
		l.add("(GMT-12:00) International Date Line West");
		l.add("(GMT-11:00) Midway Island, Samoa");
		l.add("(GMT-10:00) Hawaii");
		l.add("(GMT-09:00) Alaska");
		l.add("(GMT-08:00) Pacific Time (US & Canada)");
		l.add("(GMT-08:00) Tijuana, Baja California");
		l.add("(GMT-07:00) Arizona");
		l.add("(GMT-07:00) Chihuahua, La Paz, Mazatlan");
		l.add("(GMT-07:00) Mountain Time (US & Canada)");
		l.add("(GMT-06:00) Central America");
		l.add("(GMT-06:00) Central Time (US & Canada)");
		l.add("(GMT-06:00) Guadalajara, Mexico City, Monterrey");
		l.add("(GMT-06:00) Saskatchewan");
		l.add("(GMT-05:00) Bogota, Lima, Quito, Rio Branco");
		l.add("(GMT-05:00) Eastern Time (US & Canada)");
		l.add("(GMT-05:00) Indiana (East)");
		l.add("(GMT-04:00) Atlantic Time (Canada)");
		l.add("(GMT-04:00) Caracas, La Paz");
		l.add("(GMT-04:00) Manaus");
		l.add("(GMT-04:00) Santiago");
		l.add("(GMT-03:30) Newfoundland");
		l.add("(GMT-03:00) Brasilia");
		l.add("(GMT-03:00) Buenos Aires, Georgetown");
		l.add("(GMT-03:00) Greenland");
		l.add("(GMT-03:00) Montevideo");
		l.add("(GMT-02:00) Mid-Atlantic");
		l.add("(GMT-01:00) Cape Verde Is.");
		l.add("(GMT-01:00) Azores");
		l.add("(GMT+00:00) Casablanca, Monrovia, Reykjavik");
		l.add("(GMT+00:00) Greenwich Mean Time : Dublin, Edinburgh, Lisbon, London");
		l.add("(GMT+01:00) Amsterdam, Berlin, Bern, Rome, Stockholm, Vienna");
		l.add("(GMT+01:00) Belgrade, Bratislava, Budapest, Ljubljana, Prague");
		l.add("(GMT+01:00) Brussels, Copenhagen, Madrid, Paris");
		l.add("(GMT+01:00) Sarajevo, Skopje, Warsaw, Zagreb");
		l.add("(GMT+01:00) West Central Africa");
		l.add("(GMT+02:00) Amman");
		l.add("(GMT+02:00) Athens, Bucharest, Istanbul");
		l.add("(GMT+02:00) Beirut");
		l.add("(GMT+02:00) Cairo");
		l.add("(GMT+02:00) Harare, Pretoria");
		l.add("(GMT+02:00) Helsinki, Kyiv, Riga, Sofia, Tallinn, Vilnius");
		l.add("(GMT+02:00) Jerusalem");
		l.add("(GMT+02:00) Minsk");
		l.add("(GMT+02:00) Windhoek");
		l.add("(GMT+03:00) Kuwait, Riyadh, Baghdad");
		l.add("(GMT+03:00) Moscow, St. Petersburg, Volgograd");
		l.add("(GMT+03:00) Nairobi");
		l.add("(GMT+03:00) Tbilisi");
		l.add("(GMT+03:30) Tehran");
		l.add("(GMT+04:00) Abu Dhabi, Muscat");
		l.add("(GMT+04:00) Baku");
		l.add("(GMT+04:00) Yerevan");
		l.add("(GMT+04:30) Kabul");
		l.add("(GMT+05:00) Yekaterinburg");
		l.add("(GMT+05:00) Islamabad, Karachi, Tashkent");
		l.add("(GMT+05:30) Sri Jayawardenapura");
		l.add("(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi");
		l.add("(GMT+05:45) Kathmandu");
		l.add("(GMT+06:00) Almaty, Novosibirsk");
		l.add("(GMT+06:00) Astana, Dhaka");
		l.add("(GMT+06:30) Yangon (Rangoon)");
		l.add("(GMT+07:00) Bangkok, Hanoi, Jakarta");
		l.add("(GMT+07:00) Krasnoyarsk");
		l.add("(GMT+08:00) Beijing, Chongqing, Hong Kong, Urumqi");
		l.add("(GMT+08:00) Kuala Lumpur, Singapore");
		l.add("(GMT+08:00) Irkutsk, Ulaan Bataar");
		l.add("(GMT+08:00) Perth");
		l.add("(GMT+08:00) Taipei");
		l.add("(GMT+09:00) Osaka, Sapporo, Tokyo");
		l.add("(GMT+09:00) Seoul");
		l.add("(GMT+09:00) Yakutsk");
		l.add("(GMT+09:30) Adelaide");
		l.add("(GMT+09:30) Darwin");
		l.add("(GMT+10:00) Brisbane");
		l.add("(GMT+10:00) Canberra, Melbourne, Sydney");
		l.add("(GMT+10:00) Hobart");
		l.add("(GMT+10:00) Guam, Port Moresby");
		l.add("(GMT+10:00) Vladivostok");
		l.add("(GMT+11:00) Magadan, Solomon Is., New Caledonia");
		l.add("(GMT+12:00) Auckland, Wellington");
		l.add("(GMT+12:00) Fiji, Kamchatka, Marshall Is.");
		l.add("(GMT+13:00) Nuku'alofa");
		return l;

	}
	/** Get the number of days in a month */
	public static int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		if (month == 2)
			return isLeapYear(year) ? 29 : 28;
		return 0; // If month is incorrect
	}

	/** Determine if it is a leap year */
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
}
