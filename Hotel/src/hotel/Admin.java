package hotel;

import java.util.HashMap;

public class Admin {
	private static HashMap<String,Customer> Customers;
	private static HashMap<Integer, Room> RegRooms;
	private static HashMap<Integer, VIPRoom> VIPRooms;
	private static HashMap<String, RegWorker> RegStaffs;
	private static HashMap<String, Manager> Managers;
	public static void main(String[] args) {
		Thread tthread=new TimeThread();
		tthread.start();
		SaveMechanism.initialize();
		Customers=SaveMechanism.ReadCustomers();
		RegRooms=SaveMechanism.ReadRegRooms();
		VIPRooms=SaveMechanism.ReadVIPRooms();
		RegStaffs=SaveMechanism.ReadRegStaffs();
		Managers=SaveMechanism.ReadManager();
		/*
		 * Enter code here to fix anything in objects
		 * Please use built-in methods in each object for reference
		 * If made any changes, slash it out for log
		 * Remember to save everything after made changes
		 * e.g. VIPRooms.get(302).setStatus("Available");
		 * SaveMechanism.SaveVIPRooms(VIPRooms);
		 */
		//hire new staffs example
		/*
 		 *RegWorker Bob=new RegWorker(
 	     *        "Bob",                  // First_Name
 	     *        "Williams",             // Last_Name
 	     *        "Male",                 // gender
 	     *        "555-5678",             // number
 	     *        30,                     // age
 	     *        45000.0,                // salary
	     *        "Receptionist",         // jobtype
	     *        5,                      // WorkingExperience
	     *        40,                     // workTime
	     *        "Handles front desk"   // jobDescription
	     *    );
		 *Manager Alice=new Manager(
	     *        "Alice",                // First_Name
	     *        "Smith",                // Last_Name
	     *        "Female",               // gender
	     *        "555-1234",             // number
	     *        40,                     // age
	     *        85000.0,                // salary
	     *        "Front Desk Manager",   // jobtype
	     *        15,                     // WorkingExperience
	     *        40,                     // workTime (hours per week maybe?)
	     *        "Oversees Front Desk"  // jobDescription
	     *    );
		 *Bob.setSupervisor(Alice.getFirstName()+Alice.getLastName());
		 *Alice.AddSubordinates(Bob.getFirstName()+Bob.getLastName());
		 *RegStaffs.put(Bob.getFirstName()+Bob.getLastName(),Bob);
		 *Managers.put(Alice.getFirstName()+Alice.getLastName(), Alice);
		 *SaveMechanism.SaveWorkers(RegStaffs);
		 *SaveMechanism.SaveManagers(Managers);
		 */
	}

}
