package mvcfx;

public class Model {

	private double[][] patrameters;

	private double x;
	private double y;
	private double width;
	private double height;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void set(double x, double y, double z, double t){
		patrameters = new double[][]{{x,y},{z,y},{z,t},{x,t}};
		this.x = x;
		this.y = y;

		for (double [] parameter:patrameters) {
			if(parameter[0]<x&&parameter[1]<y){
				this.x = parameter[0];
				this.y = parameter[1];
			}
		}

		for (double [] parameter:patrameters) {
			if(parameter[0]==x&&parameter[1]!=y){
				System.out.println();
				this.height=Math.abs(parameter[1]-y);
			}
			if(parameter[1]==y&&parameter[0]!=x){
				this.width=Math.abs(parameter[0]-x);
			}
		}

	}





}
