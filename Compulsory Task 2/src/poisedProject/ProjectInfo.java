package poisedProject;

public class ProjectInfo {

	//Attributes
	private String projectNum;
	private String projectName;
	private String type;
	private String phyAddress;
	private String erfNum;
	private String totalFee;
	private String totalPaid;
	private String projDeadline;
	private String projManName;
	private String archName;
	private String conName;
	private String custName;
	private String engineName;
	
	//Constructor
	public ProjectInfo(String projectNum, String projectName, String type, String phyAddress, String erfNum, 
			String totalFee, String totalPaid, String projDeadline, String projManName, String archName, String conName, String custName,
			String engineName) {
		this.projectNum = projectNum;
		this.projectName = projectName;
		this.type = type;
		this.phyAddress = phyAddress;
		this.erfNum = erfNum;
		this.totalFee = totalFee;
		this.totalPaid = totalPaid;
		this.projDeadline = projDeadline;
		this.projManName = projManName;
		this.archName = archName;
		this.conName = conName;
		this.custName = custName;
		this.engineName = engineName;
	}
	
	//Getters
	public String getProjectNum() {
		return projectNum;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public String getType() {
		return type;
	}
	
	public String getPhyAddress() {
		return phyAddress;
	}
	
	public String getErfNum() {
		return erfNum;
	}
	
	public String getTotalFee() {
		return totalFee;
	}
	
	public String getTotalPaid() {
		return totalPaid;
	}
	
	public String getProjDeadline() {
		return projDeadline;
	}
	public String getProjManName() {
		return projManName;
	}
	public String getArchName() {
		return archName;
	}
	public String getConName() {
		return conName;
	}
	public String getCustName() {
		return custName;
	}
	public String getEngineName() {
		return engineName;
	}
	
	//Setters
	public void setProjectNum(String newProjectNum) {
		this.projectNum = newProjectNum;
	}
	
	public void setProjectName(String newProjectName) {
		this.projectName = newProjectName;
	}
	
	public void setType(String newType) {
		this.type = newType;
	}
	
	public void setPhyAddress(String newPhyAddress) {
		this.phyAddress = newPhyAddress;
	}
	
	public void setErfNum(String newErfNum) {
		this.erfNum = newErfNum;
	}
	
	public void setTotalFree(String newTotalFee) {
		this.totalFee = newTotalFee;
	}
	
	public void setTotalPaid(String newTotalPaid) {
		this.totalPaid = newTotalPaid;
	}
	
	public void setProjDeadline(String newProjDeadline) {
		this.projDeadline = newProjDeadline;
	}
	
	public void setProjManName(String newProjManName) {
		this.projManName = newProjManName;
	}
	
	public void setArchName(String newArchName) {
		this.archName = newArchName;
	}
	
	public void setConName(String newConName) {
		this.conName = newConName;
	}
	
	public void setCustName(String newCustName) {
		this.custName = newCustName;
	}
	
	public void setEngineName(String newEngineName) {
		this.engineName = newEngineName;
	}
	
	//Methods
	public String toString() {
		String detailsString = "INSERT INTO projects VALUES (" + projectNum + ", '" + projectName + "', '" + type + "', '" + phyAddress + 
								"', " + erfNum + ", " + totalFee + ", " + totalPaid + ", '" + projDeadline + "', '" + archName + "', '" +
								conName + "', '" + engineName + "', '" + custName + "', '" + projManName + "')";
		return detailsString;
	}
	
}
