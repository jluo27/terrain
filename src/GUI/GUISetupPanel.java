package GUI;

import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import terrain.GameLevel;

public class GUISetupPanel {

	private static GridPane setupTable;

	private static HashMap<String,Integer> pieceIndex = new HashMap<String,Integer>();
	private static HashMap<String,Button> pieceButton = new HashMap<String,Button>();
	private static HashMap<String,Label> pieceCounts = new HashMap<String,Label>();
	private static String[] names;
	private static int[] counts;
	private static int piecesLeft;

	public GUISetupPanel(int level) {
		makeSetupPanel(level);
	}

	public static GridPane makeSetupPanel(int level) {
		if (setupTable==null) {
			setupTable = new GridPane();
			setupTable.setHgap(15);
			
			Text buttonTitle = new Text("Button");
			buttonTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			setupTable.add(buttonTitle, 0, 0);
			
			Text pieceTitle = new Text("Piece");
			pieceTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			setupTable.add(pieceTitle, 1, 0);
			
			Text valueTitle = new Text("Value");
			valueTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			setupTable.add(valueTitle, 2, 0);
			
			Text countTitle = new Text("Count");
			countTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			setupTable.add(countTitle, 3, 0);
			
			GameLevel gamelevel = GameLevel.getEnum(level);
			names = gamelevel.getNames();
			counts = gamelevel.getCounts();
			
			for (int i=0; i<names.length; i++) {
				pieceIndex.put(names[i], i);
				piecesLeft += counts[i];
				
				Button button = new Button("Place");
				pieceButton.put(names[i], button);
				setupTable.add(button, 0, i+1);
				
				Text pieceText = new Text(names[i]);
				setupTable.add(pieceText, 1, i+1);
				
				Label count = new Label(Integer.toString(counts[i]));
				pieceCounts.put(names[i], count);
				setupTable.add(count, 3, i+1);
			}

		}
		return setupTable;
	}
	
	public boolean decreaseCount(String name) {
		counts[pieceIndex.get(name)]--;
		pieceCounts.get(name).setText(Integer.toString(counts[pieceIndex.get(name)]));
		piecesLeft--;
		return (piecesLeft==0); // ready signal?
	}
	
	public GridPane getSetupTable(int level) {
		return setupTable;
	}
	
	/*public static GUISetupPanel getSetupPanel(int level) {
		GUISetupPanel setupPanel = new GUISetupPanel(level);
	}*/
}
