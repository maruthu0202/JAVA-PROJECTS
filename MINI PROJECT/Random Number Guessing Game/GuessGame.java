import java.util.*;
public class GuessGame {
    public static void main(String[] args){
    Scanner sc =new Scanner(System.in);
    System.out.println(".----------------------Game Info-----------------------------------");
    System.out.println("1 - Guess Any Number You Want In Between 1 - 100");
    System.out.println("2 - You have 3 chances to Guess ");
    System.out.println("3 - to win this Game You have to Guess Correct number In 3 Choices ");
     System.out.println(".------------------------------------------------------------------");
     Random rand=new Random();
     int Rand=rand.nextInt(100)+1;
    int attempts=0;
    while(attempts<3)
    {
        System.out.println("Enter your guess");
        int g=sc.nextInt();
        attempts++;
       
        if (g==Rand) {
            System.out.println("Coungradulation You Won !");
            System.out.println("You Succesfullly Find A Random Number in "+attempts+"Trials !");
            break;
        } 
        else if (g>Rand) {
            System.out.println("Too High number !");
        }
         else if (g<Rand) {
            System.out.println("Too Low number !");
        }
         if(attempts==3){
             System.out.println("Choices Over  !");
            System.out.println("You Loss !");
            System.out.println("Don't Loss  Your Faith Try Again !");

        }
       
    }
     

    }

}
