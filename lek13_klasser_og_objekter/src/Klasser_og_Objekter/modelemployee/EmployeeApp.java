package Klasser_og_Objekter.modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 32);
		e1.printEmployee();
		e1.setFirstNameName("Viggo");
		e1.printEmployee();

		System.out.println(e1);

		//opgave 1d og 1e
		e1.setAge(32);
		System.out.println("Navn: " + e1.getFirstNameName());

		Employee e2 = new Employee();
		System.out.println(e2);
		e2.printEmployee();
		System.out.println("Navn: " + e2.getFirstNameName() + " Efternavn " + e1.getLastName() + " Alder: " + e1.getAge());

		Employee e3 = new Employee("Torben","Thiesen", 55);

		//1.i
		e3.Birthday();
		System.out.println("Navn: " + e3.getFirstNameName() + " Alder: " + e3.getAge());

		//opgave n
		e3.printEmployee();

	}



}
