package com.notepad;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Notepad {

	public static void main(String[] args) {
		JFrame f=new JFrame("Notepad");
		
		JMenuBar mb=new JMenuBar();
		JMenu x,x2,x3;
		JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9;
		
		x=new JMenu("File");
		m1=new JMenuItem("New");
		m2=new JMenuItem("Open");
		m3=new JMenuItem("Save");
		x.add(m1);
		x.add(m2);
		x.add(m3);		
		mb.add(x);
		
		x2=new JMenu("Edit");
		m4=new JMenuItem("Cut");
		m5=new JMenuItem("Copy");
		m6=new JMenuItem("Paste");
		x2.add(m4);
		x2.add(m5);
		x2.add(m6);
		mb.add(x2);
		
		x3=new JMenu("Search");
		m7=new JMenuItem("Find");
		m8=new JMenuItem("Find in files");
		m9=new JMenuItem("Find Next");
		x3.add(m7);
		x3.add(m8);
		x3.add(m9);
		mb.add(x3);
		
		f.setJMenuBar(mb);
		
		f.setSize(300,300);
		f.setVisible(true);
		f.setLayout(null);
	}

	
}
