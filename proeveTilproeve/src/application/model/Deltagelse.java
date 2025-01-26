package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;
    private Lektion lektion; //link til lektionklassen
    private Studerende studerende;


    Deltagelse(boolean registreret, DeltagerStatus status, Lektion lektion, Studerende studerende) {
        this.registreret = registreret;
        this.status = status;
        this.lektion = lektion;
        setStuderende(studerende);
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public void setStuderende(Studerende studerende) {
        if (this.studerende != studerende){
            Studerende oldStuderende = this.studerende;
            if (oldStuderende != null){
                oldStuderende.removeDeltagelse(this);
            }
            this.studerende = studerende;
            if (studerende != null){
                studerende.addDeltagelse(this);
            }
        }

    }

    public boolean isRegistreret() {
        return registreret;
    }

    public void setRegistreret(boolean registreret) {
        this.registreret = registreret;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    public Lektion getLektion() {
        return lektion;
    }




    //S2
    public boolean erRegistreretFravær(Lektion lektion){
        boolean registreretFravær = false;



        return registreretFravær;
    }


}
