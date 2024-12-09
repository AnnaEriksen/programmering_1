package opgave5;

public class Kvadratrod {
    public static int intSqrtLinear(int n){
        int r = 0; // vi starter med 0
        int result = 0; //vi gemmer vores resultat her

        while (r * r <= n){ //vores while loop kører, så længe loopet upfylder kravet "r^2 ≤ n"
            if (r + 1 * (r + 1) > n){ // vi tjekker betingelsen for næste kvadratrod??
                result = r;
            }
            else {
                r++; // hvis ikke betingelserne bliver opfyldt, går vi videre til næste kandidat
            }
        }
        return result;
    }

    private static int intSqrtBinary(int n) {
        int left = 0; // Start med hele intervallet
        int right = n; // Start med hele intervallet
        int result = 0; //bruges til at gemme resultat

        while (left <= right){ //vi forstsætter så længe der er en søgemængde, loop kører så længe betingelserne bliver opfyldt
            int mid = (left + right) / 2; //vi beregner midtpunktet
            if (mid * mid <= n && (mid + 1) * (mid + 1) > n){
                result = mid; //gemmer mid som resultat
                left = right + 1; // Afslut løkken ved at gøre betingelsen falsk

            } else if (mid * mid > n) { //Hvis mid^2 er for stort
                right = mid + 1; // røkker en gang til højre
            } else { // Hvis (mid+1)^2 ≤ n
                left = mid - 1; //så rykker vi til venstre
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(intSqrtLinear(25));
        System.out.println(intSqrtBinary(25));

        System.out.println(intSqrtLinear(110));
        System.out.println(intSqrtBinary(110));
    }
}
