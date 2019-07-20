package terrain;
import java.util.ArrayList;
import java.util.Collections;

public class GameLevel1 extends Game {
	private Board board;
	private String color2; // NEED TO SET BASED ON WHAT THE PLAYER SELECTS
	private static final String[] names = {"MARSHAL", "GENERAL", "COLONEL", "MAJOR", "CAPTAIN", "LIEUTENANT", "SERGEANT",
			"SPY", "ENGINEER", "SCOUT", "BOMB", "FLAG"};
	private static int[] counts = {1,1,2,3,4,4,4,1, 5,8,6,1};

	@Override
	public void setUpBoard() {
		// TODO Auto-generated method stub
		board = new Board(12,12);
		for (int i=0; i<12; i++) {
			board.setWater(i, 0); board.setWater(i, 11); 
			board.setWater(0, i); board.setWater(11, i);
		}
		board.setWater(5, 3); board.setWater(5, 4); board.setWater(5, 7); board.setWater(5, 8);
		board.setWater(6, 3); board.setWater(6, 4); board.setWater(6, 7); board.setWater(6, 8);
	}
	
	// Regular Stratego setup, randomized
	public void randomSetup() {
		//String[] names = {"MARSHAL", "GENERAL", "COLONEL", "MAJOR", "CAPTAIN", "LIEUTENANT", "SERGEANT",
				//"SPY", "ENGINEER", "SCOUT", "BOMB", "FLAG"};
		//int[] counts = {1,1,2,3,4,4,4,1, 5,8,6,1};
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i=0; i<40; i++) nums.add(i); 
		Collections.shuffle(nums);
		
		int k=0;
		for (int i=0; i<8; i++) {
			for (int j=0; j<counts[i]; j++) {
				int num = nums.get(k); int xcoord = 1 + num/10; int ycoord = 1 + (num%10);
				board.setGeneric(names[i], color2, xcoord, ycoord);
				k++;
			}	
		}
		for (int j=0; j<5; j++) {
			int num = nums.get(k); int xcoord = 1 + num/10; int ycoord = 1 + (num%10); k++;
			board.setEngineer("ENGINEER", color2, xcoord, ycoord); 
		}
		for (int j=0; j<8; j++) {
			int num = nums.get(k); int xcoord = 1 + num/10; int ycoord = 1 + (num%10); k++;
			board.setMobile("SCOUT", color2, xcoord, ycoord); 
		}
		for (int i=10; i<=11; i++) {
			for (int j=0; j<counts[i]; j++) {
				int num = nums.get(k); int xcoord = 1 + num/10; int ycoord = 1 + (num%10); k++;
				board.setObject(names[i], color2, xcoord, ycoord);
			}
		}
		
	}
	
	public String[] getNames() {
		return names;
	}
	public int[] getCounts() {
		return counts;
	}
}
