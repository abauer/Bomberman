package com.abauer.Bomberman;

import java.awt.*;
import java.awt.image.*;
import javax.swing.JComponent;

import com.abauer.Bomberman.util.FileUtils;

public class Game extends JComponent{
	private static final long serialVersionUID = 1L;
	
	BufferedImage buffer;
	Graphics main;
	KeyHandler keys;
	int width,height;
	static Image board = FileUtils.getImage("background.png");
	
	public Game(int width, int height){
		this.width = width;
		this.height = height;
		init();
	}
	
	public void init(){
		keys = new KeyHandler();
		buffer = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
		main = buffer.getGraphics();
	}
	
	public void paintComponent(Graphics g) {
		main.drawImage(board,0, 0, width, height, null);
		g.drawImage(buffer, 0, 0, width, height, null);
	}
	
	public void onResize(int width,int height){
		this.width = width;
		this.height = height;
		repaint();
	}	
	
	public KeyHandler getKeyHandler(){
		return keys;
	}
}

