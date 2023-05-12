public class timeCredits
{
    private int credits;
    private String type;
    private static int creditsUsed = 0;

    public timeCredits(){//default
        credits = 0;
        type = "";
    }

    public timeCredits(int scoreValue){//determinds credits based on score and determines type based on score
        credits = scoreValue / 200;
        if (scoreValue > 800){
            type = "better";
        } else if (scoreValue < 400) {
            type = "worse";
        } else {
            type = "mid";
        }
    }

    public int getCredits(){//returns credits
        return credits;
    }
    
    public String getType(){//returns type
        return type;
    }

    public int getCreditsUsed(){// returns TOTAL NUMBER of credits used
        return creditsUsed;
    }

    public int useCredit(){// removes one credit from the timeCredits object and returns the remaining amount of credits, if there are no credits to be used, returns -1
        if (credits <= 0){
            return -1;
        }
        credits--;
        creditsUsed++;
        return credits;
    }

    public String toString()
    {
        String ret = "";
        ret += "Type of Credits: " + type + "\n";
        ret += "Time Worked: " + credits + "\n";
        
        return ret;
    }


}