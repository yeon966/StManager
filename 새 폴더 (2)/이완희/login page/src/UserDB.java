public class UserDB {
	
	User[] users;

	public UserDB() {
		users = new User[5];
		users[0] = new User("ang123", "321gna");
		users[1] = new User("pang123", "321gnap");
		users[2] = new User("mang123", "321gnam");
		users[3] = new User("gang123", "321gnag");
		users[4] = new User("bang123", "321gnab");
	}
}