package Exercise;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    Scanner scanner = new Scanner(System.in);





    public void guess(){
        int guess = 0;
        int randomNumber = generateRandomNumber();
        int attempts = 5;


        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Can you guess what it is?");

        while (guess != randomNumber){
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > randomNumber){
                System.out.println("Too high try again");
            } else if (guess < randomNumber) {
                System.out.println("Too low try again");
            }
            else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }
        }

    }


    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
