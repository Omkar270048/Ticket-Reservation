import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class reservation {
	static bookticket bt = new bookticket();
	static Scanner scan = new Scanner(System.in);
	static wallet wallet = new wallet();
	
	//static String[] pnr;
	//static HashMap<Integer, String> hpnr = new HashMap<Integer, String>();
	static ArrayList<String> pnrs = new ArrayList<String>();
	static ArrayList<String> unbook_tickets = new ArrayList<String>();
	static ArrayList<String> reservedForFemale = new ArrayList<String>();
	static HashMap<String, String> name = new HashMap<String, String>();
	static HashMap<String, String> from = new HashMap<String, String>();
	static HashMap<String, String> destination = new HashMap<String, String>();
	static HashMap<String, Integer> age = new HashMap<String, Integer>();
	static HashMap<String, String> gender = new HashMap<String, String>();
	static HashMap<String, String> seat = new HashMap<String, String>();
	static HashMap<String, Integer> cost = new HashMap<String, Integer>();
	static HashMap<String, String> dates = new HashMap<String, String>();

	// add pnr
	static void add_pnr(String x) {
	pnrs.add(x);	
	}
	
	static void availableseats() {
		//available seats adding in the start of code
		String a;
		for(int i = 1; i <= 100; i++) {
				a = Integer.toString(i);
				unbook_tickets.add(a);
			}
	}
	
	// adding reserved seat for female in reserveForFemale arraylist
	// it reserve for female and cannot be used by male
	static void forfemale() {
		//available seats adding in the start of code
		String a;
		for(int i = 1; i <= 20; i++) {
				a = Integer.toString(i);
				reservedForFemale.add(a);
			}
	}
	
	// remove tickets if tickets are booked
	static void removetickets(String x) {
		unbook_tickets.remove(x);
	}
	
	// add name
	static void name(String a, String b) {
		name.put(a, b);
	}
	
	//add from
	static void from(String a, String b) {
		from.put(a, b);
	}
	
	// adding destination
	static void destination(String a, String b) {
		destination.put(a, b);
	}
	
	// add age
	static void age(String a, int b) {
		age.put(a, b);
	}
	
	//add gender
	static void gender(String a, String b) {
		gender.put(a, b);
	}
	
	// add seat
	static void seat(String a, String b) {
		seat.put(a, b);
	}
	//add cost
	static void cost(String a) {
		cost.put(a, wallet.buy());
		wallet.money -= wallet.buy();
	}
	
	//add dates
	static void dates(String a, String b) {
		dates.put(a, b);
	}
	
	static void search() {
		String passenger;
		System.out.println("Enter PNR number:");
		passenger = scan.next();		
		
		System.out.printf("Name: %s \t", name.get(passenger));
		System.out.printf("Age: %d \t", age.get(passenger));
		System.out.printf("PNR: %s \n", passenger);
		System.out.printf("Gender: %s \t", gender.get(passenger));
		System.out.printf("Seat no: %d \t", seat.get(passenger));
		System.out.printf("Cost: %d \n", cost.get(passenger));
		System.out.printf("From: %s \t", from.get(passenger));
		System.out.printf("To: %s \t", destination.get(passenger));
		System.out.printf("Time: %s \n", dates.get(passenger));
	}
	
	static void allpassengers() {
		for(String i: pnrs) {
			System.out.printf("Name: %s \t", name.get(i));
			System.out.printf("Age: %d \t", age.get(i));
			System.out.printf("PNR: %s \n", i);
			System.out.printf("Gender: %s \t", gender.get(i));
			System.out.printf("Seat no: %s \t", seat.get(i));
			System.out.printf("Cost: %d \n", cost.get(i));
			System.out.printf("From: %s \t", from.get(i));
			System.out.printf("To: %s \t", destination.get(i));
			System.out.printf("Time: %s \n\n", dates.get(i));
		}
	}
	
	static void cancle() {
		System.out.println("only 80% of ticket cost will be refund to you.");
		
		String c;
		while(true) {
			System.out.println("Enter PNR to cancle booking");
			c = scan.next();
			if(pnrs.contains(c)) {
				name.remove(c);
				age.remove(c);
				gender.remove(c);
				seat.remove(c);
				int a = cost.get(c);
				int m = 20 * a / 100;
				int add = a - m;
				wallet.money += add;

				cost.remove(c);
				from.remove(c);
				destination.remove(c);
				dates.remove(c);
				pnrs.remove(c);
			}
		}	
		
		
	}
	
	
}
