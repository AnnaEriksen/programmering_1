package Application.Model;

public class Deltager {

    private String navn;
    private String adresse;
    private String land;
    private String by;
    private String firmanavn;
    private String tlfNr;
    private String firmaTlf;

    public Deltager(String navn, String adresse, String land, String by, String tlfNr) {
        this.navn = navn;
        this.adresse = adresse;
        this.land = land;
        this.by = by;
        this.tlfNr = tlfNr;
    }


    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getLand() {
        return land;
    }

    public String getBy() {
        return by;
    }

    public String getFirmanavn() {
        return firmanavn;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public String getFirmaTlf() {
        return firmaTlf;
    }

    public void setFirmaTlf(String firmaTlf) {
        this.firmaTlf = firmaTlf;
    }

    public void setFirmanavn(String firmanavn) {
        this.firmanavn = firmanavn;
    }


    @Override
    public String toString() {
        return navn + " " + adresse + tlfNr;
    }
}
