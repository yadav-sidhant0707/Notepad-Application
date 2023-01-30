package com.notepad;

import java.awt.Font;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.*;

public class About  extends JFrame {
	About()
	{
		setBounds(100,100,600,600);
		setTitle("About Notepad Application");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon icon= new ImageIcon(getClass().getResource("notepad.png"));
		setIconImage(icon.getImage());
		
		
		setLayout(null);
		
		JLabel iconLabel =new JLabel(new ImageIcon(getClass().getResource("a.png")));
		iconLabel.setBounds(100,50,100,100);
		add(iconLabel);
		
		JLabel textLabel =new JLabel("<html> Welcome to notepad <br>Notepad is"
				+ " a simple text editor for "
				+ "Microsoft Windows and a basic text- eiditing program"
				+ " which enables computer user to create "
				+ "documents <br> All rights reserved@2022</html>");
		
		textLabel.setBounds(100,100,300,300);
		textLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		add(textLabel);
		
		
		
		
	}

	public static void main(String[] args) {
	
	new About().setVisible(true); 

	}

}
