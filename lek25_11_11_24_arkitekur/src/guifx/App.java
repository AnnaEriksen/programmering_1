package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.application.Application;

public class App {

	public static void main(String[] args) {
		initStorage();
		Application.launch(StartWindow.class);
	}
	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		Company c1 = Controller.createCompany("IBM", 37);
		Company c2 = Controller.createCompany("AMD", 40);
		Controller.createCompany("SLED", 45);
		Controller.createCompany("Vector", 32);

		Controller.createEmployee("Bob Dole", 210, 2021, c2);
		Controller.createEmployee("Alice Schmidt", 250,2022, c1);
		Controller.createEmployee("George Down", 150,2024, c2);

		Controller.createEmployee("Rita Uphill", 300,2022);

		Customer cus1 = Controller.createCustomer("Børge");
		Customer cus2 = Controller.createCustomer("Anna eriksen");

		Controller.addCustomerToCompany(cus1,c1);
		Controller.addCustomerToCompany(cus2, c2);
	}


}
