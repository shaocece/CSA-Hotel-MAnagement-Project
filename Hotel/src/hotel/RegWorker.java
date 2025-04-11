package hotel;
import java.io.*;
public class RegWorker extends Staffs implements Serializable{
	private static final long serialVersionUID = 3L;
	private String Supervisor;
	public RegWorker(			
			String First_Name, String Last_Name, String gender, String number, int age,
			double salary,String jobtype, int WorkingExperience, int workTime, String jobDescription,
			Manager Supervisor
			)
	{
		super(First_Name, Last_Name, gender, number, age,
				salary, jobtype, WorkingExperience, workTime, jobDescription);
	}
	public String getSupervisor() {
		return Supervisor;
	}
	public void setSupervisor(String supervisor) {
		Supervisor = supervisor;
	}
	public String toString()
	{
		return super.toString()
				+"Supervisor: "+Supervisor;
	}

}
