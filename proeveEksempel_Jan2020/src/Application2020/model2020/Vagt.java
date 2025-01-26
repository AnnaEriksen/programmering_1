package Application2020.model2020;

public class Vagt {
    private int timer;

    private Job job; //link til job

    public Vagt(int timer, Job job, Frivillig frivillig) {
        this.timer = timer;
        this.job = job; // til job
        setFrivillig(this.frivillig); //link til vagt
    }

    public int getTimer() {
        return timer;
    }

    //------til job--------------------------------------

    public Job getJob() {
        return job;
    }

    //--------------------Til frivillig-------------------------

    private Frivillig frivillig; //link til Frivillig

    public Frivillig getFrivillig() {
        return frivillig;
    }

//    public void setFrivillig(Frivillig frivillig) {
//        this.frivillig = frivillig;
//    }

    void setFrivillig(Frivillig frivillig){
        if (this.frivillig != frivillig){
            Frivillig oldFrivillig = this.frivillig;
            if (oldFrivillig != null){
                oldFrivillig.removeVagt(this);
            }
            this.frivillig = frivillig; //link til vagt -> frivillig
            if (frivillig != null);
            frivillig.addVagt(this);

        }
    }


}
