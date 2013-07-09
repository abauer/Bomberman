package com.abauer.Bomberman;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyHandler {
	
	ArrayList<KeyEvent> pressed;
	
	public KeyHandler(){
		pressed = new ArrayList<KeyEvent>();
	}
	
	public void addKey(KeyEvent k){
		if(!pressed.contains(k)){
			pressed.add(k);
		}
	}
	
	public void removeKey(KeyEvent k){
		if(pressed.contains(k)){
			pressed.remove(k);
		}
	}
	
	public boolean containsKey(int search){
		for(int index = 0; index<pressed.size(); index++){
			if(pressed.get(index).getKeyCode()==search)
				return true;
		}
		return false;
	}
}
