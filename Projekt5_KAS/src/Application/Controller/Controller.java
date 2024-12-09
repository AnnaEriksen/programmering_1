package Application.Controller;

import Application.Model.*;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Konference createKonference(String navn, LocalDate startDato, LocalDate slutDato, String sted,
                                              int konferenceAfgift) {
        Konference konference = new Konference(navn, startDato, slutDato, sted, konferenceAfgift);
        Storage.addKonference(konference);
        return konference;
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static Hotel createHotel(String navn, int enkeltVærelsesPris, int dobbeltværelsePris) {
        Hotel hotel = new Hotel(navn, enkeltVærelsesPris, dobbeltværelsePris);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHoteller(Konference konference) {
        return new ArrayList<>(konference.getHoteler());
    }

    public static void addHotel(Konference konference, Hotel hotel) {
        konference.addHotel(hotel);
    }

    public static Deltager createDeltager(String navn, String adresse, String land, String by, String tlfNr) {
        Deltager deltager = new Deltager(navn, adresse, land, by, tlfNr);
        return deltager;
    }

    public static Tilæg createTillæg(String tilægsType, int pris, Hotel hotel) {
        Tilæg tilæg = hotel.createTilæg(tilægsType, pris);
        return tilæg;
    }

    public static Udflugt createUdflugt(LocalDate dato, int pris, String sted, boolean forplejning, String navn,
                                        Konference konference) {
        Udflugt udflugt = konference.createUdflugt(dato, pris, sted, forplejning, navn);
        Storage.addUdflugt(udflugt);

        return udflugt;
    }

    public static Tildmelding createTildmelding(boolean fordragsholder, LocalDate ankomstDato, LocalDate afrejseDato,
                                                Konference konference, Hotel hotel, Deltager deltager) {
        Tildmelding tildmelding = konference.createTilmelding(fordragsholder, ankomstDato, afrejseDato,
                konference, hotel, deltager);
        return tildmelding;
    }

    public static void addTillæg(Tildmelding tildmelding, Tilæg tilæg) {
        tildmelding.addTilæg(tilæg);
    }

    public static void addUdflugt(Tildmelding tildmelding, Udflugt udflugt) {
        tildmelding.addUdflugt(udflugt);

    }

    public static Ledsager createLedsager(Tildmelding tildmelding, String navn) {
        Ledsager ledsager = tildmelding.createLedsager(navn);
        return ledsager;
    }

    public static int getSamletPris(Tildmelding tildmelding) {
        return tildmelding.samletPris();
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return Storage.getUdflugter();
    }

    public static ArrayList<Tilæg> getTilægsListe(Hotel hotel) {
        return new ArrayList<>(hotel.getTilægs());
    }

    public static ArrayList<Deltager> hotelgæster(Konference konference) {
        ArrayList<Deltager> hotelGæster = new ArrayList<>();

        try {
            PrintWriter printWriter = new PrintWriter("hotelGæster.txt");

            // Iterér gennem alle hoteller i konferencen
            for (int i = 0; i < konference.getHoteler().size(); i++) {
                Hotel hotel = konference.getHoteler().get(i);
                printWriter.println("Hotel: " + hotel.getNavn());
                printWriter.println();

                // Midlertidig liste til gæster for det aktuelle hotel
                ArrayList<Deltager> aktuelleGæster = new ArrayList<>();
                ArrayList<Ledsager> aktuelLedsagere = new ArrayList<>();

                // Find alle tilmeldinger, der matcher hotellet
                for (int j = 0; j < konference.getTilmeldinger().size(); j++) {
                    Tildmelding tilmelding = konference.getTilmeldinger().get(j);
                    if (tilmelding.getHotel() != null &&
                            tilmelding.getHotel().getNavn().equals(hotel.getNavn())) {
                        aktuelleGæster.add(tilmelding.getDeltager());
                        aktuelLedsagere.add(tilmelding.getLedsager());
                    }
                }

                // Tilføj gæster til den samlede liste
                hotelGæster.addAll(aktuelleGæster);

                // Udskriv gæster for dette hotel
                if (aktuelleGæster.isEmpty()) {
                    printWriter.println("Ingen gæster på dette hotel.");
                } else {
                    for (int k = 0; k < aktuelleGæster.size(); k++) {
                        printWriter.println(aktuelleGæster.get(k).getNavn());
                        if (aktuelLedsagere.get(k) != null) {
                            printWriter.println("Ledsager: " + aktuelLedsagere.get(k).getNavn());
                        }
                        printWriter.println();
                    }
                }

                printWriter.println("--------------------------------------------");
            }

            printWriter.close();
        } catch (FileNotFoundException error) {
            throw new RuntimeException("Kunne ikke oprette filen: " + error.getMessage());
        }

        return hotelGæster;
    }

    public static ArrayList<Ledsager> udflugtGæsterPrint(Konference konference) {
        ArrayList<Ledsager> udflugtsGæster = new ArrayList<>();

        try {
            PrintWriter printWriter = new PrintWriter("udflugtGæster.txt");

            // Iterér gennem alle udflugter i konferencen
            for (int i = 0; i < konference.getUdflugter().size(); i++) {
                Udflugt udflugt = konference.getUdflugter().get(i);
                printWriter.println("Udflugt: " + udflugt.getNavn());
                printWriter.println();

                // Midlertidig liste til gæster for det aktuelle udflugt
                ArrayList<Ledsager> aktuelleGæster = new ArrayList<>();


                // Find alle tilmeldinger, der matcher udflugten
                for (int j = 0; j < konference.getTilmeldinger().size(); j++) {
                    Tildmelding tilmelding = konference.getTilmeldinger().get(j);
                    for (int l = 0; l < tilmelding.getUdflugter().size(); l++) {
                        if (tilmelding.getUdflugter() != null &&
                                tilmelding.getUdflugter().get(l).getNavn().equals(udflugt.getNavn())) {
                            aktuelleGæster.add(tilmelding.getLedsager());
                        }

                    }
                }

                udflugtsGæster.addAll(aktuelleGæster);


                if (aktuelleGæster.isEmpty()) {
                    printWriter.println("Ingen gæster på denne udflugt.");
                } else {
                    printWriter.println("Deltager:  \n");
                    for (int k = 0; k < aktuelleGæster.size(); k++) {
                        printWriter.println(aktuelleGæster.get(k));
                        printWriter.println();
                    }
                }

                printWriter.println("--------------------------------------------");
            }

            printWriter.close();
        } catch (FileNotFoundException error) {
            throw new RuntimeException("Kunne ikke oprette filen: " + error.getMessage());
        }

        return udflugtsGæster;

    }

    public static String udflugtGæsterStringBulider(Konference konference) {
        ArrayList<Ledsager> udflugtsGæster = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        // Iterér gennem alle udflugter i konferencen
        for (int i = 0; i < konference.getUdflugter().size(); i++) {
            Udflugt udflugt = konference.getUdflugter().get(i);
            sb.append("Udflugt: " + udflugt.getNavn());
            sb.append("\n");

            // Midlertidig liste til gæster for det aktuelle udflugt
            ArrayList<Ledsager> aktuelleGæster = new ArrayList<>();


            // Find alle tilmeldinger, der matcher udflugten
            for (int j = 0; j < konference.getTilmeldinger().size(); j++) {
                Tildmelding tilmelding = konference.getTilmeldinger().get(j);
                for (int l = 0; l < tilmelding.getUdflugter().size(); l++) {
                    if (tilmelding.getUdflugter() != null &&
                            tilmelding.getUdflugter().get(l).getNavn().equals(udflugt.getNavn())) {
                        aktuelleGæster.add(tilmelding.getLedsager());
                    }

                }
            }

            udflugtsGæster.addAll(aktuelleGæster);


            if (aktuelleGæster.isEmpty()) {
                sb.append("Ingen gæster på denne udflugt.");
            } else {
                sb.append("Deltager:  \n");
                for (int k = 0; k < aktuelleGæster.size(); k++) {
                    sb.append(aktuelleGæster.get(k));
                    sb.append("\n");
                }
            }

            sb.append("--------------------------------------------");
            sb.append("\n");
        }


        return sb.toString();

    }

    public static ArrayList<Deltager> konferenceDeltager(Konference konference) {
        ArrayList<Deltager> konferenceDeltager = new ArrayList<>();

        for (int i = 0; i < konference.getTilmeldinger().size(); i++) {
            konferenceDeltager.add(konference.getTilmeldinger().get(i).getDeltager());
        }

        for (int i = 1; i < konferenceDeltager.size(); i++) {
            Deltager next = konferenceDeltager.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getNavn().compareTo(konferenceDeltager.get(j - 1).getNavn()) > 0) {
                    found = true;
                } else {
                    konferenceDeltager.set(j, konferenceDeltager.get(j - 1));
                    j--;
                }
            }
            konferenceDeltager.set(j, next);
        }

        return konferenceDeltager;
    }

    public static String konferenceDeltagerStringBuilder(Konference konference) {
        ArrayList<Deltager> konferenceDeltager = new ArrayList<>(Controller.konferenceDeltager(konference));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < konferenceDeltager.size(); i++) {
            sb.append(konferenceDeltager.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String hotelGæstString(Konference konference) {
        ArrayList<Deltager> hotelGæster = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // Iterér gennem alle hoteller i konferencen
        for (int i = 0; i < konference.getHoteler().size(); i++) {
            Hotel hotel = konference.getHoteler().get(i);
            sb.append(hotel.getNavn());
            sb.append("\n");

            // Midlertidig liste til gæster for det aktuelle hotel
            ArrayList<Deltager> aktuelleGæster = new ArrayList<>();
            ArrayList<Ledsager> aktuelleLedsager = new ArrayList<>();

            for (int j = 0; j < konference.getTilmeldinger().size(); j++) {
                Tildmelding tilmelding = konference.getTilmeldinger().get(j);
                if (tilmelding.getHotel() != null &&
                        tilmelding.getHotel().getNavn().equals(hotel.getNavn())) {
                    aktuelleGæster.add(tilmelding.getDeltager());
                    aktuelleLedsager.add(tilmelding.getLedsager());
                }
            }
        // Tilføj gæster til den samlede liste
            hotelGæster.addAll(aktuelleGæster);

            // Udskriv gæster for dette hotel
            if (aktuelleGæster.isEmpty()) {
                sb.append("\n");
                sb.append("Ingen gæster på dette hotel.");
                sb.append("\n");
            } else {
                sb.append("\n");
                for (int k = 0; k < aktuelleGæster.size(); k++) {
                    sb.append("Deltager: " + aktuelleGæster.get(k).getNavn() + " " + aktuelleGæster.get(k).getTlfNr());
                    sb.append("\n");// Antager Deltager har en korrekt toString()
                    if (aktuelleLedsager.get(k) != null) {
                        sb.append("Ledsager: " + aktuelleLedsager.get(k).getNavn());
                        sb.append("\n");
                    }
                    sb.append("\n");
                }
            }

            sb.append("--------------------------------------------\n");
        }

        return sb.toString();
    }


}
