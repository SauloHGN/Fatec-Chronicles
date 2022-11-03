package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.*;

public class UI 
{
	GamePainel gp;
	Graphics2D g2;
	Font  arial_40, RetroGaming;
	
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public String conversa = "";
	

	
	
	public int comandoN = 0;
	
	
	public UI(GamePainel gp)
	{
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		
		try {
			
		InputStream is = getClass().getResourceAsStream("/font/RETRO GAMING.TTF");
		RetroGaming = Font.createFont(Font.TRUETYPE_FONT, is);
		
		}
		catch(FontFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void showMessage(String text) 
	{
		
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2)
	{
		this.g2 = g2;
		
		
		
		g2.setFont(RetroGaming);
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
			drawPauseScreen();
		}	
		// dialogo
		if(gp.gameState == gp.dialogoState)
		{
			drawDialogo();
		}
		
	}
	
	public void drawMenuScreen()
	{
		
		// Background
		
		//g2.setColor(new Color(0,0,0)); // cor de fundo
		//g2.fillRect(0, 0, gp.screenLargura, gp.screenAltura);
		
		g2.drawImage(gp.player.menufundo, 0, 0, gp.screenLargura, gp.screenAltura, null); // imagem de fundo
		
		
		
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text = "Fatec Game";
		
		int x = textoCentralizado(text);
		int y = gp.tileSize*1 +30;
		
		//sombra
		g2.setColor(Color.gray);
		g2.drawString(text, x+5, y+5);
		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		
		// Imagens botão
		x = textoCentralizado(text)+130;
		y = y +gp.tileSize*2;
		
		g2.drawImage(gp.player.botaojogar, x+50, y-10, gp.tileSize*4, gp.tileSize*2, null);
		if(comandoN == 0)
		{
			g2.drawString(">", x-gp.tileSize, y+70);
		}
		
		
		g2.drawImage(gp.player.botaoopc, x+50, y+100, gp.tileSize*4, gp.tileSize*2, null);
		if(comandoN == 1)
		{
			g2.drawString(">", x-gp.tileSize, y+180);
		}
		
		
		g2.drawImage(gp.player.botaosair, x+50, y+210, gp.tileSize*4, gp.tileSize*2, null);
		if(comandoN == 2)
		{
			g2.drawString(">", x-gp.tileSize, y+290);
		}
		
	
		
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
	
	public void drawDialogo()
	{
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,25F));
		
		int x = gp.tileSize*2;
		int y = gp.tileSize/2;
		int largura = gp.screenLargura - (gp.tileSize*4);
		int altura = gp.screenAltura - (gp.tileSize*8);
	
		drawJanela(x, y, largura, altura);// desenha a janela dos dialogos
		
		// loc dos dialogos
		x += gp.tileSize;
		y += gp.tileSize;
		
		for(String linha : conversa.split("\n"))
		{
			g2.drawString(linha, x, y);
			y = y + 40;
		}
		
	}
	
	public void drawJanela(int x, int y, int largura, int altura)
	{
		Color black = new Color(0,0,0,200);
		g2.setColor(black);
		g2.fillRoundRect(x, y, largura, altura, 35, 35);
		
		g2.setColor(Color.white);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, largura-10, altura-10, 35, 35);
	}
	
	
	
	
}
