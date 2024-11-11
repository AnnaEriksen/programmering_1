package opgave5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Lejer> lejere;
    private Bolig bolig;

    Lejeaftale(LocalDate fraDato, Bolig bolig) {
        this.fraDato = fraDato;
        this.tilDato = null;
        this.bolig = bolig;
    }

    public void opsigLejeaftale(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public ArrayList<Lejer> getLejere() {
        return new ArrayList<>(lejere);
    }

    public void addLejer(Lejer lejer) {
        if (!lejere.contains(lejer) && lejere.size() >= 2) {
            lejere.add(lejer);
        } else {
            System.out.println("Lejer er der eller der er to lejere i forvejen");
        }
    }

    public void removeLejer(Lejer lejer) {
        if (lejere.contains(lejer)) {
            lejere.remove(lejer);
        }
    }

    public Bolig getBolig() {
        return bolig;
    }

}
