// Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 11/30/2019
 */
public class MovieTicketManagerFXController extends Application {
	// Class Variables
	public final double window_width = 550;
	public final double window_height = 535;
	public final String window_title = "Movie Manager";

	public static void main(String[] args){
		   launch(args);
	}

	public void start(Stage stage) throws Exception {
		MovieTicketManagerFX mainPane = new MovieTicketManagerFX();
		BorderPane root = mainPane.getMainPane();
		Scene scene = new Scene(root, window_width, window_height);
		stage.setScene(scene);
		stage.setTitle(window_title);
		stage.setMaxWidth(window_width);
		stage.setMinHeight(window_height);
		stage.setMinWidth(window_width);
		stage.show();
	}
}
