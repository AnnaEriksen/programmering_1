package Test;

import Model.Student;
import Model.Team;

import java.util.Arrays;

public class TeamApp {
    public static void main(String[] args) {
        int[] grades1 = {10, 7, 02, 04, 7};
        int[] grades2 = {02, 02, 02, 04, 02};
        int[] grades3 = {02, 02, 12, 04, 10};
        int[] grades4 = {7, 02, 02, 04, 7};
        int[] grades5 = {04, 10, 04, 02};
        int[] grades6 = {02, 7, 02, 04, 12};
        Student s1 = new Student("Anna", true, grades1);
        Student s2 = new Student("Bodil", true, grades2);
        Student s3 = new Student("Keld", true, grades3);
        Student s4 = new Student("Martin", true, grades4);
        Student s5= new Student("Julie", true, grades5);
        Student s6 = new Student("Amanda", true, grades6);

        Team t1 = new Team(": K1", ": 24s");
        System.out.println("=============================");
        s1.findGradeAverage();
        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);
        System.out.println("======================");
        System.out.println(s1.findGradeAverage());
        System.out.println(s2.findGradeAverage());
        System.out.println(s3.findGradeAverage());
        System.out.println("======================");
        System.out.println();
        t1.printTeam();
        System.out.println("==========================");
        Team t2 = new Team(": K2",": t24" );
        t2.addStudent(s4);
        t2.addStudent(s5);
        t2.addStudent(s6);
        System.out.println("============================");
        System.out.println(s4.findGradeAverage());
        System.out.println(s5.findGradeAverage());
        System.out.println(s6.findGradeAverage());
        System.out.println("=======================");
        t2.printTeam();
        System.out.println("======================");
        System.out.println(s1.studentAnswersToQuestions());
        System.out.println(s1.correctAnswers(t1.getCorrectAnswers()));
        System.out.println("=========================================");
        System.out.println(Arrays.toString(t1.studentInfo()));
        System.out.println(Arrays.toString(t1.getStatistics()));



    }

}
