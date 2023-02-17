package mvcfx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
	
	private View view;
	private Model model;
	private BufferedReader buffer;
	
	Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void initView() {
	}

	public void initController() {

		try {
			this.buffer = new BufferedReader(new FileReader("src\\test.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			String line;
			if(!buffer.ready()){
				System.out.println("Brak danych");
			}else{
				boolean haveData = false;
				while((line = buffer.readLine() )!= null) {

					String [] tokens = line.split("\\s+");
					boolean isAllnumber = true;

					for (String word:tokens) {
						if(!isNumber(word)){
							isAllnumber=false;
							break;
						}
					}
					if(isAllnumber){
						if(tokens.length==3){
							view.addToView(Double.valueOf(tokens[0]),Double.valueOf(tokens[1]),Double.valueOf(tokens[2]));
							haveData=true;
						}else if(tokens.length==4){
							model.set(Double.valueOf(tokens[0]),Double.valueOf(tokens[1]),Double.valueOf(tokens[2]),Double.valueOf(tokens[3]));
							view.addToView(model.getX(), model.getY(), model.getWidth(), model.getHeight());
							haveData=true;
						}
					}
				}
				buffer.close();
				if(!haveData){
					System.out.println("Brak danych");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean isNumber(String text) {
		if (text == null) {
			return false;
		}
		try {
			double d = Integer.valueOf(text);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
