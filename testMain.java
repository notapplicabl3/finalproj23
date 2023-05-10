import java.util.Scanner;

public class testMain
{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to the the Work Efficiency Tracker (Weff) ");
        System.out.println("There will be various questions asked to determine your work efficiency.");
        System.out.println("Our system will return a score corresponding to the levels of efficiency:");
        System.out.println("    0-200 - Very Poor");
        System.out.println("    200-400 - Poor");
        System.out.println("    400-600 - Ok");
        System.out.println("    600-800 - Great");
        System.out.println("    800-1000 - Excellent");
        
        int testinput = scan.nextInt();

        scan.close();

        stats testguy = new stats();
    }
}