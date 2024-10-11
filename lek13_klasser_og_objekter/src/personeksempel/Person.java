package personeksempel;

import com.sun.security.auth.NTDomainPrincipal;

import javax.sound.midi.VoiceStatus;

public class Person {

    private String name;
    private String address;
    private double monthlySalary;
    private int firm;

    public Person(String inputName, String inputAddress, double inputmonthlySal, int inputFirm){
        name = inputName;
        address = inputAddress;
        monthlySalary = inputmonthlySal;
        firm = inputFirm;

    }

    public void setName(String inputName){
        name = inputName;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String inputAddress){
        address = inputAddress;

    }

    public String getAddress(){
        return address;

    }

    public void setMonthlySalary (double inputmonthlySalary){
        monthlySalary = inputmonthlySalary;
    }

    public double getMonthlySalary(){
        return monthlySalary;

    }
    public double setyearlySalary(){
       double yearlySalary = (monthlySalary * 12) * 1.025;
       return yearlySalary;

    }


    public void printPerson(){
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Monthly salary: " + getMonthlySalary());
        System.out.println("Yearly salary: " + setyearlySalary());
        System.out.println("Firm: " + getFirm());

    }

    public void setFirms(int inputFirms){
        firm = inputFirms;

    }

    public int getFirm(){
        return firm;
    }
    public void newFirm(){
        firm++;

    }
}

