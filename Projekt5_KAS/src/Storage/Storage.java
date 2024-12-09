package Storage;

import Application.Model.*;

import java.util.ArrayList;

public class Storage {
    public static ArrayList<Hotel> hoteler = new ArrayList<>();
    public static ArrayList<Konference> konferencer = new ArrayList<>();
    public static ArrayList<Udflugt> udflugter = new ArrayList<>();

    public static ArrayList<Hotel> getHoteler() {
        return new ArrayList<>(hoteler);
    }

    public static void removeHotel(Hotel hotel){
        hoteler.remove(hotel);
    }

    public static void addHotel(Hotel hotel) {
        hoteler.add(hotel);
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void removeKonference (Konference konference) {
        konferencer.remove(konference);
    }

    public static void addKonference (Konference konference) {
        konferencer.add(konference);
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public static void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }
}
