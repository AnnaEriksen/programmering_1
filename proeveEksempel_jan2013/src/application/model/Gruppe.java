package application.model;

import java.util.ArrayList;

public class Gruppe {
    private int nr;

    private PersonChip betalingsansvarlig;
    private ArrayList<PersonChip> personchips = new ArrayList<>();

    public Gruppe(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    // personchip for betalingsansvarlig

    public PersonChip getBetalingsansvarlig() {
        return betalingsansvarlig;
    }

    public void setBetalingsansvarlig(PersonChip betalingsansvarlig) {
        if (this.betalingsansvarlig != betalingsansvarlig) {
            this.betalingsansvarlig = betalingsansvarlig;
        }
    }

    // personchips
    public ArrayList<PersonChip> getPersonchips() {
        return new ArrayList<>(personchips);
    }

    public PersonChip createPersonChip(int nr, String navn, int maxSaldo, int alder) {
        PersonChip personChip = new PersonChip(nr, navn, maxSaldo, alder, this);
        //personchips.add(personChip); // ellers tilføjes personChip x 2
        return personChip;
    }

    public void addPersonChip(PersonChip personChip) {
        if (!personchips.contains(personChip)) {
            personchips.add(personChip);
        }
    }

    public void removePersonChip(PersonChip personChip) {
        if (personchips.contains(personChip)) {
            personchips.remove(personChip);
        }
    }

    //

    // Opgave S3 (10 point)
    // finder en person med det pågældende navn. Metoden returnerer person hvis denne findes ellers returneres null.
    // Det er et krav, at metoden anvender en lineær søgning, baseret på søgeskabelonen.
    public PersonChip findPersonChip(String navn) {
        PersonChip personChip = null;
        int i = 0;
        while (personChip == null && i < getPersonchips().size()) {
            PersonChip k = getPersonchips().get(i);
            if (k.getNavn().equalsIgnoreCase(navn)) {
                personChip = k;
            } else {
                i++;
            }
        }
        return personChip;
    }

    // S3 (10 point)
    //Metoden skal returnere en liste med navn og pris på de faciliteter, en person har brugt.
    // Det er tilladt i denne metode at anvende den netop realiserede metode findPersonChip.

    public ArrayList<String> oversigtFaciliteter(String navn) {
        ArrayList<String> faciliteter = new ArrayList<>();
        PersonChip personChip = findPersonChip(navn);

        if (personChip != null) {
            for (Facilitet f : personChip.getFaciliteter()) {
                faciliteter.add(f.getNavn() + " " + f.getPris());
            }
        }

        return faciliteter;
    }


}


