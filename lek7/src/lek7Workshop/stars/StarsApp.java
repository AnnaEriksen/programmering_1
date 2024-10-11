package lek7Workshop.stars;


public class StarsApp {
    final static int MAX_ROWS = 10;

    public static void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void starPictureA() {
        // TODO
    }

    public static void starPictureB() {
        // TODO
    }

    public static void starPictureC() {
        // TODO
    }

    public static void starPictureD() {
        // TODO
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Udleveret eksempel");
        starPicture();
        System.out.println("Opgave A\n");
        starPictureA();
        System.out.println("Opgave B\n");
        starPictureB();
        System.out.println("Opgave C\n");
        starPictureC();
        System.out.println("Opgave D\n");
        starPictureD();
    }

}
