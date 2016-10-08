package com.gameImplementation;

import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Random;


public class MonkeyEatImpl {

	Point2D.Float Banana_Postion = new Point2D.Float();
	Random Banana_Generator = new Random();

	/** Creates a new instance of Food */
	public MonkeyEatImpl() {
		Banana_Postion.setLocation((((int) ((Math.random() * (600))) % 20) * 20),
				((((int) (Math.random() * (600))) % 20) * 20));
		int x = (int) Banana_Postion.getX();
		int y = (int) Banana_Postion.getY();

		while (x > 800 || y > 800) {
			Banana_Postion.setLocation((((int) ((Math.random() * (600))) % 20) * 20),
					((((int) (Math.random() * (600))) % 20) * 20));
			x = (int) Banana_Postion.getX();
			y = (int) Banana_Postion.getY();
		}

	}

	public void getFood() {
		Banana_Postion.setLocation((((int) ((Math.random() * (600))) % 20) * 20),
				((((int) (Math.random() * (600))) % 20) * 20));
	}

	public double getX() {
		return Banana_Postion.getX();
	}

	public double getY() {
		return Banana_Postion.getY();
	}

	public int get_int_X() {
		return (int) Banana_Postion.x;
	}

	public int get_int_Y() {
		return (int) Banana_Postion.y;
	}

}
