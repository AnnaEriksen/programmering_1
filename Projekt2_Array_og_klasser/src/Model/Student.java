package Model;

import java.util.Arrays;
import java.util.Random;

public class Student {

        private String name;
        private boolean active = true;
        private int[] grades;
        private char[] answer;

    public Student(String name, String room) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public Student(String name, boolean active, int[] grades) {
            this.name = name;
            this.active = active;
            this.grades = grades;
            studentAnswersToQuestions(); //vi sætter metoden her for at få for den individuelle elev.
        }

    public int findMax(int[] grades){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public double findGradeAverage(){
        double sum = 0;
        for (int i = 0; i < grades.length; i++){
            sum += grades[i];
    }
        return (double) sum/grades.length;
    }



    @Override
    public String toString() {
        return String.format("Name: %s \tisActive: %b\tgrades: %s", this.name, this.active, Arrays.toString(this.grades));
    }



    public char[] studentAnswersToQuestions(){ //shoutout til emma :DDD
        answer = new char[10];
        for (int i = 0; i < answer.length; i++){
            char test = (char) (Math.random() * 4 + 65);
            answer[i] = test;
        }

        return answer;
    }

    public int correctAnswers(char[] correctAnswers){
        int correctA = 0;
        for (int i = 0; i < 10; i++){
            if (correctAnswers[i] == answer[i]){
                correctA++;
            }
        }
        return correctA;
    }

    public char[] getAnswer() {
        return answer;
    }
}




