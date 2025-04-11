package hotel;
import java.util.Date;
public class TimeThread extends Thread{
	///this thread is reserved for notifying customers and calculate days that staff worked
	///e.g. using isOutDated(date) method from room object to send message
	///customizable for admin
	private Date date;
	final private static int TimeBlock=60000;//set for updating time	1000=1s
	@Override
	public void run()
	{
		while(true)
		{
			try {
				updateDate();
				System.out.println(date);
				Thread.sleep(TimeBlock);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void updateDate()
	{
		date=new Date();
	}
}
