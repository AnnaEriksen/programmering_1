package ArrayList;

import java.util.ArrayList;

public class opgave1_ArrayListApp {
    public static void main(String[] args) {

        //Opgave 1
        ArrayList<String> navne = new ArrayList<>();
        navne.add("Hans");
        navne.add("Viggo");
        navne.add("Jens");
        navne.add("Børge");
        navne.add("Bent");


        System.out.println("Størrelse på arrayList");
        System.out.println(navne.size());

        navne.add(2, "Jane");

        System.out.println("Indholdet på ArrayList");
        System.out.println(navne);

        navne.remove(1);


        //tilføjer ib bagerst i listen
        navne.add("Ib");

        //Pia kommer ind forrest i listen
        navne.addFirst("Pia");

        System.out.println(navne.size());

        navne.set(2, "Hansi");

        System.out.println("Ny antal");
        System.out.println(navne.size());

        //printer længden af hver string
        for (int i = 0; i < navne.size(); i++){
            System.out.println(navne.get(i).length());


        }

        //lavet om til foreach
        for (String s : navne) {
            System.out.println(s.length());


        }
    }
}
