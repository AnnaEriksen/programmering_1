package Model;

import com.sun.source.tree.IfTree;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Objects;
import java.util.zip.DeflaterOutputStream;

public class Team {

        private String name;
        private String room;
        private Student[]students;
        private int numberOfStudents = 0;
        private static final char[] correctAnswers = new char[]{'A', 'A', 'B', 'D', 'D', 'C', 'C', 'D', 'C','C'};


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public char[] getCorrectAnswers(){
        return correctAnswers;
    }

    public Team(String name, String room) {
            this.name = name;
            this.room = room;
                getCorrectAnswers();
            //her har jeg fortalt at der er plads til 32 studerende. Den er erklæret her. Når det er oprettet,
        // står der null, på alle pladser,


            this.students = new Student[32];
        }

    public void addStudent(Student student){
        //den tæller op for hver gang man bruger/kalder metoden.
        if (numberOfStudents < 32){ //vi laver en if sætning der siger, at vi kun gør noget, hvis der er plads,
            // ellers får vi en outofbounds
            this.students[numberOfStudents] = student;
            numberOfStudents++;

        }


    }

    public Student[] returnStudent(){

        // vi skal lave et nyt array, der kun er lige så langt, som der er studerende. Nu skal de studerende
        // over i det nye array
        Student[] noNull = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++){
            noNull[i] = students[i];

        }
        return noNull;
    }


    public void removeStudent(String name){

        int index = -1;
        for (int i = 0; i < numberOfStudents; i++){
            if (students[i].getName().equals(name)){
                index = i;

                if (index != -1){
                    for (int j = index; j < numberOfStudents; j++){
                        students[j] = students[j+1];

                    }
                    numberOfStudents++;
                }
            }
        }
    }

    public double findGreaterAverage(){
        double average = 0;
        for (int i = 0; i < numberOfStudents; i++){
            average += students[i].findGradeAverage();
        }
        return average / numberOfStudents;
    }

    public Student[] highScoreStudents(double minAverage){
        int count = 0;
        int[] activeStudentsCounts = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++){
            if (students[i].isActive() && students[i].findGradeAverage() >= minAverage){
                activeStudentsCounts[count] = i;
                count++;
            }
        }
        Student[] highScoreStudents = new Student[count];
        for (int i = 0; i < count; i++){
            highScoreStudents[i] = students[activeStudentsCounts[i]];
        }
        return highScoreStudents;
    }


    public String[] studentInfo(){
        String[] info = new String[numberOfStudents];
        for (int i = 0; i < students.length; i++){
            if (students[i] != null){

                String navn = students[i].getName();
                double gradeAverage = students[i].findGradeAverage();
                int answers = students[i].correctAnswers(correctAnswers);
                String result = "Name: " + navn +"\tgrade averade is: " + gradeAverage + "\t" +
                        "correct answers are: " + correctAnswers + "\n";

                info[i] = result;
            }

        }

        return info;
    }

    public int[] getStatistics(){

        int[] statistics = new int[10];
        for (int i = 0; i < correctAnswers.length; i++){
            int correctStudentAnswersCount = 0;
            for (Student s : students){
                if (s != null && s.getAnswer()[i] == correctAnswers[i]){
                    correctStudentAnswersCount++;
                }
                statistics[i] =  correctStudentAnswersCount;
            }
        }
        return statistics;
    }



    public void printTeam(){
        for (int i = 0; i < numberOfStudents; i++){
            System.out.println(students[i].getName());
            System.out.println(Arrays.toString(students[i].getGrades()));
            System.out.println(Arrays.toString(highScoreStudents(7)));
            System.out.println(room);




        }


    }

    public Student[] getStudents() {
        Student[] placeholder = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i] != null) {
                placeholder[i] = students[i];
            }
        }
        return placeholder;
    }

    public Student getStudentByName(String studentName){
        Student selectedStudent = null;
        for (Student s : students){
            if (s != null && s.getName().equalsIgnoreCase(studentName)){
                selectedStudent = s;
            }
        }
        return selectedStudent;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}




















