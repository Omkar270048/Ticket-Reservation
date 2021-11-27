import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

import java.util.Random;
import java.util.Scanner;

public class bookticket {
//classes
static Scanner scan = new Scanner(System.in);
static Random random = new Random();
static railwayroute route = new railwayroute();
static reservation r = new reservation();

//variables
static String name;
static String from;
static String destination;
static String pnr;
static int age;
static String gender;
static String seat;

	static String d() {
		//get date
				LocalDateTime myDateObj = LocalDateTime.now(); 
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
			    String formattedDate = myDateObj.format(myFormatObj);
			    return formattedDate;
	}

//add tickets
	static void addticket() {
		System.out.println("Name :");
		name = scan.next();
		
		// age
	    while(true) {    
	        try {
	            System.out.println("Age: ");
	            Scanner input = new Scanner(System.in);
	            age = input.nextInt();
	            break;
	        }
	        catch(Exception e) {
	            System.out.println("Invalid Number, Please try again");
	        }
	    }
		
		//from
		int a = 0;
		while(a == 0) {
		System.out.println("From :");
		from = scan.next();
		for(String i: route.station) {
			if(from.equalsIgnoreCase(i)) {
			a = 1;
			}
		}
		}
		
		//destination
		a = 0;
		while(a == 0) {
			System.out.println("Destination :");
			destination = scan.next();
			if(!destination.equals(from)) {
				
				for(String i: route.station) {
					if(destination.equalsIgnoreCase(i)) {
					a = 1;
					}
				}
			}
			else {
				System.out.println("\"Destination\" cannot be same as \"from\"");
			}
		
		}
		
		//gender
		a = 0;
		while(a == 0) {
			System.out.println("Gender \n\t1 : Male \n\t2 : Female");
			String option = scan.next();
			switch(option) {
			case("1"):
				gender = "Male";
				a = 1;
				break;
			case("2"):
				gender = "Female";
				a = 1;
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		
		//seat no
		a = 0;
		while(a == 0) {
			System.out.println("Seat No :");
			seat = scan.next();
			if(gender.equals("Male") && r.reservedForFemale.contains(seat)) {
				System.out.println("Seat between 1 - 20 is reserved for female");
			}
			else if(r.unbook_tickets.contains(seat)) {
				r.removetickets(seat);
				a = 1;
			}else if(r.unbook_tickets.size() == 0) {
				System.out.println("Train is full");
			}
			else {
				System.out.println("Seat not available");
			}
		}	
		
		
		// PNR 
		int pnr1 = random.nextInt(999999);
		String p1 = String.format("%06d", pnr1);
		int pnr2 = random.nextInt(999999); 
		String p2 = String.format("%06d", pnr2);
		String pnr = p1.concat(p2);
		System.out.printf("PNR : %s\nTicket Booked Successful\n\n", pnr);
		
		
		
	    
		//storing ticket data in reservation.java
		//d();
		r.seat(pnr, seat);
		r.name(pnr, name);
		r.from(pnr, from);
		r.destination(pnr,destination);
		r.age(pnr, age);
		r.gender(pnr, gender);
		r.cost(pnr);
		r.add_pnr(pnr);
		r.dates(pnr, d());
	}
}
