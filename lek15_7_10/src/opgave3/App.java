package opgave3;

public class App {
  private BankAccount[] kontoer;
  private int id;

  public void putKonto(){
      kontoer = new BankAccount[10];
      id = 0;
  }

  public void addKonto(BankAccount kontoer){
      if (id < this.kontoer.length){
          this.kontoer[id] = kontoer;
          kontoer.deposit(100);

          id++;


      }

  }

    public static void main(String[] args) {

        ;


    }

}
