package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entidade.Player;
import gameStates.GameState;
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
	public final int maxWorldColuna = 62;// quantidade de colunas que vao ser desenhadas
	public final int maxWorldLinha = 32; // quantidade de linhas que vao ser desenhadas
	public final int worldLargura = tileSize * maxWorldColuna;
	public final int worldAltura =  tileSize * maxWorldLinha;
	
	
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	InputKeys KeyH = new InputKeys(this);
	Thread gameThread;
	public Player player = new Player(this,KeyH);
	public ChecarColisao cColisao = new ChecarColisao(this);
	

	
			
	
	
	
	
	
	public GamePainel()
	{
		this.setPreferredSize(new Dimension(screenLargura, screenAltura));
		this.setBackground(Color.black); //Cor de Fundo
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
	
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
	
	public void update() 
	{
		
		
		player.Update();
		
		
		
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		player.Draw(g2);
		
		g2.dispose();
		
	}
	
}
