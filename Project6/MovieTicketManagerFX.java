// Imports
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/*
 * @author https://github.com/amattu2
 * @version 0.01
 * @date 11/30/2019
 */
@SuppressWarnings("restriction")
public class MovieTicketManagerFX {
	// Class Variables
	private MovieTicketManager Manager = new MovieTicketManager();
	private BorderPane mainPane;
	private VBox middleBox, ticketTypeVBox, movieRatingVBox, movieTypeVBox, detailVBox, totalsBox, totalsParentVBox;
	private HBox headerBox, ticketTypeBox, movieRatingBox, movieTypeBox, detailBox1, detailBox2, detailBox3, detailBox4, purchaseButtonsBox, totalBox, totalsBox1, totalsBox2, bottomBox;
	private ToggleGroup ticketTypeGroup, movieRatingGroup, movieTypeGroup;
	private Button purchaseButton, clearButton, readButton, srButton, allTicketsButton, tdTicketsButton, mpTicketsButton, exitButton;
	private Text headerLabel, ticketTypeLabel, ratingLabel, typeLabel, detailLabel, detailLabel1, detailLabel2, detailLabel3, detailLabel4, totalsLabel1, totalsLabel2, totalsLabel3, totalsLabel4, totalsParentLabel;
	private RadioButton adultRB, childRB, employeeRB, moviepassRB, gRatingRB, pgRatingRB, pg13RatingRB, rRatingRB, nrRatingRB, imaxRB, tdRB, naRB;
	private TextField movieNameInput, movieDayInput, movieTimeInput, movieIDInput;
	private int buttonMargin = 5;

	// Constructor
	public MovieTicketManagerFX() {
		// Variables
		mainPane = new BorderPane();
		headerBox = new HBox();
		middleBox = new VBox();
		bottomBox = new HBox();
		ticketTypeVBox = new VBox();
		ticketTypeBox = new HBox();
		movieTypeVBox = new VBox();
		movieTypeBox = new HBox();
		detailVBox = new VBox();
		movieRatingVBox = new VBox();
		movieRatingBox = new HBox();
		detailBox1 = new HBox();
		detailBox2 = new HBox();
		detailBox3 = new HBox();
		detailBox4 = new HBox();
		totalsParentVBox = new VBox();
		totalBox = new HBox();
		totalsBox = new VBox();
		totalsBox1 = new HBox();
		totalsBox2 = new HBox();
		purchaseButtonsBox = new HBox();
		ticketTypeGroup = new ToggleGroup();
		movieRatingGroup = new ToggleGroup();
		movieTypeGroup = new ToggleGroup();
		headerLabel = new Text("Movie Ticket Manager");
		ticketTypeLabel = new Text("1. Select the ticket type");
		ratingLabel = new Text("2. Select the movie rating");
		typeLabel = new Text("3. Select the movie type");
		detailLabel = new Text("4. Enter the ticket details");
		detailLabel1 = new Text("Movie Name:");
		detailLabel2 = new Text("Month Day: ");
		detailLabel3 = new Text("Movie Time:");
		detailLabel4 = new Text("ID Number: ");
		totalsParentLabel = new Text("5. Complete ticket purchase");
		totalsLabel1 = new Text("Ticket Cost: $");
		totalsLabel2 = new Text("0.00");
		totalsLabel3 = new Text("Total Sales: $");
		totalsLabel4 = new Text("0.00");
		adultRB = new RadioButton("Adult");
		childRB = new RadioButton("Child");
		employeeRB = new RadioButton("Employee");
		moviepassRB = new RadioButton("MoviePass");
		gRatingRB = new RadioButton("G");
		pgRatingRB = new RadioButton("PG");
		pg13RatingRB = new RadioButton("PG-13");
		rRatingRB = new RadioButton("R");
		nrRatingRB = new RadioButton("NR");
		imaxRB = new RadioButton("IMAX");
		movieNameInput = new TextField();
		movieDayInput = new TextField();
		movieTimeInput = new TextField();
		movieIDInput = new TextField();
		tdRB = new RadioButton("3D");
		naRB = new RadioButton("None");
		purchaseButton = new Button("Purchase");
		clearButton = new Button("Clear");
		readButton = new Button("Read File");
		srButton = new Button("View Reports");
		allTicketsButton = new Button("View Tickets");
		tdTicketsButton = new Button("View 3D Tickets");
		mpTicketsButton = new Button("View MoviePasses");
		exitButton = new Button("Exit");

		// Attributes
		headerBox.setAlignment(Pos.CENTER);
		bottomBox.setAlignment(Pos.CENTER);
		detailBox1.setAlignment(Pos.CENTER_LEFT);
		detailBox2.setAlignment(Pos.CENTER_LEFT);
		detailBox3.setAlignment(Pos.CENTER_LEFT);
		detailBox4.setAlignment(Pos.CENTER_LEFT);
		adultRB.setToggleGroup(ticketTypeGroup);
		childRB.setToggleGroup(ticketTypeGroup);
		employeeRB.setToggleGroup(ticketTypeGroup);
		moviepassRB.setToggleGroup(ticketTypeGroup);
		gRatingRB.setToggleGroup(movieRatingGroup);
		pgRatingRB.setToggleGroup(movieRatingGroup);
		pg13RatingRB.setToggleGroup(movieRatingGroup);
		rRatingRB.setToggleGroup(movieRatingGroup);
		nrRatingRB.setToggleGroup(movieRatingGroup);
		imaxRB.setToggleGroup(movieTypeGroup);
		tdRB.setToggleGroup(movieTypeGroup);
		naRB.setToggleGroup(movieTypeGroup);
		adultRB.setUserData("adult");
		childRB.setUserData("child");
		employeeRB.setUserData("employee");
		moviepassRB.setUserData("moviepass");
		gRatingRB.setUserData("g");
		pgRatingRB.setUserData("pg");
		pg13RatingRB.setUserData("pg13");
		rRatingRB.setUserData("r");
		nrRatingRB.setUserData("nr");
		imaxRB.setUserData("imax");
		tdRB.setUserData("3d");
		naRB.setUserData("none");
		HBox.setMargin(headerLabel, getMarginInsets(7));
		VBox.setMargin(ticketTypeLabel, getMarginInsets(10));
		VBox.setMargin(ratingLabel, getMarginInsets(10));
		VBox.setMargin(typeLabel, getMarginInsets(10));
		VBox.setMargin(detailLabel, getMarginInsets(10));
		VBox.setMargin(totalsParentLabel, getMarginInsets(10));
		HBox.setMargin(adultRB, getMarginInsets(buttonMargin));
		HBox.setMargin(childRB, getMarginInsets(buttonMargin));
		HBox.setMargin(employeeRB, getMarginInsets(buttonMargin));
		HBox.setMargin(moviepassRB, getMarginInsets(buttonMargin));
		HBox.setMargin(gRatingRB, getMarginInsets(buttonMargin));
		HBox.setMargin(pgRatingRB, getMarginInsets(buttonMargin));
		HBox.setMargin(pg13RatingRB, getMarginInsets(buttonMargin));
		HBox.setMargin(rRatingRB, getMarginInsets(buttonMargin));
		HBox.setMargin(nrRatingRB, getMarginInsets(buttonMargin));
		HBox.setMargin(imaxRB, getMarginInsets(buttonMargin));
		HBox.setMargin(tdRB, getMarginInsets(buttonMargin));
		HBox.setMargin(naRB, getMarginInsets(buttonMargin));
		HBox.setMargin(movieNameInput, getMarginInsets(buttonMargin));
		HBox.setMargin(movieDayInput, getMarginInsets(buttonMargin));
		HBox.setMargin(movieTimeInput, getMarginInsets(buttonMargin));
		HBox.setMargin(movieIDInput, getMarginInsets(buttonMargin));
		VBox.setMargin(detailBox1, getMarginInsets(3, 10));
		VBox.setMargin(detailBox2, getMarginInsets(3, 10));
		VBox.setMargin(detailBox3, getMarginInsets(3, 10));
		VBox.setMargin(detailBox4, getMarginInsets(3, 10));
		HBox.setMargin(purchaseButton, getMarginInsets(3, 10));
		HBox.setMargin(clearButton, getMarginInsets(3, 10));
		HBox.setMargin(totalsBox, getMarginInsets(3, 10));
		HBox.setMargin(readButton, getMarginInsets(buttonMargin));
		HBox.setMargin(srButton, getMarginInsets(buttonMargin));
		HBox.setMargin(allTicketsButton, getMarginInsets(buttonMargin));
		HBox.setMargin(tdTicketsButton, getMarginInsets(buttonMargin));
		HBox.setMargin(mpTicketsButton, getMarginInsets(buttonMargin));
		HBox.setMargin(exitButton, getMarginInsets(buttonMargin));
		headerLabel.setStyle("-fx-font: 24 arial; -fx-fill: white;");
		headerBox.setStyle("-fx-background-color: #4285f4; -fx-fill: white;");
		middleBox.setStyle("-fx-border-style: solid inside; -fx-border-width: 1; -fx-border-color: black; -fx-border-insets: 1;");
		bottomBox.setStyle("-fx-background-color: #f2f2f2;");

		// UI
		ticketTypeBox.getChildren().addAll(adultRB, childRB, employeeRB, moviepassRB);
		ticketTypeVBox.getChildren().addAll(ticketTypeLabel, ticketTypeBox);
		movieRatingBox.getChildren().addAll(gRatingRB, pgRatingRB, pg13RatingRB, rRatingRB, nrRatingRB);
		movieRatingVBox.getChildren().addAll(ratingLabel, movieRatingBox);
		movieTypeBox.getChildren().addAll(imaxRB, tdRB, naRB);
		movieTypeVBox.getChildren().addAll(typeLabel, movieTypeBox);
		detailBox1.getChildren().addAll(detailLabel1, movieNameInput);
		detailBox2.getChildren().addAll(detailLabel2, movieDayInput);
		detailBox3.getChildren().addAll(detailLabel3, movieTimeInput);
		detailBox4.getChildren().addAll(detailLabel4, movieIDInput);
		detailVBox.getChildren().addAll(detailLabel, detailBox1, detailBox2, detailBox3, detailBox4);
		purchaseButtonsBox.getChildren().addAll(purchaseButton, clearButton);
		totalsBox1.getChildren().addAll(totalsLabel1, totalsLabel2);
		totalsBox2.getChildren().addAll(totalsLabel3, totalsLabel4);
		totalsBox.getChildren().addAll(totalsBox1, totalsBox2);
		totalBox.getChildren().addAll(purchaseButtonsBox, totalsBox);
		totalsParentVBox.getChildren().addAll(totalsParentLabel, totalBox);
		headerBox.getChildren().addAll(headerLabel);
		middleBox.getChildren().addAll(ticketTypeVBox, movieRatingVBox, movieTypeVBox, detailVBox, totalsParentVBox);
		bottomBox.getChildren().addAll(readButton, srButton, allTicketsButton, tdTicketsButton, mpTicketsButton, exitButton);
		mainPane.setTop(headerBox);
		mainPane.setCenter(middleBox);
		mainPane.setBottom(bottomBox);

		// Events
		srButton.setOnAction(event -> this.printSalesReport());
		allTicketsButton.setOnAction(event -> this.printAllTickets());
		tdTicketsButton.setOnAction(event -> this.print3DTickets());
		mpTicketsButton.setOnAction(event -> this.printMoviePassTickets());
		exitButton.setOnAction(event -> System.exit(0));
		readButton.setOnAction(event -> {
			try {
				readFile();
			} catch (FileNotFoundException e) {
				this.showMessage("Oops", "No file was found");
			}
		});
		purchaseButton.setOnAction(event -> this.handlePurchase());
		clearButton.setOnAction(event -> {
			movieNameInput.setText("");
			movieDayInput.setText("");
			movieTimeInput.setText("");
			movieIDInput.setText("");
		});
		ticketTypeGroup.selectedToggleProperty().addListener((ov, ot, nt) -> {
			// Variables
			Object value = ticketTypeGroup.getSelectedToggle().getUserData();

			// Checks
			if (value.toString().equals("child")) {
				// Checks
				if (rRatingRB.isSelected() || nrRatingRB.isSelected() || pg13RatingRB.isSelected()) {
					this.showMessage("Oops", "A child cannot purchase this ticket");
				}

				// UI
				rRatingRB.setDisable(true);
				nrRatingRB.setDisable(true);
				pg13RatingRB.setDisable(true);
				rRatingRB.setSelected(false);
				nrRatingRB.setSelected(false);
				pg13RatingRB.setSelected(false);
			} else {
				rRatingRB.setDisable(false);
				nrRatingRB.setDisable(false);
				pg13RatingRB.setDisable(false);
			}
			if (value.toString().equals("employee") || value.toString().equals("moviepass")) {
				movieIDInput.setDisable(false);
			} else {
				movieIDInput.setDisable(true);
				movieIDInput.setText("");
			}
		});
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Return reference to main pane
	 * @version 0.01
	 * @date 11/30/2019
	 */
	public BorderPane getMainPane() {
		return mainPane;
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Print sales period report
	 * @version 0.01
	 * @date 11/30/2019
	 */
	private void printSalesReport() throws NullPointerException {
		// Attributes
		JOptionPane.showMessageDialog(null, "Sales Report:\n" + Manager.monthlySalesReport());
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Print sales period report
	 * @version 0.01
	 * @date 11/30/2019
	 */
	private void printAllTickets() throws NullPointerException {
		// Variables
		JPanel panel = new JPanel();
		JList list = new JList(Manager.getAllTickets().toArray());
		JScrollPane pane = new JScrollPane();

		// Attributes
		panel.add(pane);
		pane.getViewport().add(list);
		JOptionPane.showMessageDialog(null, pane, "All Tickets Report", JOptionPane.PLAIN_MESSAGE);
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Print 3d sales period report
	 * @version 0.01
	 * @date 11/30/2019
	 */
	private void print3DTickets() throws NullPointerException {
		// Variables
		JPanel panel = new JPanel();
		JList list = new JList(Manager.get3DTickets().toArray());
		JScrollPane pane = new JScrollPane();

		// Attributes
		panel.add(pane);
		pane.getViewport().add(list);
		JOptionPane.showMessageDialog(null, pane, "3D Tickets Report", JOptionPane.PLAIN_MESSAGE);
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Print MoviePass sales period report
	 * @version 0.01
	 * @date 11/30/2019
	 */
	private void printMoviePassTickets() throws NullPointerException {
		// Variables
		JPanel panel = new JPanel();
		JList list = new JList(Manager.getMoviePassTickets().toArray());
		JScrollPane pane = new JScrollPane();

		// Attributes
		panel.add(pane);
		pane.getViewport().add(list);
		JOptionPane.showMessageDialog(null, pane, "MoviePass Tickets Report", JOptionPane.PLAIN_MESSAGE);
	}


	/*
	 * @author https://github.com/amattu2
	 * @desc Read a user specified file
	 * @version 0.01
	 * @date 12/3/2019
	 */
	private void readFile() throws FileNotFoundException {
		// Variables
		File selectedFile;
		FileChooser chooser = new FileChooser();

		// UI
		chooser.setTitle("Read File");

		// Checks
		if ((selectedFile = chooser.showOpenDialog(null)) != null) {
			// Read File
			Manager.readFile(selectedFile);

			// Update Totals
			totalsLabel4.setText(Double.toString(Manager.totalSalesMonth()));
		} else {
			this.showMessage("Oops", "You did not pick a file");
		}
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Handle the ticket purchase action
	 * @version 0.01
	 * @date 12/3/2019
	 */
	private void handlePurchase() {
		// Variables
		String TicketType = ticketTypeGroup.getSelectedToggle() != null && ticketTypeGroup.getSelectedToggle().getUserData() != null ? ticketTypeGroup.getSelectedToggle().getUserData().toString() : "";
		String MovieRating = movieRatingGroup.getSelectedToggle() != null && movieRatingGroup.getSelectedToggle().getUserData() != null ? movieRatingGroup.getSelectedToggle().getUserData().toString() : "";
		String MovieType = movieTypeGroup.getSelectedToggle() != null && movieTypeGroup.getSelectedToggle().getUserData() != null ? movieTypeGroup.getSelectedToggle().getUserData().toString() : "";
		String MovieName = movieNameInput.getText() != null && movieNameInput.getText().trim().length() > 0 ? movieNameInput.getText() : "";
		int MovieDay = movieDayInput.getText() != null ?  this.parseInteger(movieDayInput.getText()): 0;
		int MovieTime = movieTimeInput.getText() != null ?  this.parseInteger(movieTimeInput.getText()): 0;
		int ID = movieIDInput.getText() != null ?  this.parseInteger(movieIDInput.getText()): 0;
		double total = 0;

		// Checks
		if (TicketType.equals("")) {
			this.showMessage("Oops", "Please select a ticket type");
			return;
		}
		if (MovieRating.equals("")) {
			this.showMessage("Oops", "Please select a movie rating");
			return;
		}
		if (MovieType.equals("")) {
			this.showMessage("Oops", "Please select a movie type");
			return;
		}
		if (MovieName.equals("")) {
			this.showMessage("Oops", "Please enter the movie name");
			return;
		}
		if (MovieDay <= 0 || MovieDay > 31) {
			this.showMessage("Oops", "Please enter a valid day (1-31)");
			return;
		}
		if (MovieTime < 8 || MovieTime > 23) {
			this.showMessage("Oops", "Please enter a valid time (8-23)");
			return;
		}
		if (ID <= 0 && (TicketType.equals("employee") || TicketType.equals("moviepass"))) {
			this.showMessage("Oops", "Please enter a valid ID number (1-99999999)");
			return;
		}

		// Add Ticket
		total = Manager.addTicket(MovieName, MovieRating, MovieDay, MovieTime, MovieType, TicketType, ID);
		totalsLabel4.setText(Double.toString(Manager.totalSalesMonth()));
		totalsLabel2.setText(Double.toString(total));
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Display a application specified message
	 * @version 0.01
	 * @date 12/3/2019
	 */
	private void showMessage(String title, String text) {
		// Attributes
		JOptionPane.showMessageDialog(null, title + "\n" + text);
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Build Box Margin Insets
	 * @version 0.01
	 * @date 12/3/2019
	 */
	private Insets getMarginInsets(int margins) {
		return new Insets(margins, margins, margins, margins);
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Build Box Margin Insets
	 * @version 0.01
	 * @date 12/4/2019
	 */
	private Insets getMarginInsets(int side, int margins) {
		return new Insets(side == 0 ? margins : 0, side == 1 ? margins : 0, side == 2 ? margins : 0, side == 3 ? margins : 0);
	}

	/*
	 * @author https://github.com/amattu2
	 * @desc Safely parse string to integer
	 * @version 0.01
	 * @date 12/4/2019
	 */
	private int parseInteger(String text) {
		// Variables
		int value = 0;

		// Checks
		if (text == null) { return 0; }
		if (text.trim().equals("")) { return 0; }

		// Parse
		try {
			value = Integer.parseInt(text.trim());
		} catch (Exception e) {};

		// Return
		return value;
	}
}
