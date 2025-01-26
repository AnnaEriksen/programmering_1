package application.model;

import java.util.ArrayList;

public class Saelger {
    private String navn;
    private int studiekortNummer;
    private String mobil;

    private final ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

    public Saelger(String navn, int studiekortNummer, String mobil) {
        this.navn = navn;
        this.studiekortNummer = studiekortNummer;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public int getStudiekortNummer() {
        return studiekortNummer;
    }

    public String getMobil() {
        return mobil;
    }

    //--


    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return new ArrayList<>(salgsannoncer);
    }

    public void addSalgsannonce(Salgsannonce salgsannonce) {
        if (!salgsannoncer.contains(salgsannonce)) {
            salgsannoncer.add(salgsannonce);
        }
    }

    public void removeSalgsannonce(Salgsannonce salgsannonce) {
        if (salgsannoncer.contains(salgsannonce)) {
            salgsannoncer.remove(salgsannonce);
        }
    }

//    public Salgsannonce createSalgsannonce() {
//        Salgsannonce salgsannonce = new Salgsannonce(this);
//        salgsannoncer.add(salgsannonce);
//        return  salgsannonce;
//    }


    //--

    //TODO S3
    // Tilføj til klassen Sælger metoden alleIkkesolgteVarerIKategori(Varekategori kategori): ArrayList<Vare>,
    // der returnerer en liste med alle de ikke solgte varer sælgeren har til salg i den angivne kategori.
    // Dvs. kun ikke solgte varer, hørende til aktive salgsannoncer skal med i listen.

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(Varekategori kategori) {
        ArrayList<Vare> ikkeSolgteVarer = new ArrayList<>();
        for (Salgsannonce s : salgsannoncer) { //gennemgår alle salgsannoncer i listen salgsannonce
            if (s.isAktiv()) { //vi tjekker om salgsannoncen s er aktiv
                for (Vare v : s.getVarer()) { //hvis annoncen er aktiv, går vi gennem alle varer i salgsannoncen
                    if (v.getKategori().equals(kategori) && !v.isSolgt()) { //for hver vare, v, tjekker vi,
                        // om den ønskede kategori matcher, og om varen ikke er solgt
                        ikkeSolgteVarer.add(v); //hvis varen matcher kategorien og varen ikke er solgt,
                        // bliver den tilføjet til listena af ikke solgte varer
                    }
                }
            }
        }
        return ikkeSolgteVarer; //returnerer alle ikke solgte varer i den ønskede kategori
    }

    //--


    @Override
    public String toString() {
        return navn;
    }
}
