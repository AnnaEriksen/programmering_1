package enkeltesammenænge;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String adresse;

    public Kollegie(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //-----------------------------------------------------

    // link 1 --> 0..* Bolig (aggregering)
    private final ArrayList<Bolig> boliger = new ArrayList<>();

    public ArrayList<Bolig> getBoliger() {
        return new ArrayList<>(boliger);
    }

    public Bolig createBolig(int kvm, String adresse, int prisPrMåned) {
        Bolig bolig = new Bolig(kvm, adresse, prisPrMåned);
        boliger.add(bolig);
        return bolig;
    }

    public void addBolig(Bolig bolig) {
        if (!boliger.contains(bolig)) {
            boliger.add(bolig);
        }
    }

    public void removeBolig(Bolig bolig) {
        if (boliger.contains(bolig)) {
            boliger.remove(bolig);
        }
    }

    public int getAntalLejeaftaler() {
        int antal = 0;
        for (Bolig bolig : boliger) {
            antal += bolig.getLejeaftaler().size();
        }
        return antal;
    }

    public double gennemsnitligAntalDage() {
        int samletAntalDage = 0;
        int count = 0;
        for (Bolig bolig : boliger) {
            for (Lejeaftale lejeaftale : bolig.getLejeaftaler()) {
                if (lejeaftale.getTilDato() != null) {
                    int dage = (int) ChronoUnit.DAYS.between(lejeaftale.getFraDato(), lejeaftale.getTilDato());
                    samletAntalDage += dage;
                    count++;
                }
            }
        }
        return 1.0 * samletAntalDage / count;
    }
}
