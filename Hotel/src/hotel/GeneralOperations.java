package hotel;

public interface GeneralOperations {
	///operations that Usr can do
	public static void Book(int RoomNum) {
	}
	public void LogIn();
	public void SignUp();
	public static void Cancel(int roomNum) {}
	public static void CheckIn() {}
	public static void CheckOut() {}
	public static void ExtendDate(int roomNum) {}
	public void checkCart();
	public static void JoinQueue(int RoomNum) {}
}
