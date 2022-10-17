/* The game of craps is a gambling game that works as follows.  Make a bet (we have to make sure you don't bet an
 * illegal amount such as a negative number or more than you have).  Roll 2 6-sided dice.  If you roll a 7 or 11, you
 * win.  If you roll 2, 3 or 12 (called Craps), you lose.  Otherwise your roll is your mark.  Roll until either you roll
 * your mark (you win) or a 7 (you lose).  Output the results and let the user play again.  Write this game using methods. */

import java.util.*;			// Scanner and Random

public class Craps
{
    public static void main(String[] args)
    {
        System.out.println("Enter the Intial amount you like to start with:"); // user's initial amount to gamble
        Scanner in = new Scanner(System.in);
        int amount= in.nextInt();// needed to input user's next bet
        Random g = new Random();					// g is our Random number generator
        int bet;
        int die1, die2, roll, mark, win;			// win is used to store whether you won this particular round or lost
        bet = getBet(amount, in);					// input the bet and data verify its not < 0 or > amount
        while(bet>0) {								// play while they want to continue to bet
            die1 = rollDie(g);						// roll both die and store sum in roll
            die2 = rollDie(g);
            roll = die1 + die2;
            output(die1, die2, roll);				// output result of roll
            win = didYouWin(roll, 0, 1);			// didYouWin returns 1 if you won, -1 if you lost, 0 if neither
            while(win!=1&&win!=-1) 				// if you didn't win or lose, roll is your mark, continue
            {										//    until you win or lose (get mark or 7)
                mark = roll;						// remember your first roll
                die1 = rollDie(g);
                die2 = rollDie(g);
                roll = die1 + die2;
                output(die1, die2, roll);				// output result of roll
                win = didYouWin(roll, mark, 2);		// test for win (did you roll a mark or 7?)
            }
            amount = updateAmount(win, bet, amount);	// update amount based on your bet and whether you won or lost
            if(amount>0) bet = getBet(amount, in);		// if you still have money to gamble, get next bet
            else 										// but if amount is 0, you have to leave
            {
                System.out.println("You lost all your money, sorry but you can't play any more");
                bet = 0;
            }
        }
        outputResult(amount);						// output result
    }

    // get user's bet between 0 (quit) or 1..amount (legal bet) and data verify - don't let user enter a negative or a value > amount
    public static int getBet(int amount, Scanner in)
    {
        int bet;
        do{
            System.out.print("How much do you want to bet?  It can't be more than " + amount + " or less than 1.  Enter 0 to exit  ");
            bet = in.nextInt();
        }while(bet<0||bet>amount);
        return bet;
    }

    // output result of the current roll
    public static void output(int d1, int d2, int roll)
    {
        System.out.println("Your roll is " + d1 + " and " + d2 + " for a total of " + roll);
    }

    // generate a random 6-sided die roll using the Random number generator
    public static int rollDie(Random r)
    {
        return r.nextInt(6)+1;
    }

    // if first roll, did the user win (7/11) then return 1 or lose (2/3/12) then return -1 otherwise return 0 to indicate
    //   neither a winning or losing roll
    // if not first roll, did the user win (roll==mark) then return 1 or lose (roll==7) then -1 else 0 to continue
    public static int didYouWin(int roll, int mark, int turn)
    {
        if(turn==1)				// first turn, check, for 7/11 for a winning first roll
            if(roll==7||roll==11)
            {
                System.out.println("First roll winner!");
                return 1;
            }
            else if(roll==2||roll==3||roll==12)	// or craps for a losing first roll
            {
                System.out.println("Craps");
                return -1;
            }
            else return 0;			// otherwise if first roll then continue playing, roll becomes the mark
        else				// else not first roll
            if(roll==mark)			// was the new roll the mark? if so user wins
            {
                System.out.println("You hit your mark!");
                return 1;
            }
            else if(roll==7)		// else if new roll was 7, user loses
            {
                System.out.println("Bummer, a 7");
                return -1;
            }
            else return 0;			// otherwise new roll was neither mark nor 7, continue rolling
    }

    public static int updateAmount(int win, int bet, int amount)	// based on bet and win/loss, update amount
    {
        if(win==1)
        {
            amount+=bet;
            System.out.println("You won $" + bet + " and now have $" + amount);
        }
        else
        {
            amount-=bet;
            System.out.println("You lost $" + bet + " and now have $" + amount);
        }
        return amount;
    }

    public static void outputResult(int amount)		// output the results of the game
    {
        if(amount>200) System.out.println("You have $" + amount + " so you won $" + (amount - 200));
        else if(amount==200) System.out.println("You broke even, thanks for playing");
        else if(amount>0) System.out.println("You lost money, sorry, but you still walk away with $" + amount);
        else System.out.println("Wow, you lost it all, maybe you shouldn't gamble!");
    }
}