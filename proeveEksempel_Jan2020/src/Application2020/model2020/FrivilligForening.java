package Application2020.model2020;

public class FrivilligForening extends Frivillig {
    protected String foreningsNavn;
    protected int antalPersoner;

    public FrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
        super(navn, mobil, maksAntalTimer);
        this.foreningsNavn = foreningsNavn;
        this.antalPersoner = antalPersoner;
    }

    public String getForeningsNavn() {
        return foreningsNavn;
    }

    public int getAntalPersoner() {
        return antalPersoner;
    }

    public void setForeningsNavn(String foreningsNavn) {
        this.foreningsNavn = foreningsNavn;
    }

    public void setAntalPersoner(int antalPersoner) {
        this.antalPersoner = antalPersoner;
    }

    @Override
    public int antalGaver() {
        return antalPersoner; // Gaver = antal frivillige
    }


}
