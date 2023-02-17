package mvcfx;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Model {
	private DoubleProperty a = new SimpleDoubleProperty(0);
	private DoubleProperty b = new SimpleDoubleProperty(0);
	private DoubleProperty c = new SimpleDoubleProperty(0);
	private NumberBinding delta = new DoubleBinding() {
		{
			super.bind(a,b,c);
		}
		@Override
		protected double computeValue() {
			return (pow(b.getValue(),2)-4*a.getValue()*c.getValue());
		}
	};
	private NumberBinding x1 = new DoubleBinding() {
		{
			super.bind(a,b,delta);
		}
		@Override
		protected double computeValue() {
			return ((-b.getValue()+sqrt(delta.doubleValue()))/2*a.getValue());
		}
	};
	private NumberBinding x2 =new DoubleBinding() {
		{
			super.bind(a,b,delta);
		}
		@Override
		protected double computeValue() {
			return ((-b.getValue()-sqrt(delta.doubleValue()))/2*a.getValue());
		}
	};

	public double getDelta() {
		return delta.doubleValue() ;
	}

	public double getX1() {
		return x1.doubleValue();
	}

	public double getX2() {
		return x2.doubleValue();
	}

	public void set(double a, double b, double c){
		this.a.set(a);
		this.b.set(b);
		this.c.set(c);
	}

	public void reset(){
		this.a.set(0);
		this.b.set(0);
		this.c.set(0);
	}
}
