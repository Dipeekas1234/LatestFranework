package com.crm.comcast.GenericUtilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * get the data from property file
 * @author Admin
 *
 */
public class FileUtility {
public String getPropertyValue(String key ) throws IOException {
	FileInputStream fileInputStream=new FileInputStream(IConstants.filepath);
	Properties properties=new Properties();
	 properties.load(fileInputStream);
	 String value=properties.getProperty(key);
return value;
}

}
