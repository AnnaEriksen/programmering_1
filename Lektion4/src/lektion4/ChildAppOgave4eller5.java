package lektion4;

public class ChildAppOgave4eller5 {

//    Metoden skal returenre en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
//    Reglerne for dette kan ses på opgavedsedlen

    public static String institution(int age) {
        String result = "";
        if (age == 0){
            result = "Derhjemme";
        }
        //hvis alderen er ...
        else if (age <= 2){
            result = "Dagpleje";
        }
        //går barnet i...
        else if (age <= 5){
            result = " børnehave";
        }
        else if (age <= 16){
            result = " Skole";
        }
        else{
            result = " Afsluttet skole";
        }
        return result;
    }

    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen

    public static String team(boolean isBoy, int age) {
        String result = "";

        if (isBoy){
            if (age < 8){
                result = " Young cubs";
            }
            else{
                result = " Coolboys";
            }
        }
        else {
            if (age < 8) {

                result = "Tumbling girls";

            } else {
                result = "Spinrgy Girls";
            }
        }
        return result;
    }
    //Husk return og team metode

    public static void main(String[] args) {
        System.out.println("Et barn på 5 skal i" + institution(6));
        System.out.println("Et dreng på 8 skal i " + team(true,8));
    }
}

