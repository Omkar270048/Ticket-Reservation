import java.util.HashMap;

public class admindata {


static HashMap<String, String> admins = new HashMap<String, String>();
	{
		admins.put("omkar", "12345678");
	}
	
	static void addadmin(String name,String password){
		admins.put(name, password);
	}
}
