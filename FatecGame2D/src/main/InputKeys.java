package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeys implements KeyListener
{

	public boolean cima, baixo, esquerda, direita;
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W)
		{
			cima = true;
		}
		
		if(code == KeyEvent.VK_S)
		{
			baixo = true;
		}
		
		if(code == KeyEvent.VK_A)
		{
			esquerda = true;
		}
		
		if(code == KeyEvent.VK_D)
		{
			direita = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W)
		{
			cima = false;
		}
		
		if(code == KeyEvent.VK_S)
		{
			baixo = false;
		}
		
		if(code == KeyEvent.VK_A)
		{
			esquerda = false;
		}
		
		if(code == KeyEvent.VK_D)
		{
			direita = false;
		}
		
	}

}
