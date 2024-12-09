package Application.Model;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        Konference k1 = new Konference("Hav og Himmel",LocalDate.of(2024,12,18),
                LocalDate.of(2024,12,20),"Odense Universitet",1500);

        Deltager d1 = new Deltager("Finn Madsen", "adresse","Danmark","Viby","123456789");

        Deltager d2 = new Deltager("Niels Petersen","adresse","Dk","ds","1234");

        Deltager d3 = new Deltager("Peter Sommer","das","ds","ds","123456");

        Deltager d4 = new Deltager("Lone Jensen", "das","ds","ds","123456");

       Udflugt u1 = k1.createUdflugt(LocalDate.of(2024,12,18),125,"Odense",true,
                "Byrundttur Odense");

       Udflugt u2 =k1.createUdflugt(LocalDate.of(2024,12,19),75,"Egeskov",false,
                "Egeskov");

       Udflugt u3 = k1.createUdflugt(LocalDate.of(2024,12,20),200,"Kolding",true,"Trapholt Museum, Kolding");

        Hotel h1 = new Hotel("Den Hvide Svane",1050,1250);

        Hotel h2 = new Hotel("Høtel Phønix",700,800);

        Hotel h3 = new Hotel("Pension Tusindfryd ", 500,600);

       Tilæg tilæg1 = h1.createTilæg("WIFI", 50);

       Tilæg tilæg2 = h2.createTilæg("Bad",200);
       Tilæg tilæg3 = h2.createTilæg("WIFI",75);

       Tilæg tilæg4 = h3.createTilæg("Morgenmad",100);

       Tildmelding t1 = k1.createTilmelding(false,LocalDate.of(2024,12,18),
               LocalDate.of(2024,12,20),k1,null,d1);

       Tildmelding t2 = k1.createTilmelding(false,LocalDate.of(2024,12,18),
               LocalDate.of(2024,12,20),k1,h1,d2);

       Tildmelding t3 = k1.createTilmelding(false,LocalDate.of(2024,12,18),
               LocalDate.of(2024,12,20),k1,h1,d3);
       t3.createLedsager("Mie Sommer");
       t3.addTilæg(tilæg1);
       t3.addUdflugt(u2);
       t3.addUdflugt(u3);

       Tildmelding t4 = k1.createTilmelding(true,LocalDate.of(2024,12,18),
               LocalDate.of(2024,12,20),k1,h1,d4);

       t4.createLedsager("Jan Madsen");
       t4.addTilæg(tilæg1);
       t4.addUdflugt(u1);
       t4.addUdflugt(u2);

        System.out.println(t1.samletPris());

        System.out.println(t2.samletPris());

        System.out.println(t3.samletPris());

        System.out.println(t4.samletPris());







    }
}
