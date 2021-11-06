package oo.minimal.model;

public class Model {

	int fahrenheit;
	
	public Model (int f) {
		fahrenheit = f;
	}
	
	public void setTemperature(int f) {
		fahrenheit = f;
	}
	
	public int getFahrenheit () {
		return fahrenheit;
	}
	
	public int getCelsius () {
		return 5*(fahrenheit-32)/9;
	}
}
