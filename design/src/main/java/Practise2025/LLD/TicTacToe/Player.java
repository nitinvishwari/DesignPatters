package Practise2025.LLD.TicTacToe;

public class Player {
	Piece piece;
	String playerName;

	public String getPlayerName() {
		return playerName;
	}	

	public Piece getPiece() {
		return piece;
	}
	
	public Player(Piece piece, String name) {
		this.piece = piece;
		this.playerName = name;
	}
}
