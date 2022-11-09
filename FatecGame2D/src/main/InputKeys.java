package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import data.Conexao;

public class InputKeys implements KeyListener
{
	GamePainel gp;
	public boolean cima, baixo, esquerda, direita;
	public boolean pressEnter;
	
	public boolean loc = false;
	
	public int v = 0;
	public boolean password = false;
	
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
			
			menuState(code);
		}
							
		// play State
		else if(gp.gameState == gp.playState)
		{
			playState(code);
		
		}				
		
		// pause State
		else if(gp.gameState == gp.pauseState)
		{
			pauseState(code);
		}
		
		// Dialogo state
		else if(gp.gameState == gp.dialogoState)
		{
			dialogoState(code);
		}
		
		// inventario State
		
		else if(gp.gameState == gp.inventarioState)
		{
			inventarioState(code);
			
		}
		
		else if(gp.gameState == gp.senhaState)
		{
			senhaState(code);
			
		}
		else if(gp.gameState == gp.battleState)
		{
			battleState(code);
			
		}
		
	}

	
	public void menuState(int code)
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
				
				Conexao.getConnection(gp);
				gp.conexao.Load(gp);
				
				gp.gameState = gp.playState;
				
				
				
			}
			
			if(gp.ui.comandoN == 2)
			{
				System.exit(0);
			}
		}
	}
	
	public void playState(int code)
	{
		
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
		
		if(code == KeyEvent.VK_I)
		{
				
			gp.gameState = gp.inventarioState;
			
		}
		
		if(code == KeyEvent.VK_9)
		{
				if(loc == false)
				{
					loc = true;
				}
				else if(loc == true)
				{
					loc = false;
				}		
		}
		
		if(code == KeyEvent.VK_8)
		{
			gp.tileM.LoadMapa("/mapas/mapa1.txt");
		}
		
		if(code == KeyEvent.VK_B)
		{
			gp.gameState = gp.battleState;
		}
		
	}
	
	public void pauseState(int code)
	{
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			
			gp.gameState = gp.playState;					
				
		}
		
		if(code == KeyEvent.VK_W)
		{
			gp.ui.comandoM--;
			
			if(gp.ui.comandoM < 0)
			{
				gp.ui.comandoM = 2;
			}
		}
		
		if(code == KeyEvent.VK_S)
		{
			gp.ui.comandoM++;
			
			if(gp.ui.comandoM > 2)
			{
				gp.ui.comandoM = 0;
			}
		}
		
		if(code == KeyEvent.VK_ENTER)
		{
			
			if(gp.ui.comandoM == 0)
			{
				
				Conexao.getConnection(gp);
				gp.conexao.Salvar(gp);
				//gp.saveload.Salvar(gp);
			}
			
			if(gp.ui.comandoM == 1)
			{
				
			}
			
			if(gp.ui.comandoM == 2)
			{
				System.exit(0);
			}
		}
		
		
	}
	
	public void dialogoState(int code)
	{
		
		if(code == KeyEvent.VK_ENTER)
		{
			gp.gameState = gp.playState;
		}
	}
	
	public void inventarioState(int code)
	{
		
		if(code == KeyEvent.VK_I)
		{
			
			gp.gameState = gp.playState;
		}
	}
	
	public void senhaState(int code)
	{
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			gp.gameState = gp.playState;
		}
		
		if(code == KeyEvent.VK_W)
		{
			if(gp.ui.comandoS == 11)
			{
				gp.ui.comandoS = 10;
			}
			else
			{
				
				gp.ui.comandoS = gp.ui.comandoS - 4;
			
			}
			if(gp.ui.comandoS < 1)
			{
				gp.ui.comandoS = 12;
			}
			else if(gp.ui.comandoS > 12)
			{
				gp.ui.comandoS = 1;
			}
		}
		
		if(code == KeyEvent.VK_S)
		{
			if(gp.ui.comandoS == 10 || gp.ui.comandoS == 9)
			{
				gp.ui.comandoS = 11;
			}
			else
			{
				gp.ui.comandoS = gp.ui.comandoS +4;
			}
			
			if(gp.ui.comandoS < 1)
			{
				gp.ui.comandoS = 12;
			}
			else if(gp.ui.comandoS > 12)
			{
				gp.ui.comandoS = 1;
			}
			
		}
		
		if(code == KeyEvent.VK_A)
		{
			gp.ui.comandoS--;
			
			if(gp.ui.comandoS < 1)
			{
				gp.ui.comandoS = 12;
			}
			else if(gp.ui.comandoS > 12)
			{
				gp.ui.comandoS = 1;
			}
		}
		
		if(code == KeyEvent.VK_D)
		{
			gp.ui.comandoS++;
			
			if(gp.ui.comandoS < 1)
			{
				gp.ui.comandoS = 12;
			}
			
			else if(gp.ui.comandoS > 12)
			{
				gp.ui.comandoS = 1;
			}
		}
		
		if(code == KeyEvent.VK_ENTER)
		{
			
			if(gp.ui.comandoS == 1)
			{
				gp.acao.v[v] = 1;
				v++;
			}
			
			if(gp.ui.comandoS == 2)
			{
				gp.acao.v[v] = 2;
				v++;
			}
			
			if(gp.ui.comandoS == 3)
			{
				gp.acao.v[v] = 3;
				v++;
			}
			if(gp.ui.comandoS == 4)
			{
				gp.acao.v[v] = 4;
				v++;
			}
			if(gp.ui.comandoS == 5)
			{
				gp.acao.v[v] = 5;
				v++;
			}
			if(gp.ui.comandoS == 6)
			{
				gp.acao.v[v] = 6;
				v++;
			}
			if(gp.ui.comandoS == 7)
			{
				gp.acao.v[v] = 7;
				v++;
			}
			if(gp.ui.comandoS == 8)
			{
				gp.acao.v[v] = 8;
				v++;
			}
			if(gp.ui.comandoS == 9)
			{
				gp.acao.v[v] = 9;
				v++;
			}
			if(gp.ui.comandoS == 10)
			{
				gp.acao.v[v] = 0;
				v++;
			}
			if(gp.ui.comandoS == 11)
			{
				gp.gameState = gp.playState;
			}
			if(gp.ui.comandoS == 12)
			{
				for(v = 0; v < 3; v++)
				{
					if(gp.acao.v[0] == 2 && gp.acao.v[1] == 0 && gp.acao.v[2] == 8)
					{
						
						gp.acao.teleporte(gp.dialogoState);
						
						password = true;
					}
					else
					{
						
						gp.acao.v[v] = 0;
							
							
						
					}
				}
				
				v = 0;
			}
		}
	}
	
	public void battleState(int code)
	{
		if(code == KeyEvent.VK_ESCAPE)
		{
			
			gp.gameState = gp.playState;					
				
		}
		
		if(code == KeyEvent.VK_W)
		{		
			cima = true;				
		}
		
		if(code == KeyEvent.VK_A)
		{	
			esquerda = true;	
		}
		
		if(code == KeyEvent.VK_S)
		{	
			baixo = true;						
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