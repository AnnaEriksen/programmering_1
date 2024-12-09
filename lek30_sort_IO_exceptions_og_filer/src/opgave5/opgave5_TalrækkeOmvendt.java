package opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class opgave5_TalrækkeOmvendt {
//    Læs filen fra opgave 4) og indsæt tallene i en ArrayList<Integer> efterhånden som de indlæses.
//    Udskriv dernæst tallene fra arraylisten i omvendt rækkefølge, dvs. 285, 177, ..., 34

    public static void main(String[] args) throws FileNotFoundException {

        //vi skal selvfølgelig bruge filens placering
        File filein = new File("C:\\\\Users\\\\annae\\\\IdeaProjects\\\\projekt 1\\\\opgave4_tal.txt");
            ArrayList<Integer> tal = new ArrayList<>();

        Scanner scan = new Scanner(filein);
        while (scan.hasNext()){
            tal.add(Integer.parseInt(scan.nextLine()));
        }
        scan.close();
        System.out.println("Talrække" + tal);

        ArrayList<Integer> omvendt = new ArrayList<>();
        for (int i = tal.size() -1; i >= 0; i--){
            omvendt.add(tal.get(i));
        }

        System.out.println("Talrække omvendt" + omvendt);

        }

    }

