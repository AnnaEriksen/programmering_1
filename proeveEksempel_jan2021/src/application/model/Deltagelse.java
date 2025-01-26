package application.model;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;

    private Lektion lektion;
    private Studerende studerende;

    Deltagelse(Lektion lektion, Studerende studerende) {
        this.registreret = false;
        this.status = DeltagerStatus.TILSTEDE;
        this.lektion = lektion;
        this.studerende = studerende;
        studerende.addDeltagelse(this);

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

    public void setStatus(DeltagerStatus status) {
        this.status = status;
    }

    //--

    public Lektion getLektion() {
        return lektion;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public void setStuderende(Studerende studerende) {
        if (this.studerende != studerende) {
            Studerende oldStuderende = this.studerende;
            if (oldStuderende != null) {
                oldStuderende.removeDeltagelse(this);
            }

            this.studerende = studerende;
            if (studerende != null) {
                studerende.addDeltagelse(this);
            }
        }
    }


    //--

    public boolean erRegistreretFraværende() {
        boolean erFraværende = false;

        if (!status.equals(DeltagerStatus.TILSTEDE) && registreret) {
            erFraværende = true;
        }
        return erFraværende;
    }

    @Override
    public String toString() {
        return studerende + " " + registreret + " " + status;
    }
}
