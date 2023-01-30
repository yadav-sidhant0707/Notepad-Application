package com.notepad;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImageFilter;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.*;

public class notepadApp extends JFrame implements ActionListener {
	JMenuBar menubar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenu edit=new JMenu("Edit");
	JMenu help=new JMenu("Help");
	
	JMenuItem newFile =new JMenuItem("New");
	JMenuItem openFile =new JMenuItem("Open");
	JMenuItem saveFile =new JMenuItem("Save");
	JMenuItem printFile =new JMenuItem("Print");
	JMenuItem exitFile =new JMenuItem("Exit");
	
	
	JMenuItem cut =new JMenuItem("Cut");
	JMenuItem copy =new JMenuItem("Copy");
	JMenuItem paste =new JMenuItem("Paste");
	JMenuItem selectall =new JMenuItem("Select All");
	
	JMenuItem about=new JMenuItem("About");
	
	JTextArea textarea=new JTextArea();
	
	
	
	notepadApp()
	{
		
		setTitle("Notpad Applicaation");
		setBounds(100,100,800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon= new ImageIcon(getClass().getResource("notepad.png"));
		setIconImage(icon.getImage());
		setJMenuBar(menubar);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		
		
		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(printFile);
		file.add(exitFile);
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectall);
		 
		help.add(about);
		JScrollPane scrollpane =new JScrollPane(textarea);
		add(scrollpane);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());   //To remove double line after JMenuBar
		
		textarea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		
		newFile.addActionListener(this);
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		printFile.addActionListener(this);
		exitFile.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectall.addActionListener(this);
		about.addActionListener(this);
		
		
		//To create shortcut key for every JMenuItem 
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
		openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
		saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
		printFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
		exitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
	
		
	}

	

	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getActionCommand().equalsIgnoreCase("New"))
		{
			textarea.setText(null);
		}
		
		
		
		else if(e.getActionCommand().equalsIgnoreCase("Open")) {
			
			JFileChooser filechooser =new JFileChooser();	//The object of JFileChooser class represents a dialog window from which the user can select file. It inherits JComponent class.
			FileNameExtensionFilter textFilter = new FileNameExtensionFilter("only text file(.text)","txt");//It is used to filter specific set of extensions
			filechooser.setAcceptAllFileFilterUsed(true);
			filechooser.addChoosableFileFilter(textFilter);
			
			
			int action =filechooser.showOpenDialog(null);
			
			if(action!=JFileChooser.APPROVE_OPTION)
			{
				return;
			}
			else
			{
				try
				{
					
					BufferedReader reader = new BufferedReader(new FileReader(filechooser
							.getSelectedFile()));
					textarea.read(reader,null);
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}
					
		}	
		}
		
		
		
		
		else if(e.getActionCommand().equalsIgnoreCase("Save")) 
		{
			JFileChooser filechooser =new JFileChooser(); //The object of JFileChooser class represents a dialog window from which the user can select file. It inherits JComponent class.
			FileNameExtensionFilter textFilter = new FileNameExtensionFilter("only text file(.text)","txt");  //To choose only txt file, here we used FileNameExtensionFilter class.
			filechooser.setAcceptAllFileFilterUsed(false);  //it will only choose txt file(for choosing all type of file we need to set the method "true"
			filechooser.addChoosableFileFilter(textFilter);  //for choosing only txt file we need to set command to filter by using addChoosableFileFilter(textFilter)
			
			int action =filechooser.showSaveDialog(null);  //to show save dialog box, here showSaveDialog() is used and whatever the status will return will be stored in action variable
			if(action!=JFileChooser.APPROVE_OPTION) //To check if we clicked on save button or not if not then code will not save and it will goes to else block
			{
				return;
			}
			else {
				String fileName=filechooser.getSelectedFile().getAbsolutePath().toString();  //Before saving file we need to check which type of file user will going to check
				if(!fileName.contains(".txt"))  //to check if user had save file with using .txt or not
					fileName+=".txt";  //if user didn't had write .txt extension then add .txt extension
				
				try
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));  // To save the file we have used BufferedWriter class.It will throws IOException so we write code in try catch block
					textarea.write(writer); //write() is used to store data in specified file
				}
				catch(IOException ex)
				{
					ex.printStackTrace();
				}	
			}
				
				}
		
/*		else if(e.getActionCommand().equalsIgnoreCase("Print")) 
		{
			try
			{
				textarea.print();
				
			}
			catch(PrinterException ex)
			{
				Logger.getLogger(notepadApp.class.getName()).log(Level.SEVERE,null,ex);
			}		
		}
		
		*/
		
		else if(e.getActionCommand().equalsIgnoreCase("Exit")) {
			
			System.exit(0);  // to exit window System class exit() method is used
		}
		
		
		else if(e.getActionCommand().equalsIgnoreCase("Cut")) {
			textarea.cut();	//to cut some part of textarea use cut() method. for cut there is built-in method is present in textarea.
				}
		
		
		else if(e.getActionCommand().equalsIgnoreCase("Copy")) {
			textarea.copy();  //to copy some part of textarea use copy() method. for copy text there is built-in method is present in textarea.
		}
		
		
		
		else if(e.getActionCommand().equalsIgnoreCase("Paste")) {
			textarea.paste();  //to paste some part of textarea use paste() method. for paste text there is built-in method is present in textarea.
		}
		
		
		else if(e.getActionCommand().equalsIgnoreCase("Select All")) {
			textarea.selectAll();   //to selectAll some part of textarea use selectAll() method. for selectAll text there is built-in method is present in textarea.
		}
		
		
		else if(e.getActionCommand().equalsIgnoreCase("About")) {
			new About().setVisible(true);   //we have created About class so, we need to create object of About class.
		}
		


	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		 new notepadApp().setVisible(true);
	}
}
