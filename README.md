# Craps Game - Java Gambling Game

This project is a gambling game developed using Java, based on the classic game of Craps. The game lets players place bets, roll two 6-sided dice, and win or lose based on specific outcomes. This game is designed to run in a console and offers a simple yet engaging betting experience for users.

## Game Rules

1. **Initial Bet**: Players start by entering an initial amount of money and place a bet before each round.
2. **First Roll**: The player rolls two dice. 
   - Rolling a **7** or **11** on the first roll results in an **instant win**.
   - Rolling a **2**, **3**, or **12** results in **Craps**, and the player **loses**.
   - Any other result becomes the **mark**.
3. **Subsequent Rolls**: The player continues to roll until:
   - The **mark** is rolled again (win), or
   - A **7** is rolled (lose).
4. The player can choose to continue betting as long as they have money.

## Key Features

- **Betting System**: Players place bets, which must be a positive amount and cannot exceed the money they have available.
- **Dice Roll Simulation**: Uses random numbers to simulate the rolling of two 6-sided dice.
- **Win/Loss Logic**: Players can win by rolling specific numbers, or they lose if they roll a 7 during the round. The game keeps track of their remaining balance.
- **Replayable**: The game allows users to continue playing rounds until they run out of money or decide to quit.
- **User Feedback**: Informative messages guide the player through each step of the game, whether they win or lose.

## Prerequisites

To run this game, you need:
- Java Development Kit (JDK) 8 or higher
- An IDE or text editor capable of running Java (e.g., Eclipse, IntelliJ IDEA, or NetBeans)

## Gameplay video
https://github.com/user-attachments/assets/90993d0a-24c1-4284-96d6-11582cf217af



