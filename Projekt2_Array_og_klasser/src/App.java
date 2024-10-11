import Model.Team;
import Model.Student;
import jdk.swing.interop.SwingInterOpUtils;
import java.sql.SQLOutput;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Team[] teams = new Team[10];
        int teamCount = 0;
        Student[] students = new Student[320];
        int studentCount = 0;

        var sc = new Scanner(System.in);
        int choice;
        //prompt bruger

        do {
           printMenu();
            System.out.print("Enter number: ");
            choice = sc.nextInt();

            if (choice == 1) {
                createTeam(sc, teams, teamCount);
                teamCount++;


            } else if (choice == 2) {
                createStudent(sc, students, studentCount, teams);
                studentCount++;

            } else if (choice == 3) {
                ShowStudentInfo(sc, teams);

            } else if (choice == 4) {
                showTeamInfo(sc, teams);

            } else if (choice == 5) {
                showTeamInfoAll(teams);

            }if (choice < 1 ||choice > 6){
                System.out.println("Invalid number...");

            }

        }
        while (choice != 6);

    }
    public static void printMenu(){
        System.out.println("\nMENU");
        System.out.println("1: Create a team\n");
        System.out.println("2: Create a student\n");
        System.out.println("3: Show one student's info and results\n");
        System.out.println("4: Show one team's info and results\n");
        System.out.println("5: Show info and results for all teams\n");
        System.out.print("6: Exit program\n");

    }

    public static void createTeam(Scanner sc, Team[] teams, int teamCount){
        String teamName;
        String teamRoom;
        sc.nextLine(); //clears leftover input from scanner usage
        System.out.println("Enter team name");
        teamName = sc.nextLine();
        System.out.println("Enter classroom");
        teamRoom = sc.nextLine();
        teams[teamCount] = new Team(teamName, teamRoom);


    }

    public static void createStudent(Scanner sc, Student[] students, int studentCount, Team[] teams){
        String teamName, studentName;
        Team SelectedTeam = null;
        boolean studentActivity = false;
        int numberOfGrades;
        int[] grades;

        sc.nextLine();

        do {
            System.out.print("Input students team: ");
            teamName = sc.nextLine();
            for (Team t : teams)
                if (t != null && t.getName().equalsIgnoreCase(teamName)){
                    SelectedTeam = t;
                }
            if (SelectedTeam == null){
                System.out.println("Invalid input...");
            }

            System.out.print("");
        } while (SelectedTeam == null);
        // prompt bruger til at indtaste navn
        System.out.println("Enter student name: ");
        studentName = sc.nextLine();
        System.out.println("Enter student activity: ");
        studentActivity = sc.nextBoolean();
        System.out.println("Enter number of grades: ");
        numberOfGrades = sc.nextInt();
        System.out.println("Enter grades: ");
        grades = new int[numberOfGrades];

        for (int i = 0; i < numberOfGrades; i++){
            System.out.printf("Enter %d grade: ", i + 1);
            grades[i] = sc.nextInt();
        }
        var studentToAdd = new Student(studentName, studentActivity, grades);
        students[studentCount] = studentToAdd;
        SelectedTeam.addStudent(studentToAdd);



    }
    public static void ShowStudentInfo(Scanner sc, Team[] teams){
        String teamName;
        Team selectedTeam = null;
        sc.nextLine();

        do {
            System.out.print("Input students team: ");
            teamName = sc.nextLine();
            for (Team t : teams)
                if (t != null && t.getName().equalsIgnoreCase(teamName)){
                    selectedTeam = t;
                }

        } while (selectedTeam == null);

        System.out.println("Select student: ");
        for (Student s : selectedTeam.getStudents()){
            System.out.printf("%s \t", s.getName());
        }

        System.out.println();
        System.out.println("Enter name of student: ");
        String studentName = sc.nextLine();
        Student selectedStudent = selectedTeam.getStudentByName(studentName);
        System.out.println(selectedStudent);
    }
    public static void showTeamInfo(Scanner sc, Team[] teams){
        String teamName;
        Team selectedTeam = null;
        sc.nextLine();

        do {
            System.out.print("Input students team: ");
            teamName = sc.nextLine();
            for (Team t : teams)
                if (t != null && t.getName().equalsIgnoreCase(teamName)){
                    selectedTeam = t;
                }
            if (selectedTeam == null){
                System.out.println("Invalid input...");
            }

            System.out.print("");
        } while (selectedTeam == null);
        System.out.printf("Team name: %s\t Team room: %s\t Team member count: %d");
        selectedTeam.getName();
        selectedTeam.getRoom();
        selectedTeam.getNumberOfStudents();

        System.out.println("\nstudents in team: ");


        String[] studentInfo = selectedTeam.studentInfo();
        for (String s : studentInfo){
            System.out.println(s);
        }

    }
    public static void showTeamInfoAll(Team[] teams){
        for (Team t : teams){
            if (t != null){
                System.out.printf("\n\n_____________" + t.getName() + "_______________");
                t.getName();
                t.getRoom();
                t.getNumberOfStudents();

                System.out.println("\nstudents in team: ");


                String[] studentInfo = t.studentInfo();
                for (String s : studentInfo){
                    System.out.println(s);

                    System.out.println("________________________________________________");
                }
            }
        }
    }
}

