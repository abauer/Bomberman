package com.abauer.Bomberman;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;

public class Bomberman extends JFrame implements ComponentListener, KeyListener{
	private static final long serialVersionUID = 1L;
	
	public static void main(String args[]){
		Bomberman game = new Bomberman();
		game.addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent e)
		{System.exit(0);}});
	}
	
	int width,height;
	Dimension screenSize;
	Game display;
	boolean init = false;
	
	public Bomberman(){
		width = 700; height = 700;
		display = new Game(width,height);
		init = true;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((screenSize.width-width)/2, (screenSize.height-height)/2-25, width, height);
		this.setVisible(true);
		addComponentListener(this);
		addKeyListener(this);
		display.setLocation(0,0);
		display.onResize(width,height);
		setContentPane(display);
	}
	
	public void componentHidden(ComponentEvent ce) { }
	public void componentMoved(ComponentEvent ce) { }
	public void componentResized(ComponentEvent ce) {
		if(init){
			width = ce.getComponent().getWidth();
			height= ce.getComponent().getHeight();
			display.onResize(width, height);
		}
	}
	public void componentShown(ComponentEvent ce) { }
	public void keyPressed(KeyEvent arg0) {
		display.getKeyHandler().addKey(arg0);
	}
	public void keyReleased(KeyEvent arg0) { 
		display.getKeyHandler().removeKey(arg0);
	}
	public void keyTyped(KeyEvent arg0) { }
}
