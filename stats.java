public class stats
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

    public double getTimeWork(){
        return timeWorked;
    }

    public double getTimeBreak(){
        return timeBreaked;
    }

    public double getTimeNotFocused(){
        return timeNotFocused;
    }

    public double getEfficiency(){
        return efficiency;
    }

    public double getSleep(){
        return sleep;
    }

    public boolean advanced(){
        return false;
    }

    public int workScore(){
        return score.scoreCalculator(timeWorked, timeBreaked, timeNotFocused, efficiency, sleep);
    }

}