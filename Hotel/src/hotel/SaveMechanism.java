package hotel;
import java.io.*;
import java.util.*;

public class SaveMechanism {
	final static String path="Saves/";
	private static final String ManagersFile=path+"Managers.ser" ;
	private static final String RegWorkersFile=path+"RegWorkers.ser" ;
	private static final String CustomersFile=path+"Customers.ser";
	private static final String RegRoomsFile=path+"RegRooms.ser";
	private static final String VIPRoomsFile=path+"VIPRooms.ser";
	public static void initialize()//create the folder for datas
	{
		File FolderPath=new File(path);
		if (!FolderPath.exists()){
		    FolderPath.mkdirs();
		}
		File ManagersPath=new File(ManagersFile);
		if (!ManagersPath.exists()){
		    	HashMap<String, Manager> Mng=new HashMap<String,Manager>();
		    	SaveManagers(Mng);
		}
		File RegWorkersPath=new File(RegWorkersFile);
		if (!RegWorkersPath.exists()){
			HashMap<String, RegWorker> Wkr=new HashMap<String,RegWorker>();
	    	SaveWorkers(Wkr);
		}
		File CustomersPath=new File(CustomersFile);
		if (!CustomersPath.exists()){
			HashMap<String, Customer> Cus=new HashMap<String,Customer>();
	    	SaveCustomers(Cus);
		}
		File RegRoomsPath=new File(RegRoomsFile);
		if (!RegRoomsPath.exists()){
			HashMap<Integer, Room> RegRm=new HashMap<Integer,Room>();
	    	SaveRegRooms(RegRm);
		}
		File VIPRoomsPath=new File(VIPRoomsFile);
		if (!VIPRoomsPath.exists()){
			HashMap<Integer, VIPRoom> VIPRm=new HashMap<Integer,VIPRoom>();
	    	SaveVIPRooms(VIPRm);
		}
	}
	public static void SaveManagers(HashMap<String, Manager> staffList)//Save as pair of manager and working hours
	{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ManagersFile))) {
            oos.writeObject(staffList);
            System.out.println("Managers list saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void SaveWorkers(HashMap<String,RegWorker> staffList)//same as manager
	{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RegWorkersFile))) {
            oos.writeObject(staffList);
            System.out.println("Workers list saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void SaveCustomers(HashMap<String, Customer> customersList)
	{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CustomersFile))) {
            oos.writeObject(customersList);
            System.out.println("Customers list saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void SaveRegRooms(HashMap<Integer,Room> roomList)//Room and status
	{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RegRoomsFile))) {
            oos.writeObject(roomList);
            System.out.println("Regular Rooms list saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void SaveVIPRooms(HashMap<Integer, VIPRoom> l)
	{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(VIPRoomsFile))) {
            oos.writeObject(l);
            System.out.println("VIP Rooms list saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
//	public void SaveExtraItems()
//	{}
	@SuppressWarnings("unchecked")
	public static HashMap<String,RegWorker> ReadRegStaffs()
		{   
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RegWorkersFile)))
			{
	        return (HashMap<String, RegWorker>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return null;
	    }
		}
	@SuppressWarnings("unchecked")
	public static HashMap<String,Manager> ReadManager()
		{   
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ManagersFile)))
			{
	        return (HashMap<String, Manager>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return null;
	    }
		}
	@SuppressWarnings("unchecked")
	public static HashMap<String, Customer> ReadCustomers()
		{   
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CustomersFile)))
			{
	        return (HashMap<String,Customer>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) { 
	        e.printStackTrace();
	        return null;
	    }
	}
	@SuppressWarnings("unchecked")
	public static HashMap<Integer, Room> ReadRegRooms()
		{   
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RegRoomsFile)))
			{
				return (HashMap<Integer,Room>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	@SuppressWarnings("unchecked")
	public static HashMap<Integer,VIPRoom> ReadVIPRooms()
		{   
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(VIPRoomsFile)))
			{
	        return (HashMap<Integer, VIPRoom>) ois.readObject();
	    } catch (IOException | ClassNotFoundException e) { 
	        e.printStackTrace();
	        return null;
	    }
	}


	public static void main(String[] args)//testing purpose
	{
//		initialize();
//		Customer k=new Customer("Qua", "Muhaha", "Male", "114514", 25, false, 0);
//		VIPRoom m=new VIPRoom(201, 39, "Available", "Fancy", "Fancy", "Fancy");
//		k.setRoom(m);
//		m.setCurrentResident(k);
//		l.put(m.getRoomNumber(),m);
//		SaveVIPRooms(l);//make all things static, also make every object implement serializable
//		HashMap<Integer, VIPRoom> v=ReadVIPRooms();
//		v.remove(201);
//		System.out.println(v.toString());
//		System.out.println(v.get(201).getCurrentResident());
//		HashMap<String,Customer> Customers=ReadCustomers();
//		System.out.println(Customers.toString());
//		JOptionPane.showMessageDialog(null, "Successfully Signed Up!\nYour User Name is first name+UpperCased first letter of last name","Congrats",JOptionPane.INFORMATION_MESSAGE);
////For adding rooms
		HashMap<Integer,VIPRoom> l=new HashMap<Integer,VIPRoom>();
		HashMap<Integer,Room> m=new HashMap<Integer,Room>();
		Room R101=new Room(101, 49.99, "Available", "Single");
		Room R102=new Room(102, 56.99, "Available","Double");
		Room R103=new Room(103, 56.99, "Available", "Double");
		Room R201=new Room(201, 49.99, "Available", "Single");
		Room R202=new Room(202, 49.99, "Available", "Single");
		Room R203=new Room(203, 56.99, "Available", "Double");
		m.put(101, R101);
		m.put(102, R102);
		m.put(103, R103);
		m.put(201, R201);
		m.put(202, R202);
		m.put(203, R203);
		VIPRoom R302=new VIPRoom(302, 109, "Available", "Fancy", "Comfort", "Wide");
		VIPRoom R301=new VIPRoom(301, 129, "Available", "Fancy", "Fancy", "Huge");
		VIPRoom R303=new VIPRoom(303, 139, "Available", "Fancy", "Fancy", "Fancy");
		l.put(301, R301);
		l.put(302, R302);
		l.put(303, R303);
		
		Room R104=new Room(104, 69.99, "Available", "Two Singles");
		Room R105=new Room(105, 69.99, "Available", "Two Singles");
		Room R204=new Room(204, 72.99, "Available", "Two Singles");
		Room R205=new Room(205, 76.99, "Available", "Three Singles");
		VIPRoom R304=new VIPRoom(304, 149, "Available", "Double Fancys", "Fancy", "Huge");
		VIPRoom R305=new VIPRoom(305, 159, "Available", "Three Fancys", "Luxury", "Dreamy");
		l.put(304, R304);
		l.put(305, R305);
		m.put(104, R104);
		m.put(105, R105);
		m.put(204, R204);
		m.put(205, R205);
		SaveRegRooms(m);
		SaveVIPRooms(l);
		
		
//		HashMap<Integer,VIPRoom> l=ReadVIPRooms();
//		HashMap<Integer,Room> m=ReadRegRooms();
	}
}
