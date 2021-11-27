import java.util.Scanner;

public class adminlogin {
	static Scanner scan = new Scanner(System.in);
	static admindata admindata = new admindata();
	static features features = new features();
	
	static void signup() {
		int a = 0;
		while(a == 0) {
			System.out.println("1 : Register\n2 : Login");
			String option = scan.next();
			switch(option) {
				case("1"):
					a = 1;
					register();
					break;
				case("2"):
					a = 1;
					login();
					break;
				default:
					System.out.println("Invalid input");				
			}
		}
	}
	// Register
	static void register() {
		int i = 0;
		while(i == 0) {
			System.out.println("Enter new user name");
			String name = scan.next();
			if(admindata.admins.containsKey(name)) {
				System.out.println("Admin Exists");
			}else {
				System.out.println("Enter new password");
				String password = scan.next();
				int len = password.length();
				if(len < 8 || len > 16) {
					System.out.println("Password must be more than 7 and less than 16");
				}else {
					System.out.println("Confirm password");
					String confirm_password = scan.next();
					if(password.equals(confirm_password)) {
						System.out.println("Registration successful");
						admindata.addadmin(name, password);
						i = 1;
						login();
						//System.out.println(admindata.admins);
					}else {
						System.out.println("Password dose not match");
						System.out.println(password);
						System.out.println(confirm_password);
					}
				}
			}
			
			
		}
	}
	
	// Login`
	static void login() {
		int i = 0;
		while(i == 0) {
			System.out.println("Enter username");
			String name = scan.next();
			if(!admindata.admins.containsKey(name)) {
				System.out.println("User not found");
			}else {
				System.out.println("Enter password");
				String password = scan.next();
				if(admindata.admins.get(name).equals(password)) {
					System.out.println("Login Successful");
					i = 1;
					features.tab();
				}else {
					System.out.println("Password not Match");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		signup();
	}

}
