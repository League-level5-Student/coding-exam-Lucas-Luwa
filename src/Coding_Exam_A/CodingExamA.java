package Coding_Exam_A;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information. 1. How
		 * many robots 2. The color of the shapes 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the
		 * requested number of robots each draw the requested shape in the requested
		 * color. The robots should execute at the same time so Threads will need to be
		 * used. Arrange the robots so that the shapes do not overlap. For full credit,
		 * define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product
		 * should look like. Slightly Different to even out spacing.
		 */
		String numofbots = JOptionPane.showInputDialog("How Many Robots?");
		String color = JOptionPane.showInputDialog("Which Color? (Red, Green, Blue)");
		String sides = JOptionPane.showInputDialog("How Many Sides In Shape? (>0)");
		int numberofrobots = Integer.parseInt(numofbots);
		int sidesofshape = Integer.parseInt(sides);
		Robot[] robots = new Robot[numberofrobots];
		Thread[] thread = new Thread[numberofrobots];
		for (int i = 0; i < thread.length; i++) {
			robots[i] = new Robot();
			robots[i].penDown();
			robots[i].setSpeed(10000);
			if (color.equalsIgnoreCase("red")) {
				robots[i].setPenColor(Color.RED);
			}
			if (color.equalsIgnoreCase("blue")) {
				robots[i].setPenColor(Color.BLUE);
			}
			if (color.equalsIgnoreCase("green")) {
				robots[i].setPenColor(Color.GREEN);
			}
			int x = i;
			thread[i] = new Thread(() -> {
				robots[x].setX(90 + 203 * (x % 4));
				if (x >= 0 && x <= 4) {
					robots[x].setY(100);
				}
				if (x != 0 && x % 4 == 0) {
					robots[x].setY(100 + 210 * (x / 4));
				}
				if (x > 4 && x % 4 != 0) {
					robots[x].setY(100 + 210 * (x / 4));
				}
				for (int f = sidesofshape; f > 0; f--) {
					robots[x].move(50);
					robots[x].turn(360 / sidesofshape);
				}
				robots[x].penUp();
				robots[x].move(2000);
			});
		}
		for (int i = 0; i < thread.length; i++) {
			thread[i].start();
		}
	}
}