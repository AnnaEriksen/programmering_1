package enkeltesammenænge;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMåned;

     public Bolig(int kvm, String adresse, int prisPrMåned) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMåned = prisPrMåned;
    }

    public int getKvm() {
        return kvm;
    }

    public void setKvm(int kvm) {
        this.kvm = kvm;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPrisPrMåned() {
        return prisPrMåned;
    }

    public void setPrisPrMåned(int prisPrMåned) {
        this.prisPrMåned = prisPrMåned;
    }

    //-----------------------------------------------------

    // link 1 --> 0..* Lejeaftale (komposition)
    private final ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();

    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }

    public Lejeaftale createLejeaftale(LocalDate fraDato) {
        Lejeaftale lejeaftale = new Lejeaftale(fraDato);
        lejeaftaler.add(lejeaftale);
        return lejeaftale;
    }
}
