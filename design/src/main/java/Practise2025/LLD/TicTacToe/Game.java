package Practise2025.LLD.TicTacToe;

public class Game {
	public static void main(String[] args) {
		Board board = new Board(3);
		Piece cross = new Piece(PieceType.Cross);
		
		Player p1 = new Player(cross, "Nitin");
		Player p2 = new Player(cross, "Chinni");
	}
}




/*

PieceType
enum{
	RoundPiece,
	CrossPiece
}
----------
Game
variable:

Method:
InitializeGame()
PlayGame()
-------------------
Player

Variable:
PlayerName
Piece

Method
GetterSetter
-------------------
Piece

Variable:
PieceType

Method
GetterSetter

--------------------
Board

Variable:
size
int[][] board

Method
Board(size) -> constructor
setPiece(int row, int col, PieceType p)
PieceType getPiece(int row, int col)
*/
