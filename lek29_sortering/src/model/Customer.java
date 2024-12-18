package model;

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
		return firstName + " " + lastName + " (" + age + ")";
	}
}
