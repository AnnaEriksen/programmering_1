package Opg3;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Team {
    private static String name;
    private static ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void printPlayers(){
        for (Player player: players){
            System.out.print("Navn: " + player.getName());
            System.out.print("Alder: " +player.getAge() );
            System.out.println("Score: " + player.getScore());
        }
    }

    public double calcAverageAge(){
        double averageAge = 0;
        double sum = 0;
        for (Player player: players){
            sum += player.getAge();
        }
        averageAge = sum / players.size();
        return averageAge;
    }

   public int calcTotalScore(){
        int totalScore = 0;
        for (Player player: players){
            totalScore = player.getScore();
   }
       return totalScore;
   }

    public int calcOldPlayersScore(int ageLimit){
        int oldScore = 0;
        for (Player player : players){
            if(player.getAge() >= ageLimit){
                oldScore += player.getScore();
            }
        }
        return oldScore;
    }

    public int maxScore(){
        int maxScore = 0;

        for (Player player: players){

        if (player.getScore() > maxScore){
            maxScore = player.getScore();
        }
        }
        return maxScore;
    }

    public String bestPlayer(){
        int maxScore = 0;
        Player maxScorePlayer = null;
        for (Player player: players){
            if (player.getScore() > maxScore){
                maxScorePlayer = player;
            }
        }
        return maxScorePlayer.getName();
    }






}


