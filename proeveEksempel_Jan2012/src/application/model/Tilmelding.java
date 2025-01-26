package application.model;

public class Tilmelding {
    private boolean aktiv;
    private boolean VIPmedlem;

    private Medlem medlem;

    public Tilmelding(boolean aktiv, boolean VIPmedlem, Medlem medlem, Hold hold) {
        this.aktiv = aktiv;
        this.VIPmedlem = VIPmedlem;
        setMedlem(medlem);
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public boolean isVIPmedlem() {
        return VIPmedlem;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public void setMedlem(Medlem medlem) {
        if (this.medlem != medlem) {
            Medlem oldMedlem = this.medlem;
            if (oldMedlem != null) {
                oldMedlem.removeTilmelding(this);
            }
            this.medlem = medlem;
            if (medlem != null) {
                medlem.addTilmelding(this);
            }
        }
    }
}
