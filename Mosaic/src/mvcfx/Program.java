package mvcfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Program extends Application {

	@Override
	public void start(Stage primaryStage) {

		Model model = new Model();
		View view = new View();		
		Controller controller = new Controller(model, view);

		controller.initView();
		controller.initController();

		Scene scene = new Scene(view.getRootNode());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mosaic");
		primaryStage.show();

		
	}

}