package opgaver_lek3;

public class opgave5 {
        public static void main(String[]args){
                String ord1 = "Datamatiker";
                String ord2 = "Uddannelsen";
                String ord3 = ord1 +" " + ord2.toLowerCase();
                System.out.println(ord1.toUpperCase());
                System.out.println(ord2.toLowerCase());
                System.out.println(ord1 + " " + ord2);

                System.out.println(ord3.length());
                System.out.println(ord1.substring(0,7));
                System.out.println(ord2.substring(2,7));
                System.out.println(ord3.substring(11));
                System.out.println(ord3.substring(12));

                int halvdel = ord1.length() / 2;
                System.out.println(ord3.substring(halvdel));

}
}
