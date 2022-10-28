package pojoclassforSerialisationAndDesrialsation;

public class Employe {
 String EmpName;
 String EmpID;
 String EmpEmailId;
 int PhoneNo;
 
 //constructor for Employee 
public Employe(String empName, String empID, String empEmailId, int phoneNo) {
	super();
	EmpName = empName;
	EmpID = empID;
	EmpEmailId = empEmailId;
	PhoneNo = phoneNo;
}

public Employe() {

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







 

 

 
 
}
