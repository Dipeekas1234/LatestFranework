package pojoclassforSerialisationAndDesrialsation;

public class Employee {
 String EmpName;
 String EmpID;
 String EmpEmailId;
 int PhoneNo;
 int[] mobilearr;
 //constructor for Employee 

public Employee(String empName, String empID, String empEmailId, int phoneNo, int[] mobilearr) {
	super();
	EmpName = empName;
	EmpID = empID;
	EmpEmailId = empEmailId;
	PhoneNo = phoneNo;
	this.mobilearr = mobilearr;
}



 
 
public Employee() {

}


public String getEmpName() {
	return EmpName;
}


public void setEmpName(String empName) {
	EmpName = empName;
}


public String getEmpID() {
	return EmpID;
}


public void setEmpID(String empID) {
	EmpID = empID;
}


public String getEmpEmailId() {
	return EmpEmailId;
}


public void setEmpEmailId(String empEmailId) {
	EmpEmailId = empEmailId;
}


public int getPhoneNo() {
	return PhoneNo;
}


public void setPhoneNo(int phoneNo) {
	PhoneNo = phoneNo;
}





public int[] getMobilearr() {
	return mobilearr;
}





public void setMobilearr(int[] mobilearr) {
	this.mobilearr = mobilearr;
}
 

 

 
 
}
