package Application2020.model2020;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonorar;
    private int antalTimer;


    public Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }

    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonorar() {
        return timeHonorar;
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    public void setAntalTimer(int antalTimer) {
        this.antalTimer = antalTimer;
    }

    //----------til vagt-------------------------------


    private final ArrayList<Vagt> vagter = new ArrayList<>();

    public ArrayList<Vagt> getVagter() {
        return vagter;
    }

    public void removeVagt(Vagt vagt){
        if (vagter.contains(vagt)){
            vagter.remove(vagt);
        }

    }

    public Vagt createVagt(int timer, Job job){
        Vagt vagt = createVagt(timer, this);
        vagter.add(vagt);
        return vagt;
    }
}
