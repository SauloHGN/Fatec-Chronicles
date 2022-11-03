package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeys implements KeyListener
{
	GamePainel gp;
	public boolean cima, baixo, esquerda, direita;
	public boolean pressEnter;
	
	
	
	public InputKeys(GamePainel gp)
	{
		this.gp = gp;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		// Menu State
		if(gp.gameState == gp.menuState)
		{
			if(code == KeyEvent.VK_W)
			{
				gp.ui.comandoN--;
				
				if(gp.ui.comandoN < 0)
				{
					gp.ui.comandoN = 2;
				}
			}
			
			if(code == KeyEvent.VK_S)
			{
				gp.ui.comandoN++;
				
				if(gp.ui.comandoN > 2)
				{
					gp.ui.comandoN = 0;
				}
			}
			
			if(code == KeyEvent.VK_ENTER)
			{
				
				if(gp.ui.comandoN == 0)
				{
					gp.gameState = gp.playState;
				}
				
				if(gp.ui.comandoN == 1)
				{
					
				}
				
				if(gp.ui.comandoN == 2)
				{
					System.exit(0);
				}
			}
			
			
		}
		
		// play State
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
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			gp.gameState = gp.pauseState;
			
		}
		if(code == KeyEvent.VK_ENTER)
		{
			pressEnter = true;
			
			
		}
		
		
		
		// pause State
		if(gp.gameState == gp.pauseState)
		{
			if(code == KeyEvent.VK_ESCAPE)
			{
				gp.gameState = gp.playState;
				
			}
		}
		
		// Dialogo state
		if(gp.gameState == gp.dialogoState)
		{
			if(code == KeyEvent.VK_ENTER)
			{
				gp.gameState = gp.playState;
			}
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
