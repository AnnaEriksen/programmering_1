package Klasser_og_Objekter.modelemployee;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String firstName;
	private boolean trainee;

	//opgave 1b
	private int age;
	private String lastName;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */

	//opgave 1.f og 1.l
	public Employee(String inputFirstName, String inputLastName, int inputAge) {
		firstName = inputFirstName;
		trainee = true;
		lastName = inputLastName;
	}

	public Employee() {
		firstName = "";
		trainee = true;

	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setFirstNameName(String inputName) {
		firstName = inputName;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getFirstNameName() {

		return firstName;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {

		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}
	// opgave 1c
	public int getAge(){
		return age;
    }

// opgave n
	public void printEmployee() {
		System.out.println("*******************");
		System.out.println(" First Name " + firstName);
		System.out.println("Last Name " + lastName);
		System.out.println("Trainee " + trainee);
		System.out.println("age " + age);
		System.out.println("*******************");
	}


	/*
	 * Returnerer en kort tekst repræsentation af objektet
	 */
	public String toString(){
		return firstName;
	}

	public void setAge(int inputAge){
		age = inputAge;

	}
	// opgave 1h
	public void Birthday (){
		age++;
	}

	//opgave 1.k

	public String getLastName(){
		return lastName;

	}

	public void setLastName(String input) {
		lastName = input;
	}


}
