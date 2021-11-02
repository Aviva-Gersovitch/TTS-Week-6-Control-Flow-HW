import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        printNumbers();     //calls function that prints out valid ASCII values for numbers 0-9
        printUpperCase();   //calls function that prints out valid ASCII values for upper case letters A-Z
        printLowerCase();   //calls function that prints out valid ASCII values for lower case letters a-z

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:  ");
        //To add: .matches("^[a-zA-Z]*$") once I understand more about RegEx
        String userEnteredName = scanner.nextLine();

        System.out.println("Hello " + userEnteredName);

        System.out.println("Do you wish to continue to the interactive portion? Enter yes or y if so.");

        boolean toContinue = true;   //initializes a boolean to true to enter the switch statement

        String promptYOrN = scanner.nextLine();
        while (toContinue) {
            switch (promptYOrN) {
            case "yes":              //if user enters yes or y, begins prompting them with the following questions
            case "y":
                System.out.println("What is the name of your favorite pet?");
                String petName = scanner.nextLine();

                System.out.println("What is the age of your favorite pet?");
                int petAge = scanner.nextInt();
                
                System.out.println("What is your lucky number?");
                int luckyNum = scanner.nextInt();

                System.out.println(
                        "What is your favorite quarterback's jersey number? If this means nothing to you, just pick a number.");
                int jerseyNum = scanner.nextInt();

                System.out.println("What is two-digit model year of your car?");
                int modelYear = scanner.nextInt();
                
                System.out.println("What is the first name of your favorite actor or actress? ");
                scanner.nextLine(); //resets scanner after nextInt
                String actorName = scanner.nextLine();

                System.out.println("Enter a random number between 1 and 50.");
                int randomNum = scanner.nextInt();

                Random random = new Random();

                int rand1 = random.nextInt(30);  //picks a random number from 1-29

                int rand2 = random.nextInt(30);

                int rand3 = random.nextInt(30);

                int magicBall = jerseyNum * rand1;
                while (magicBall > 75) {         //ensures that magicBall cannot be >75
                    if (magicBall > 75) {
                        magicBall -= 75;
                    }
                }

                int lotNum1 = (int) petName.charAt(2);   //casts the third character of the pet's name to an int
                //throws error if the petName is <3 characters, add fix later on
                
                while (lotNum1 > 65 || lotNum1 < 1) {    //ensures that lottery numbers are less than 65 and not a negative number
                    if (lotNum1 > 65) {
                        lotNum1 -= 65;
                    }
                    else if (lotNum1 < 1){
                        lotNum1 += 10;
                    }
                }
                int lotNum2 = modelYear + luckyNum;
                while (lotNum2 > 65 || lotNum2 < 1) {
                    if (lotNum2 > 65) {
                        lotNum2 -= 65;
                    }
                    else if (lotNum2 < 1){
                        lotNum2 += 10;
                    }
                }
                int lotNum3 = randomNum - rand2;
                while (lotNum3 > 65 || lotNum3 < 1) {
                    if (lotNum3 > 65) {
                        lotNum3 -= 65;
                    }
                    else if (lotNum3 < 1){
                        lotNum3 += 10;
                    }
                }
                int lotNum4 = 42;
                int lotNum5 = petAge + modelYear;
                while (lotNum5 > 65 || lotNum5 < 1) {
                    if (lotNum5 > 65) {
                        lotNum5 -= 65;
                    }
                    else if (lotNum5 < 1){
                        lotNum5 += 10;
                    }
                }

                //Bonus removing duplicates (not finished)
                // if (lotNum1 == lotNum2 || lotNum1 == lotNum3 || lotNum1 == lotNum4 || lotNum1 == lotNum5 || lotNum2 == lotNum3 || lotNum2 == lotNum4 || lotNum2 == lotNum5 || lotNum3 == lotNum4 || lotNum3 == lotNum5 || lotNum4 == lotNum5){
                //     lotNum1 += 1;
                //     if (lotNum1 > 65){
                //         lotNum1 -=2;
                //     }
                //     lotNum2 -=2
                //     if (lotNum2 < 1){
                //         lotNum2 +=4;
                //     }
                // }

                System.out.println("Lottery numbers: " + lotNum1 + ", " + lotNum2 + ", " + lotNum3 + ", " + lotNum4
                        + ", " + lotNum5 + " Magic ball: " + magicBall);

                System.out.println(
                        "Would you like to generate another set of numbers? Please enter yes(or y) or no(or n).");
                scanner.nextLine();  //resets scanner

                String choice = scanner.nextLine();
                if (choice.equals("n") || choice.equals("no")) {     //checks user input to match either n or no, sets the boolean in the beginning while loop equal to false and breaks out of the if statement, then the while loop
                    toContinue = false;
                    System.out.println("Thank you for playing.");
                    break;
                } else if (choice.equals("yes") || choice.equals("y")) {   //checks user input to match either yes or y, prints restarting and begins the question prompts again since toContinue is still true
                    System.out.println("Restarting.");
                } else {
                    System.out.println("Please enter yes(or y) or no(or n).");  //if some other input is entered, tells user what they should enter and breaks out of if/else, returning to if
                    scanner.nextLine();
                    break;
                }
                break;

            default:
                System.out.println("Program quitting. Please return later to complete the survey.");   //if user enters something other than yes or y at the beginning, sets toContinue boolean to false to negate the while loop, and breaks out of it
                toContinue = false;
                break;
            }
        }

        scanner.close();  //prevents resource leak
    }

    public static void printNumbers() {
        System.out.println("The valid ASCII characters for all numbers are: ");
        for (int i = 48; i <= 57; i++) {
            System.out.println(i);
        }
    }

    public static void printLowerCase() {
        System.out.println("The valid ASCII characters for all lower case letters are: ");
        for (int i = 97; i <= 122; i++) {
            System.out.println(i);
        }

    }

    public static void printUpperCase() {
        System.out.println("The valid ASCII characters for all lower case letters are: ");
        for (int i = 65; i <= 90; i++) {
            System.out.println(i);
        }
    }
}
