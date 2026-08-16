import java.time.LocalDate;
import java.util.Scanner;

public class job2 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println("Goa 3-Day Trip Budget Calculator");
		System.out.println("Date: " + today);
		System.out.println();

		// Defaults (can be overridden via CLI args or interactive prompts)
		String from = "Bengaluru";
		String to = "Goa";
		int days = 2;
		int travelers = 2; // number of people

		double travelPerPerson = 2500.00; // roundtrip travel cost per person (INR)
		double hotelPerNightPerRoom = 3500.00; // per room per night
		int peoplePerRoom = 2; // sharing
		double foodPerPersonPerDay = 800.00;
		double localTransportPerPersonPerDay = 300.00;
		double sightseeingPerPerson = 1200.00; // lump sum per person for activities
		double miscPerPerson = 600.00; // shopping, tips, etc.

		// If args are provided, parse them in order (all optional):
		// travelers days travelPerPerson hotelPerNightPerRoom peoplePerRoom foodPerPersonPerDay localTransportPerPersonPerDay sightseeingPerPerson miscPerPerson
		if (args.length > 0) {
			try {
				if (args.length > 0) travelers = Integer.parseInt(args[0]);
				if (args.length > 1) days = Integer.parseInt(args[1]);
				if (args.length > 2) travelPerPerson = Double.parseDouble(args[2]);
				if (args.length > 3) hotelPerNightPerRoom = Double.parseDouble(args[3]);
				if (args.length > 4) peoplePerRoom = Integer.parseInt(args[4]);
				if (args.length > 5) foodPerPersonPerDay = Double.parseDouble(args[5]);
				if (args.length > 6) localTransportPerPersonPerDay = Double.parseDouble(args[6]);
				if (args.length > 7) sightseeingPerPerson = Double.parseDouble(args[7]);
				if (args.length > 8) miscPerPerson = Double.parseDouble(args[8]);
				System.out.println("Using command-line arguments to compute budget.");
			} catch (NumberFormatException e) {
				System.out.println("Invalid CLI argument(s). Falling back to interactive prompts or defaults.");
			}
		} else {
			// Interactive prompts
			Scanner scanner = new Scanner(System.in);
			System.out.println("No CLI args provided — enter values or press Enter to keep defaults in [brackets].");

			System.out.print("Number of travelers [" + travelers + "]: ");
			String line = scanner.nextLine().trim();
			if (!line.isEmpty()) travelers = Integer.parseInt(line);

			System.out.print("Number of days [" + days + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) days = Integer.parseInt(line);

			System.out.print("Travel cost per person (INR) [" + travelPerPerson + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) travelPerPerson = Double.parseDouble(line);

			System.out.print("Hotel per night per room (INR) [" + hotelPerNightPerRoom + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) hotelPerNightPerRoom = Double.parseDouble(line);

			System.out.print("People per room [" + peoplePerRoom + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) peoplePerRoom = Integer.parseInt(line);

			System.out.print("Food per person per day (INR) [" + foodPerPersonPerDay + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) foodPerPersonPerDay = Double.parseDouble(line);

			System.out.print("Local transport per person per day (INR) [" + localTransportPerPersonPerDay + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) localTransportPerPersonPerDay = Double.parseDouble(line);

			System.out.print("Sightseeing per person (INR) [" + sightseeingPerPerson + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) sightseeingPerPerson = Double.parseDouble(line);

			System.out.print("Misc per person (INR) [" + miscPerPerson + "]: ");
			line = scanner.nextLine().trim();
			if (!line.isEmpty()) miscPerPerson = Double.parseDouble(line);

			scanner.close();
		}

		int roomsNeeded = (travelers + peoplePerRoom - 1) / peoplePerRoom;

		double totalTravel = travelPerPerson * travelers;
		double totalHotel = hotelPerNightPerRoom * roomsNeeded * days;
		double totalFood = foodPerPersonPerDay * travelers * days;
		double totalLocalTransport = localTransportPerPersonPerDay * travelers * days;
		double totalSightseeing = sightseeingPerPerson * travelers;
		double totalMisc = miscPerPerson * travelers;

		double grandTotal = totalTravel + totalHotel + totalFood + totalLocalTransport + totalSightseeing + totalMisc;
		double perPerson = grandTotal / travelers;

		System.out.println("Trip: " + from + " -> " + to + " for " + days + " days, " + travelers + " travelers");
		System.out.println();

		System.out.printf("%-30s : INR %.2f%n", "Travel (roundtrip, total)", totalTravel);
		System.out.printf("%-30s : INR %.2f%n", "Hotel (total for " + roomsNeeded + " room(s))", totalHotel);
		System.out.printf("%-30s : INR %.2f%n", "Food (total)", totalFood);
		System.out.printf("%-30s : INR %.2f%n", "Local transport (total)", totalLocalTransport);
		System.out.printf("%-30s : INR %.2f%n", "Sightseeing & activities (total)", totalSightseeing);
		System.out.printf("%-30s : INR %.2f%n", "Miscellaneous (total)", totalMisc);
		System.out.println("------------------------------------------------------------");
		System.out.printf("%-30s : INR %.2f%n", "Grand total", grandTotal);
		System.out.printf("%-30s : INR %.2f per person%n", "Estimated cost per person", perPerson);

		System.out.println();
		System.out.println("Notes:");
		System.out.println("- Modify the sample input values in the source to match real quotes (travel, hotel, etc.).");
		System.out.println("- For more accuracy, fetch live fares or accept user input via Scanner.");
	}
}
