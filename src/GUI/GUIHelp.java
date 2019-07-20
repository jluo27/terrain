package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIHelp {
	
	private static GUIHelp help;
	
	Stage helpStage;
	
	public GUIHelp() {
		makeHelpStage();
	}
	
	public static GUIHelp getHelpStage() {
		if (help==null) {
			help = new GUIHelp();
		}
		return help;
	}
	
	public Stage makeHelpStage() {
		if (helpStage==null) {
			helpStage = new Stage();
			helpStage.setTitle("Help");
			
			Text helpTitle = new Text("HELP");
			Text helpText = new Text();
			helpText.setText("\n ** INSERT TERRAIN HELP HERE **");
			
			BorderPane helpPane = new BorderPane();
			helpPane.setTop(helpTitle);
			helpPane.setCenter(helpText);
			
			//Group root = new Group(helpText);
			Scene helpScene = new Scene(helpPane);
			helpStage.setScene(helpScene);
		}
		return helpStage;
	}
}
