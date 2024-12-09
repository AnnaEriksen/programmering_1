package Application.Model;

public class Tilæg {

    private String tilægsType;
    private int pris;
    private Hotel hotel;

    Tilæg(String tilægsType, int pris, Hotel hotel) {
        this.tilægsType = tilægsType;
        this.pris = pris;
        this.hotel = hotel;
    }

    public String getTilægsType() {
        return tilægsType;
    }

    public int getPris() {
        return pris;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public String toString() {
        return tilægsType + " " + pris;
    }
}
