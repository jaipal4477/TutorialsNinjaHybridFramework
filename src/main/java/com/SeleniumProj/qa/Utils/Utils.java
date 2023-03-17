package com.SeleniumProj.qa.Utils;

import java.util.Date;

public class Utils {
	
	public static String generateEmailWithTimeStamp() 
	{
		Date date=new Date();
		String timestamp=date.toString().replace(" ","_").replace(":","_");
		return "amotoori"+timestamp+"@gmail.com";
	}
}
