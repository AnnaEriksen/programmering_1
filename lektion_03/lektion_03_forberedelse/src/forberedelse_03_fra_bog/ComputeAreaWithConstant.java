package forberedelse_03_fra_bog;

import java.util.Scanner;

public class ComputeAreaWithConstant {public static void main(String[]args){
final double PI = 3.14159; // Declare a constant

    // Create scanner object
    Scanner input = new Scanner(System.in);

    // Prompt user to enter a radius
    System.out.println("Enter a number for radius: ");
    double radius = input.nextDouble();

    // Compute area
    double area = radius * radius * PI;

    // Display result
    System.out.println("The area for the circle of radius " + radius + " is " + area);
}
}
