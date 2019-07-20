package terrain;
import java.util.List;

public class PieceGeneric extends Piece {
	
	protected PieceGeneric(int count, String name, String color, Square square) {
		super(count, name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Generic";
	}
	
	protected PieceGeneric(String name, String color, Square square) {
		super(name, color, square);
		this.rank = nameToRank(name);
		this.classification = "Generic";
	}
	
	// PROPERTIES
	
	@Override
	public int nameToRank(String name) {
		switch (name) {
		case "MARSHALL": 	return 10;
		case "GENERAL": 	return 9;
		case "COLONEL": 	return 8;
		case "MAJOR":		return 7;
		case "CAPTAIN":		return 6;
		case "LIEUTENANT":  return 5;
		case "SERGEANT":	return 4;
		case "PAWN":		return 3;
		//case "SCOUT":		return 2;
		case "SPY":			return 1;
		case "MEDIC":		return 1;
		default:			return 1;
		}
	}

	// MOVE
	
	@Override
	public List<Square> legalMoves(Square[][] board) {
		return this.oneAway(board, this.currentSquare.getX(), this.currentSquare.getY());
	}

	// FIGHT
	
	@Override
	public int fight(Piece p2) {
		String name1 = this.NAME; String name2 = p2.NAME;
		int rank1 = this.rank; int rank2 = p2.rank;
		//if (name1.equals("ENGINEER") && name2.equals("BOMB")) return true;
		if (name2.equals("WATER")) {
			this.die(); return -1;
		}
		if (name2.equals("LANDMINE")) {
			this.die(); return -1;
		}
		if (name1.equals("SPY") && name2.equals("MARSHALL")) {
			p2.die(); return 1;
		}
		
		if (rank1 >= rank2) p2.die();
		if (rank2 >= rank1) this.die();
		return (int) Math.signum(rank1-rank2);
	}

}
