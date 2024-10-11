package opgave4;

public class NameApp{
    public static void main(String[] args) {

        //mine navne er mine parametre, og derfor kommer de herind i parenteserne
        Name n1 = new Name("Anna", "Witt", "Eriksen");
        Name n2 = new Name("Anna", "Eriksen");

        System.out.println("Full name: " + n1.getFullName());
        System.out.println(n1.getFirstName());

        System.out.println("Username: " + n1.getUsername());

        System.out.println("Initials: " + n1.getInit());

        System.out.println("Encrypted initials: " + n1.getCryptoInit(2));
    }

}
