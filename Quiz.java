import java.util.Random;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int level1_points = 0; // We initialize seperate points for level 1
        int level2_points = 0; // same as level1 but for level2

        // Welcoming the player
        System.out.println("Hello! And welcome to the Math Quiz Game! Answering 10 questions will advance you to level 2");
        System.out.println("Please enter your name");
        String name = input.next();
        System.out.println("Welcome to the game " + name + " !");
        System.out.println("Starting level one!");

        int level = 1; // We set the level to start with level1 itself

        while (level == 1) { // While the game is in level 1
            while (level1_points < 10) { // when the score is less than 10, itll do this...

                // Generating 1 digit random numbers for multiplication questions in level 1

                int num1_level1 = random.nextInt(9) + 1;
                int num2_level1 = random.nextInt(9) + 1;

                // Displaying the multiplication questions for first level

                System.out.print(num1_level1 + " times " + num2_level1 + ": ");
                int user_input = input.nextInt();

                // Checking if the user's answer is correct and updating points
                // We create a variable for boolean that checks the answer.
                boolean correct_input = false; //making it false from start
                
                while (!correct_input) {
                    
                    if (user_input == num1_level1 * num2_level1) {
                        level1_points++;
                        System.out.println("Correct answer! Moving to the next question");
                        correct_input = true;
                    } else {
                        System.out.println("Wrong answer! Please try again");
                        user_input = input.nextInt();
                    }
                }
            }

            if (level1_points == 10) { // If the player answered 10 level 1 questions correctly
                System.out.println("Congrats! You have advanced to the next level.");
                level = 2; // Move to level 2
            }
        }

        
        while (level == 2) { // While the game is in level 2
            System.out.println("Starting level two!");
            System.out.println("In this level, your answer is the number before the decimal point");

            while (level2_points < 20) { // While the player hasn't answered 20 level 2 questions

                int num1_level2 = random.nextInt(90) + 10; // Random number for 2 digits
                int num2_level2 = random.nextInt(90) + 10;
                int num3_level2 = random.nextInt(90) + 10;
        
                // Forming the pattern of multiple question types. We added 3 for now.
                // Having an array will decrease the lines of code by 80. (by experience)
                String[] level2_Questions = {
                    "(" + num1_level2 + " + " + num2_level2 + ") * " + num3_level2 + ": ",
                    "(" + num1_level2 + " / " + num2_level2 + ") + " + num3_level2 + ": ",
                    num1_level2 + " / " + num2_level2 + " + " + num3_level2 + ": "};

                int type = random.nextInt(3); // Generating a random question type

                // telling person that for fractions, only number before decimal point is to be entered

                System.out.print(level2_Questions[type]); //using random number (1-3) to execute
                                                          //the line from array
                int user_input = input.nextInt();

                // Checking if the user's answer for each question type is correct
                // then recording new points for them

                boolean correct_input2 = false;
                while (!correct_input2) {

                    if (type == 0 && user_input == (num1_level2 + num2_level2) * num3_level2) {
                        System.out.println("Correct answer! Moving to the next question");
                        level2_points++;
                        correct_input2 = true;
                    } else if (type == 1 && user_input == (num1_level2 / num2_level2) + num3_level2) {
                        System.out.println("Correct answer! Moving to the next question");
                        level2_points++;
                        correct_input2 = true;
                    } else if (type == 2 && user_input == (num1_level2 / num2_level2) + num3_level2) {
                        System.out.println("Correct answer! Moving to the next question");
                        level2_points++;
                        correct_input2 = true;
                    } else {
                        System.out.println("Wrong answer! Please try again");
                        user_input = input.nextInt();
                    }
                }
                
                // If 20 questions answered, end the game.

                if (level2_points == 20) {
                    System.out.println("Congratulations! You won! Your score is 20 Points!");
                    break;
                }
            }
        }
    }
}
