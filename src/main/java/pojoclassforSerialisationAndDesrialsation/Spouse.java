package pojoclassforSerialisationAndDesrialsation;

public class Spouse {

	String spouseName;
	String spouseId;
	int spouseage;
	
	public Spouse(String spouseName, String spouseId, int spouseage) {
		super();
		this.spouseName = spouseName;
		this.spouseId = spouseId;
		this.spouseage = spouseage;
	}
	Spouse(){
		
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getSpouseId() {
		return spouseId;
	}
	public void setSpouseId(String spouseId) {
		this.spouseId = spouseId;
	}
	public int getSpouseage() {
		return spouseage;
	}
	public void setSpouseage(int spouseage) {
		this.spouseage = spouseage;
	}
	
	
}
