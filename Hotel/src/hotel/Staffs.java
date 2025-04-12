package hotel;
import java.io.*;
public abstract class Staffs extends Human implements Serializable{
	private static final long serialVersionUID = 3L;
	private double salary;
	private int WorkingExperience;
	private int workTime;
	private String jobtype;
	private String JobDescription;
	public Staffs(
			String First_Name, String Last_Name, String gender, String number, int age,
			double salary,String jobtype, int WorkingExperience, int workTime, String JobDescription
			) {
		super(First_Name, Last_Name, gender, number, age);
		this.setSalary(salary);
		this.setWorkingExperience(WorkingExperience);
		this.setWorkTime(workTime);
		this.setJobtype(jobtype);
		this.setJobDescription(JobDescription);
	}
	
	///heres set and get methods for these properties
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public int getWorkingExperience() {
		return WorkingExperience;
	}
	public void setWorkingExperience(int workingExperience) {
		WorkingExperience = workingExperience;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String JobDescription) {
		this.JobDescription = JobDescription;
	}
	public String toString()
	{
		return super.toString()
				+"\nJob: "+jobtype
				+"Job description: "+JobDescription
				+"\nSalary: "+salary
				+"\nWorking Hours: "+workTime
				+"\nWorking Experience: "+WorkingExperience;
	}

}
