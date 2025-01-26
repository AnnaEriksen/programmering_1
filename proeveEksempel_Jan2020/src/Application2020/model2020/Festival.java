package Application2020.model2020;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {

    private String navn;
    private LocalDate fraDato;
    LocalDate tilDato;


    public Festival(String navn, LocalDate fraDato, LocalDate tilDato, Job job) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
        this.jobs = new ArrayList<>();
    }

    private static ArrayList<Job> jobs = new ArrayList<>(); //link til job

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }


    //-----------til job-------------------------------------------------------------
    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer){
        Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
        jobs.add(job);
        return job;
    }




    //Opgave S2 (5 point)
    //Tilføj til klassen Festival metoden budgetteretJobUdgift(): int, der returnerer den samlede
    //budgetterede udgift for festivalen til de frivillige jobs, såfremt alle jobs bliver udført. Denne
    //beregning skal basere sig på felterne timeHonorar og antalTimer i klassen Job.

    public int budgetteretUdgift(){

        int samletUdgift = 0;
        for (Job j : jobs) {
            samletUdgift += j.getTimeHonorar() * j.getAntalTimer();

        }
        return samletUdgift;

    }

    //Opgave S3 (7 point)
    //Tilføj til klassen Festival metoden realiseretJobUdgift(): int, der returnerer den samlede
    //udgift for festivalen, til de frivillige jobs. Her er det kun de jobs og det antal timer, der reelt er
    //registreret af frivillige, der skal medregnes.


    public int realiseretJobudgift(){

        int jobudgift = 0;

        for (Job j : jobs) {
            jobudgift += j.getTimeHonorar() * j.getAntalTimer();

        }
        return jobudgift;
    }


    //Opgave S8 (13 point)
    //Tilføj til klassen Festival metoden gaverTilFrivillige() der skal returnere en sorteret liste
    //af tekststrenge. Hvert element i listen skal svare til en frivillig eller en frivilligforening med navn på
    //den frivillige/kontaktpersonen og hvor mange gaver, den frivillige/foreningen skal have, samt navn
    //på foreningen, når det er aktuelt. Hvis det er en frivillig forening, skal antallet af gaver være antal
    //frivillige foreningen stiller med, ellers er det blot én gave. Det er et krav, at der anvendes
    //polymorfi. (Der må gerne tilføjes metoder til modellen, såfremt dette synes hensigtsmæssigt.)
    //Med de aktuelle data vil listen for festivalen Northside indeholde nedenstående 4 elementer,
    //såfremt alle de frivillige har fået mindst én vagt:


    public ArrayList<String>gaverTilFrivillige(){

        //opretter tommer lister
        ArrayList<String> gaverTilFrivillige = new ArrayList<>();
        ArrayList<String> sorteretListe = new ArrayList<>();
        ArrayList<Frivillig> frivillige = new ArrayList<>();

        // Henter frivillige fra jobs og vagter
        for (Job j : jobs){ //iterér over alle jobs,
            for (Vagt v : j.getVagter()){ //og for hvert job går vi gennem alle vagter
                frivillige.add(v.getFrivillig()); //for hver vagt henter vi frivillige og tiløjer dem til listen
            }
        }
        // Sorterer listen af frivillige efter antal gaver (insertion sort)
        insertionSort(frivillige); //kalder metoden til at sortere listen i faldende orden ift gaver

        // Bygger en liste af strenge med information om hver frivillig
        for (Frivillig f : frivillige){ //for hver frivillig
            String info = f.getNavn() + " " + f.antalGaver(); //orpetter vi en tekststreng "info" med navn og antal gaver
            if (f instanceof FrivilligForening){ //hvis "instanceof" er en forening, tilføjes foreningent til strengen
                FrivilligForening ff = (FrivilligForening) f; //tvinget java til at behandle ff som "FrivilligForening"
                info += " " + ff.getForeningsNavn(); //tilføjer navnet til variablen "info"
            }
            sorteretListe.add(info);
        }

        return sorteretListe;
    }

    // Insertion sort til at sortere frivillige efter antal gaver i faldende rækkefølge
    private void insertionSort(ArrayList<Frivillig> list) {
        for (int i = 1; i < list.size(); i++) { //vi starter fra 1, da 0 betragtes som sorteret
            Frivillig current = list.get(i); //vi gemmer nuværende element i variablen "current"
            int j = i - 1; // samligner nuværende elementerne før det, "j"

            //så længe vi ikke er nået til starten af listen "j >= 0", og elementet ved position j,
            // har færre gaver end elementet "current"
            while (j >= 0 && list.get(j).antalGaver() < current.antalGaver()) {
                list.set(j + 1, list.get(j));  //rykker vi elementet 1 plads frem
                j--; //vi reducerer j for at samligne med næste element til venstre
            }
            list.set(j + 1, current); //når vi har fundet den rigtige position, for current,
            // indsætter vi det i listen ved denne position
        }
    }








}
