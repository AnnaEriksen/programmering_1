package enkeltesammenænge;

import java.time.LocalDate;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;

    public Lejeaftale(LocalDate fraDato) {
        this.fraDato = fraDato;
        this.tilDato = null;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    //-----------------------------------------------------

    // link 0..* --> 2 Lejer
    private Lejer lejer1; // nullable
    private Lejer lejer2; // nullable

    public Lejer getLejer1() {
        return lejer1;
    }

    public Lejer getLejer2() {
        return lejer2;
    }

    public void setLejer1(Lejer lejer) {
        if (this.lejer1 != lejer) {
            this.lejer1 = lejer;
        }
    }

    public void setLejer2(Lejer lejer) {
        if (this.lejer2 != lejer) {
            this.lejer2 = lejer;
        }
    }
}
