package Application.Model;

public class Ledsager {

    private String navn;
    private Tildmelding tildmelding;


    Ledsager(String navn, Tildmelding tildmelding) {
        this.navn = navn;
        this.tildmelding = tildmelding;
    }

    public Tildmelding getTildmelding() {
        return tildmelding;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn + "(" + tildmelding.getDeltager().getNavn() + " " + tildmelding.getDeltager().getTlfNr() + ")";
    }
}
