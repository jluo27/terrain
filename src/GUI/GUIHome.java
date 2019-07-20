package GUI;

import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GUIHome {
	
	private static final int BUTTON_SIZE = 150;
	
	Stage stage;
	Scene scene;
	MenuBar menuBar;
	VBox menu;
	BorderPane borderpane;
	GUISetupPanel setupPanel;
	Button play;
	Button help;
	Button quit;
	GridPane screen;
	
	private String logoFileLoc = "C:\\Users\\luo\\Documents\\Justin's Stuff\\Duke\\2015-2016\\CS201\\Terrain\\";
	
	public GUIHome() throws FileNotFoundException {
		makeStage();
	}
	
	private Stage makeStage() throws FileNotFoundException {
		if (stage==null) {
			stage = new Stage();
			stage.setTitle("TERRAIN");
			
			//GridPane gridpane = new GridPane();
			borderpane = new BorderPane();
			borderpane.setTop(null);
			borderpane.setRight(null);
			borderpane.setLeft(makeVBox());
			borderpane.setCenter(makeHomeScreen());
			
			scene = new Scene(borderpane);
			
			stage.setScene(scene);
			stage.show();
		}
		System.out.println("hello");
		return stage;
	}
	
	/*public Scene makeScene() {
		if (stage.getScene()==null) {
			Scene scene = new Scene();
		}
		return stage.getScene();
	}*/
	
	// make the center pane; Default upon opening is just a nice home screen
	public GridPane makeHomeScreen() throws FileNotFoundException {
		screen = new GridPane();
		screen.setHgap(10); screen.setVgap(10);
		
		Text title = new Text("TERRAIN");
		title.setFont(Font.font("Arial",20));
		title.setTextAlignment(TextAlignment.CENTER);
		screen.add(title,1,1,2,1);
		
		String logoFile = "bluepurplepinkcrazyprint.png";
		ImageView logo = new ImageView(new Image(new FileInputStream(logoFileLoc + "graphics\\" + logoFile)));
		screen.add(logo,1,2,2,1);
		
		return screen;
	}
	
	public VBox makeVBox() {
		if (menu == null) {
			menu = new VBox();
			menu.setSpacing(8); // change
			
			//Button play = new Button("Play"); play.setMinWidth(150); 
			//Button help = new Button("Help"); help.setMinWidth(150);
			//Button quit = new Button("Quit"); quit.setMinWidth(150);
			
			menu.getChildren().add(makePlayButton());
			menu.getChildren().add(makeHelpButton());
			menu.getChildren().add(makeQuitButton());
		}
		return menu;
	}
	
	private Button makePlayButton() {
		// TODO finish centerpane; need to finish this after GUIBoard
		if (play==null) {
			play = new Button("Play");
			play.setMinWidth(BUTTON_SIZE);
			
			EventHandler<MouseEvent> openPlay = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					GUISetupPanel setupPanel = new GUISetupPanel(1);
					borderpane.setRight(setupPanel.getSetupTable(1));
					//borderpane.setRight(GUISetupPanel.getSetupPanel(1).setupTable);
					scene.setRoot(borderpane);
				}
			};
			play.addEventFilter(MouseEvent.MOUSE_CLICKED, openPlay);
		}
		return play;
	}
	
	private Button makeHelpButton() {
		if (help==null) {
			help = new Button("Help"); 
			help.setMinWidth(BUTTON_SIZE);
			
			EventHandler<MouseEvent> openHelp = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					GUIHelp.getHelpStage().helpStage.show();
				}
			};
			help.addEventFilter(MouseEvent.MOUSE_CLICKED, openHelp);
		}
		return help;
	}
	
	private Button makeQuitButton() {
		if (quit==null) {
			quit = new Button("Quit");
			quit.setMinWidth(BUTTON_SIZE);
			EventHandler<MouseEvent> openQuit = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent e) {
					stage.close();
				}
			};
			quit.addEventFilter(MouseEvent.MOUSE_CLICKED, openQuit);
		}
		return quit;
	}
	
	private MenuBar setMenuBar() {
		
		if (menuBar==null) {
			menuBar = new MenuBar();
			
			Menu play = new Menu("Play");
			MenuItem level1 = new MenuItem("1"); play.getItems().add(level1);
			MenuItem level2 = new MenuItem("2"); play.getItems().add(level2);
			MenuItem level3 = new MenuItem("3"); play.getItems().add(level3);
			
			Menu options = new Menu("Options");
			MenuItem help = new MenuItem("Help"); options.getItems().add(help);
			MenuItem quit = new MenuItem("Quit"); options.getItems().add(quit);
			
			menuBar.getMenus().add(play); menuBar.getMenus().add(options);
		}
		
		return menuBar;
	}
	
}
