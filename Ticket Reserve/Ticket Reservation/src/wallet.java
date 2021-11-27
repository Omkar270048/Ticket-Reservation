
public class wallet {
	static bookticket bookticket = new bookticket();
	static railwayroute route = new railwayroute();
	static int len = route.station.length;
	static String[] rs = route.station;
	
	static int arrayIndex(String x) {
		String pos = x;
		int a = 1;
		for(String i: rs) {
			if(x.equalsIgnoreCase(i)) {
				break;
			}
			else {
				a++;
			}
		}
		return a;
	}
	
	// ticket cost
	/*static int ticketcost(String i, String j) {
		
		System.out.println(arrayIndex(from));
		System.out.println(arrayIndex(destination));
		
	}*/
	
	static int money = 10000;
	
	static int buy() {
		String from = bookticket.from;
		String destination = bookticket.destination;
		//System.out.println(arrayIndex(from));
		//System.out.println(arrayIndex(destination));
		int a, b;
		if(arrayIndex(from) < arrayIndex(destination)) {
			a = arrayIndex(destination);
			b = arrayIndex(from);
		}
		else {
			b = arrayIndex(destination);
			a = arrayIndex(from);
		}
		int cost = (a - b) * 5;
		return cost;
		
	}
	
	static void current_money() {
		System.out.printf("Wallet: %d",money);
	}
	
}
