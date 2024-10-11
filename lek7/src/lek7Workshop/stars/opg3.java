package lek7Workshop.stars;

public class opg3 {
    public static void main(String[] args) {
        int n = 5;
        printMatrix(n);

    }

    public static void printMatrix(int n){
        String s ="";

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                s = s + (int)(Math.random() * 2);

            }

            System.out.println(s);
            s = "";



        }
    }
}
