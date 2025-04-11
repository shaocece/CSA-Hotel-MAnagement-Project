package hotel;
import java.io.*;
//create general Human object
public class Human implements Serializable{
	private static final long serialVersionUID = 3L;
	private String First_Name;
	private String Last_Name;
	private String gender;
	private String number;
	private int age;
	public Human(String First_Name, String Last_Name, String gender,String number, int age)
	{
		this.First_Name=First_Name;
		this.Last_Name=Last_Name;
		this.gender=gender;
		this.number=number;
		this.age=age;
	}
	
	public String getFirstName()
	{
		return First_Name;
	}
	public String getLastName()
	{
		return Last_Name;
	}
	public String getGender()
	{
		return gender;
	}
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return "Name: "+Last_Name+", "+First_Name+
				"\nAge: "+age+
				"\nGender: "+gender+
				"\nNumber: "+number;
	}
}
