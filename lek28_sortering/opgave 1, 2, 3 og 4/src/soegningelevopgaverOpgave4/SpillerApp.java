package soegningelevopgaverOpgave4;

import java.util.ArrayList;

public class SpillerApp {

    // TODO Opgave 4.1
    public static Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null; //<initialiser RESULTAT til ikke-fundet>
        int i = 0; //<initialiser KM>
        while(spiller == null && i < spillere.size()){ //while (<RESULTAT er ikke-fundet> && <KM  >, altså forskellig fra tom. at kandidatmændge ikke er tom) {
            Spiller s = spillere.get(i); //<Udvælg K fra KM>
            if (s.getMaal() == score){ //<if (<K er lig med M>)
                spiller = s; //<sæt RESULTAT (M er fundet, opdaterer vores spiller så den ikke længere er null)>
            }
            else {
                i++; //<split KM i forhold til K og M, gør kandidatmængde mindre og søger videre>
            }
        }
        return spiller;
    }

    // TODO Opgave 4.2
//    4.2 Lav igen en metode der givet en ArrayList list, indeholdende Spiller objekter, finder en spiller
//    med en bestemt målscore. Hvis en sådan ikke findes, returneres null. Det kan antages listen er
//    sorteret i aftagende orden efter målscore. Metoden skal have nedenstående signatur:
    public static Spiller findScoreBinær(ArrayList<Spiller> spillere, int score){
        Spiller spiller = null;
        int left = 0;
        int right = spillere.size() - 1;

        while (spiller == null && left <= right) { //ved binær søgning, skal de være sorteret. Vi starter på midten.
            int middle = (left + right) / 2;
            Spiller s = spillere.get(middle);
            if (s.getMaal() == score){ //
                spiller = s;
            }
            else if (s.getMaal() > score) { //gør kandidatmændgen mindre, ved at rykke left og right. Min kanditatmængde er alle dem der ligger mellem left og right
                left = middle + 1; //finder min middle og rykker min left
            }
            else {
                right = middle -1;
            }

        }

        return spiller;
    }

//    4.3 Lav en metode der givet en ArrayList list indeholdende Spiller objekter, finder navnet på en
//    Spiller, der er mindre end 170 cm og har scoret mere end 50 mål. Listen er ikke sorteret. Metoden
//    skal have nedenstående signatur:
//    Metoden skal laves ved lineær søgning. Hvis ingen spiller opfylder kriteriet returneres den tomme
//    String.

    // TODO Opgave 4.3
    public static String godSpiller (ArrayList<Spiller> spillere){
        String spiller = null;
        int i = 0;

        while (spiller == null && i < spillere.size()){
            Spiller s = spillere.get(i);
            if ( s.getHoejde() < 170 && s.getMaal() > 50){
                spiller = String.valueOf(s);
            }
            else {
                i++;
            }
        }

        return spiller + "";
    }



    // Her tilføjes metoder der løser opgve 4.2 og 4.3

    public static void main(String[] args) {

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));
        spillerListe.add(new Spiller("bo", 169, 73, 51));

        System.out.println("Spiller der har scoret 35 mål: " + findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3
        // TODO Opgave 4.2
        ArrayList<Spiller> maalIAftagendeOrden = new ArrayList<>();
        maalIAftagendeOrden.add(new Spiller("Bo", 203, 89, 60));
        maalIAftagendeOrden.add(new Spiller("bo", 169, 73, 51));
        maalIAftagendeOrden.add(new Spiller("Hans", 196, 99, 45));
        maalIAftagendeOrden.add(new Spiller("Mads", 200, 103, 37));
        maalIAftagendeOrden.add(new Spiller("Lars", 192, 86, 35));
        maalIAftagendeOrden.add(new Spiller("Jens", 188, 109, 32));
        maalIAftagendeOrden.add(new Spiller("Finn", 194, 102, 12));


        // TODO Opgave 4.2
        System.out.println("Spiller der har scoret 35 mål: " + findScoreBinær(maalIAftagendeOrden, 35));
        System.out.println("Spiller der har scoret 30 mål: " + findScoreBinær(maalIAftagendeOrden, 30));




        // TODO Opgave 4.3

        System.out.println("Finder spiller der er mindre end 170, og har en målscore på over 50; " + godSpiller(spillerListe));
    }

}
