package Opg3;

import java.sql.SQLOutput;

public class TeamApp {
    public static void main(String[] args) {
        Player p1 = new Player("Søren", 24);
        Player p2 = new Player("Bo", 26);
        Player p3 = new Player("Lars", 21);


        p1.addScore(9);
        p2.addScore(11);
        p3.addScore(5);

        Team t1 = new Team("Barcelona");

        System.out.println(p1.getScore());

        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);

        System.out.println("Max score på holdet: " + t1.maxScore());
        System.out.println("Average Age: " + t1.calcAverageAge());
        System.out.println("Sum of score for players being 25: " + t1.calcOldPlayersScore(25));
        System.out.println("Best player: " + t1.bestPlayer());








    }
}
