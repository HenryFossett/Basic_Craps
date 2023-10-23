import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int point = 0;
        int die1 = 1;
        int die2 = 2;
        boolean done = false;
        boolean donePoint = false;
        boolean playAgain = false;

        // Trying to add balance and bets
//        double balance = 100.0;
//        double bet = 0;

        while (!done) {
//            System.out.println("Your balance is: " + balance);
//            bet = bet();
            int sum = roll(die1, die2);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
//                balance = balance - bet;
//                System.out.println("Your balance is: " + balance);
                playAgain = SafeInput.getYNConfirm(in, "Do you want to play again? [Y/N]");
                if (playAgain == false){
                    done = true;
                }
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You Win!");
//                balance = balance + bet;
//                System.out.println("Your balance is: " + balance);
                playAgain = SafeInput.getYNConfirm(in, "Do you want to play again? [Y/N]");
                if (playAgain == false){
                    done = true;
                }
            } else{
                System.out.println("The point is " + sum + ", roll a " + sum + " to win!");
                point = sum;
                do {
                    int score = roll(die1, die2);

                    if (score == 7) {
                        System.out.println("You Lose.");
//                        balance = balance -  bet;
//                        System.out.println("Your balance is: " + balance);
                        donePoint = true;
                    }
                    if (score == point) {
                        System.out.println("You Win!");
//                        balance = balance + bet;
//                        System.out.println("Your balance is: " + balance);
                        donePoint = true;
                    }
                }while (!donePoint);

                playAgain = SafeInput.getYNConfirm(in, "Do you want to play again? [Y/N]");
                if (playAgain == false){
                    done = true;
                }
            }
        }
//        System.out.println("Thanks for playing! Your final balance is: " + balance);
        System.out.println("Thanks for playing!");
    }
    public static int roll (int die1, int die2){
        Random rnd = new Random();
        int dice1 = rnd.nextInt(6)+1;
        int dice2 = rnd.nextInt(6)+1;
        int score = dice1 + dice2;
        System.out.println ("Dice 1 is " + dice1 + " and Dice 2 is " + dice2 + ", totaling: " + score);


        return score;
    }
    public static double bet (){
        Scanner in = new Scanner(System.in);
        double bet = SafeInput.getDouble(in, "How much would you like to bet?");
        return bet;
    }
}
