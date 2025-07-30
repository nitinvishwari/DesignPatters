package Practise2025.LLD.SnakeAndLadder;

import java.util.HashSet;
import java.util.List;

public class Main {

}

/*
The game should be played on a board with numbered cells, typically with 100 cells.
The board should have a predefined set of snakes and ladders, connecting certain cells.
The game should support multiple players, each represented by a unique game piece.
Players should take turns rolling a dice to determine the number of cells to move forward.
If a player lands on a cell with the head of a snake, they should slide down to the cell with the tail of the snake.
If a player lands on a cell with the base of a ladder, they should climb up to the cell at the top of the ladder.
The game should continue until one of the players reaches the final cell on the board.
The game should handle multiple game sessions concurrently, allowing different groups of players to play independently.

Objects::
Game - D
Board - D
Player - D
Piece - D
Dice
Snake - D
Ladder - D

-----------
interface DiceStrategy
getNumber(min, max)

1) RandomNumber
2) BisedTowardMax

------------
Dice:
min
max
DiceStrategy ds

Dice(ds)

getNumber() -> ds

-----------
Game::
Board board
List<Player> players
Dice

intializeTheGame()
play() -> Queue

------------
Snake:
snakeId
start
end

constructor
--------------
Ladder:
ladderId
start
end

constructor
-------------
Board:
numberOfCells
HashSet<Snake> snakes
HashSet<Ladders> ladders

Board(numberOfCells)
addSnake()
addLadder()
removeSnake()
removeLadder()
---------------
Piece:
pieceId
pieceName
color

getter and Setter
--------------
Player:
playerName
currCell
piece

Player(piece, name)
changeCell()
------------------

 */

enum Color{
	Blue,
	Yellow,
	Red,
	Green
}

class Cell{
	int cellNumber;
//	HashSet<Player> listOfPlayers;
	
	public Cell(int cellNumber) {
		this.cellNumber = cellNumber;
//		listOfPlayers = new HashSet<>();
	}
	
	public int getCellNumber() {
		return this.cellNumber;
	}
//	
//	public void addPlayer(Player player) {
//		listOfPlayers.add(player);
//	}
//	
//	public void removePlayer(Player player) {
//		listOfPlayers.remove(player);
//	}
}

class Piece{
	int pieceId;
	String pieceName;
	Color color;
	
	public Piece(int pieceId, String pieceName, Color color) {
		this.pieceId = pieceId;
		this.pieceName = pieceName;
		this.color = color;
	}
}


class Player{
	private Piece piece;
	private String playerName;
	private Cell currCell;
	
	public Player(Piece piece, String playerName){
		this.piece = piece;
		this.playerName = playerName;
	}
	
	public void changeCell(Cell newCell) {
		this.currCell = newCell;
	}
}


































