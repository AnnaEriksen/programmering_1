package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;

    // composition 1 --> 0..* Bestilling
    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return this.navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    @Override
    public String toString() {
        return navn + " " + startDato + " " + slutDato;
    }

    //-----------------------------------------------------

    // TODO: metoder til linkattributten til Bestilling klassen

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public Bestilling createBestilling(LocalDate dato, Kunde kunde) {
        Bestilling bestilling = new Bestilling(dato, kunde, this);
        bestillinger.add(bestilling); // link Forestilling -> Bestilling
        return bestilling;
    }


    //-----------------------------------------------------

    // S3
    public int antalBestiltePladserPaaDag(LocalDate dato) {
        int antal = 0;
        for (Bestilling bestilling : bestillinger) {
            if (bestilling.getDato().equals(dato)) {
                antal += bestilling.getPladser().size();
            }
        }
        return antal;
    }

    // S4
    public LocalDate succesDato() {

        LocalDate successDato = null;
        int max = 0;

        for (Bestilling b : bestillinger) {
            int antalPladser = antalBestiltePladserPaaDag(b.getDato());
            if (antalPladser > max){
                max = antalPladser;
                successDato = b.getDato();
            }

        }

        return successDato;
    }


    //S8
    public boolean erPladsLedig(int række,int nr, LocalDate dato){
        boolean ledig = false; // initialiser til at være ledig
        int i = 0; //starter med den første bestilling

        while (ledig && i < bestillinger.size()){// Starter en while-løkke, der fortsætter så længe 'ledig' er true og 'i' er mindre end antallet af bestillinger.
            Bestilling b = bestillinger.get(i); // Henter bestillingen ved indeks 'i' fra listen af bestillinger.
            if (b.getDato().equals(dato)){ // Tjekker om bestillingens dato matcher den ønskede dato.
                boolean erPladsFundet = false; // Initialiserer en variabel 'pladsFundet' som false. Denne variabel vil spore, om pladsen er fundet i denne bestilling.
                int j = 0; // Initialiserer tælleren 'j' til 0, som bruges til at iterere gennem listen af pladser i denne bestilling.

                while (!erPladsFundet && j < b.getPladser().size()){ //
                    Plads p = b.getPladser().get(j); // Henter pladsen ved indeks 'j' fra listen af pladser i bestillingen.
                    if (p.getRække() == række && p.getNr() == nr){ // Tjekker om pladsens række og nummer matcher den ønskede række og nummer.
                        erPladsFundet = true; // Sætter 'pladsFundet' til true, da vi har fundet den ønskede plads.
                        ledig = false; ; // Sætter 'ledig' til false, da pladsen er optaget på den ønskede dato. }
                    }
                    j++; //tæller op for at tjekke næste bestilling i listen
                }
            }
            i++; //tæller op for at tjekke næste bestilling i listen2

            }
        return ledig;
        }
    }

