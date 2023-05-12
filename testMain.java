import java.util.ArrayList;
import java.util.Scanner;

public class testMain
{
    public static void main(String[] args) throws InterruptedException{// Benjamin Chen

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to the  ");
        System.out.println("There will be various questions asked to determine your work efficiency.");
        System.out.println("Our system will return a score corresponding to the levels of efficiency:");
        System.out.println("    0-200 - Very Poor");
        System.out.println("    200-400 - Poor");
        System.out.println("    400-600 - Ok");
        System.out.println("    600-800 - Good");
        System.out.println("    800-1000 - Very Good");
        System.out.println("    1000+ - Excellent");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        

        ArrayList<stats> arrayOfStats = new ArrayList<stats>();


        boolean keepGoing = true;

        while (keepGoing){
            System.out.println("Please put in the following values in hours unless otherwise specified (only input numbers)");
            System.out.println("How long was your work session? (include short breaks and not focused time, do not include time spent on extended breaks (> 15 minutes) (resting, eating, relaxing), these extended times of rest denote the time of break between work sessions)");
            double working = scan.nextDouble();

            System.out.println("How long did you break?");
            double breaking = scan.nextDouble();

            System.out.println("How long were you not focused?");
            double notfocusing = scan.nextDouble();

            System.out.println("What was your working efficiency on a scale of 1-10 (feel free to provide a decimal value!)");
            double efficiently = scan.nextDouble();

            System.out.println("How long did you sleep today?");
            double sleeping = scan.nextDouble();
            System.out.println("");
            System.out.println("");
            

            System.out.println("Would you like to put more information in to provide a more accurate score? (y/n)");
            String answer = scan.next();
            System.out.println("");

            if (answer.equals("y")){
                System.out.println("Great!");
                System.out.println("");


                System.out.println("How long did you exercise today?");
                double exercising = scan.nextDouble();

                System.out.println("What is your resting heartrate? (If you don't know, put 70)");
                double restingheart = scan.nextDouble();

                System.out.println("Did you use study music? (y/n)");
                String musicanswer = scan.next();

                boolean listening = false;
                if (musicanswer.equals("y")){
                    listening = true;
                }

                arrayOfStats.add(new advancedStats(working, breaking, notfocusing, efficiently, sleeping, exercising, restingheart, listening));



            } else {
                arrayOfStats.add(new stats(working, breaking, notfocusing, efficiently, sleeping));
            }

            
            System.out.println("Would you like to keep putting in more work sessions for today? (y/n)");

            String yesno = scan.next(); // using scan.next instead of nextLine because nextLine is not properly working consistently 

            if (yesno.equals("n")){
                keepGoing = false;
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            


        }

        // printing out all the data
        System.out.println("");
        System.out.println("");
        System.out.println("Here are all your sessions and their stats + score:");
        System.out.println("");

        for (int i = 0; i < arrayOfStats.size(); i++){
            System.out.println("\t Session " + (i + 1) + ": \n" + arrayOfStats.get(i));
            System.out.println("");
            System.out.println("SCORE: " + arrayOfStats.get(i).workScore());
            System.out.println("");
            System.out.println("");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Here are the corresponding credits for each session:");

        ArrayList<timeCredits> arrayOfCredits = new ArrayList<timeCredits>();


        for (int i = 0; i < arrayOfStats.size(); i++){
            arrayOfCredits.add(new timeCredits(arrayOfStats.get(i).workScore()));
        }

        for (int i = 0; i < arrayOfCredits.size(); i++){
            System.out.println("\t Session " + (i + 1) + ": \n" + arrayOfCredits.get(i));
            System.out.println("");
            System.out.println("");
        }

        System.out.println("");
        System.out.println("");
        

        System.out.println("Would you like to do anymore actions? (use credits, look at specific entry) (y/n)");
        String moreActions = scan.next();
        while (moreActions.equals("y")){
            System.out.println("Please type \"c\" if you want to use credits, \"s\" if you want to look at a specific entry, \"q\" if you want to quit");
            String action = scan.next();
            if (action.equals("c")){ // action to use credits
                System.out.println("Type in the session number you would like use credits from");
                int sessionNum = scan.nextInt() - 1;
                int creditsRemaining;
                if (sessionNum >= arrayOfStats.size() || sessionNum < 0){
                    System.out.println("");
                    System.out.println("error");
                } else {
                    System.out.println("Using a credit...");
                    System.out.println("");
                    creditsRemaining = arrayOfCredits.get(sessionNum).useCredit();
                    if (arrayOfCredits.get(sessionNum).getType().equals("better")){
                        System.out.println("You used a better credit, have some fun. You earned it!");
                    }
                    if (arrayOfCredits.get(sessionNum).getType().equals("mid")){
                        System.out.println("You used a mid credit, have some fun, but don't get carried away!");
                    }
                    if (arrayOfCredits.get(sessionNum).getType().equals("worse")){
                        System.out.println("You used a worse credit, have some fun, and make sure you have a good work session next time!");
                    }

                    System.out.println("You have " + creditsRemaining + " creditsRemaining");
                    System.out.println("");
                }


            } else if (action.equals("s")){ // action to look at specific work session
                System.out.println("Type in the session number you would to look at");
                int sessionNum = scan.nextInt() - 1;
                if (sessionNum >= arrayOfStats.size() || sessionNum < 0){
                    System.out.println("");
                    System.out.println("error");
                } else {
                    System.out.println("Here you go");
                    System.out.println("");
                    System.out.println("\t Session " + (sessionNum + 1) + ": \n" + arrayOfStats.get(sessionNum));
                    System.out.println("");
                    System.out.println("SCORE: " + arrayOfStats.get(sessionNum).workScore());
                    System.out.println("");
                    System.out.println("");
                    
                }
            } else if (action.equals("q")){
                break;
            } else {
                System.out.println("error");
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Would you like to do anymore actions? (use credits, look at specific entry) (y/n)");
            moreActions = scan.next();


        }


        System.out.println("");
        
        System.out.println("See you next time!");






  
        scan.close();
    }
}