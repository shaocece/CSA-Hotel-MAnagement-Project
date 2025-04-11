package hotel;
import java.util.*;
import java.io.*;
public class Manager extends Staffs implements Serializable{
	private static final long serialVersionUID = 3L;
	private ArrayList<String> Subordinates;
	public Manager(
			String First_Name, String Last_Name, String gender, String number, int age,
			double salary,String jobtype, int WorkingExperience, int workTime, String jobDescription
			)
	{
		super(First_Name, Last_Name, gender, number, age,
				salary, jobtype, WorkingExperience, workTime, jobDescription);
	}
	public ArrayList<String> getSubordinates() {
		return Subordinates;
	}
	public void setSubordinates(ArrayList<String> subordinates) {
		Subordinates = subordinates;
	}
	
	public void AddSubordinates(String NewWorker) 
	{
		Subordinates.add(NewWorker);
	}
	public void RemoveSubordinates(String FiredWorker) 
	{
		Subordinates.remove(FiredWorker);
	}
	public String toString()
	{
		return super.toString()
				+"Subordinates: "+Subordinates.toString();
	}
}
