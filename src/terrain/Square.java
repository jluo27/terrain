package terrain;

public class Square {
	private int x; private int y;
	private Piece piece;
	
	public Square(int x, int y) {
		this.x=x; this.y=y;
	}
	
	////// FIGHT STUFF //////
	
	public boolean isAdjacentMedic(Square[][] board) {
		if (board[x+1][y].isOccupied() && board[x+1][y].piece.NAME.equals("MEDIC")) return true;
		if (board[x-1][y].isOccupied() && board[x-1][y].piece.NAME.equals("MEDIC")) return true;
		if (board[x][y+1].isOccupied() && board[x][y+1].piece.NAME.equals("MEDIC")) return true;
		if (board[x][y-1].isOccupied() && board[x][y-1].piece.NAME.equals("MEDIC")) return true;
		return false;
	}
	
	////// set, remove piece //////
	public void setPiece(Piece piece) {
		this.piece = piece; 
	}
	public Piece removePiece() {
		Piece piece = this.piece;
		this.piece = null;
		return piece;
	}
	
	////// gets //////
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public boolean isOccupied() {
		return (!(this.piece==null));
	}
	public Piece getPiece() {
		return this.piece;
	}
	
	//equals
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Square)) return false;
		Square s = (Square) o;
		return (this.x==s.x && this.y==s.y);
	}
	
	@Override
	public int hashCode() {
		return this.x*69 + this.y*42;
	}
}
