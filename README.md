# Chess-LPOO
Chess Game Final Project LPOO

TABLE OF CONTENTS:

## Description

## Controls

## Core Features

## GUI Mockups/Elements

## Class Diagram

## Package Diagram

## Unit Testing

## Design Patterns






### Description
Multiplayer Chess Game



### Controls
#### On Phone:

#### On Desktop:




### Core Features
##### Networking:
-Save/Load any board state and play it from then;
-Visualize early board states in mid-game(revert move and see board before last move); Undo and Redo(Command DP)????
Possible:Connect to a database to display the chess opening name at everymove

#### Social:
-Export game in analisys format(compatible with chess engines)

#### Mobile:
-Two different views possible in game(normal view shows only board and options, side view shows extra panel showing previous moves ex:1.Ke4 2. Bc6




### GUI Mockups/Elements
#### Screen Diagram
![alt text](http://imageshack.com/a/img924/3448/ilQZxr.png)


#### Screen Mockup
Horizontal
![alt text](http://imageshack.com/a/img923/3229/oCZRhA.jpg)

Vertical
![alt text](http://imageshack.com/a/img922/5282/QSnfHi.jpg)






### Behaviour State Diagram
![alt text](http://imageshack.com/a/img923/2043/Za8JVd.png)





### Class Diagram
![alt text](http://imageshack.com/a/img923/3119/hEBVlC.png)




### Package Diagram
![alt text](http://imageshack.com/a/img922/1767/2LGjGW.png)





### Unit Testing
Test for the board(visual and game elements of board)
BoardPanelSquareTest
ChessGameBoardTest

Test for the playing of the game itsef
ChessGameEngineTest
CHessGameLogTest
ChessMainTest

Tests for pieces possible moves, for a list of possible game boards
BishopTest
KingTest
KnightTest
PawnTest
QueenTest
RookTest




### Design Patterns
Command (Undo/Redo) tbd
