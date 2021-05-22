package mydicegame;

import java.util.Scanner;

/**
 * This class models a DiceGame.
 * @author  Trong Nguyen
 * @version 1.0
 */
public class DiceGame {
    private final Die die;
    private final int numberOfDices;

    /**
     * A constructor that takes the numberOfSides and numberOfDice arguments for DiceGame.
     * @param numberOfSides int : the number of sides for the Die
     * @param numberOfDices int : the number of dices for the DiceGame
     */
    public DiceGame(int numberOfSides, int numberOfDices) {
        die = new Die(numberOfSides);
        this.numberOfDices = numberOfDices;
    }

    /**
     * A specified default constructor for DieGame.
     */
    public DiceGame() {
        this(6,2);
    }

    /**
     * This method plays a game of dice against the computer. The game will have a set of dice that the user and
     * the computer roll in turn, in order to win money that the user bet before each round. The user and the computer
     * each have an initial amount of money with which to make wagers.
     */
    public void play() {
        System.out.println("Welcome to the Game of Dice!");
        System.out.printf("Starting a game with %d %d-sided dice.%n", this.numberOfDices, die.getSides());

        int userMoney = 100;
        int compMoney = 100;
        Scanner sc = new Scanner(System.in);

        while (userMoney > 0 && compMoney > 0) {
            int userRollSum = 0;
            int compRollSum = 0;

            System.out.println("--------------------------------");
            System.out.printf("You have $%d.%n", userMoney);
            System.out.printf("The computer has $%d.%n", compMoney);
            System.out.print("Place your bet (-1 to quit playing) >>> ");

            int userInput = sc.nextInt();
            if (userInput == -1) {
                break;
            }
            if (userInput > userMoney || userInput <= 0) {
                System.out.println("You have to bet a positive value, but less than your remaining money!");
            } else {
                System.out.printf("%d Dice :: You rolled > { ", numberOfDices);
                for (int i = 0; i < numberOfDices; i++) {
                    int userRoll = die.roll();
                    System.out.print(userRoll + " ");
                    userRollSum += userRoll;
                }
                System.out.println("}");

                System.out.printf("%d Dice :: Comp rolled > { ", numberOfDices);
                for (int i = 0; i < numberOfDices; i++) {
                    int compRoll = die.roll();
                    System.out.print(compRoll + " ");
                    compRollSum += compRoll;
                }
                System.out.println("}");

                if (userRollSum > compRollSum) {
                    if (userInput > compMoney) {
                        // If the computer does not have enough, it will go all-in.
                        userMoney += compMoney;
                        compMoney = 0;
                    } else {
                        userMoney += userInput;
                        compMoney -= userInput;
                    }
                    System.out.println("You win this round!");
                } else if (userRollSum < compRollSum) {
                    userMoney -= userInput;
                    compMoney += userInput;
                    System.out.println("The computer wins this round!");
                } else {
                    System.out.println("It's a tie!");
                }

                if (userMoney == 0) {
                    System.out.println("Oh no, you're out of credit!");
                } else if (compMoney == 0) {
                    System.out.println("Oh no, the computer is out of credit!");
                }
            }
        }
        System.out.println("Good Bye!");
    }

    /**
     * Runs the DiceGame program.
     * @param args  String[] : the arguments taken by the program
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            DiceGame dc = new DiceGame();
            dc.play();
        }
        if (args.length == 2) {
            try {
                if (Integer.parseInt(args[0]) > 2 && Integer.parseInt(args[1]) > 0) {
                    DiceGame dc = new DiceGame(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                    dc.play();
                } else {
                    System.out.println("<sides per die> must be greater than 2 and <number of dice> must be greater than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Argument must be an integer.");
                System.out.println("Must be of the form: >>> java DiceGame <sides per die> <number of dice>");
            }
        }
        if (args.length > 2) {
            System.out.println("Must be of the form: >>> java DiceGame <sides per die> <number of dice>");
        }
    }
}

