package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import data.Conexao;
import entidade.Cerebro;
//import data.SaveLoad;
import entidade.Entidade;
import entidade.Player;
import objetos.superObjetos;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePainel extends JPanel implements Runnable
{
	
	//config da tela 
	
	final int originalTileSize = 16; // Tamanho original das pixels arts
	final int scale = 3; //altere a scala para aumentar o tamanho da tela
	
	public final int tileSize = originalTileSize * scale; // vai aumentar o tamanho da PixelArt ex: 48x48
	public final int maxScreenColuna = 16;
	public final int maxScreenLinha = 12;
	public final int screenLargura = tileSize * maxScreenColuna; // Resolução da janela ex: 768
	public final int screenAltura = tileSize * maxScreenLinha; // resolução da janela ex: 576 
	
	// config do mapa
	public final int maxWorldColuna = 100;// quantidade de colunas que vao ser desenhadas
	public final int maxWorldLinha = 35; // quantidade de linhas que vao ser desenhadas
	public final int worldLargura = tileSize * maxWorldColuna;
	public final int worldAltura =  tileSize * maxWorldLinha;
	
	
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	public InputKeys KeyH = new InputKeys(this);
	Thread gameThread;
	public Player player = new Player(this,KeyH);
	public ChecarColisao cColisao = new ChecarColisao(this);
	public UI ui = new UI(this);
	public setAssets sAssets = new setAssets(this);
	public superObjetos[] obj = new superObjetos[10];
	
	//
	public Cerebro cerebro = new Cerebro(this, KeyH);
	
	// ações
	public Acao acao = new Acao(this);
	
	//NPC
	public Entidade npc[] = new Entidade[10];
	

	// GAME STATE
	public int gameState;
	public final int menuState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogoState = 3;
	public final int inventarioState = 4;
	public final int senhaState = 5;
	public final int battleState = 6;
	public Object menu;
	
			
	// Banco de dados
	public Conexao conexao = new Conexao(this);
	
	
	
	
	public GamePainel()
	{
		
		this.setPreferredSize(new Dimension(screenLargura, screenAltura));
		this.setBackground(Color.black); //Cor de Fundo
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
		
		
	
	}
	
	
	public void setupGame()
	{
	
		gameState = menuState;
		sAssets.setNpc();
		sAssets.Itens();
				
	}
	
	

	public void startGameThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	

	@Override
	public void run() 
	{
		// System.out.println("O jogo esta rodando");
					// 1 segundo = 1.000,000,000 nanosegundos
					// 1 segundo = 1.000 milisegundos
		
		
	 // Game loop delta para travar em 60 fps
		
		double drawInterval = 1000000000/FPS;
		double delta = 0; //"
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCont = 0;
		
		while(gameThread != null)
		{
			currentTime = System.nanoTime();
			
			delta = delta + (currentTime - lastTime) / drawInterval;
			timer = timer + (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta>= 1 )
			{
				update();
				repaint();
				delta--;
				drawCont++;
			}
			
			if(timer >= 1000000000)
			{
				System.out.println("FPS:" + drawCont);
				timer = 0;
				drawCont = 0;
			}
			
		}
	}
	
	
	
	// update
	public void update() 
	{
		
		if(gameState == playState)
		{	
			// player update
			player.Update();
			
			// npc update
			for(int i = 0; i < npc.length; i++)
			{
				if(npc[i] != null)
				{
					npc[i].update();
				}
			}
			
		}
		
		if(gameState == pauseState)
		{
			 
		}
		
		if(gameState == battleState)
		{
			cerebro.UpdateC();
		}
		
		
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
			
		
		
		// Menu incial
		if(gameState == menuState)
		{
			ui.draw(g2);
		}
		if(gameState == battleState)
		{
			ui.draw(g2);
			cerebro.drawC(g2);
		}
		else // 
		{
			tileM.draw(g2);
			for(int i = 0; i< npc.length; i++)
			{
				if(npc[i] !=null)
				{
					npc[i].draw(g2);
				}	
			}
			
			// iten
			for(int i = 0; i< obj.length; i++)
			{
				if(obj[i] !=null)
				{
					obj[i].draw(g2, this);
				}	
			}
			
			player.Draw(g2);
			ui.draw(g2);
			
			
			
		}
		
		// colona e linha
		int coluna = (player.worldX + player.solidArea.x)/tileSize;
		int linha = (player.worldY + player.solidArea.x)/tileSize;
		
		
		if(KeyH.loc == true)
		{
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,16F));
			g2.setColor(Color.white);
			int x = 10;
			int y = 400;
			int linhaAltura = 20;
		
			g2.drawString("Coluna:" + (coluna), x, y);
			y = y +linhaAltura;
			g2.drawString("linha:" + (linha), x, y);
			y = y +linhaAltura;
			g2.drawString("WordlX:" + (player.worldX), x, y);
			y = y +linhaAltura;
			g2.drawString("WordlY:" + (player.worldY), x, y);
			
			
			
		}
		
		g2.dispose();
		
		
	}
	
}