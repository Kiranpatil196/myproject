package com.mit;
import java.util.Scanner;

class Taxi {
	char initialPoint;
	int departureTime, earnings;

	public Taxi() {
		initialPoint = 'A';
	}

	public void departureTime(int pickTime, char pick, char drop) {
		this.departureTime = (pickTime + (Math.abs(pick - drop)));
	}

	public void calculateEarnings(char pick, char drop) {
		int dist = (Math.abs(pick - drop) * 15);
		int amount = ((dist - 5) * 10) + 100;
		this.earnings = earnings + amount;
	}

}
 
class Booking {
	int customerId, pickupTime, dropTime, earnings, taxino;
	char pickupPoint;
	char dropPoint;
	Taxi[] t;

	Booking(int id, char pick, char drop, int PickTime) {
		customerId = id;
		pickupPoint = pick;
		dropPoint = drop;
		pickupTime = PickTime;
	}

	public void dropTime() {
		this.dropTime = (pickupTime + (Math.abs(pickupPoint - dropPoint)));
	}

	public void calculateEarnings() {
		int dist = (Math.abs(pickupPoint - dropPoint) * 15);
		this.earnings = ((dist - 5) * 10) + 100;

	}

	public int isAvailable(Taxi[] t, int n) {
		int j, min = 6, temp = -1;
		for (j = 0; j < n; j++) {
			if (Math.abs(pickupPoint - t[j].initialPoint) <= min && t[j].departureTime <= pickupTime) {
				if (temp == -1 || Math.abs(pickupPoint - t[j].initialPoint) < min)
					temp = j;
				if (Math.abs(pickupPoint - t[j].initialPoint) == min && t[j].earnings != 0) {
					if (t[temp].earnings > t[j].earnings)
						temp = j;
				}
				min = Math.abs(pickupPoint - t[j].initialPoint);

			}
		}
		if (min != 6) {
			t[temp].departureTime(pickupTime, pickupPoint, dropPoint);
			t[temp].initialPoint = dropPoint;
			taxino = temp;

			return temp;
		}
		return -1;
	}

}

public class TaxiBook {


	public static void main(String[] args) {

		Booking[] b = new Booking[10];
		int i = 0, j = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of taxies: ");
		int n = scan.nextInt();
		Taxi[] t = new Taxi[n];
		for (int a = 0; a < n; a++) {
			t[a] = new Taxi();
		}

		while (true) {
			System.out.println("========================================================================");
			System.out.println("TAXI BOOKING");
			System.out.println("1.Booking");
			System.out.println("2.Display");
			System.out.println("3.Exit");
			System.out.println("========================================================================");
			System.out.print("Enter your choice: ");
			int ch = scan.nextInt();
			System.out.println("========================================================================");

			switch (ch) {
			case 1:

				System.out.println("Input " + (i + 1) + ":");
				System.out.println("Customer Id:");
				int id = scan.nextInt();
				System.out.println("Pickup Point:");
				scan.nextLine();
				char pick = scan.nextLine().charAt(0);
				System.out.println("Drop Point:");
				char drop = scan.nextLine().charAt(0);
				System.out.println("Pickup Time:");
				int PickTime = scan.nextInt();
				b[i] = new Booking(id, pick, drop, PickTime);
				int a;
				a = b[i].isAvailable(t, n);
				System.out.println("ouput " + (i + 1));
				if (a != -1) {
					System.out.println("Taxi-" + (a + 1) + " is alloted");

					t[a].calculateEarnings(b[i].pickupPoint, b[i].dropPoint);

					b[i].dropTime();
					b[i].calculateEarnings();
				} else
					System.out.println("Booking is rejected!!!!");
				i++;
				break;
			case 2:
				System.out.format("%-10s%-10s\n", "Taxi No:", "Total Earnings:");
				System.out.format("%-10s%-13s%-10s%-10s%-13s%-10s%-10s\n", "BookingID", "CustomerId", "From", "To",
						"PickupTime", "DropTime", "Amount");
				System.out.println("output");
				for (int k = 0; k < n; k++) {
					if (t[k].earnings != 0) {
						System.out.println("Taxi-" + (k + 1) + "    " + "Total Earnings:" + "Rs . " + t[k].earnings);
						for (j = 0; j < i; j++) {
							if (b[j].taxino == k) {

								System.out.format("%-10d%-10d%-10c%-10c%-10d%-10d%-10d\n", (j + 1), b[j].customerId,
										b[j].pickupPoint, b[j].dropPoint, b[j].pickupTime, b[j].dropTime,
										b[j].earnings);
							}

						}
					}
				}

				break;

			case 3:
				System.exit(0);

			default:
				System.out.println("Invalid Input!!!!");

			}
		}
	}

}




