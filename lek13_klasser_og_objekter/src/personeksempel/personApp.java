package personeksempel;

public class personApp {
    public static void main(String[] args) {
        Person p1 = new Person("Lars ", "Prutvej 21", 300.33, 4);
//        System.out.println("Name: " + p1.getName() + "Address: " + p1.getAddress() + " Monthly salay: " + p1.getMonthlySalary());
        p1.printPerson();
        p1.newFirm();
        p1.printPerson();



    }

}
