package api.payloads;

//Using Pojo Technique we can create JSON Payloads.

public class User {
	
	//initialize  the variables and generate methods using getter and setter.
	
	String name;
	String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	

}
