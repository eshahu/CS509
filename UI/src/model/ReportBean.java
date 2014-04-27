package model;

public class ReportBean {
	private int logNumber;
	private String reporter;
	private String victim;
	private String abuser;
	private String description;
	private String apeal;
	private String dr; //decision report
	private String ca; //corrective action
	private String dl; //disposition letter
	public int getLogNumber() {
		return logNumber;
	}
	public void setLogNumber(int logNumber) {
		this.logNumber = logNumber;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getVictim() {
		return victim;
	}
	public void setVictim(String victim) {
		this.victim = victim;
	}
	public String getAbuser() {
		return abuser;
	}
	public void setAbuser(String abuser) {
		this.abuser = abuser;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApeal() {
		return apeal;
	}
	public void setApeal(String apeal) {
		this.apeal = apeal;
	}
	public String getDr() {
		return dr;
	}
	public void setDr(String dr) {
		this.dr = dr;
	}
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	public String getDl() {
		return dl;
	}
	public void setDl(String dl) {
		this.dl = dl;
	}
}
