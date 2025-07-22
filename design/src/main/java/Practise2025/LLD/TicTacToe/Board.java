package Practise2025.LLD.TicTacToe;

public class Board {
	PieceType[][] board;
	int size;
	
	public Board(int size) {
		this.size = size;
		board = new PieceType[3][3];
	}
	
	public boolean setPiece(int row, int col, PieceType pieceType) {
		if(board[row][col] != null) {
			return false;
		}
		board[row][col] = pieceType;
		return true;
	}
	
	public PieceType getPieceType(int row, int col) {
		return board[row][col];
	}
}
