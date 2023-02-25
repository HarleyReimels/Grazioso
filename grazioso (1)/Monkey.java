import java.util.Scanner;

/* 	Method Name: Monkey
	 * 
	 * 	The monkey class inherits from the RescueAnimal as well
	 * 	as implementing a few methods that are specific to monkeys.
	 * 
	 * 	Author: Harley Reimels
	 * 	Date Created: 02/16/2023
	 * 
	 */
	public class Monkey  extends RescueAnimal{
		// Set all variables
		private String species;
		private double tailLength;
		private double height;
		private double bodyLength;
		boolean error = true;
		String[] availableSpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
		Scanner scanner = new Scanner(System.in);
		
		// Constructor
	    public Monkey(String name, String species, String gender, String age,
	    String weight, String acquisitionDate, String acquisitionCountry,
		String trainingStatus, boolean reserved, String inServiceCountry,
		double tailLength, double height, double bodyLength) {
	        setName(name);
	        setSpecies(species);
	        setGender(gender);
	        setAge(age);
	        setWeight(weight);
	        setAcquisitionDate(acquisitionDate);
	        setAcquisitionLocation(acquisitionCountry);
	        setTrainingStatus(trainingStatus);
	        setReserved(reserved);
	        setInServiceCountry(inServiceCountry);
	        setTailLength(tailLength);
	        setHeight(height);
	        setBodyLength(bodyLength);
	
	}
	    // Accessor Method
	    public String getSpecies() {
	        return species;
	    }
	
	    // Mutator Method
	    public void setSpecies(String species) {
	    	this.species = species;
	    }
	    
	    // Accessor Method
	    public Double getTailLength() {
	        return tailLength;
	    }
	
	    // Mutator Method
	    public void setTailLength(double tailLength) {
	        this.tailLength = tailLength;
	    }
	
	    // Accessor Method
	    public double getHeight() {
	        return height;
	    }
	
	    // Mutator Method
	    public void setHeight(double height) {
	        this.height = height;
	    }
	    
	    // Accessor Method
	    public double getBodyLength() {
	        return bodyLength;
	    }
	
	    // Mutator Method
	    public void setBodyLength(double bodyLength) {
	        this.bodyLength = bodyLength;
	    }
	}
