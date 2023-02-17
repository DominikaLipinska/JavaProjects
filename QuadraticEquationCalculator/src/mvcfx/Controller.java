package mvcfx;

import javafx.event.ActionEvent;


public class Controller {
	
	private View view;
	private Model model;
	
	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void initController() {
		
		view.getSumButtton().addEventHandler(ActionEvent.ACTION ,
									(event) -> {
													String aValue = view.getA().getText();
													String bValue = view.getB().getText();
													String cValue = view.getC().getText();
													if(isNumber(aValue)&&isNumber(bValue)&&isNumber(cValue)){
														double a = Double.valueOf(aValue);
														double b = Double.valueOf(bValue);
														double c = Double.valueOf(cValue);
														if(a == 0){
															view.getResultLabel().setText("Not a quadratic equation!");
															view.getResultLabel().setStyle("-fx-text-fill: black;-fx-background-color: red;");
														}else{
															model.set(a,b,c);
															if(model.getDelta()<0){
																view.getResultLabel().setText("Results not exist!");
																view.getResultLabel().setStyle("-fx-text-fill: blue;-fx-background-color: white;");
															}else if(model.getDelta()==0){
																view.getResultLabel().setText("x = " + model.getX1());
																view.getResultLabel().setStyle("-fx-text-fill: blue;-fx-background-color: white;");
															}else{
																view.getResultLabel().setText("x1 = " + model.getX1() + ", x2 = " + model.getX2());
																view.getResultLabel().setStyle("-fx-text-fill: blue;-fx-background-color: white;");
															}

														}

													}else{
														view.getResultLabel().setText("Number format error!");
														view.getResultLabel().setStyle("-fx-text-fill: black;-fx-background-color: red;");
													}
											  }
		);

		view.getClearButton().addEventHandler(ActionEvent.ACTION ,
				(event) -> {
								view.getA().setText("");
								view.getB().setText("");
								view.getC().setText("");
								model.reset();
								view.getResultLabel().setText("Enter quadratic equation coefficients");
								view.getResultLabel().setStyle("-fx-text-fill: black;-fx-background-color: white;");
				}
		);

	}

	public boolean isNumber(String text) {
		if (text == null) {
			return false;
		}
		try {
			double d = Double.valueOf(text);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}

