


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button btn1, btn2, btn3, btn4, btn5;
	Label label1;
	TextField tf;
	HBox hb1, hb2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dm = new DataManager();
	Insets inset = new Insets(5);
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		btn1 = new Button("Hello");
		btn2 = new Button("Howdy");
		btn3 = new Button("Chinese");
		btn4 = new Button("Clear");
		btn5 = new Button("Exit");
		label1 = new Label("Feedback:");
		tf = new TextField();
		hb1 = new HBox();
		hb2 = new HBox();
		
		// Add Events
		btn1.setOnAction(new handler());
		btn2.setOnAction(new handler());
		btn3.setOnAction(new handler());
		btn4.setOnAction(new handler());
		btn5.setOnAction(new handler());
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		//student Task #3:
		hb1.getChildren().addAll(label1, tf);
		hb2.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb1.setMargin(tf, inset);
		hb2.setMargin(btn1, inset);
		hb2.setMargin(btn2, inset);
		hb2.setMargin(btn3, inset);
		hb2.setMargin(btn4, inset);
		hb2.setMargin(btn5, inset);
		
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hb1, hb2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class handler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// Variables
			EventTarget t = event.getTarget();
			
			// Checks
			if (t == btn1) {
				tf.setText(dm.getHello());
			} else if (t == btn2) {
				tf.setText(dm.getHowdy());
			} else if (t == btn3) {
				tf.setText(dm.getChinese());
			} else if (t == btn4) {
				tf.setText("");
			} else if (t == btn5) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
