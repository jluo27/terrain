package terrain;

public enum GameLevel {
	//LEVEL1 (1, names1, counts1);
	LEVEL1 (new String[] {"MARSHAL", "GENERAL", "COLONEL", "MAJOR", "CAPTAIN", "LIEUTENANT", "SERGEANT",
			"SPY", "ENGINEER", "SCOUT", "BOMB", "FLAG"}, 
			new int[] {1,1,2,3,4,4,4,1,5,8,6,1});
	
	private int level;
	private String[] names;
	private int[] counts;
	
	//private static String[] names1 = {"MARSHAL", "GENERAL", "COLONEL", "MAJOR", "CAPTAIN", "LIEUTENANT", "SERGEANT",
	//		"SPY", "ENGINEER", "SCOUT", "BOMB", "FLAG"};
	//private static int[] counts1 = {1,1,2,3,4,4,4,1,5,8,6,1};
	
	private GameLevel(String[] names, int[] counts) {
		//this.level = level; 
		this.level = ordinal()+1; this.names = names; this.counts = counts;
	}
	
	public String[] getNames() {
		return names;
	}
	public int[] getCounts() {
		return counts;
	}
	
	public static GameLevel getEnum(int level) {
		for (GameLevel gamelevel : GameLevel.values()) {
			if (gamelevel.level==level) return gamelevel;
		}
		return null;
	}

}
