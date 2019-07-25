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
		 * should look like.
		 */
		String numofbots = JOptionPane.showInputDialog("How Many Robots?");
		String color = JOptionPane.showInputDialog("Which Color? (Red, Green, Blue)");
		String sides = JOptionPane.showInputDialog("How Many Sides In Shape? (>0)");
		int numberofrobots = Integer.parseInt(numofbots);
		int sidesofshape = Integer.parseInt(sides);
		Robot[] robots = new Robot[numberofrobots];
		Thread[] thread = new Thread[numberofrobots];
//		for (int i = 0; i < numberofrobots ; i++) {
//			robots[i] = "r" + i;
//		}
//		for (int i = 0; i < numberofrobots; i++) {
//			String x = robots[i];
//			x = new Robot(); 
//		}
		System.out.println(robots[4]);
		
		for (int i = 0; i < thread.length; i++) {
		Robot rbt = robots[i];	
		rbt.penDown();
		rbt.setSpeed(1000);
		if (color.equalsIgnoreCase("red")) {
			rbt.setPenColor(Color.RED);
		}
		if (color.equalsIgnoreCase("blue")) {
			rbt.setPenColor(Color.BLUE);
		}
		if (color.equalsIgnoreCase("green")) {
			rbt.setPenColor(Color.GREEN);
		}
		thread[i] = new Thread(() -> {
			
			rbt.setX(90);
			rbt.setY(120);
			for (int f = sidesofshape; f > 0; f--) {
				rbt.move(50);
				rbt.turn(360/sidesofshape);
			}
			rbt.penUp();
			rbt.move(2000);

		});
		thread[i].start();
		}
		
	}
}
