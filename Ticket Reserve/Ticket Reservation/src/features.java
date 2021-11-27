import java.util.Scanner;

public class features {
	static Scanner scan = new Scanner(System.in);
	static bookticket bookticket = new bookticket();
	static wallet wallet = new wallet();
	static reservation reservation = new reservation();
	
	static void tab() {
		//adding not booked seat from 1 - 100;
		reservation.availableseats();
		// adding reserve seat for female
		reservation.forfemale();
		//System.out.println(reservation.unbook_tickets);
		
		// features
		int a = 0;
		while(a == 0) {
			System.out.println("\t1 : Book Tickets\n\t2 : Cancle Ticket\n\t3 : Display Reservation"
					+ "\n\t4 : Search passanger\n\t5 : Unbook Tickets\n\t6 : Wallet");
			String option = scan.next();
			switch(option) {
			case("1"):
				System.out.print("Available Seats :");
				System.out.println(reservation.unbook_tickets);
				bookticket.addticket();
				break;
			case("2"):
				reservation.cancle();
				break;
			case("3"):
				reservation.allpassengers();
				break;
			case("4"):
				reservation.search();
				break;
			case("5"):
				System.out.println(reservation.unbook_tickets);
				break;
			case("6"):
				//System.out.println(wallet.buy());
				wallet.current_money();
				break;
			default:
				
			}
		}
	}

}
