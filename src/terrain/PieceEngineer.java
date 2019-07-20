package terrain;
import java.util.List;

public class PieceEngineer extends Piece {
	
	private int thanosCollect = 0;

	protected PieceEngineer(int count, String name, String color, Square square) {
		super(count, name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Engineer";
	}
	
	protected PieceEngineer(String name, String color, Square square) {
		super(name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Engineer";
	}
	
	//// PROPERTIES
	
	@Override
	public int nameToRank(String name) {
		switch (name) {
		case "ENGINEER": 	return 3;
		case "HYDROLOGIST": return 1;
		case "THANOS":		return 3;
		default:			return 3;
		}
	}
	// Note: may be useful if engineers with different ranks are added

	//// MOVE 
	
	@Override
	public List<Square> legalMoves(Square[][] board) {
		return this.oneAway(board, this.currentSquare.getX(), this.currentSquare.getY());
	}

	@Override
	public int fight(Piece p2) {
		String name1 = this.NAME; String name2 = p2.NAME;
		int rank1 = this.rank; int rank2 = p2.rank;
		if (name2.equals("WATER")) {
			if (name1.equals("HYDROLOGIST")) {
				p2.die(); return 1;
			}
			this.die(); return -1;
		}
		if (p2.classification.equals("Object")) {
			//p2.die(); 
			if (name1.equals("THANOS")) thanosCollect++;
			//return 1;
		}
		if (rank1 >= rank2) p2.die();
		if (rank2 >= rank1) this.die();
		return (int) Math.signum(rank1-rank2);
	}
	
	//// GETTER
	
	public int getThanosCollect() {
		return this.thanosCollect;
	}

}
