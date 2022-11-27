package entidade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePainel;

public class Obstaculo 
{

	GamePainel gp;
	BufferedImage raio1, raio2, osso, botaoLv, botaoPontos, botaoBatalha, fundo;
	
	public int x;
	public double vObstaculo = 3;
	public int comprimento;
	
	public Obstaculo(int x, double vObstaculo, int comprimento)
	{
		this.x = x;
		this.vObstaculo = vObstaculo;
		this.comprimento = comprimento;
		
		ImageObstaculos();
		
	}
	
	public void Update()
	{
		
	}
	
	public void ImageObstaculos()
	{
		try
		{
			raio1 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio1.png"));
			raio2 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio2.png"));
                        osso = ImageIO.read(getClass().getResourceAsStream("/Batalha/osso.png"));
                        fundo = ImageIO.read(getClass().getResourceAsStream("/Batalha/teste.png"));
                        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void drawObstaculos(Graphics2D g2)
	{
		g2.drawImage(osso, 245, 220, 12, 90, null);
                g2.drawImage(osso, 245, 378, 12, 90, null);
                g2.drawImage(fundo, 0,0,768, 576, null);
               
	}
	

	
}
