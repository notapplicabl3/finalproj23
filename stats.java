public class stats // basic class
{
    private double timeWorked; // total from start to finish (including breaks & not focused)
    private double timeBreaked; // includes water breaks, 5 minute walks, etc. does NOT include the breaks after finishing a work session
    private double timeNotFocused; // includes time not focused when supposed to be working, staring off into the distance, getting distracted, etc.
    private double efficiency; // the users percieved efficiency on a scale of 1-10
    private double sleep; // the amount of sleep the user has gotten the night before

    public stats(){ //sets everything to zero (if detects an all 0 constructor, will return for score n/a)
        timeWorked = 0;
        timeBreaked = 0;
        timeNotFocused = 0;
        efficiency = 0;
        sleep = 0;
    }

    public stats(double work, double breaked, double notFocused, double eff, double slp){ // initializes all variables with given inputs
        timeWorked = work;
        timeBreaked = breaked;
        timeNotFocused = notFocused;
        efficiency = eff;
        sleep = slp;

    }

    public double getTimeWork(){ // returns timeWorked
        return timeWorked;
    }

    public double getTimeBreak(){ // returns timeBreaked
        return timeBreaked;
    }

    public double getTimeNotFocused(){ // returns TimeNotFocused
        return timeNotFocused;
    }

    public double getEfficiency(){ // returns efficiency
        return efficiency;
    }

    public double getSleep(){ // returns sleep
        return sleep;
    }

    public boolean advanced(){ // returns if the objects is advanced stats or not (overridden)
        return false;
    }

    public int workScore(){ // returns score (overriden if advanced)
        return score.scoreCalculator(timeWorked, timeBreaked, timeNotFocused, efficiency, sleep);
    }

    public String toString(){
        String ret = "";
        ret += "Time Worked: " + timeWorked + "h\n";
        ret += "Time Not Focused: " + timeNotFocused + "h\n";
        ret += "Time Breaked: " + timeBreaked + "h\n";
        ret += "Efficiency: " + efficiency + "\n";
        ret += "Time Slept: " + sleep + "h\n";
        ret += "Type of Stat: normal \n";

        return ret;
    }
}