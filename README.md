
# Tic-Tac-Toe

This is the low level design of Tic-Tac-Toe - game application.

N x N Tic-Tac-Toe is an extended version of the classic game where the grid size is N x N, and it can accommodate 2 to N players. The objective is to be the first to align a set number of symbols (usually N) in a row, column, or diagonal.


## Requirements

* Create board
  ``` 
  create_board {board-size} {player-count} {..player-names..}
  create_board 3 2 syed1 syed2
  ```
* List Players
  ``` 
  list_players
  ```
* Status of the board
  ``` 
  board_status
  ```
* play the move
  ``` 
  play_move {row} {column}
  play_move 1 1
  ```
* Stop the application
  ``` 
  exit
  ```

## Problem Statement
* Create a board
* Board size should be 3 <= board-size <= 11 and odd
* Players count should be 2 <= player-count <= board-size 
* Play the move row col
* Invalid move if row, col outisde the bound or piece already exist
* Playing move, listing players, checking board status without creating board throws Exception
* Can create new board during the game, it will abort previous game and start new one
* Can exit anytime
* Game finishes if -> Any player wins or no moves left
* Cannot play move once the game is finished.
* Can list players and check board status, even after the game is finished
* Throws Exception if command not found or incorrect parameter provided to a command.



## Patterns / Principles used

* Strategy Pattern
  * Input Mode (Command Line / File ...)
  * Output Mode (Command Line / File ...)
* Factory Pattern
  * For commands
* Command Pattern
  * For handling commands as input
* Single Responsibilty Principle
  * Board - for Win, place move, valid move, ....
  * Game for the flow of game
  * Command - each for different operation
  * Game does not have input Responsibilty
* Program to interfaces, not implementation
  * Mode
  * Writer
  * Command



## Run Locally

Clone the project

```bash
  git clone https://github.com/SyedMizbahuddin/lld-tic-tac-toe
```

Go to the project directory

```bash
  cd lld-tic-tac-toe
```

Install dependencies

```bash
  mvn clean install
```

Start the Application

```bash
  ......
```




## Example Command

```
create_board 3 2 syed1 syed2
list_players
board_status
play_move 1 1
play_move 0 1
play_move 0 0
play_move 0 2
play_move 2 2
exit 


```

## Example Execution
```
>create_board 3 2 syed1 syed2
CREATED
syed1 X
syed2 O

Starting the game

  |   |  
  |   |  
  |   |  
Turn of Player 1 : syed1

>list_players
syed1 X
syed2 O

>board_status

  |   |  
  |   |  
  |   |  
Turn of Player 1 : syed1

>play_move 1 1

  |   |  
  | X |  
  |   |  
Turn of Player 2 : syed2

>play_move 0 1

  | O |  
  | X |  
  |   |  
Turn of Player 1 : syed1

>play_move 0 0

X | O |  
  | X |  
  |   |  
Turn of Player 2 : syed2

>play_move 0 2

X | O | O
  | X |  
  |   |  
Turn of Player 1 : syed1

>play_move 2 2

X | O | O
  | X |  
  |   | X
Game won by Player 1 : syed1
>exit
Bye!!



```

