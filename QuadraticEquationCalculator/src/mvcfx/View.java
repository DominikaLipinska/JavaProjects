package mvcfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import static javafx.scene.paint.Color.*;


public class View {
	
	private GridPane rootNode;
	private TextField a,b,c;
	private Button sumButtton, clearButton;
	private Label resultLabel;
	
	public GridPane getRootNode() {
		return rootNode;
	}

	public TextField getA() {
		return a;
	}
	public TextField getB() {
		return b;
	}
	public TextField getC() {
		return c;
	}

	public Button getSumButtton() {
		return sumButtton;
	}

	public Button getClearButton() {
		return clearButton;
	}

	public Label getResultLabel() {
		return resultLabel;
	}

	public View() {

			// left component
		GridPane leftComponent = new GridPane();
		GridPane abcComponent = new GridPane();
		abcComponent.setPrefSize(330,30);
		
			// controls
		resultLabel = new Label();
		resultLabel.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		resultLabel.setMinSize(60,60);
		resultLabel.setAlignment(Pos.CENTER);
		resultLabel.setFont(Font.font("Helvetica",FontWeight.BOLD, FontPosture.ITALIC,17));
		resultLabel.setText("Enter quadratic equation coefficients");
		a = new TextField();
		a.setTooltip(new Tooltip("Enter a"));
		a.setMinSize(30,30);
		b = new TextField();
		b.setTooltip(new Tooltip("Enter b"));
		b.setMinSize(30,30);
		c = new TextField();
		c.setTooltip(new Tooltip("Enter c"));
		c.setMinSize(30,30);

		sumButtton = new Button("Sum");
		sumButtton.setFont(Font.font("Lucida Sans Unicode",FontWeight.MEDIUM,FontPosture.REGULAR,15));
		sumButtton.setPrefSize(330,40);
		clearButton = new Button("Clear");
		clearButton.setFont(Font.font("Lucida Sans Unicode",FontWeight.MEDIUM,FontPosture.REGULAR,15));
		clearButton.setPrefSize(330,40);

		leftComponent.add(resultLabel,0,0,1,1);
		abcComponent.add(a,0,0);
		abcComponent.add(b,1,0);
		abcComponent.add(c,2,0);
		leftComponent.add(abcComponent,0,1);
		leftComponent.add(sumButtton, 0, 2,1,1);
		leftComponent.add(clearButton, 0, 3,1,1);
			// root node (panel)
		rootNode = new GridPane();
		rootNode.add(leftComponent, 0, 0);


	}
	
}