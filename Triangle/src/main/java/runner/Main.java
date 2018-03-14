package runner;

import triangle.Triangle;

public class Main {


	public static void main(String[] args) {

		//double a = Double.MAX_VALUE * 10;
		//System.out.println(a);
		int a = 3;
		Triangle tr = new Triangle(a, 4.2, 3.1);
		System.out.println(tr.checkTriangle());
		System.out.println(tr.getMessage());
		System.out.println(tr.detectTriangle());
		System.out.println(tr.getSquare());
	}

}
