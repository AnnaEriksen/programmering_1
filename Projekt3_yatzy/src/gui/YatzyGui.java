package gui;


import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.YatzyDice;

import java.net.PortUnreachableException;

public class YatzyGui extends Application {


	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults;
	// Shows points in sums, bonus and total.
	private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;

	private Button btnRoll;
	private int mouseClicks = 0;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// initialize txfValues, chbHolds, btnRoll and lblRolled
		txfValues = new TextField[5];
		for (int i = 0; i < 5; i++){
			txfValues[i] = new TextField();
			//opretter et nyt TextField-felt og gemmer det i arrayet txfValues ved indeks i.

			txfValues[i].setPrefSize(60,60);
			//foretrukne højde og bredde??

			dicePane.add(txfValues[i], i, 1);
			//tilføjer TextField-felt (fra txfValues[i]) til et GridPane-layout kaldet dicePane.
			// Den placerer feltet i kolonne i og række 0.
			txfValues[i].setFont(new Font(30)); //gør teksten større
			txfValues[i].setAlignment(Pos.CENTER); //centrer teksen
		}


		chbHolds = new CheckBox[5]; //opretter checkbox
		for (int i = 0; i < 5; i++){
			chbHolds[i] = new CheckBox("Hold"); //opretter checkbox med teksten "Hold
			//

			dicePane.add(chbHolds[i], i, 2);
			//placerer hver CheckBox i arrayet chbHolds på brugerfladen dicePane.
			GridPane.setMargin(chbHolds[i], new Insets(0, 0, 0, 12)); //rykker teksten lidt til venstre
		}

		//initialize btnRoll
		btnRoll = new Button("Roll"); //laver ny knap med teksten "Roll"
		dicePane.add(btnRoll,3, 3); //tilføjer knappen btnRoll til layoutet dicePane i kolonne 3 og række 2.
		btnRoll.setPrefSize(50, 30); //sætter bredde til 50 og højde til 30
		btnRoll.setFont(new Font(15)); //sætter tekststørrelse til 15 pixels

		//initialize lblRolled
		lblRolled = new Label("Rolled: "); //
		lblRolled.setFont(new Font(8));
		dicePane.add(lblRolled, 4, 3);//tilføjer labelen lblRolled til dicePane i kolonne 4 og række 2.
		btnRoll.setOnAction(event -> this.throwDiceAction());

		// initialize txfValues, chbHolds, btnRoll and lblRolled

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int w = 50; // width of the text fields

		//Labels
		Label lblOnes = new Label("1-s");
		scorePane.add(lblOnes, 0,0);
		Label lblTwos = new Label("2-s");
		scorePane.add(lblTwos, 0,1);
		Label lblThrees = new Label("3-s");
		scorePane.add(lblThrees, 0,2);
		Label lblFours = new Label("4-s");
		scorePane.add(lblFours, 0,3);
		Label lblFives = new Label("5-s");
		scorePane.add(lblFives, 0,4);
		Label lblSixes = new Label("6-s");
		scorePane.add(lblSixes, 0,5);
		Label lblOnePair = new Label("One Pair");
		scorePane.add(lblOnePair, 0,6);
		Label lblTwoPairs = new Label("Two Pair");
		scorePane.add(lblTwoPairs, 0,7);
		Label lblThreeSame = new Label("Three Same");
		scorePane.add(lblThreeSame, 0,8);
		Label lblFourSame = new Label("Four Same");
		scorePane.add(lblFourSame, 0,9);
		Label lblFullHouse = new Label("Full House");
		scorePane.add(lblFullHouse, 0,10);
		Label lblSmallStraight = new Label("Small Straight");
		scorePane.add(lblSmallStraight, 0,11);
		Label lblLargeStraight = new Label("Large Straight");
		scorePane.add(lblLargeStraight, 0,12);
		Label lblChance = new Label("Chance");
		scorePane.add(lblChance, 0,13);
		Label lblYatzi = new Label("Yatzi");
		scorePane.add(lblYatzi, 0,14);

		//Tekstbokse
		txfResults = new TextField[15];
		for (int i = 0; i < 15; i++){
			txfResults[i] = new TextField();
			scorePane.add(txfResults[i], 1, i);
			txfResults[i].setPrefSize(50,1);
			txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event));
		}

		//labels pt 2.
		Label lblSumSame = new Label("Sum:");
		scorePane.add(lblSumSame, 4,5);
		txfSumSame = new TextField("0");
		txfSumSame.setPrefSize(40,1);
		scorePane.add(txfSumSame,5,5);
		Label lblBonus = new Label("Bonus: ");
		scorePane.add(lblBonus, 6,5);
		txfBonus = new TextField("0");
		txfBonus.setPrefSize(40,1);
		scorePane.add(txfBonus,7,5);

		Label lblSumOther = new Label("Sum:");
		lblSumOther.setPrefSize(40,1);
		scorePane.add(lblSumOther,4,14);
		txfSumOther = new TextField("0");
		txfSumOther.setPrefSize(40,1);
		scorePane.add(txfSumOther,5,14);
		Label lblTotal = new Label("Total: ");
		scorePane.add(lblTotal, 6,14);
		txfTotal = new TextField("0");
		txfTotal.setPrefSize(40,1);
		scorePane.add(txfTotal,7,14);

		// Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
	}
	// -------------------------------------------------------------------------

	private YatzyDice yatzy = new YatzyDice();
	private boolean[] holds = new boolean[5]; //holder styr på terningernes status

	private void diceHolds(){
		for (int i = 0; i < chbHolds.length; i++){
			holds[i] = chbHolds[i].isSelected(); //Tjekker om man har klikket på boksene
		}
	}
	private void throwDiceAction(){
		if (yatzy.getThrowCount() < 3){
			diceHolds();
			yatzy.throwDice(holds);
			int[] values = yatzy.getValues();

			for (int i = 0; i < txfValues.length; i++){

				txfValues[i].setText(String.valueOf(values[i]));

			}
			lblRolled.setText("Rolled: " + yatzy.getThrowCount());

			showResults();
		}

	}
	public void clearDiceThrow(){ //fjerner flueben fra checkbox og nulstiller terninger
		for (int i = 0; i < txfValues.length; i++){
			txfValues[i].clear();
			chbHolds[i].setSelected(false);
		}
	}


	private void showResults(){
		int[] results = yatzy.getResults();
		for (int i = 0; i < txfResults.length; i++){
			if (!txfResults[i].isDisabled() && yatzy.getThrowCount() == 3){
				txfResults[i].setText(String.valueOf(results[i]));

			}
		}
	}

	// Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.

	// -------------------------------------------------------------------------

	// Create a method for mouse click on one of the text fields in txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.
	// TODO

	public void chooseFieldAction(Event event) {
			TextField txt = (TextField) event.getSource(); // så kan den samme action bruge til mange tekstfelter
			txt.setDisable(true);
			mouseClicks++;
			for (int i = 0; i < txfResults.length; i++){
				if (!txfResults[i].isDisabled()){
					txfResults[i].clear();
					clearDiceThrow();
				}

			}
			yatzy.resetThrowCount();
			throwDiceAction();
			sumSame();
			sumOther();
			total();
			if (mouseClicks == txfResults.length){
				winner();
			}

		}

		//kig også lige på denne her
	private void winner() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		int total = Integer.parseInt(txfSumOther.getText()) + Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txfBonus.getText());
		alert.setTitle("Slut!");
		alert.setHeaderText("Spillet er slut!");
		alert.setContentText("Points i alt: " + total);
		alert.showAndWait();
		resetGame();
	}

	public void sumSame(){
		int sumSame = 0;
		for (int i = 0; i <= 6; i++){
			if (txfResults[i].isDisabled()){
				String text = txfResults[i].getText();
				sumSame += Integer.parseInt(text);
			}
		}
		txfSumSame.setText(String.valueOf(sumSame));
		if (sumSame > 63){
			int bonus = 50;
			txfBonus.setText(String.valueOf(bonus));

		}
	}

	public void sumOther(){
		int sumOther = 0;
		for (int i = 7; i < txfResults.length; i++){
			if (txfResults[i].isDisabled()){
				String text = txfResults[i].getText();
				sumOther += Integer.parseInt(text);
			}
		}
		txfSumOther.setText(String.valueOf(sumOther));
	}

	public void total(){
		int total = Integer.parseInt(txfSumOther.getText()) + Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txfBonus.getText());
		txfTotal.setText(String.valueOf(total));
	}


	// kig lige på denne her
	private void resetGame() {
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].clear();
			chbHolds[i].setSelected(false);
		}
		for (int i = 0; i < txfResults.length; i++) {
			txfResults[i].clear();
			txfResults[i].setDisable(false);
		}
		txfSumSame.setText("0");
		txfSumOther.setText("0");
		txfBonus.setText("0");
		txfTotal.setText("0");
		yatzy.resetThrowCount();

	}
}











