public class advancedStats extends stats //uses extra parameters to calculate with more complexity
{
    private double hoursExercised;
    private double restingHeartRate;
    private boolean studyMusic;

    public advancedStats(){//default
        super();
        hoursExercised = 0;
        restingHeartRate = 70;
        studyMusic = false;
    }

    public advancedStats(double work, double breaked, double notFocused, double eff, double slp, double hExercised, double rhr, boolean music){// using variables
        super(work, breaked, notFocused, eff, slp);
        hoursExercised = hExercised;
        restingHeartRate = rhr;
        studyMusic = music;
    }

    public double getHoursExercised(){// returns hoursExercised
        return hoursExercised;
    }

    public double getRestingHeartRate(){// returns restingHeartRate
        return restingHeartRate;
    }

    public boolean usingStudyMusic(){// returns studyMusic
        return studyMusic;
    }

    public boolean advanced(){// returns if it is an advanced stats object (overridden)
        return true;
    }

    public int workScore(){// returns the score
        return score.scoreCalculator(getTimeWork(), getTimeBreak(), getTimeNotFocused(), getEfficiency(), getSleep(), hoursExercised, restingHeartRate, studyMusic);
    }

    public String toString(){ // cant use super() here because the "type of stat" needs to be at the very end for my personal preference
        
        String ret = "";
        ret += "Time Worked: " + getTimeWork() + "h\n";
        ret += "Time Not Focused: " + getTimeNotFocused() + "h\n";
        ret += "Time Breaked: " + getTimeBreak() + "h\n";
        ret += "Efficiency: " + getEfficiency() + "\n";
        ret += "Time Slept: " + getSleep() + "h\n";
        ret += "Time Exercised: " + hoursExercised + "h\n";
        ret += "Resting Heart Rate: " + restingHeartRate + "bpm\n";
        ret += "Study Music: " + studyMusic + "\n";
        ret += "Type of Stat: advanced \n";
    
        return ret;
        
    }


}