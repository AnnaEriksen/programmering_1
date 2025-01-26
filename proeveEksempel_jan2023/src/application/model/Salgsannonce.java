package application.model;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnoncer = 0;
    private int annonceNummer;
    private boolean aktiv;
    private LocalDate udløbsdato;

    private ArrayList<Vare> varer = new ArrayList<>();
    private final Saelger saelger;


    public Salgsannonce(Saelger saelger) {
        antalAnnoncer++; // når der oprettes en annonce, tæller den op
        this.annonceNummer = antalAnnoncer;
        this.aktiv = true;
        this.udløbsdato = LocalDate.now().plusMonths(1);
        this.saelger = saelger;
        saelger.addSalgsannonce(this);
    }

    public static int getAntalAnnoncer() {
        return antalAnnoncer;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public LocalDate getUdløbsdato() {
        return udløbsdato;
    }

    //--

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    //--

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public void addVare(Vare vare) {
        if (!varer.contains(vare)) {
            varer.add(vare);
            vare.setSalgsannonce(this);
        }
    }

    public void removeVare(Vare vare) {
        if (varer.contains(vare)) {
            varer.remove(vare);
            vare.setSalgsannonce(null);
        }
    }

    //--

    public Saelger getSælger() {
        return saelger;
    }

    //--

    //TODO S2
    // Tilføj til klassen Salgsannonce metoden samletAnnonceUdbud() : int,
    // der returnerer det samlede beløb, alle de varer der indgår i annoncen,
    // kan sælges til, hvis de sælges til den udbudte pris.

    public int samletAnnonceUdbud() {
        int samletPris = 0;
        for (Vare v : varer) { //itererer over hver vare i listen/arrayey kaldt "varer"
            samletPris += v.getUdbudspris(); //nuværende pris på vare bliver lagt til den samlede pris
        }
        return samletPris;
    }

    //TODO S7
    // Tilføj til klassen Salgsannonce en metode der opdaterer om salgsannoncen fortsat skal være aktiv.
    // Salgsannoncen skal ikke være aktiv hvis udløbsdatoen er overskredet eller,
    // hvis alle varer hørende til salgsannoncen, er solgt. '
    // Sørg for at denne metode bliver kaldt, når en varer knyttet til en salgsannonce sælges.

    public void skalSalgsannonceVæreAktiv() {
        // hvis der bare er en vare, der ikke er solgt, settes false
        boolean alleVarerErSolgt = true;

        for (Vare v : varer) { //går gennem alle varer i listen "varer", hver vare, v,
            // i listen bliver tjekket for om den er solgt

            if (!v.isSolgt()) { //tjekker om varen, v, er solgt vha metoden isSolgt();
                alleVarerErSolgt = false; //returnerer en boolean, trye, hvis solgt, false, hvis ikke
            }
        }

        //vi tjekker om den nuværende dato er efter udløbsdatoen, og om alle varer ser solgt
        if (LocalDate.now().isAfter(udløbsdato) || alleVarerErSolgt) {
            setAktiv(false); //hvis alle betingelser er opfyldt
        } else {
            setAktiv(true); //hvis ikke alle betingelser er opfyldt
        }
    }

    @Override
    public String toString() {
        return annonceNummer + " " + saelger + " " + udløbsdato;
    }
}
