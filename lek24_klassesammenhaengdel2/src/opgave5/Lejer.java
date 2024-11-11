package opgave5;

public class Lejer {
    private String navn;
    private String uddannelse;

    public Lejer(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    @Override
    public String toString() {
        return navn;
    }

}
