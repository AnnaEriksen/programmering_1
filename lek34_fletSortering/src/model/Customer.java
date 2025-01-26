package model;

import java.util.ArrayList;

public class Customer {
	private String firstName;
	private String lastName;
	private int age;

	public Customer(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				'}';
	}

	public static ArrayList fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
		ArrayList<Customer> result = new ArrayList<>();


		int i1 = 0;
		int i2 = 0;

		while (i1 < l1.size() && i2 < l2.size()){
			if (l1.get(i1).getFirstName().compareTo(l2.get(i2).getFirstName()) > 0) {
				result.add(l1.get(i1));
				i1++;
			}
			else {
				result.add(l2.get(i2));
			}
		}

		while (i1 < l1.size()){
			result.add(l1.get(i1));
			i1++;
		}

		while (i2 < l2.size()){
			result.add(l2.get(i2));
			i2++;
		}

        return result;
    }


	public static void main(String[] args) {
		ArrayList<Customer> l1 = new ArrayList<>();
		Customer c1 = new Customer("Anna", "Jensen", 28);
		Customer c2 = new Customer("Bent", "Nielsen", 40);
		Customer c3 = new Customer("Camilla", "Thomsen", 29);
		Customer c4 = new Customer("Charlotte", "Sørensen", 33);
		Customer c5 = new Customer("Vanessa", "Trinh", 22);

		l1.add(c1);
		l1.add(c2);
		l1.add(c3);
		l1.add(c4);
		l1.add(c5);

		ArrayList<Customer> l2 = new ArrayList<>();
		Customer c6 = new Customer("Jonas", "Petersen", 31);
		Customer c7 = new Customer("Lars", "Hansen", 35);
		Customer c8 = new Customer("Sofie", "Lund", 26);
		l2.add(c6);
		l2.add(c7);
		l2.add(c8);



		System.out.println(l1);
		System.out.println("--------------------------------------");
		System.out.println(l2);



	}
}
