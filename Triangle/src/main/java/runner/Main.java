package runner;

import triangle.Triangle;

public class Main {


	public static void main(String[] args) {

		//double a = Double.MAX_VALUE * 10;
		//System.out.println(a);
		Triangle tr = new Triangle(new Double(5), new Double(5), Math.round(Math.sqrt(5*5 + 5*5)));
		System.out.println(tr.checkTriangle());
		System.out.println(tr.getMessage());
		System.out.println(tr.detectTriangle());
		System.out.println(tr.getSquare());
	}

}
