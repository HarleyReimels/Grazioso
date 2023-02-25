/* 	Method Name: Driver
 * 
 * 	The driver class is the class we use to create
 * 	and store our Dog Objects and Monkey Objects
 * 	We can also check the status of which dogs and monkeys
 * 	are in the system as well as which are not reserved.
 * 
 * 	Author: Harley Reimels
 * 	Date Created: 02/16/2023
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	// Created a variable to have the menu loop
	private static Character menuOption = null;

	static Scanner scanner = new Scanner(System.in);

	// ArrayLists for dog and monkey objects
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

	public static void main(String[] args) {

		initializeDogList();
		initializeMonkeyList();

		// Created menu loop using do-while and switch statements
		do {
			displayMenu();
			menuOption = scanner.next().charAt(0);

			// If the menuOption is a number and only only character we choose from the
			// number menu
			if (Character.isDigit(menuOption)) {
				int number = Character.getNumericValue(menuOption);
				switch (number) {
				case 1:
					intakeNewDog(scanner);
					break;
				case 2:
					intakeNewMonkey(scanner);
					break;
				case 3:
					reserveAnimal(scanner);
					break;
				case 4:
					printAnimals(number);
					break;
				case 5:
					printAnimals(number);
					break;
				case 6:
					printAnimals(number);
					break;
				// Catches any digit character not 1-6
				default:
					System.out.println("Please enter a valid choice.");
				}

			} else {
				// Catches any string not q
				if (menuOption != 'q') {
					System.out.println("Please enter a valid choice.");
				}
			}
			// Terminates Program
		} while (menuOption != 'q');
	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}

	// Adds dogs to a list for testing
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
				true, "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in-service", false,
				"United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "United States", "in-service",
				false, "United States");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}

	// Adds monkeys to a list for testing
	public static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Bill", "Ape", "male", "6", "114.2", "02-03-2023", "United States", "Phase I",
				false, "Canada", 22.8, 10.1, 244.6);
		Monkey monkey2 = new Monkey("Jane", "chimp,", "female", "2", "34.2", "05-23-2013", "Mexico", "in-service",
				false, "Brazil", 22.8, 10.1, 244.6);
		Monkey monkey3 = new Monkey("Fred", "lemur", "male", "16", "144.5", "01-23-2010", "Portugal", "in-service",
				false, "Italy", 22.8, 10.1, 244.6);

		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
	}

	// Method for adding a new dog
	public static void intakeNewDog(Scanner scanner) {

		// Set all appropriate variables
		String name, breed, gender, age, weight, acquistionDate, acquistionCountry, trainingStatus, inServiceCountry;
		boolean reserved;

		scanner.nextLine();
		System.out.println("What is the dog's name?");

		name = scanner.nextLine();

		// Loop through every dog name in dogList array
		for (Dog dog : dogList) {
			// If dog is already in the system we return to menu
			if (dog.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis dog is already in our system\n\n");
				return; // returns to menu
			}
		}

		// If dog is not in system, continue.
		// Using the appropriate method, we assign each variable the correct data

		breed = dogBreed();

		gender = animalGender();

		age = animalAge();

		weight = animalWeight();

		acquistionDate = animalAcquisitionDate();

		acquistionCountry = animalAcquisitionCountry();

		trainingStatus = animalTrainingStatus();

		reserved = animalReserved();

		inServiceCountry = animalInServiceCountry();

		// Create the new dog object, and add it to the array
		Dog dog4 = new Dog(name, breed, gender, age, weight, acquistionDate, acquistionCountry, trainingStatus,
				reserved, inServiceCountry);
		dogList.add(dog4);
		System.out.println("Congratulations, dog was added!");
	}

	// Method for adding a new monkey with appropriate variables
	public static void intakeNewMonkey(Scanner scanner) {
		// Set all appropriate variables
		String name, gender, age, weight, acquistionDate, acquistionCountry, trainingStatus, inServiceCountry, species;
		boolean reserved;
		double tailLength, height, bodyLength;

		scanner.nextLine();

		System.out.println("What is the monkey's name?");
		name = scanner.nextLine();
		for (Monkey monkey : monkeyList) {
			// Checks if monkey is already in the system
			if (monkey.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis monkey is already in our system\n\n");
				return; // returns to menu
			}

		}

		// If monkey is not in system, continue.
		// Using the appropriate method, we assign each variable the correct data

		species = monkeySpecies();

		gender = animalGender();

		age = animalAge();

		weight = animalWeight();

		acquistionDate = animalAcquisitionDate();

		acquistionCountry = animalAcquisitionCountry();

		trainingStatus = animalTrainingStatus();

		reserved = animalReserved();

		inServiceCountry = animalInServiceCountry();

		// Monkey has a few additional methods and variables
		// These methods were made specifically for the Monkey object

		tailLength = monkeyTail();

		height = monkeyHeight();

		bodyLength = monkeyLength();

		// Create a new Monkey object with new parameters
		Monkey monkey4 = new Monkey(name, species, gender, age, weight, acquistionDate, acquistionCountry,
				trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
		// Add new monkey to Monkey Array
		monkeyList.add(monkey4);
		System.out.println("Congratulations, monkey was added!");
	}

	// The animalGender Method returns the animals gender
	public static String animalGender() {
		// Set variable
		String gender;

		// Loop forever until conditions are met
		do {
			System.out.println("What is the animals gender: ");
			gender = scanner.nextLine();
			// If gender variable is anything besides male or female, print error message
			if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
				System.out.println("Please choose Male or Female for gender.");
			} else {
				// If gender is male or female, return gender
				return gender;
			}
		} while (true);
	}

	// The animalAge method returns the animals age
	public static String animalAge() {
		// Set variable
		Integer age;

		// Loop forever until conditions are met
		do {
			// Age is an integer variable, we use try-catch, in case the user
			// enters a non digit.
			try {
				System.out.println("What is the animals age: ");
				age = scanner.nextInt();
				// Verify age is a non-negative number
				if (age < 0) {
					System.out.println("Please choose an age greater than 0");
				} else {
					// Clear out scanner buffer, return age as String
					scanner.nextLine();
					return age.toString();
				}
				// If user enters a non-digit input, we give feedback
			} catch (InputMismatchException ime) {
				System.out.println("Please enter a valid digit number. Ex: 22");
			}
			// Clear out scanner buffer
			scanner.nextLine();
		} while (true);
	}

	// The animalWeight method returns the animals Weight
	public static String animalWeight() {
		// Set variables
		Integer weight;

		// Loop forever until conditions are met
		do {
			// Weight is an integer variable, we use try-catch, in case the user
			// enters a non digit.
			try {
				System.out.println("What is the animals weight (pounds): ");
				weight = scanner.nextInt();
				// Verify weight is a non-negative number
				if (weight < 0) {
					System.out.println("Please choose an weight greater than 0.");
				} else {
					// Clear scanner buffer and return weight
					scanner.nextLine();
					return weight.toString();
				}
				// If user enters a non-digit input, we give feedback
			} catch (InputMismatchException ime) {
				System.out.println("Please enter a valid digit number. Ex: 22");
			}
			// Clear scanner buffer
			scanner.nextLine();
		} while (true);
	}

	// The animalAcquisitionDate method returns the date the animals was acquired
	public static String animalAcquisitionDate() {
		// Create a SimpleDateFormat object
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// Create variable
		String date;
		// Loop forever until conditions are met
		do {
			// If the user enters input that does not match what is asked
			// they are sent to catch.
			try {
				System.out.println("What date was the animal acquired yyyy-MM-dd: ");
				date = scanner.nextLine();
				// The setLeniet method makes it so no fake dates may be entered
				// The month 25 or the day 99 do not exist
				format.setLenient(false);
				// Verify the date variables matches
				format.parse(date);
				// Everything checks out, return date as string
				return date.toString();
				// Give feedback as how to enter the date correctly
			} catch (ParseException pe) {
				System.out.println("Please enter a date using this format yyyy-MM-dd.");
			}
		} while (true);

	}

	// The animalAcquistionCountry method returns the country the animals was
	// acquired
	public static String animalAcquisitionCountry() {
		// Set variable
		String country;
		// Loop forever until conditions are met
		do {
			System.out.println("What country was the animal acquired: ");
			country = scanner.nextLine();
			// No real country has digits, using regular expressions
			// We verify at the minimum that the country entered has no digits
			// To verify if a country is real, I would need an array of every country
			// and loop through it.
			if (country.matches("[a-zA-Z\\s]+")) {
				// If no digits detected, return country
				return country;
			} else {
				// If digits detected, print message
				System.out.println("Please enter a country without using digits.");
			}

		} while (true);
	}

	// The animalTrainingStatus method returns the current status of the animal
	public static String animalTrainingStatus() {
		// Set variable
		String status;
		// Set array of status that are allowed
		String[] approvedStatus = { "I", "II", "III", "IV", "V", "in-service", "farm" };
		// Loop forever until conditions are met
		do {
			System.out.println("What is the training status of the animal: ");
			status = scanner.nextLine();
			// Using an enhanced for loop, iterate over the array
			for (String currentStatus : approvedStatus) {
				// If user input matches any item in array, return the status
				if (currentStatus.equals(status)) {
					return status;
					// If user input does not match, and we reach end of array
					// Tell user how to correctly enter information
				} else if (currentStatus.equals(approvedStatus[6])) {
					System.out.println("Please enter a valid status (I, II, III, IV, V, in-service, farm.");
				}
			}
		} while (true);

	}
	
	// The animalReserved method returns the reservation status of the animal
	public static boolean animalReserved() {
		// Set variable
		boolean reserved;
		// Loop forever until conditions are met
		do {
			// If user enters anything besides true or false, catch the exception
			try {
				System.out.println("Is this animal currently reserved: ");
				reserved = scanner.nextBoolean();
				scanner.nextLine();
				return reserved;
				// Tell user the correct input
			} catch (InputMismatchException ime) {
				System.out.println("Please enter true or false.");
				scanner.nextLine();
			}
		} while (true);
	}

	// The animalServiceCountry method returns which country the animal is used in
	public static String animalInServiceCountry() {
		// Set variable
		String service;
		// Loop forever until condition is met
		do {
			System.out.println("What country is this animal in service: ");
			service = scanner.nextLine();
			// No country has digits, using regular expression verify no digit
			if (service.matches("[a-zA-Z\\s]+")) {
				return service;
				// Help user by giving instructions
			} else {
				System.out.println("Please enter a country without using digits.");
			}
		} while (true);
	}

	// The dogBreed method is dog specific, returns the breed of the dog.
	public static String dogBreed() {
		// Set Variable
		String breed;
		// Loop forever until conditions are met
		do {
			System.out.println("What is the breed of your dog: ");
			breed = scanner.nextLine();
			// No dog breed has digits. To verify if the breed was real
			// I would need to iterate through an array of dog breeds.
			if (breed.matches("[a-zA-Z\\s]+")) {
				return breed;
				// Give user directions
			} else {
				System.out.println("Please enter a breed without using digits.");
			}
		} while (true);
	}

	// The monkeySpecies is a monkey Specific method, it verifies the user
	// has chosen a monkey
	public static String monkeySpecies() {
		// Create array of approved monkey species
		String[] availableSpecies = { "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin" };
		String species;
		// Loop forever until the the condition is met
		do {
			System.out.println("What is the monkeys species: ");
			species = scanner.nextLine();
			// Checking if species is correct
			for (String currentSpecies : availableSpecies) {
				// If species in list, we continue to next question
				if (species.equals(currentSpecies)) {
					return species;
				}
				// If species not in list and error is still true, print all species
				if (currentSpecies.equals(availableSpecies[5])) {
					System.out.println("Please choose from the following:");
					for (String allSpecies : availableSpecies) {
						System.out.print(" " + allSpecies + " /");
					}
					System.out.println();
				}
			}
			// Continue Running until we receive proper input
		} while (true);
	}
	
	// The monkeyTail method is a monkey specific method that returns the length of the monkeys tail
	public static double monkeyTail() {
		double tail;
		// Loops forever until conditions are met
		do {
			// Asks for an input of type of double, if any other type 
			try {
				System.out.println("What is the monkeys tail length (inches): ");
				tail = scanner.nextDouble();
				// The tail is greater than 0, return tail
				if (tail > 0) {
					return tail;
				// Tail can not be less than 0
				} else {
					System.out.println("Please enter a non-negative number.");
				}
				// If type is not double, print error message
			} catch (InputMismatchException ime) {
				System.out.println("Please enter a number in digit form. Ex: 22");
			}
			// Continue Running until we receive proper input
		} while (true);
	}

	// The monkeyHeight method is a monkey specific method that returns the monkeys height
	public static double monkeyHeight() {

		double height;
		// Loop forever until condition is met
		do {
			// Input must be type double
			try {
				System.out.println("What is the monkeys height (inches): ");
				height = scanner.nextDouble();
				// If height is greater than 0, return height
				if (height > 0) {
					return height;
					// Height can not be 0
				} else {
					System.out.println("Please enter a non-negative number.");
				}
				// Print error message if input is not double
			} catch (InputMismatchException ime) {
				System.out.println("Please enter a number in digit form. Ex: 22");
			}
			// Continue Running until we receive proper input
		} while (true);
	}

	// The monkeyLength method is a monkey specific method that returns monkeyLength
	public static double monkeyLength() {

		double length;
		// Loop forever until conditions are met
		do {
			// Input must be type double
			try {
				System.out.println("What is the monkeys length (inches): ");
				length = scanner.nextDouble();
				// If length is greater than 0, return length
				if (length > 0) {
					return length;
				} else {
					System.out.println("Please enter a non-negative number.");
				}
				// Print error message if input is not double
			} catch (InputMismatchException ime) {
				System.out.println("Please enter a number in digit form. Ex: 22");
			}
			// Continue Running until we receive proper input
		} while (true);
	}

	// Complete reserveAnimal
	// You will need to find the animal by animal type and in service country
	public static void reserveAnimal(Scanner scanner) {
		scanner.nextLine();
		// Declaring variables
		String pickCountry;
		String animal;
		int dogIndex;
		int monkeyIndex;

		// Loop forever until conditions are met
		do {
			System.out.println("Which country would you like to use this animal in: ");
			pickCountry = scanner.nextLine();
			System.out.println("Would you like to reserve a Dog or a Monkey or press 'q' to return: ");
			animal = scanner.nextLine();
			// If animal is dog, go down dog branch
			if (animal.equalsIgnoreCase("dog")) {
				// Iterate through dogList array
				for (Dog dog : dogList) {
					// If a dog is in service location and not reserve, allow user to reserve dog
					if (dog.getInServiceLocation().equalsIgnoreCase(pickCountry) && dog.getReserved() == false) {
						dogIndex = dogList.indexOf(dog);
						dogList.get(dogIndex).setReserved(true);
						System.out.println("Congratulations, you have reserved: " + dog.getName());
						return;
					}
				}
				// If animal or country are not available, print unavailable message
				System.out.println("I am sorry but no animals of that type and location are available.");
				// If animal is monkey, go down monkey branch
			} else if (animal.equalsIgnoreCase("monkey")) {
				// Iterate through monkeyList array
				for (Monkey monkey : monkeyList) {
					// If a monkey is in service location and not reserve, allow user to reserve monkey
					if (monkey.getInServiceLocation().equalsIgnoreCase(pickCountry) && monkey.getReserved() == false) {
						monkeyIndex = monkeyList.indexOf(monkey);
						monkeyList.get(monkeyIndex).setReserved(true);
						System.out.println("Congratulations, you have reserved: " + monkey.getName());
						return;
					}
				}
				// If animal or country are not available, print unavailable message
				System.out.println("I am sorry but no animals of that type and location are available.");
			}
			// If animal equals q, return to main menu
			else if (animal.equalsIgnoreCase("q")) {
				return;
			}
		} while (true);
	}

	// Complete printAnimals
	// Include the animal name, status, acquisition country and if the animal is
	// reserved.
	// Remember that this method connects to three different menu items.
	// The printAnimals() method has three different outputs
	// based on the listType parameter
	// dog - prints the list of dogs
	// monkey - prints the list of monkeys
	// available - prints a combined list of all animals that are
	// fully trained ("in service") but not reserved
	// Remember that you only have to fully implement ONE of these lists.
	// The other lists can have a print statement saying "This option needs to be
	// implemented".
	// To score "exemplary" you must correctly implement the "available" list.
	
	public static void printAnimals(int menuOption) {
		// Print a list of all dogs
		if (menuOption == 4) {
			System.out.println("List of all dogs.");
			// Loop through dogList until the end
			for (Integer i = 0; i < dogList.size(); ++i) {
				Dog currentDog = dogList.get(i);
				// Print out dogs info
				System.out.println("\nName: " + currentDog.getName() + "\nTraining Status: "
						+ currentDog.getTrainingStatus() + "\nAcquisition Location: "
						+ currentDog.getAcquisitionLocation() + "\nReserved: " + currentDog.getReserved());

			}
			// Print a list of all monkeys
		} else if (menuOption == 5) {
			// Loop through monkeyList until end
			System.out.println("List of all monkeys.");
			for (Integer i = 0; i < monkeyList.size(); ++i) {
				Monkey currentMonkey = monkeyList.get(i);
				// Print out monkeys info
				System.out.println("\nName: " + currentMonkey.getName() + "\nTraining Status: "
						+ currentMonkey.getTrainingStatus() + "\nAcquisition Location: "
						+ currentMonkey.getAcquisitionLocation() + "\nReserved: " + currentMonkey.getReserved());
			}
		} else {
			// Print list of animals not reserved
			System.out.println("The current list of available animals that are in-service are: ");
			// Print all dogs that are in-service and not reserved
			for (Dog dog : dogList) {
				if (dog.getTrainingStatus().equalsIgnoreCase("in-service") && dog.getReserved() == false) {
					System.out.println("Dog: " + dog.getName());
				}
			}
			// Print all monkeys that are in-service and not reserved
			for (Monkey monkey : monkeyList) {
				if (monkey.getTrainingStatus().equalsIgnoreCase("in-service") && monkey.getReserved() == false) {
					System.out.println("Monkey: " + monkey.getName());
				}
			}

		}
	}
}
