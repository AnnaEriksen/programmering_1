package opgave5;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
            ArrayList<String> castList = new ArrayList<>();

            castList.add("Julemanden");
            castList.add("æblemand");

            Series s1 = new Series("PeepEEpOoPoO", castList);

            ArrayList<String> guestList = new ArrayList<>();
            guestList.add("hej");
            guestList.add("farvel");

            s1.createEpisode(32, guestList, 40);

            ArrayList<String> guestList2 = new ArrayList<>(); // Corrected type to ArrayList<String>

            guestList2.add("poo");
            guestList2.add("poo");

            Episode s2 = new Episode(6, guestList2, 65);

            // Assuming the episodes list can be accessed
            for (Episode e : s1.episodes) {
                System.out.println("episode nr: " + e.getNumber() +
                        "\nGuest stars: " + e.getGuestActors() +
                        "\nLength: " + e.getLengthMinutes() + " minutes " +
                        "\n");
            }

            System.out.println();
            System.out.println("Total length of s1: " + s1.totalLength() + " minutes");
            System.out.println();
            System.out.println("Guest actors in s1: " + s1.getGuestActors());
        }
    }

