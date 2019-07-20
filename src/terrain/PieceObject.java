package terrain;
import java.util.List;

public class PieceObject extends Piece {

	protected PieceObject(int count, String name, String color, Square square) {
		super(count, name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Object";
	}
	
	protected PieceObject(String name, String color, Square square) {
		super(name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Object";
	}
	
	protected PieceObject(String name, Square square) {
		super(name, square);
		this.rank = nameToRank(name); 
		this.classification = "Object";
	}

	@Override
	public int nameToRank(String name) {
		// TODO Auto-generated method stub
		switch (name) {
		case "LANDMINE":	return 0;
		case "FLAG":		return 0;
		case "STONE":		return 0;
		case "WATER":		return -1;
		}
		return 0;
	}

	@Override
	public List<Square> legalMoves(Square[][] board) {
		return null;
	}

	@Override
	public int fight(Piece p2) {
		return 0;
	}

}
