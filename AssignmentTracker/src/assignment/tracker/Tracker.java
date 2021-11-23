/*
 * Name: Ashley Hummel
 * CSE 110 Honors Contract - Fall 2021
 * Description:
 * 
 * Classes Used:
 */

package assignment.tracker;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Tracker extends JFrame
{
	//declare Java Swing components
	JFrame f;
	CardLayout cardLayout;
	JPanel panel, pMenu, pCreate, pRemove, pUpcoming;
	JLabel lWelcome, spacer = new JLabel("                     ");
	JButton bCreate, bRemove, bUpcoming, bBack1, bDone1, bBack2, bDone2, bBack3;
	
	public Tracker() 
	{
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		
		f = new JFrame("Assignment Tracker");
		//define frame details
		f.setSize(410,165);
		f.setBounds(200,200,410,165);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		//initialize Swing components
		panel = new JPanel();
		pMenu = new JPanel();
		pCreate = new JPanel();
		pRemove = new JPanel();
		pUpcoming = new JPanel();
		
		cardLayout = new CardLayout();
		panel.setLayout(cardLayout);
		
		//-------------------- MENU PANEL --------------------//
		lWelcome = new JLabel("\nWelcome to Assignment Tracker!\n");
		
		//"Create assignment" button
		bCreate = new JButton("Create new assignment");
		bCreate.setPreferredSize(new Dimension(200,50));
		bCreate.addActionListener(e -> cardLayout.show(panel, "linkCreate"));
		
		//"Remove assignment" button
		bRemove = new JButton("Remove assignment");
		bRemove.setPreferredSize(new Dimension(200,50));
		bRemove.addActionListener(e -> cardLayout.show(panel, "linkRemove"));
		
		//"Upcoming assignments" button
		bUpcoming = new JButton("Upcoming assignments");
		bUpcoming.setPreferredSize(new Dimension(200,50));
		bUpcoming.addActionListener(e -> cardLayout.show(panel, "linkUpcoming"));
		
		//add components to menu panel
		pMenu.add(lWelcome);
		pMenu.add(bCreate);
		pMenu.add(bRemove);
		pMenu.add(bUpcoming);
		
		//-------------------- "CREATE ASSIGNMENT" PANEL --------------------//
		JLabel createName = new JLabel("Assignment Name: ");
		JTextField fieldName = new JTextField(15);
		JLabel description = new JLabel("Enter short description: ");
		JTextField fieldDescription = new JTextField(30);
		
		//"Back" button
		bBack1 = new JButton("Back");
		bBack1.setPreferredSize(new Dimension(120,35));
		bBack1.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		//"Done" button
		bDone1 = new JButton("Done");
		bDone1.setPreferredSize(new Dimension(120,35));
		bDone1.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		pCreate.add(createName);
		pCreate.add(fieldName);
		pCreate.add(description);
		pCreate.add(fieldDescription);
		pCreate.add(bBack1);
		pCreate.add(spacer);
		pCreate.add(bDone1);
		
		//-------------------- "REMOVE ASSIGNMENT" PANEL --------------------//
		//TODO: PRINT ASSIGNMENT NAMES
		JLabel removeName = new JLabel("Enter assignment name to remove: ");
		//TODO JLabel assignmentNames = new JLabel("()"); //PUT NAMES IN BETWEEN
		JTextField fieldRemove = new JTextField(30);
		
		//"Back" button
		bBack2 = new JButton("Back");
		bBack2.setPreferredSize(new Dimension(120,35));
		bBack2.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		//"Done" button
		bDone2 = new JButton("Done");
		bDone2.setPreferredSize(new Dimension(120,35));
		bDone2.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		//TODO: ADD TOP JLABELS
		pRemove.add(removeName);
		pRemove.add(fieldRemove);
		pRemove.add(bBack2);
		pRemove.add(spacer);
		pRemove.add(bDone2);
		
		//-------------------- "UPCOMING ASSIGNMENTS" PANEL --------------------//
		//TODO
		
		//"Back" button
		bBack3 = new JButton("Back");
		bBack3.setPreferredSize(new Dimension(120,35));
		bBack3.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		pUpcoming.add(bBack3);
		
		//add individual panels to main panel
		panel.add(pMenu, "linkMenu");
		panel.add(pCreate, "linkCreate");
		panel.add(pRemove, "linkRemove");
		panel.add(pUpcoming, "linkUpcoming");
		
		f.add(panel);
		f.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Tracker();
	}
}
