package stopwatch;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch() {
    }

    public LocalTime start(){
        return startTime =LocalTime.now();
    }

    public LocalTime stop(){
        return endTime =LocalTime.now();
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public long elapsedTime(){

        //Vi bruger kommandeon chronounits til at finde sekunder mellem startTIme og endTime
        return ChronoUnit.SECONDS.between(startTime, endTime);
    }

}
