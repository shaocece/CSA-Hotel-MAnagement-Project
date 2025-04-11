package hotel;
import java.io.*;
public class VIPRoom extends RoomBasic implements Serializable{
	private static final long serialVersionUID = 3L;
	private String BathTubType;
	private String BalconyType;
	final double tax=.22;
	public VIPRoom(int RoomNumber, double price, String status, String bedType, String BathTubType, String BalconyType) {
		super(RoomNumber, price, status, bedType);
		this.BathTubType=BathTubType;
		this.BalconyType=BalconyType;
	}
	public String getBathTubType() {
		return BathTubType;
	}

	double calcPrice(double days, boolean Pets) {
		if(Pets)
			return days*getPrice()*(tax+.1);
		else
			return days*getPrice()*tax;
	}
	public String getBalconyType() {
		return BalconyType;
	}
	

}
