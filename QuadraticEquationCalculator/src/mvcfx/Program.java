package mvcfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Program extends Application {
		
//	public static void main(String[] args) 
//	{	
//		launch(args);	
//	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		Model model = new Model();
		View view = new View();		
		Controller controller = new Controller(model, view);

		controller.initController();

		Scene scene = new Scene(view.getRootNode());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Quadratic Equation Calculator");
		primaryStage.setResizable(false);
		primaryStage.show();

		
	}

}