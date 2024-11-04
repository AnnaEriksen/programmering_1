package opgave5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast = new ArrayList<>();
    ArrayList<Episode> episodes = new ArrayList<>(); // Define the episodes list

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    /**
     * Return the total length (in minutes) of all the
     * episodes in the series.
     */
    public int totalLength() {
        int totalLength = 0;

        for (Episode e : episodes) {
            totalLength += e.getLengthMinutes();
        }
        return totalLength;
    }

    /**
     * Return the total list of all guest actors from all
     * episodes.
     */
    public ArrayList<String> getGuestActors() {
        ArrayList<String> totalList = new ArrayList<>();

        for (Episode e : episodes) {
            totalList.addAll(e.getGuestActors());
        }

        return totalList;
    }

    public void createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        episodes.add(episode);
    }
}

