package ca.gc.cra.rcsc.eda_epayroll_poc.model;

public class Errors {

    private int errorNumber;
    private String description;
    private int bn;
    private int paydac;
    private String name;
    private String payType;
    private String periodStart;
    private String periodEnd;
    private int employeeSin;
    private String employeeName;
    private int employeeID;
    private String employeeActivity;
    private int grossPay;
    private int taxDeducted;
    private int cppContribution;
    private int cppPensionEarning;
    private int eiContribution;
    private int eiInsurable;
    


    public Errors() {

    }

    public Errors( int errorNumber, String description, int bn, int paydac, String name, String payType, String periodStart, String periodEnd, int employeeSin, String employeeName, int employeeID,  String employeeActivity, int grossPay, int taxDeducted, int cppContribution, int cppPensionEarning, int eiContribution, int eiInsurable  ) {
    	this.errorNumber = errorNumber;
    	this.description = description;
    	this.bn = bn;
    	this.paydac = paydac;
    	this.name = name;
    	this.payType = payType;
    	this.periodEnd = periodEnd;
    	this.periodStart = periodStart;
    	this.employeeSin = employeeSin;
    	this.employeeName = employeeName;
    	this.employeeID = employeeID;
    	this.employeeActivity = employeeActivity;
    	this.grossPay = grossPay;
    	this.taxDeducted = taxDeducted;
    	this.cppContribution = cppContribution;
    	this.cppPensionEarning = cppPensionEarning;
    	this.eiContribution = eiContribution;
    	this.eiInsurable = eiInsurable;
    	
    }

	public int getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(int errorNumber) {
		this.errorNumber = errorNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBn() {
		return bn;
	}

	public void setBn(int bn) {
		this.bn = bn;
	}

	public int getPaydac() {
		return paydac;
	}

	public void setPaydac(int paydac) {
		this.paydac = paydac;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(String periodStart) {
		this.periodStart = periodStart;
	}

	public String getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(String periodEnd) {
		this.periodEnd = periodEnd;
	}

	public int getEmployeeSin() {
		return employeeSin;
	}

	public void setEmployeeSin(int employeeSin) {
		this.employeeSin = employeeSin;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeActivity() {
		return employeeActivity;
	}

	public void setEmployeeActivity(String employeeActivity) {
		this.employeeActivity = employeeActivity;
	}

	public int getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(int grossPay) {
		this.grossPay = grossPay;
	}

	public int getTaxDeducted() {
		return taxDeducted;
	}

	public void setTaxDeducted(int taxDeducted) {
		this.taxDeducted = taxDeducted;
	}

	public int getCppContribution() {
		return cppContribution;
	}

	public void setCppContribution(int cppContribution) {
		this.cppContribution = cppContribution;
	}

	public int getCppPensionEarning() {
		return cppPensionEarning;
	}

	public void setCppPensionEarning(int cppPensionEarning) {
		this.cppPensionEarning = cppPensionEarning;
	}

	public int getEiContribution() {
		return eiContribution;
	}

	public void setEiContribution(int eiContribution) {
		this.eiContribution = eiContribution;
	}

	public int getEiInsurable() {
		return eiInsurable;
	}

	public void setEiInsurable(int eiInsurable) {
		this.eiInsurable = eiInsurable;
	}
    
    


}