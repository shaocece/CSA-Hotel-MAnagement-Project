package hotel;
import java.io.*;
public class Room extends RoomBasic implements Serializable{
	private static final long serialVersionUID=3L;
	final double tax=0.13;
	public Room(int RoomNumber, double price, String status, String bedType)
	{
		super(RoomNumber,price,status,bedType);
	}
	
	public String toString()
	{
		return "Room: "+getRoomNumber()+
				"\nPrice Per Day"+getPrice();
	}

	double calcPrice(double days, boolean Pet) {
		if(Pet)
			return getPrice()*days*(tax+0.2);
		else
			return getPrice()*days*tax;
	}

}
