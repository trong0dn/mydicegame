# mydicegame
Version 1.0 <br>
April 5, 2021 <br>

## CONTACT INFORMATION

Contact Name:		Trong Nguyen <br>
Contact Email: 		trong0dn@gmail.com <br>


## DESCRIPTION

- A dice gambling game played against the computer. The game premise is to 
have a set of dice and take turns to roll for the highest sum, in order to win 
money via wagers. 

- The application is composed of the following programs:
  - mydicegame
    - Die.java
    - DiceGame.java

## INSTALLATION

This programs requires the latest version of JDK, such as OpenJDK 11 (Hotspot).

This program was designed on Notepad++ and has been tested on Windows OS
Command Prompt.

Die.java and DiceGame.java must be located in the same package called
'mydicegame'.


## USAGE

------------------------------- Program Compilation --------------------------

Open Command Prompt on Windows OS and navigate to the directory containing 
'mydicegame' package. Compile the .java files in the following order to generate
the .class files.

	>>> javac mydicegame/Die.java
	>>> javac mydicegame/DiceGame.java

--------------------------------- Program Running ----------------------------

To run the program via Command Prompt, using the following prompt entry:

	>>> java mydicegame/DiceGame <# of dice> <# of sides>

For instance, starting a game with 3 12-sided dice,

	>>> java mydicegame/DiceGame 12 3

However, if no entries for number of die and sides then the default is
2 6-sided dice with a balance of $100.

------------------------------- Game Sequence --------------------------------

Each round consists of the following sequence of events:
- The player enters a wager which the computer matches. If the computer does 
not have enough, it will go all-in.
- The player and computer roll the dice.
- The highest sum, as determined by the face-up values of each die collects 
the pot for the round.
- The game continues until you quit (by entering a special value for your bet, 
-1 for example), or until either you or the computer run out of money.

---------------------- Sample Game Shell Input & Ouputs ----------------------
<div>
Welcome to the Game of Dice! <br>
Starting a game with 3 12-sided dice. <br>
-------------------------------- <br>
You have $100. <br>
The computer has $100. <br>
Place your bet (-1 to quit playing) >>> 1 <br>
2 Dice :: You rolled > { 5 12 7 } <br>
2 Dice :: Comp rolled > { 10 1 10  } <br>
You win this round! <br>
-------------------------------- <br>
You have $101. <br>
The computer has $99. <br>
Place your bet (-1 to quit playing) >>> 102 <br>
You have to bet a positive value, but less than your remaining money! <br>
-------------------------------- <br>
You have $101. <br>
The computer has $99. <br>
Place your bet (-1 to quit playing) >>> 101 <br>
2 Dice :: You rolled > { 3 1 12 } <br>
2 Dice :: Comp rolled > { 9 11 3 } <br>
The computer wins this round! <br>
Oh no, you're out of credit! <br>
Good Bye! <br>
</div>

<END OF FILE>




