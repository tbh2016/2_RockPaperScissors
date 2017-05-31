/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Random;        //class instance for generating random numbers
import java.util.Scanner;       //class instance for scanning numbers from user input

/**
 *
 * @author Thuan Huynh
 */
public class RPS {        //name of the file class and can be called from anywhere

    public static void main(String[] args) {//public mean it can be accessed from anywhere, static means no need to create an object when invoking the main method, 
        //void will not return any value, main is the name of the class, String[]args is a command line arguments  

        int rounds = 0;         //input rounds from user

        int ties = 0;           //count of ties
        int userWins = 0;       //count of user wins
        int compWins = 0;       //count of computer wins

        int yourHand = 0;       //your hand of rocks, paper, scissors
        int compHand = 0;       //computer's hand of rocks, paper, scissors

        int playAgain = 1;      //this is for playing again

        Random rn = new Random();   //rn is a name for the random number generator class, new Random() will give new random each time it runs

        Scanner sc = new Scanner(System.in);    //sc is a name calling upon the scanner class, new Scanner(System.in) will give new scanner each input

        while (playAgain == 1) {     //playAgain is for playing again and it must == 1 and will be wait to be invoked at the end
            System.out.println("How many rounds do you want to play? : ");  //prints out text asking for rounds to play
            rounds = sc.nextInt();  //rounds will equal the placeholder for the next integer

            if (rounds < 1 || rounds > 10) {    //if statement is used to limit between 1 and 10
                System.out.println("Error: Number must be between 1 and 10");   //prints out text that gives and error message
            } else {
                while (rounds >= 1) {   //while rounds is greater than or equal to 1 it will keep looping, rounds will decrement

                    System.out.println("Would you like \n1.rock \n2.paper \n3.scissors"); //print text ask for user pick 1, 2, or 3
                    yourHand = sc.nextInt();    //yourHand equals scanner and it will call upon next integer class
                    if (yourHand < 1 || yourHand > 3) { //if loop to make sure yourHand is between integer 1 and 3
                        System.out.println("Error not within choice range"); //prints out Error message if not within range
                    } else {                                            //if the first statement in the loop doesn't work next statement will execute
                        compHand = rn.nextInt(3) + 1;       //compHand is equal to the random number generator for numbers between 1 to 3 

                        System.out.println("Computer chose: " + compHand);      //prints text and then prints the value of comHand

                        if (yourHand == compHand) {                     //yourHand compared with compHand and it has a 33% chance of getting a tie so I put it as the first decision maker when comparing hands
                            System.out.println("You're tied.");         //text for tie
                            ties++;                                     //ties tracker   
                        } else if (yourHand == 1) {                     //if yourHand is equal to 1(rock)  
                            if (compHand == 2) {                        //and compHand is equal to 2(paper) you lost
                                System.out.println("You lost");         //text for lost
                                compWins++;                             //compWin tracker
                            } else {                                    
                                System.out.println("You won");          //if compHand doesn't equal 2(paper) you win, ***if statement makes sense since all the comparisions for ties would have been calculated already hence it being the first decision maker for the program
                                userWins++;                             //tracker for your wins
                            }
                        } else if (yourHand == 2) {                    //if your hand is 2(paper) and compHand is 1(rock) you won and userWins will keep track of that win
                            if (compHand == 1) {
                                System.out.println("You win.");
                                userWins++;
                            } else {                                    //else you lost, its the only other win/lose factor if yourHand of 2(paper) vs compHand of 3(scissors)
                                System.out.println("You lost.");
                                compWins++;
                            }
                        } else if (yourHand == 3) {                     //if yourHand is equal to 3(scissors) and compHand is equal to 1(rock) you lost
                            if (compHand == 1) {
                                System.out.println("You lost.");
                                compHand++;
                            } else {                                    //else you win, your 3(scissors) beat compHand's 2(paper)
                                System.out.println("You win.");
                                userWins++;
                            }
                        }
                        rounds--;               //each round will decrement
                    }

                }

            }
            System.out.println("ties:" + ties + " yourWins:" + userWins + " compWins:" + compWins);     //SHOWS THE AMOUNT OF TIES, YOUR WINS, COMPUTER WINS
            if (0 == 0) {                                   //if error message shows it won't show it's a tie
                System.out.println(" ");                    //new line
            } else if (userWins == compWins) {              //if combined user wins equals combined computer wins will show text that it's a tie 
                System.out.println("It's a tie!!");
            } else if (userWins > compWins) {               //text for combined user wins beating combined computer wins
                System.out.println("You won!!!");
            } else {
                System.out.println("Computer won....");     //if neither of the above computer wins text output
            }
            userWins = 0;           //resetting trackers for wins
            compWins = 0;
            ties = 0;

            System.out.println("Do you want to play again? Press '1' for yes and '2' for no");      //output text if they wanna play again
            playAgain = sc.nextInt();       //playAgain variable will equal scanner tools integer saver 

        }

    }
}

// declare variables, including objects random and scanner
// while rounds is between 1 and 10
// ask person for rounds and save it in scanner
// within the while loop have an if statement for rounds less than 1 and greater than 10, give error message if out of range
// 
