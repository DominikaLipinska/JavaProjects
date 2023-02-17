package mvcfx;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class View {
	
	private GridPane rootNode;
	private Pane Component;
	
	public GridPane getRootNode() {
		return rootNode;
	}

	public Pane getComponent() {
		return Component;
	}

	public View() {

		Component = new Pane();

		rootNode = new GridPane();
		rootNode.add(Component, 0, 0);
	}

	public void addToView(double x,double y, double z){
		Circle circle = new Circle(x,y,z,Color.color(Math.random(),Math.random(),Math.random()));
		Component.getChildren().add(circle);
	}

	public void addToView(double x,double y, double z,double t){
		Rectangle rectangle = new Rectangle(x,y,z,t);
		rectangle.setFill(Color.color(Math.random(),Math.random(),Math.random()));
		Component.getChildren().add(rectangle);
	}

	
}