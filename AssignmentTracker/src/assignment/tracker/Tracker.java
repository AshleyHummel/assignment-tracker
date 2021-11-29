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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class Tracker extends JFrame
{
	//declare Java Swing components
	JFrame f;
	CardLayout cardLayout;
	BoxLayout boxLayout; //used for "Upcoming Assignments" panel
	BoxLayout boxLayout2;
	JPanel panel, pMenu, pCreate, pRemove, pUpcoming = new JPanel();
	JLabel lWelcome, spacer = new JLabel("                              ");
	JLabel displayNames = new JLabel();
	JPanel displayAssignments;
	JButton bCreate, bRemove, bUpcoming, bBack1, bDone1, bBack2, bDone2, bBack3;
	String assignmentNames = ""; //used to display names of current assignments
	
	String[] parts;
	int month;
	int day;
	int year;
	
	public Tracker() 
	{
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		
		f = new JFrame("Assignment Tracker");
		//define frame details
		f.setSize(410,210);
		f.setBounds(200,200,410,210);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		//initialize Swing components
		panel = new JPanel();
		pMenu = new JPanel();
		pCreate = new JPanel();
		pRemove = new JPanel();
		
		pUpcoming = new JPanel();
		boxLayout = new BoxLayout(pUpcoming, BoxLayout.PAGE_AXIS);
		pUpcoming.setLayout(boxLayout);
		pUpcoming.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		displayAssignments = new JPanel();
		boxLayout2 = new BoxLayout(displayAssignments, BoxLayout.PAGE_AXIS);
		displayAssignments.setLayout(boxLayout2);
		displayAssignments.setAlignmentX(Component.CENTER_ALIGNMENT);
		displayAssignments.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		
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
		JTextField fieldName = new JTextField(20);
		JLabel description = new JLabel("Enter short description: ");
		JTextField fieldDescription = new JTextField(30);
		JLabel dueDate = new JLabel("Enter due date (EX: 01-16-2021): ");
		JTextField fieldDate = new JTextField(20);
		
		//"Back" button
		bBack1 = new JButton("Back");
		bBack1.setPreferredSize(new Dimension(160,35));
		bBack1.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		//"Done" button
		bDone1 = new JButton("Done");
		bDone1.setPreferredSize(new Dimension(160,35));
		bDone1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add assignment to ArrayList
				parts = fieldDate.getText().split("-"); //split next index's date
				month = Integer.parseInt(parts[0]);
				day = Integer.parseInt(parts[1]);
				year = Integer.parseInt(parts[2]);
				assignments.add(new Assignment(fieldName.getText(), fieldDescription.getText(), LocalDate.of(year,month,day)));
				fieldName.setText("");
				fieldDescription.setText("");
				fieldDate.setText("");
				
				//update assignments ArrayList
				assignmentNames = ""; //reset String
				for(int i = 0; i < assignments.size(); i++) {
					assignmentNames += assignments.get(i).getName();
					if(i != assignments.size() - 1) assignmentNames += ", ";
				}
				displayNames.setText(assignmentNames);
				
				//FOR "UPCOMING ASSIGNMENTS" PANEL
				//go through assignments ArrayList and sort by date (using comparator method in Assignment.java)
				Collections.sort(assignments, Assignment.dateComparator);
				
				//update assignments ArrayList
				displayAssignments.removeAll(); //clear displayAssignments JPanel before adding all assignments
				for(int i = 0; i < assignments.size(); i++) {
					displayAssignments.add(new JLabel(assignments.get(i).getName() + " - due " + assignments.get(i).getDate() 
							+ " ... " + assignments.get(i).daysLeft() + " DAYS UNTIL DUE"));
				}

				cardLayout.show(panel, "linkMenu");
			}
		});
		
		pCreate.add(createName);
		pCreate.add(fieldName);
		pCreate.add(description);
		pCreate.add(fieldDescription);
		pCreate.add(dueDate);
		pCreate.add(fieldDate);
		pCreate.add(bBack1);
		pCreate.add(spacer);
		pCreate.add(bDone1);
		
		//-------------------- "REMOVE ASSIGNMENT" PANEL --------------------//
		JLabel assignmentsText = new JLabel("Assignments: ");
		assignmentsText.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel removeName = new JLabel("Enter assignment name to remove: ");
		removeName.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextField fieldRemove = new JTextField(30);
		
		//"Back" button
		bBack2 = new JButton("Back");
		bBack2.setPreferredSize(new Dimension(120,35));
		bBack2.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		//"Done" button
		bDone2 = new JButton("Done");
		bDone2.setPreferredSize(new Dimension(120,35));
		bDone2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < assignments.size(); i++) {
					if(assignments.get(i).getName().equals(fieldRemove.getText())) {
						assignments.remove(i);
					}
				}
				
				//update assignments ArrayList
				assignmentNames = ""; //reset String
				for(int i = 0; i < assignments.size(); i++) {
					assignmentNames += assignments.get(i).getName();
					if(i != assignments.size() - 1) assignmentNames += ", ";
				}
				displayNames.setText(assignmentNames);
				
				//FOR "UPCOMING ASSIGNMENTS" PANEL
				//go through assignments ArrayList and sort by date (using comparator method in Assignment.java)
				Collections.sort(assignments, Assignment.dateComparator);
				
				//update assignments ArrayList
				displayAssignments.removeAll(); //clear displayAssignments JPanel before adding all assignments
				for(int i = 0; i < assignments.size(); i++) {
					displayAssignments.add(new JLabel(assignments.get(i).getName() + " - due " + assignments.get(i).getDate() 
							+ " ... " + assignments.get(i).daysLeft() + " DAYS UNTIL DUE"));
				}
				
				cardLayout.show(panel, "linkMenu");
				fieldRemove.setText("");
			}
		});
		
		pRemove.add(assignmentsText);
		pRemove.add(displayNames);
		pRemove.add(removeName);
		pRemove.add(fieldRemove);
		pRemove.add(bBack2);
		pRemove.add(spacer);
		pRemove.add(bDone2);
		
		//-------------------- "UPCOMING ASSIGNMENTS" PANEL --------------------//
		JLabel assignmentsText2 = new JLabel("Upcoming Assignments:");
		assignmentsText2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//"Back" button
		bBack3 = new JButton("Back");
		bBack3.setPreferredSize(new Dimension(120,35));
		bBack3.setAlignmentX(Component.CENTER_ALIGNMENT);
		bBack3.addActionListener(e -> cardLayout.show(panel, "linkMenu"));
		
		pUpcoming.add(assignmentsText2);
		pUpcoming.add(displayAssignments);
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
