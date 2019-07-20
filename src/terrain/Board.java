package terrain;
public class Board {
	protected final int NUM_ROWS;
	protected final int NUM_COLS;
	protected Square[][] board;
	
	protected Board(int rows, int cols) {
		this.NUM_ROWS = rows; 
		this.NUM_COLS = cols;
		board = new Square[NUM_ROWS][NUM_COLS];
	}
	
	//setter
	public void setPiece(int a, int b, Piece p) {
		board[a][b].setPiece(p);
	}
	
	public void setEngineer(String name, String color, int a, int b) {
		PieceEngineer egr = new PieceEngineer(name, color, board[a][b]);
		board[a][b].setPiece(egr);
	}
	
	public void setGeneric(String name, String color, int a, int b) {
		PieceGeneric generic = new PieceGeneric(name, color, board[a][b]);
		board[a][b].setPiece(generic);
	}
	
	public void setMobile(String name, String color, int a, int b) {
		PieceMobile mobile = new PieceMobile(name, color, board[a][b]);
		board[a][b].setPiece(mobile);
	}
	
	public void setObject(String name, String color, int a, int b) {
		PieceObject object = new PieceObject(name, color, board[a][b]);
		board[a][b].setPiece(object);
	}
	
	public void setWater(int a, int b) {
		PieceObject water = new PieceObject("WATER", board[a][b]);
		board[a][b].setPiece(water);
	}
	
	//getter
	public Piece getPiece(int a, int b) {
		return board[a][b].getPiece();
	}

	// Note: when declaring the board, we surround it with waters.
}
