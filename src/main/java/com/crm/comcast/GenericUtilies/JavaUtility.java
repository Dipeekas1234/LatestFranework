package com.crm.comcast.GenericUtilies;


import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * to get random number
	 * @return
	 */
	public int getRandomNum() {
	Random ran =new Random();
	int num=ran.nextInt(1200);
	return num;
}
	/**
	 * to get the system dateand time
	 * @return
	 */
	public String getSystemDate() {
		Date date=new Date();
		String dateTime=date.toString();
		return dateTime;
		}
	public String getSystemDateInFormat() {
		Date datte=new Date();
		String dateTime=datte.toString();
		String[]dateArr=dateTime.split(" ");
		int month=datte.getMonth()+1;
		String date=dateArr[2];
		String year=dateArr[5];
		int day=datte.getDay();
		String time=dateArr[3];
		String finalFormat=month+" "+date+" "+year+" "+day+" "+time;
		return finalFormat;
		
		
	}
}

