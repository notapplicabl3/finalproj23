public class score // class for score calculating
{

    public static int scoreCalculator(double work, double breaked, double notFocused, double eff, double rest) // method if only normal stats object (overloaded)
    {

        if (work == 0){
            return -1;
        }

        double totalScore = 0;

        totalScore += 700.0 * (1.05 - Math.abs(0.08 - (breaked / work))); // base score multiplied by a factor according to lengths taken in the work time

        if (work <= 2){ // slightly decreases score for working less than 2 hours
            totalScore *= (1.00 - (2.0 * work / 100.0));
        }
        
        totalScore += (150.0 - 250 * Math.pow(10.0 * notFocused / work, 2.0)); // changes score by an amount determined by the amount of time not focused relative to timeWorked

        totalScore *= (0.60 + eff / 20.0); // multiplies score by a factor according to the users input of percieved efficiency (1-10)

        totalScore *= (1.05 - ( 1 / 2 ) * ( (rest - 8.5) / 8.5) ); // multiplies the final score by a factor relative to how much sleep the user got

        int totalScoretruncated = (int) totalScore; // truncates


        return totalScoretruncated;

    }




    public static int scoreCalculator(double work, double breaked, double notFocused, double eff, double rest, double exercise, double rh, boolean music) //method if advanced stats object (overloaded)
    {

        if (work == 0){
            return -1;
        }

        double totalScore = 0;

        totalScore += 700.0 * (1.05 - Math.abs(0.08 - (breaked / work))); // base score multiplied by a factor according to lengths taken in the work time

        if (work <= 2){ // slightly decreases score for working less than 2 hours
            totalScore *= (1.00 - (2.0 * work / 100.0));
        }
        
        totalScore += (150.0 - 250 * Math.pow(10.0 * notFocused / work, 2.0)); // changes score by an amount determined by the amount of time not focused relative to timeWorked

        totalScore *= (0.60 + eff / 20.0); // multiplies score by a factor according to the users input of percieved efficiency (1-10)

        totalScore *= (1.07 - Math.pow( (40.0 - rh) / 100.0 , 2.0)); // multiplies the score by a factor according to how close resting heartrate is to 40.

        if (music){ // increases score for using study music
            totalScore *= 1.02;
        }

        totalScore *= (1.05 - ( 1 / 2 ) * ( (rest - 8.5) / 8.5) ); // multiplies the final score by a factor relative to how much sleep the user got

        
        int totalScoretruncated = (int) totalScore; // truncates


        return totalScoretruncated;

    }
}