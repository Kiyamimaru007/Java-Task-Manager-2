package poisedProject;

public class Person {
	
	//Architect Attributes
	private String archName;
	private String archTelNum;
	private String archEmail;
	private String archPhyAddress;
	
	//Contractor Attributes
	private String conName;
	private String conTelNum;
	private String conEmail;
	private String conPhyAddress;
	
	//Customer Attributes
	private String custName;
	private String custTelNum;
	private String custEmail;
	private String custPhyAddress;
	
	//Project Manager Attributes
	private String projManName;
	private String projManTelNum;
	private String projManEmail;
	private String projManPhyAddress;
	
	//Structural Engineer Attributes
	private String engineName;
	private String engineTelNum;
	private String engineEmail;
	private String enginePhyAddress;
	
	//Constructor
	public Person(String archName, String archTelNum, String archEmail, String archPhyAddress, String conName, String conTelNum, String conEmail, 
					String conPhyAddress, String custName, String custTelNum, String custEmail, String custPhyAddress, String projManName, 
					String projManTelNum, String projManEmail, String projManPhyAddress, String engineName, String engineTelNum,
					String engineEmail, String enginePhyAddress) {
		this.archName = archName;
		this.archTelNum = archTelNum;
		this.archEmail = archEmail;
		this.archPhyAddress = archPhyAddress;
		this.conName = conName;
		this.conTelNum = conTelNum;
		this.conEmail = conEmail;
		this.conPhyAddress = conPhyAddress;
		this.custName = custName;
		this.custTelNum = custTelNum;
		this.custEmail = custEmail;
		this.custPhyAddress = custPhyAddress;
		this.projManName = projManName;
		this.projManTelNum = projManTelNum;
		this.projManEmail = projManEmail;
		this.projManPhyAddress = projManPhyAddress;
		this.engineName = engineName;
		this.engineTelNum = engineTelNum;
		this.engineEmail = engineEmail;
		this.enginePhyAddress = enginePhyAddress;
	}
	
	//Getters
	public String getArchName() {
		return archName;
	}
	
	public String getArchTelNum() {
		return archTelNum;
	}
	
	public String getArchEmail() {
		return archEmail;
	}
	
	public String getArchPhyAddress() {
		return archPhyAddress;
	}
	
	public String getConName() {
		return conName;
	}
	
	public String getConTelNum() {
		return conTelNum;
	}
	
	public String getConEmail() {
		return conEmail;
	}
	
	public String getConPhyAddress() {
		return conPhyAddress;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public String getCustTelNum() {
		return custTelNum;
	}
	
	public String getCustEmail() {
		return custEmail;
	}
	
	public String getCustPhyAddress() {
		return custPhyAddress;
	}
	
	public String getProjManName() {
		return projManName;
	}
	public String getProjManTelNum() {
		return projManTelNum;
	}
	public String getProjManEmail() {
		return projManEmail;
	}
	public String getProjManPhyAddress() {
		return projManPhyAddress;
	}
	public String getEngineName() {
		return engineName;
	}
	public String getEngineTelNum() {
		return engineTelNum;
	}
	public String getEngineEmail() {
		return engineEmail;
	}
	public String getEnginePhyAddress() {
		return enginePhyAddress;
	}
	
	//Setters
	public void setArch(String newArchName) {
		this.archName = newArchName;
	}

	public void setArchTelNum(String newArchTelNum) {
		this.archTelNum = newArchTelNum;
	}
	
	public void setArchEmail(String newArchEmail) {
		this.archEmail = newArchEmail;
	}
	
	public void setArchPhyAddress(String newArchPhyAddress) {
		this.archPhyAddress = newArchPhyAddress;
	}
	
	public void setConName(String newConName) {
		this.conName = newConName;
	}
	
	public void setConTelNum(String newConTelNum) {
		this.conTelNum = newConTelNum;
	}
	
	public void setConEmail(String newConEmail) {
		this.conEmail = newConEmail;
	}
	
	public void setConPhyAddress(String newConPhyAddress) {
		this.conPhyAddress = newConPhyAddress;
	}
	
	public void setCustName(String newCustName) {
		this.custName = newCustName;
	}
	
	public void setCustTelNum(String newCustTelNum) {
		this.custTelNum = newCustTelNum;
	}
	
	public void setCustEmail(String newCustEmail) {
		this.custEmail = newCustEmail;
	}
	
	public void setCustPhyAddress(String newCustPhyAddress) {
		this.custPhyAddress = newCustPhyAddress;
	}
	
	public void setProjManName(String newProjManName) {
		this.projManName = newProjManName;
	}
	
	public void setProjManTelNum(String newProjManTelNum) {
		this.projManTelNum = newProjManTelNum;
	}
	
	public void setProjManEmail(String newProjManEmail) {
		this.projManEmail = newProjManEmail;
	}
	
	public void setProjManPhyAddress(String newProjManPhyAddress) {
		this.projManPhyAddress = newProjManPhyAddress;
	}
	
	public void setEngineName(String newEngineName) {
		this.engineName = newEngineName;
	}
	
	public void setEngineTelNum(String newEngineTelNum) {
		this.engineTelNum = newEngineTelNum;
	}
	
	public void setEngineEmail(String newEngineEmail) {
		this.engineEmail = newEngineEmail;
	}
	
	public void setEnginePhyAddress(String newEnginePhyAddress) {
		this.enginePhyAddress = newEnginePhyAddress;
	}
	
	//Methods
	//I will be using this to string to write into the database therefore it must be in the correct format.
	public String toString() {
		String personString = "INSERT INTO people VALUES ('" + projManName + "', '" + projManTelNum + "', '" + projManEmail + "', '" 
								+ projManPhyAddress + "', '" + archName + "', '" + archTelNum + "', '" + archEmail + "', '" +
								archPhyAddress + "', '" + conName + "', '" + conTelNum + "', '" + conEmail + "', '" + conPhyAddress + "', '" +
								custName + "', '" + custTelNum + "', '" + custEmail + "', '" + custPhyAddress + "', '" + engineName + "', '" +
								engineTelNum + "', '" + engineEmail + "', '" + enginePhyAddress + "')";
		return personString;
	}
}
