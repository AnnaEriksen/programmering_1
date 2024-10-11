package momsprocentstaticOPg2;


public class BankAccount {
    private double balance;
    private int id;

    private static int antalKonti;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        antalKonti++;
        id = antalKonti;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
    public double getBalance() {
        return balance;

    } //opgave 2.1
    public int getId(){
        return id;
    }

    public static int getAntalKonti(){
        return antalKonti;
    }
}

//Forklar hvad der sker i opgaven:
//Koden: Hver gang du laver et objekt(bank account), så tæller den op i en anden metode, altså antal kontier,
// og antallet af kontier er id. ergo id er nummeret, altså hvor mange gange en konto bliver kaldt, så hvis du kalder den
// "3" kommer kontoen til at hedde 3
