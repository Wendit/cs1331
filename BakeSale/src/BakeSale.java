import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The BakeSale class simulates a bake sale.
 * 
 * @author Elizabeth,Wendi Tang
 */
public class BakeSale {

	// make new counter objects to keep track of our items

	public static void main(String[] args) {
		Logger logger = Logger.getAnonymousLogger();
		Scanner scan = new Scanner(System.in);
		int choice;
		String track;
		Counter[] counters = { new Counter("Cupcakes", 24),
				new Counter("Brownies", 30), new Counter("Cookies", 12) };
		int quantity;

		// we want our program to loop until we have sold everything
		while (Counter.getTotalCount() > 0) {
			System.out
					.print("Welcome to our bake sale! \n"
							+ "Would you like to buy something? Or do you have a delivery?[B\\D] ");
			track = scan.nextLine().toLowerCase();
			// since we allow for people to give us deliveries and buy things,
			// we have to keep track of this
			// If buying things
			try {
				
				if (track.contains("b")) {
					System.out.println("We have");
					for (int i = 0; i < counters.length; i++) {
						System.out.println(counters[i].toString() + " [" + i
								+ "]");
					}

					System.out.println("What do you want?[Number]");
					choice = Integer.parseInt(scan.nextLine());

					if (choice >= counters.length) {
						System.out.println("Sorry we don't have this item.");
					} else {
						if (counters[choice].getCount() == 0) {
							System.out
									.println("I'm sorry, we don't have any more "
											+ counters[choice].getItemName()
											+ " :[");
						} else {
							System.out.println("How many do you want?");
							quantity = Integer.parseInt(scan.nextLine());
							if (quantity > counters[choice].getCount()) {
								System.out
										.println("I'm sorry, we don't have that many "
												+ counters[choice]
														.getItemName()
												+ " :[ But here are all.");
								counters[choice].reset();
							} else {
								counters[choice].changeCount(false, quantity);
							}
						}
					}

				} else if (track.contains("d")) {

					System.out.println("Now we have");
					for (int i = 0; i < counters.length; i++) {
						System.out.println(counters[i].toString() + " [" + i
								+ "]");
					}

					System.out.println("What do you have for us? [Number]");
					choice = Integer.parseInt(scan.nextLine());

					System.out.println("How many do you have?");
					quantity = Integer.parseInt(scan.nextLine());
					
					counters[choice].changeCount(true, quantity);

				}

			} catch (NumberFormatException e) {
				System.out
						.println("Invalid format. Please enter a valid number.");
			} catch (Exception o) {
				System.out
						.println("Unexpected exception. Error has been logged.");
				logger.log(Level.SEVERE, "an exception was thrown", o);
			}
		}
			// we're done!
			System.out.println("We sold out! Goodbye");
	}
}
