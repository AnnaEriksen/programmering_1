package stopwatch;

import java.util.Arrays;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        StopWatch run = new StopWatch();
            run.start();
            Scanner tænketid = new Scanner(System.in);
           int input = tænketid.nextInt();
            run.stop();
        System.out.println(run.elapsedTime());



    }
}

