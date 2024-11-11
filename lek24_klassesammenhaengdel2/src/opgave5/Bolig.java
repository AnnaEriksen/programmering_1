package opgave5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMåned;
    private ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();
    private Kollegie kollegie;

    public Bolig(String adresse, int kvm, int prisPrMåned) {
        this.adresse = adresse;
        this.kvm = kvm;
        this.prisPrMåned = prisPrMåned;
    }

    public int getPrisPrMåned() {
        return prisPrMåned;
    }

    public void setPrisPrMåned(int prisPrMåned) {
        this.prisPrMåned = prisPrMåned;
    }

    public int getKvm() {
        return kvm;
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }
    public Lejeaftale createLejeaftale(LocalDate fraDato) {
        Lejeaftale lejeaftale = new Lejeaftale(fraDato,this);
        lejeaftaler.add(lejeaftale);
        return lejeaftale;
    }
    public void removeLejeaftale(Lejeaftale lejeaftale) {
        if (lejeaftaler.contains(lejeaftale)) {
            lejeaftaler.remove(lejeaftale);
        }
    }

    public Kollegie getKollegie() {
        return kollegie;
    }

    /**
     * Sets the group as this person's group, if they aren't connected.
     */
    public void setKollegie(Kollegie kollegie) {
        if (this.kollegie != kollegie) {
            Kollegie gammelKollegie = this.kollegie;
            if (gammelKollegie != null) {
                gammelKollegie.removeBolig(this);
            }
            this.kollegie = kollegie;
            if (kollegie != null) {
                kollegie.addBolig(this);
            }
        }
    }
}
