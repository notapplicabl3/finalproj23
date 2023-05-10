public class advancedStats extends stats //uses extra parameters to calculate with more complexity
{
    private double hoursExercised;
    private double restingHeartRate;
    private boolean studyMusic;

    public advancedStats(){
        super();
        hoursExercised = 0;
        restingHeartRate = 70;
        studyMusic = false;
    }

    public advancedStats(double work, double breaked, double notFocused, double eff, double slp, double hExercised, double rhr, boolean music){
        super(work, breaked, notFocused, eff, slp);
        hoursExercised = hExercised;
        restingHeartRate = rhr;
        studyMusic = music;
    }

    public double getHoursExercised(){
        return hoursExercised;
    }

    public double getRestingHeartRate(){
        return restingHeartRate;
    }

    public boolean usingStudyMusic(){
        return studyMusic;
    }

    public boolean advanced(){
        return true;
    }

    public int workScore(){
        return score.scoreCalculator(getTimeWork(), getTimeBreak(), getTimeNotFocused(), getEfficiency(), getSleep(), hoursExercised, restingHeartRate, studyMusic);
    }


}