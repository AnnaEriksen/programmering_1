package opgave5;

import java.time.Period;
import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String addresse;
    private ArrayList<Bolig> boliger;

    public Kollegie(String navn, String addresse) {
        this.navn = navn;
        this.addresse = addresse;
    }

    public String getNavn() {
        return navn;
    }

    public String getAddresse() {
        return addresse;
    }

    public ArrayList<Bolig> getBoliger() {
        return new ArrayList<>(boliger);
    }

    public Bolig createBolig(String adresse, int kvm, int prisPrMåned) {
        Bolig bolig = new Bolig(adresse,kvm,prisPrMåned);
        this.addBolig(bolig);
        return bolig;
    }

    public void addBolig(Bolig bolig) {
        if (!boliger.contains(bolig)) {
            boliger.add(bolig);
            bolig.setKollegie(this);
        }
    }


    public void removeBolig(Bolig bolig) {
        if (boliger.contains(bolig)) {
            boliger.remove(bolig);
            bolig.setKollegie(null);
        }
    }

    @Override
    public String toString() {
        return navn + ", ved " + addresse;
    }

    public int getAntalLejeaftaler() {
        int antalLegeaftaler = 0;
        for(Bolig b: boliger){
            antalLegeaftaler += b.getLejeaftaler().size();
        }
        return antalLegeaftaler;
    }

    public double gennemsnitligAntalDage(){
        double gennemsnitAntalDage = 0;
        int antalLejeaftaler = 0;
        for(Bolig b: boliger){
            for(Lejeaftale l : b.getLejeaftaler()){
                if(l.getTilDato() != null){
                    Period period = Period.between(l.getFraDato(),l.getTilDato());
                    gennemsnitAntalDage += period.getDays();
                    antalLejeaftaler++;
                }
            }
        }
        return gennemsnitAntalDage /(double) antalLejeaftaler;
    }
}
