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
		
		// senha
		else if(gp.gameState == gp.senhaState)
		{
			senhaState(code);
			
		}
		// batalha
		else if(gp.gameState == gp.battleState)
		{
			battleState(code);
			
		}
		
		// Resposta
		else if(gp.gameState == gp.respostaState)
		{
			respostaState(code);
		}
		// Resposta 2
		else if(gp.gameState == gp.respostaState2)
		{
			respostaState2(code);
		}
		// Teclas
		else if(gp.gameState == gp.teclaState)
		{
			teclaState(code);
		}
		// GameOver
		else if(gp.gameState == gp.gameOverState)
		{
			gameOverState(code);
		}
		// Vitoria
		else if(gp.gameState == gp.winState)
		{
			winState(code);
		}
		else if(gp.gameState == gp.instruState)
		{
			instruState(code);
		}	
	}
	
	public void menuState(int code)
	{
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
		{
			gp.ui.comandoN--;
			
			if(gp.ui.comandoN < 0)
			{
				gp.ui.comandoN = 3;
			}
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
		{
			gp.ui.comandoN++;
			
			if(gp.ui.comandoN > 3)
			{
				gp.ui.comandoN = 0;
			}
		}
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
		{
			gp.ui.comandoN = gp.ui.comandoN +2;
			
			if(gp.ui.comandoN > 3)
			{
				gp.ui.comandoN = 0;
			}
		}
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
		{
			gp.ui.comandoN = gp.ui.comandoN -2;
			
			if(gp.ui.comandoN < 0)
			{
				gp.ui.comandoN = 3;
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
				gp.gameState = gp.instruState;
			}
			
			if(gp.ui.comandoN == 3)
			{
				System.exit(0);
			}
		}
	}
	
	public void playState(int code)
	{
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
		{
			cima = true;
		}
	
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
		{
			baixo = true;
		}
	
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
		{
			esquerda = true;
		}
	
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
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
		
		/*if(code == KeyEvent.VK_9)
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
			//gp.tileM.LoadMapa("/mapas/Mapa.txt");
			gp.player.worldX = gp.tileSize*84;
			gp.player.worldY = gp.tileSize*10; 
		}
		
		if(code == KeyEvent.VK_B)
		{
			gp.gameState = gp.battleState;
		}*/
	
	}
	
	public void pauseState(int code)
	{
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			
			gp.gameState = gp.playState;					
				
		}
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
		{
			gp.ui.comandoM--;
			
			if(gp.ui.comandoM < 0)
			{
				gp.ui.comandoM = 2;
			}
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
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
			}
			
			if(gp.ui.comandoM == 1)
			{
				gp.gameState = gp.teclaState;		
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
			pressEnter = true;
		}
	}
	
	public void inventarioState(int code)
	{
		
		if(code == KeyEvent.VK_I)
		{	
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_ESCAPE)
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
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
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
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
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
		
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
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
		
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
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
		
             //       
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
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
		{		
			cima = true;				
		}
		
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
		{	
			esquerda = true;	
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
		{	
			baixo = true;						
		}
		
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
		{	
			direita = true;					
		}
	}
	
	public void respostaState(int code)
	{
		if(code == KeyEvent.VK_ENTER)
		{
			if(gp.ui.comandoR == 1)
			{
				gp.gameState = gp.playState;
				gp.acao.subiuNivel2(gp.dialogoState);
			}
			if(gp.ui.comandoR == 2)
			{
				gp.player.vida--;
				gp.acao.subiuNivel(gp.dialogoState);
			}
			if(gp.ui.comandoR == 3)
			{
				gp.player.vida--;
				gp.acao.subiuNivel(gp.dialogoState);			
			}
		}
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
		{
			gp.ui.comandoR--;
			
			if(gp.ui.comandoR < 1)
			{
				gp.ui.comandoR = 3;
			}
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
		{
			gp.ui.comandoR++;
			
			if(gp.ui.comandoR > 3)
			{
				gp.ui.comandoR = 1;
			}
		}	
	}
	
	public void respostaState2(int code)
	{
		if(code == KeyEvent.VK_ENTER)
		{
			if(gp.ui.comandoR2 == 1)
			{
				gp.acao.subiuNivel(gp.dialogoState);
				gp.player.vida--;
			}
			if(gp.ui.comandoR2 == 2)
			{			
				gp.gameState = gp.playState;
				gp.acao.subiuNivel2(gp.dialogoState);
			}
			if(gp.ui.comandoR2 == 3)
			{
				gp.player.vida--;
				gp.acao.subiuNivel(gp.dialogoState);
			}
		}
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
		{
			gp.ui.comandoR2--;
			
			if(gp.ui.comandoR2 < 1)
			{
				gp.ui.comandoR2 = 3;
			}
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
		{
			gp.ui.comandoR2++;
			
			if(gp.ui.comandoR2 > 3)
			{
				gp.ui.comandoR2 = 1;
			}
		}	
	}
	
	public void teclaState(int code)
	{
		
		if(code == KeyEvent.VK_ESCAPE)
		{
			gp.gameState = gp.pauseState;	
		}
	}
	
	public void gameOverState(int code)
	{	
		if(code == KeyEvent.VK_ENTER)
		{
			if(gp.ui.comandoP == 0)
			{
				gp.gameState = gp.menuState;
			}
			
			if(gp.ui.comandoP == 1)
			{
				System.exit(0);
			}
		}	
	}
	
	public void winState(int code)
	{
		if(code == KeyEvent.VK_ENTER)
		{			
				System.exit(0);		
		}
	}
	
	public void instruState(int code)
	{
		if(code == KeyEvent.VK_ESCAPE)
		{			
				gp.gameState = gp.menuState;		
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
		{
			cima = false;
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
		{
			baixo = false;
		}
		
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
		{
			esquerda = false;
		}
		
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
		{
			direita = false;
		}		
	}
}
