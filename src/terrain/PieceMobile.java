package terrain;
import java.util.List;

public class PieceMobile extends Piece {

	protected PieceMobile(int count, String name, String color, Square square) {
		super(count, name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Mobile";
	}
	
	protected PieceMobile(String name, String color, Square square) {
		super(name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Mobile";
	}
	
	@Override
	public int nameToRank(String name) {
		switch (name) {
		case "SCOUT": 		return 2;
		case "JEEP":		return 5;
		case "NINJA":		return 11;
		default:			return 2;
		}
	}
	
	@Override
	public List<Square> legalMoves(Square[][] board) {
		return this.sameLine(board, this.currentSquare.getX(), this.currentSquare.getY());
	}

	@Override
	public int fight(Piece p2) {
		// TODO Auto-generated method stub
		String name1 = this.NAME; String name2 = p2.NAME;
		int rank1 = this.rank; int rank2 = p2.rank;
		
		if (name2.equals("WATER")) {
			this.die(); return -1;
		}
		
		if (rank1 >= rank2) p2.die();
		if (rank2 >= rank1) this.die();
		if (name1.equals("NINJA")) this.die(); // maybe create a leave method later?
		return (int) Math.signum(rank1-rank2);
	}

}
