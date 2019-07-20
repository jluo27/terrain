package terrain;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
	protected final int PIECE_COUNT;
	protected final String NAME;
	protected String classification;
	protected String color;
	protected int rank;
	protected int killcount;
	protected Square currentSquare;
	protected boolean dead = false;
	
	////// CONSTRUCTOR //////
	
	protected Piece(int count, String name, String color, Square square) {
		this.PIECE_COUNT = count; //this.KILLCOUNT = killcount;
		this.NAME = name; this.color = color; this.killcount = 0; this.currentSquare = square;
		//this.rank = nameToRank(name);
	}
	
	protected Piece(String name, String color, Square square) {
		this.PIECE_COUNT = 0; 
		this.NAME = name; this.color = color; this.killcount = 0; this.currentSquare = square;
	}
	
	protected Piece(String name, Square square) {
		this.PIECE_COUNT = 0; this.NAME = name; this.color = "clear"; this.killcount = 0;
		this.currentSquare = square;
	}
	
	public abstract int nameToRank(String name);
	
	/*public int nameToRank(String name) {
		switch (name) {
		case "MARSHALL": 	return 10s;
		case "GENERAL": 	return 9;
		case "COLONEL": 	return 8;
		case "MAJOR":		return 7;
		case "CAPTAIN":		return 6;
		case "LIEUTENANT":  return 5;
		case "JEEP":		return 5;
		case "SERGEANT":	return 4;
		case "PAWN":		return 3;
		case "ENGINEER":	return 3;
		case "THANOS":		return 3;
		case "SCOUT":		return 2;
		case "SPY":			return 1;
		case "MEDIC":		return 1;
		case "LANDMINE":	return 0;
		case "FLAG":		return 0;
		case "STONE":		return 0;
		case "WATER":		return -1;
		default:			return -2;
		}
	}*/
	
	////// MOVES //////
	
	// move
	
	public boolean move(Square dest) {
		if (dest.isOccupied()) {
			Piece old = dest.getPiece();
			if (old.color == this.color) return false;
			old.currentSquare = null; dest.removePiece(); this.killcount++; 
		}
		this.currentSquare.removePiece(); 
		dest.setPiece(this); this.currentSquare = dest;
		return true;
	}
	
	// moves allowed
	
	public abstract List<Square> legalMoves(Square[][] board);
	
	public List<Square> oneAway(Square[][] board, int x, int y) {
		List<Square> oneAways = new ArrayList<Square>();
		List<Square> candidates = new ArrayList<Square>();
		candidates.add(board[x+1][y]); candidates.add(board[x-1][y]); 
		candidates.add(board[x][y+1]); candidates.add(board[x][y-1]);
		for (Square square : candidates) {
			if (!square.isOccupied() || square.getPiece().rank >= 0) {
				oneAways.add(square);
			}
		}
		return oneAways;
	}
	
	public List<Square> sameLine(Square[][] board, int x, int y) {
		String origColor = board[x][y].getPiece().color;
		List<Square> sameColumns = new ArrayList<Square>();
		int counter = x+1;
		while (!board[counter][y].isOccupied()) {
			sameColumns.add(board[counter][y]); counter++;
		}
		if (board[counter][y].getPiece().rank >= 0 &&
				!board[counter][y].getPiece().color.equals(origColor)) {
			sameColumns.add(board[counter][y]);
		}
		counter = x-1;
		while (!board[counter][y].isOccupied()) {
			sameColumns.add(board[counter][y]); counter--;
		}
		if (board[counter][y].getPiece().rank >= 0 &&
				!board[counter][y].getPiece().color.equals(origColor)) {
			sameColumns.add(board[counter][y]);
		}
		counter = y+1;
		while (!board[x][counter].isOccupied()) {
			sameColumns.add(board[x][counter]); counter++;
		}
		if (board[x][counter].getPiece().rank >= 0 && 
				!board[x][counter].getPiece().color.equals(origColor)) {
			sameColumns.add(board[x][counter]);
		}
		counter = y-1;
		while (!board[x][counter].isOccupied()) {
			sameColumns.add(board[x][counter]); counter--;
		}
		if (board[x][counter].getPiece().rank >= 0 && 
				!board[x][counter].getPiece().color.equals(origColor)) {
			sameColumns.add(board[x][counter]);
		}
		return sameColumns;
	}
	
	////// FIGHT //////
	
	/*public boolean fight(Piece p1, Piece p2) {
		// p1 attacks p2. Return true if p1 wins.
		String name1 = p1.NAME; String name2 = p2.NAME;
		if (name1.equals("SPY") && name2.equals("MARSHALL")) return true;
		if (name1.equals("ENGINEER") && name2.equals("LANDMINE")) return true;
	}*/
	
	public abstract int fight(Piece p2);
	// p1 attacks p2. Return 1 if win, 0 if draw, -1 if loss.
	
	////// SETTER //////
	
	public void setSquare(Square square) {
		this.currentSquare = square;
	}
	
	public void die() {
		this.currentSquare = null;
		this.dead = true;
	}
	
	////// GETTER //////
	
	public int getRank() {
		return rank;
	}
	public int getKillCount() {
		return killcount;
	}
	public String getColor() {
		return color;
	}
	public boolean isDead() {
		return this.dead;
	}
	public Square getSquare() {
		return currentSquare;
	}
}
