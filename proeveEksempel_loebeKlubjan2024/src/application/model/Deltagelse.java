package application.model;

public class Deltagelse {

    private boolean isTræner;
    private boolean isFremmødt;

    public Deltagelse(boolean isTræner, boolean isFremmødt, Træning træning) { //til træning
        this.isTræner = isTræner;
        this.isFremmødt = isFremmødt;
        this.træning = træning; //til træning
    }

    public boolean isTræner() {
        return isTræner;
    }

    public void setTræner(boolean isTræner) {
        this.isTræner = isTræner; }

    public boolean isFremmødt() {
        return isFremmødt;
    }

    public void setFremmødt(boolean isFremmødt) {
        this.isFremmødt = isFremmødt;
    }

    public void setTræning(Træning træning) {
        if (træning != null) {
        this.træning = træning;
        } else {
            throw new IllegalArgumentException("Træning må ikke være null");
        }
    }



    //-------------metoder til træning-----------------------
    private Træning træning;

    public Træning getTræning() {
        return træning;
    }

    @Override public String toString() { return "Deltagelse{" + "isTræner=" + isTræner + ", isFremmødt=" + isFremmødt + ", træning=" + træning.getRute() + '}'; }
}
