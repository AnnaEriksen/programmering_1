package application.model;

public class Note {
    private int strafkSekunder;
    private Forhindring forhindring; // link til forhindring

    public Note(int strafkSekunder, Forhindring forhindring) {
        this.strafkSekunder = strafkSekunder;
        this.forhindring = forhindring;
    }

    public int getStrafkSekunder() {
        return strafkSekunder;
    }

    public Forhindring getForhindring() {
        return forhindring;
    }



}
