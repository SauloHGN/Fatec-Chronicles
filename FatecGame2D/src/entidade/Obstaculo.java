package entidade;



import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import main.ColisaoBattle;
import main.GamePainel;

public class Obstaculo 
{

	GamePainel gp;
	BufferedImage raio1, raio2, osso, fundo;
	// Status do Obstaculo
	public int x;
	public int vObstaculo;
	public int comprimento;
	//
	public Random rand = new Random();
	public int cimaRandom, baixoRandom;
	public ColisaoBattle obsCima;
	public ColisaoBattle obsBaixo;
	public Rectangle cima;
	public Rectangle baixo;
	
	public Obstaculo(int x, int vObstaculo, int comprimento)
	{
		this.x = x;
		this.vObstaculo = vObstaculo;
		this.comprimento = comprimento;
		
		obsCima = new ColisaoBattle(x, cimaRandom, 12, comprimento);
		obsBaixo = new ColisaoBattle(x, baixoRandom, 12, comprimento);
		
		cima = new Rectangle(x, cimaRandom, 12, comprimento);
		baixo = new Rectangle(x, baixoRandom, 12, comprimento);
		
		ImageObstaculos();
		Random();
	}
	
	public void Update()
	{
		x = x - vObstaculo;
		obsCima.move(x - 1, 0);
		obsBaixo.move(x - 1, 0);
		cima.x = cima.x -1;
		baixo.x = baixo.x -1;
	}
	
	public void ImageObstaculos()
	{
		try
		{
			raio1 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio1.png"));
			raio2 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio2.png"));
			osso = ImageIO.read(getClass().getResourceAsStream("/Batalha/osso.png"));
			fundo = ImageIO.read(getClass().getResourceAsStream("/Batalha/fundoPreto.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void Random()
	{
		cimaRandom = (rand.nextInt(235 -(180-1)+1)+ 180);
		// ((max -(min -1) +1)+ min)
		baixoRandom = (rand.nextInt(410 -(375-1)+1)+ 375);
		
		cima.y = cimaRandom;
		baixo.y = baixoRandom;
	}
		
	
	public void drawObstaculos(Graphics2D g2)
	{
		g2.drawImage(osso, x, cimaRandom, 12, comprimento, null);
		g2.drawImage(osso, x, baixoRandom, 12, comprimento, null);	
		//g2.drawRect(cima.x, cima.y, cima.width, cima.height);
		//g2.drawRect(baixo.x, baixo.y, baixo.width, baixo.height);
	}	
}
