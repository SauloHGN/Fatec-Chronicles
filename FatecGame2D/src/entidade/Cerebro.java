package entidade;

import java.awt.Graphics2D;
import javax.imageio.ImageIO;

//import java.util.ArrayList;
//import java.util.Random;

import main.GamePainel;
import main.InputKeys;

public class Cerebro extends Entidade
{
	//
	GamePainel gp;
	InputKeys KeyH;
	//
	int cerebroX = 363;
	int cerebroY = 368;
	int speedC = 15;
	int gravidade = 2;
	
	//
	int projetilX = 0;
	int projetilY;
	
	int c = 0;
	

	public Cerebro(GamePainel gp, InputKeys KeyH) 
	{
		super(gp);
		
		this.gp = gp;
		this.KeyH = KeyH;
			
		
		getCerebroImage();
		spritesAttack();
	}

	
	public void getCerebroImage()
	{
		try
		{
			cerebro = ImageIO.read(getClass().getResourceAsStream("/Batalha/cerebro.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void UpdateC()
	{
		
		
		if(KeyH.cima == true && cerebroY >245)
		{
			//cerebroY = cerebroY - speedC;
			cerebroY = cerebroY - gravidade - 12;
			
		}
		
		else if(KeyH.baixo == true && cerebroY < 432)
		{
			cerebroY = cerebroY + speedC;
			
		}
		
		else if(KeyH.esquerda == true && cerebroX > 125)
		{
			cerebroX = cerebroX - speedC;
			
		}
		
		else if(KeyH.direita == true && cerebroX < 603)
		{
			cerebroX = cerebroX + speedC;
			
		}	
		
		
		
		if(gp.gameState == gp.battleState)
		{
			Gravity();					
		}
		
	}
	
	public void Gravity()
	{
		
		if( cerebroY < 432)
		{
			cerebroY = cerebroY + gravidade;
		}
		
		// max Y = 440 // min Y = 300
		// X = 0
	
	}
	
	public void spritesAttack()
	{
		try
		{
		areaAlerta = ImageIO.read(getClass().getResourceAsStream("/Batalha/areaAlerta.png"));
		barraH = ImageIO.read(getClass().getResourceAsStream("/Batalha/barraH.png"));
		barraV = ImageIO.read(getClass().getResourceAsStream("/Batalha/barraV.png"));
		Bomb = ImageIO.read(getClass().getResourceAsStream("/Batalha/Bomb.png"));
		laser = ImageIO.read(getClass().getResourceAsStream("/Batalha/laser.png"));
		
		projetilS = ImageIO.read(getClass().getResourceAsStream("/Batalha/projetilS.png"));

		
		
		
		// Projetil 
		projetil = ImageIO.read(getClass().getResourceAsStream("/Batalha/projetil.png"));
	
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void drawC(Graphics2D g2)
	{
		g2.drawImage(cerebro, cerebroX, cerebroY, 30, 30, null);
		
		
	}
	


}
