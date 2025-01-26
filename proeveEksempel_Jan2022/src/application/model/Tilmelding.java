package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tilmelding {
    private String navn;
    private boolean kvinde;
    private LocalDate tildmeldingsDato;
    private int løbeNummer;
    private int løbsTid;
    private Løb løb;
    private List<Note> noter; // Liste af noter

    Tilmelding(String navn, boolean kvinde, LocalDate tildmeldingsDato, int løbeNummer, int løbsTid, Løb løb) {
        this.navn = navn;
        this.kvinde = kvinde;
        this.tildmeldingsDato = tildmeldingsDato;
        this.løbeNummer = løbeNummer;
        this.løbsTid = løbsTid;
        this.løb = løb; // link til løb
        this.noter = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public boolean isKvinde() {
        return kvinde;
    }

    public LocalDate getTildmeldingsDato() {
        return tildmeldingsDato;
    }

    public int getLøbeNummer() {
        return løbeNummer;
    }

    public int getLøbsTid() {
        return løbsTid;
    }

    public Løb getLøb() {
        return løb;
    }

    public List<Note> getNoter() {
        return new ArrayList<>(noter);
    }

    //Opgave S3 (5 point)
    //Når en forhindring ikke gennemføres korrekt, skal der oprettes en note med forhindringen og
    // antal straf sekunder.
    //Tilføj til klassen Tilmelding metoden
    // registrerStrafPåForhindring(String navnForhindring, int strafSekunder) : void

    public void registrerStrafPåForhindring(Forhindring forhindring, int strafSekunder) {
        Note note = new Note(strafSekunder, forhindring);
        noter.add(note);
    }


    //Opgave S4 (5 point)
    //Resultattiden for en tilmelding er den registrerede løbstid, hvorfra der skal tillægges de
    // strafsekunder, man har fået på de forhindringer, der ikke er gennemført korrekt.
    //Tilføj til klassen Tilmelding en metode resultatTid() : int, der returnerer løbs tiden,
    // tillagt de registrerede strafsekunder.


    public int resultatTid(){

        int totalSek = 0; // til at holde styr på totale straf i sekunder

        for (Note n : noter) {
            totalSek += n.getStrafkSekunder(); //vi går gennem listen af noter og summerer alle strafsekunder

        }
        return løbsTid + totalSek;
    }



}
