package com.crm.comcast.GenericUtilies;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiclass {
	
DataBaseUtility dlib=new DataBaseUtility();
JavaUtility jlib=new JavaUtility();
@BeforeSuite

public void bdconfig() {
	
	dlib.connectToDB();
}
@AfterSuite
public void bdcon() {
	
dlib.closeDB();
}


}

