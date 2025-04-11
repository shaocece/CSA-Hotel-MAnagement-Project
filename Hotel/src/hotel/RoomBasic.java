package hotel;
import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
public abstract class RoomBasic implements Serializable {
	private static final long serialVersionUID=3L;
	private double price;
	private String status;//3 status total: "Occupied", "Booked", "Available"
	private int RoomNumber;
	private String bedType;
	private ArrayList<String> WaitingQueue;
	private String CurrentResident=null;
	private Date DesiredCheckOut=new Date();
	abstract double calcPrice(double days, boolean Pet);
	public RoomBasic(int RoomNumber, double price, String status,String bedType)
	{
		this.price=price;
		this.RoomNumber=RoomNumber;
		this.status=status;
		this.setBedType(bedType);
		WaitingQueue=new ArrayList<String>();
	}
	void changePrice(double new_price)
	{
		setPrice(new_price);
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRoomNumber() {
		return RoomNumber;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public ArrayList<String> getWaitingQueue() {
		return WaitingQueue;
	}
	
	public void setWaitingQueue(ArrayList<String> waitingQueue) {
		WaitingQueue = waitingQueue;
	}
	
	public void joinWaitingQueue(String nextCustomer)
	{
		WaitingQueue.add(nextCustomer);
	}
	
	public void quitWaitingQueue(String selectedCustomer)
	{
		if(WaitingQueue.contains(selectedCustomer))
			WaitingQueue.remove(selectedCustomer);
		else
			JOptionPane.showMessageDialog(null, "No such usr in the queue","Error",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String callNext()
	{
		WaitingQueue.remove(0);
		return NextIntheQueue();
	}

	public String NextIntheQueue()
	{
		if(isNext())
			return WaitingQueue.get(0);
		else
			return null;
	}
	
	public boolean isNext()
	{
		return !WaitingQueue.isEmpty();
	}
	
	public String toString()
	{
		return "\nRoom Number: "+RoomNumber
				+"\nStatus: "+status
				+"\nPrice: "+price
				+"\nWaiting List:"+WaitingQueue.toString()
				+"\nCurrent Resident: "+CurrentResident
				+"\nDesired Check Out Date: "+DesiredCheckOut;
	}
	public String getCurrentResident() {
		return CurrentResident;
	}
	public void setCurrentResident(String currentResident) {
		CurrentResident = currentResident;
	}
	
	public void addDays(int date)
	{
		Calendar cal=Calendar.getInstance();
		cal.setTime(DesiredCheckOut);
		cal.add(Calendar.DATE, date);
		DesiredCheckOut=cal.getTime();
	}
	
	public void setDesiredCheckOut(Date ca)
	{
		DesiredCheckOut=ca;
	}
	
	public Date getDesiredCheckOut()
	{
		return DesiredCheckOut;
	}
	
	public boolean isOutdated(Date day)
	{
		Calendar cal=Calendar.getInstance();
		cal.setTime(DesiredCheckOut);
		Calendar compareday=Calendar.getInstance();
		compareday.setTime(day);
		return cal.get(Calendar.YEAR)>=compareday.get(Calendar.YEAR)&&cal.get(Calendar.MONTH)>=compareday.get(Calendar.MONTH)&&cal.get(Calendar.DATE)>compareday.get(Calendar.DATE);
	}
}
