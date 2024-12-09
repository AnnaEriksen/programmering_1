package opgave7;

public class opgave7 {
    public static boolean femEns(String s, int k){
        int count = 1; //vi skal have en tæller som starter ved 1, da vi skal tælle det første tegn
        int i = 0;
        boolean found = false; //det mest praktiske er at sætte en boolean til false til at starte med

        //vi løber hele strengen "s" igennem
        while (i < s.length()){
            if (s.charAt(i) == s.charAt(i) -1){ //hvis det nuværende bogstav er det samme som det forrige..
                count++; //så tæller vi op
                if (count == k){ //hvis tælleren når k
                    found = true; //sætter vi found til true
                }
            } else {
                count = 1; //ellers nulstiller vi tælleren
            }
            i++;

        }
        return found;
    }

    public static void main(String[] args) {

        System.out.println(femEns("Jubiiii", 4)); // Skal returnere sandt, da der er fire i'er i træk
        System.out.println(femEns("Jubiiii", 5)); // Skal returnere falsk, da der ikke er fem ens tegn i træk
        System.out.println(femEns("Jubiiiiii", 5)); // Skal returnere sandt, da der er fem i'er i træk

    }

}
