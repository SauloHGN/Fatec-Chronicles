package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI 
{
	GamePainel gp;
	Graphics2D g2;
	Font maruMonica, purisaB;
	
	public Font arial_40;
	public boolean menssageOn = false;
	public String menssage = "";
	public boolean gameFinished = false;
	
	public UI(GamePainel gp)
	{
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		
		
		
		
		
	}
	
	
	
	
	public void draw(Graphics2D g2)
	{
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		// Menu
		if(gp.gameState == gp.menuState)
		{
			drawMenuScreen();
		}
		
		// Play
		if(gp.gameState == gp.playState)
		{
			
		}
		// Pause
		if(gp.gameState == gp.pauseState)
		{
			
		}	
		
	}
	
	public void drawMenuScreen()
	{
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
		String text = "Blue Boy Adventure";
		
		int x = textoCentralizado(text);
		int y = gp.tileSize*3;
		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
	}
	
	public void drawPauseScreen()
	{
		
		String text = "PAUSED";
		int x = textoCentralizado(text);
		int y = gp.screenAltura/2;
		
		g2.drawString(text, x, y);
	}
	
	public int textoCentralizado(String text)
	{
		int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenLargura/2 - lenght/2;
		
		return x;
	}
	
	
	
	
}
