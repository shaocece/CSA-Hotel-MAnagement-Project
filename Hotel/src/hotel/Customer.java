package hotel;
import java.util.*;

import java.io.*;
public class Customer extends Human implements Serializable{
	private static final long serialVersionUID = 3L;
	private String Email=null;
	private int accompaniesNum;//this is for reference only
	private String usrName;
	private String credential; //user name is Customer's First name+Capitalized Last name first letter
	//credential is last four digits of phone number+age
	private Date CheckInTime;
	private boolean CheckInStat=false;
	private Date CheckOutTime;
	private int room=0;
	private boolean WithPets=false;
	
	public Customer(String First_Name, String Last_Name,String gender,String number, int age)
	{
		super(First_Name,Last_Name,gender,number,age);
		this.setUsrName(generateUsrName());
		this.setCredential(generateCredential());
	}
	
	public Customer(String First_Name, String Last_Name,String gender,String number, String Email, int age)
	{
		super(First_Name,Last_Name,gender,number,age);
		this.Email=Email;
		this.setUsrName(generateUsrName());
		this.setCredential(generateCredential());
	}
	

	public int getAccompaniesNum()
	{
		return accompaniesNum;
	}
	
	public void setAccompaniesNum(int accompaniesNum)
	{
		this.accompaniesNum=accompaniesNum;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email)
	{
		this.Email=email;
	}
	
	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String toString()
	{
		if(Email != null) 
			return super.toString()+
				"\nEmail: "+Email+
				"\nNumber of accompanies: "+accompaniesNum+
				"\nRoom: "+room+
				"\nCheck in Stat: "+CheckInStat+
				"\nCheck in Time"+CheckInTime;
		else
			return super.toString()+
					"\nNumber of accompanies: "+accompaniesNum+
					"\nRoom: "+room+
					"\nCheck in Stat: "+CheckInStat+
					"\nCheck in Time"+CheckInTime;
	}
	
	private String generateUsrName()
	{
		return getFirstName().concat(getLastName().substring(0,1).toUpperCase());
	}
	
	private String generateCredential()
	{
		int l = getNumber().length();
		return getNumber().substring(l-4,l).concat(""+getAge());//last four digits of the number + age
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	
	//get day, hour, year are implemented by java.util.Date
	public Date CheckIn() {
		CheckInTime=new Date();
		CheckInStat=true;
		return CheckInTime;
	}
	
	public boolean getCheckInStat() {
		return CheckInStat;
	}
	
	public void resetCheckIn() {
		CheckInStat=false;
	}
	
	public Date CheckOut() {
		CheckOutTime=new Date();
		return CheckOutTime;
	}
	
	public boolean isWithPets() {
		return WithPets;
	}

	public void setWithPets(boolean withPets) {
		WithPets = withPets;
	}
}