# Tic-Tac-Toe with AI

- [Tic-Tac-Toe with AI](#tic-tac-toe-with-ai)
  - [Stage 5/5: An undefeated champion](#stage-55-an-undefeated-champion)
    - [Description](#description)
    - [Example](#example)
  - [Stage 4/5: Signs of Intelligence](#stage-45-signs-of-intelligence)
    - [Description](#description-1)
    - [Example](#example-1)
  - [Stage 3/5: Watch 'em fight](#stage-35-watch-em-fight)
    - [Description](#description-2)
    - [Example](#example-2)
  - [Stage 2/5: Easy does it](#stage-25-easy-does-it)
    - [Description](#description-3)
    - [Example](#example-3)
  - [Stage 1/5: Initial Setup](#stage-15-initial-setup)
    - [Description](#description-4)
    - [Examples](#examples)
    - [Example 1:](#example-1)

## Stage 5/5: An undefeated champion

### Description
Let's write the "hard" level difficulty.

Compared to the "medium" level difficulty, this level not just go one move ahead to see an immediate win or prevent an immediate loss. This level can see two moves ahead, three moves ahead and so on. Basically, it can see all possible outcomes till the end of the game and choose the best of them considering his opponent also would play perfectly. So, it doesn't rely on the blunders of the opponent, it plays perfectly regardless of the opponent's skill.

The algorithm that implements this is called Minimax. This is the brute force algorithm that maximizes the value of the own position and minimizes the value of the opponent's position. It's not only an algorithm for Tic-Tac-Toe, but for every game with two players with alternate move order, for example, chess. You need to implement it as the "hard" difficulty level. This [link](https://medium.freecodecamp.org/how-to-make-your-tic-tac-toe-game-unbeatable-by-using-the-minimax-algorithm-9d690bad4b37) will help to understand details.

You also should add "hard" parameter to be able to play against this level.

### Example
The example below shows how your program should work.
```text
Input command: start hard user
Making move level "hard"
---------
|       |
| X     |
|       |
---------
Enter the coordinates: 2 2
---------
|       |
| X O   |
|       |
---------
Making move level "hard"
---------
|   X   |
| X O   |
|       |
---------
Enter the coordinates: 2 1
---------
|   X   |
| X O   |
|   O   |
---------
Making move level "hard"
---------
| X X   |
| X O   |
|   O   |
---------
Enter the coordinates: 1 1
---------
| X X   |
| X O   |
| O O   |
---------
Making move level "hard"
---------
| X X X |
| X O   |
| O O   |
---------
X wins

Input command: exit
```

## Stage 4/5: Signs of Intelligence

### Description

Let's write a "medium" level difficulty. Compared to randomly picking a cell to take a move, this level is considerably smarter.

The "medium" level difficulty makes a move using the following process:

1. If it can win in one move (if it has two in a row), it places a third to get three in a row and win.
2. If the opponent can win in one move, it plays the third itself to block the opponent to win.
3. Otherwise, it makes a random move.

Despite the randomness of the third rule, this level is a lot harder to beat. This level stops all simple attempts to beat it due to the second rule, and always wins when it can due to the first rule.

You also should add "medium" parameter to be able to play against this level. And, of course, it should be possible to make "easy" vs "medium" matchup!

### Example

The example below shows how your program should work.

```text
Input command: start user medium
---------
|       |
|       |
|       |
---------
Enter the coordinates: 2 2
---------
|       |
|   X   |
|       |
---------
Making move level "medium"
---------
|       |
|   X   |
| O     |
---------
Enter the coordinates: 1 3
---------
| X     |
|   X   |
| O     |
---------
Making move level "medium"
---------
| X     |
|   X   |
| O   O |
---------
Enter the coordinates: 2 1
---------
| X     |
|   X   |
| O X O |
---------
Making move level "medium"
---------
| X O   |
|   X   |
| O X O |
---------
Enter the coordinates: 1 2
---------
| X O   |
| X X   |
| O X O |
---------
Making move level "medium"
---------
| X O   |
| X X O |
| O X O |
---------
Enter the coordinates: 3 3
---------
| X O X |
| X X O |
| O X O |
---------
Draw

Input command: start medium user
---------
|       |
|       |
|       |
---------
Making move level "medium"
---------
|       |
|       |
|   X   |
---------
Enter the coordinates: 2 2
---------
|       |
|   O   |
|   X   |
---------
Making move level "medium"
---------
|       |
|   O   |
| X X   |
---------
Enter the coordinates: 3 1
---------
|       |
|   O   |
| X X O |
---------
Making move level "medium"
---------
| X     |
|   O   |
| X X O |
---------
Enter the coordinates: 1 2
---------
| X     |
| O O   |
| X X O |
---------
Making move level "medium"
---------
| X     |
| O O X |
| X X O |
---------
Enter the coordinates: 3 3
---------
| X   O |
| O O X |
| X X O |
---------
Making move level "medium"
---------
| X X O |
| O O X |
| X X O |
---------
Draw

Input command: exit
```

## Stage 3/5: Watch 'em fight

### Description

It is time to make some variations of the game possible. What if you want to play with a friend and not with AI? What if you get tired of playing the game and want to see a match between two AI? Finally, you need to be able to play either the first move or the second move playing against AI.

Write a menu loop, which can interpret two commands: "start" and "exit".

The command "start" should take two parameters: who will play ‘X’ and who will play ‘O.’ Two parameters are possible for now: "user" to play as a human and "easy" to play as an easy level AI. In the next steps, you will add "medium" and "hard" parameters.

The command "exit" should simply terminate the program.

Do not forget to handle incorrect input!

### Example

The example below shows how your program should work.

```text
Input command: start
Bad parameters!
Input command: start easy
Bad parameters!
Input command: start easy easy
---------
|       |
|       |
|       |
---------
Making move level "easy"
---------
|       |
|     X |
|       |
---------
Making move level "easy"
---------
|       |
| O   X |
|       |
---------
Making move level "easy"
---------
|       |
| O   X |
|     X |
---------
Making move level "easy"
---------
|       |
| O   X |
|   O X |
---------
Making move level "easy"
---------
|       |
| O X X |
|   O X |
---------
Making move level "easy"
---------
|     O |
| O X X |
|   O X |
---------
Making move level "easy"
---------
| X   O |
| O X X |
|   O X |
---------
X wins

Input command: start easy user
---------
|       |
|       |
|       |
---------
Making move level "easy"
---------
|       |
|       |
|     X |
---------
Enter the coordinates: 2 2
---------
|       |
|   O   |
|     X |
---------
Making move level "easy"
---------
|   X   |
|   O   |
|     X |
---------
Enter the coordinates: 1 1
---------
|   X   |
|   O   |
| O   X |
---------
Making move level "easy"
---------
|   X X |
|   O   |
| O   X |
---------
Enter the coordinates: 3 2
---------
|   X X |
|   O O |
| O   X |
---------
Making move level "easy"
---------
| X X X |
|   O O |
| O   X |
---------
X wins

Input command: start user user
---------
|       |
|       |
|       |
---------
Enter the coordinates: 1 1
---------
|       |
|       |
| X     |
---------
Enter the coordinates: 2 2
---------
|       |
|   O   |
| X     |
---------
Enter the coordinates: 1 2
---------
|       |
| X O   |
| X     |
---------
Enter the coordinates: 2 1
---------
|       |
| X O   |
| X O   |
---------
Enter the coordinates: 1 3
---------
| X     |
| X O   |
| X O   |
---------
X wins

Input command: exit
```

## Stage 2/5: Easy does it

### Description
Now it is time to make a working game. In this version of the program, the user will be playing as X, and the "easy" level computer will be playing as O.

Let's make it so that at this level the computer will make random moves. This level will be perfect for those who play this game for the first time! Well, though... You can create a level of difficulty that will always give in and never win the game. You can implement such a level along with "easy" level, if you want, but it will not be tested.

When starting the program, an empty field should be displayed and the first to start the game should be the user as X. Next the computer should make its move as O. And so on until someone will win or there will be a draw.

At the very end of the game you need to print the final result of the game.

### Example

The example below shows how your program should work.

```text
---------
|       |
|       |
|       |
---------
Enter the coordinates: 2 2
---------
|       |
|   X   |
|       |
---------
Making move level "easy"
---------
| O     |
|   X   |
|       |
---------
Enter the coordinates: 3 1
---------
| O     |
|   X   |
|     X |
---------
Making move level "easy"
---------
| O     |
| O X   |
|     X |
---------
Enter the coordinates: 1 1
---------
| O     |
| O X   |
| X   X |
---------
Making move level "easy"
---------
| O     |
| O X O |
| X   X |
---------
Enter the coordinates: 2 1
---------
| O     |
| O X O |
| X X X |
---------
X wins
```

## Stage 1/5: Initial Setup

### Description
In this project, you'll write a game called Tic-Tac-Toe that you can play with your computer. The computer will have three levels of difficulty - easy, medium, hard.

But, for starters, let's write a program that knows how to work with coordinates and determine the state of the game.

Suppose the bottom left cell has the coordinates (1, 1) and the top right cell has the coordinates (3, 3) like in this table:

(1, 3) (2, 3) (3, 3)
(1, 2) (2, 2) (3, 2)
(1, 1) (2, 1) (3, 1)

The program should work in the following way:

1. Get the 3x3 field from the first input line (it contains 9 symbols containing X, O and _, the latter means it's an empty cell),
2. Output this 3x3 field with cells before the user's move,
3. Then ask the user about his next move,
4. Then the user should input 2 numbers that represent the cell on which user wants to make his X or O. (9 symbols representing the field would be on the first line and these 2 numbers would be on the second line of the user input). Since the game always starts with X, if the number of X's and O's on the field is the same, the user should make a move with X, and if X's is one more than O's, then the user should make a move with O.
5. Then output the table including the user's most recent move.
6. Then output the state of the game.

Possible states:

- `"Game not finished"` - when no side has a three in a row but the field has empty cells;
- `"Draw"` - when no side has a three in a row and the field has no empty cells;
- `"X wins"` - when the field has three X in a row;
- `"O wins"` - when the field has three O in a row;

If the user input wrong coordinates, the program should keep asking until the user enters coordinate that represents an empty cell on the field and after that output the field with that move. You should output the field only 2 times - before the move and after a legal move.

### Examples

The examples below show how your program should work.

### Example 1:

```text
Enter cells: _XXOO_OX_
---------
|   X X |
| O O   |
| O X   |
---------
Enter the coordinates: 1 1
This cell is occupied! Choose another one!
Enter the coordinates: one
You should enter numbers!
Enter the coordinates: one three
You should enter numbers!
Enter the coordinates: 4 1
Coordinates should be from 1 to 3!
Enter the coordinates: 1 3
---------
| X X X |
| O O   |
| O X   |
---------
X wins
```

Example 2:

```text
Enter cells: XX_XOXOO_
---------
| X X   |
| X O X |
| O O   |
---------
Enter the coordinates: 3 1
---------
| X X   |
| X O X |
| O O O |
---------
O wins
```

Example 3:

```text
Enter cells: OX_XOOOXX
---------
| O X   |
| X O O |
| O X X |
---------
Enter the coordinates: 3 3
---------
| O X X |
| X O O |
| O X X |
---------
Draw
```

Example 4:

```text
Enter cells: _XO_OX___
---------
|   X O |
|   O X |
|       |
---------
Enter the coordinates: 1 1
---------
|   X O |
|   O X |
| X     |
---------
Game not finished
```