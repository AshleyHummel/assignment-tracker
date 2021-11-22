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
import javax.swing.*;

public class Tracker extends JFrame
{
	//declare Java Swing components
	JFrame f;
	CardLayout cardLayout;
	JPanel panel, pMenu, pCreate, pRemove, pUpcoming;
	JLabel lWelcome;
	JButton bCreate, bRemove, bUpcoming;
	
	public Tracker() 
	{
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
		
		lWelcome = new JLabel("\nWelcome to Assignment Tracker!\n");
		
		bCreate = new JButton("Create new assignment");
		bCreate.setPreferredSize(new Dimension(200,50));
		
		bRemove = new JButton("Remove assignment");
		bRemove.setPreferredSize(new Dimension(200,50));
		
		bUpcoming = new JButton("Upcoming assignments");
		bUpcoming.setPreferredSize(new Dimension(200,50));
		
		panel.setLayout(cardLayout);
		pMenu.add(lWelcome);
		pMenu.add(bCreate);
		pMenu.add(bRemove);
		pMenu.add(bUpcoming);
		
		panel.add(pMenu, "linkMenu");
		panel.add(pCreate, "linkCreate");
		panel.add(pRemove, "linkRemove");
		panel.add(pUpcoming, "linkUpcoming");
		bCreate.addActionListener(e -> cardLayout.show(panel, "linkCreate"));
		bRemove.addActionListener(e -> cardLayout.show(panel, "linkRemove"));
		bUpcoming.addActionListener(e -> cardLayout.show(panel, "linkUpcoming"));
		
		f.add(panel);
		f.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new Tracker();
	}

}
