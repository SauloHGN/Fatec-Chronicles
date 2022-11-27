package entidade;

import java.awt.Graphics2D;
import java.util.Random;

import main.GamePainel;

public class ProjetilS extends Entidade
{

	GamePainel gp;
	
	public int projetilX, projetilY;
	String nome;
	
	
	
	public ProjetilS(int projetilX, int projetilY, GamePainel gp)
	{
		super(gp);
		
		this.projetilX = projetilX;
		this.projetilY = projetilY;		
		
		
	}
	
	
	
	public void update()
	{
		
	}
	
	public void drawP(Graphics2D g2)
	{
		g2.drawImage(gp.cerebro.projetil, new Random().nextInt(0), new Random(350).nextInt(), 25, 15, null);
	}
	
}


