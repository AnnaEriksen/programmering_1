package Opgave1;

import java.awt.*;

public class Fan {

    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;

    private int speed = SLOW;
    private boolean on;
    private double radius = 5;
    private String color = "Blue";

    //Constructoren

    public Fan(){ //den skal ikke lukkes så vi bruger en klammeparentes

    }

    //vi laver vores setspeed
    public void setSpeed(int speed){
        this.speed = speed;
    }

    public int getSpeed(){ //hver gang du laver en get, skal der ikke stå noget i parenteserne
        return speed;
    }

    public void setOn(boolean on){
        this.on = on;
    }

    public boolean getOn(){
        return on;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    //A method named toString() that returns a string description for the fan. If
    //the fan is on, the method returns the fan speed, color, and radius in one combined
    //string. If the fan is not on, the method returns the fan color and radius
    //along with the string “fan is off” in one combined string.
    public String toString(){

        if (on){
            return "Speed is: " + speed + ",Color is: " + color + ",Radius is: " + radius;
        }
        else{
            return " Fan is off... Color is: " + color + ", Radius is: " + radius;
        }
    }


    }