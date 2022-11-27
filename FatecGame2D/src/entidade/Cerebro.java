package entidade;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

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
	int speedC = 3;
	
	//
	int projetilX = 0;
	int projetilY;
	public ArrayList<ProjetilS> ProjeteisList;
	int c = 0;
	

	public Cerebro(GamePainel gp, InputKeys KeyH) 
	{
		super(gp);
		
		this.gp = gp;
		this.KeyH = KeyH;
			
		ProjeteisList = new ArrayList<>();
		
		getCerebroImage();
		spritesAttack();
		
		//Projetil();
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
		
		
		if(KeyH.cima == true && cerebroY >302)
		{
			cerebroY = cerebroY - speedC;
			
		}
		
		else if(KeyH.baixo == true && cerebroY < 432)
		{
			cerebroY = cerebroY + speedC;
			
		}
		
		else if(KeyH.esquerda == true && cerebroX > 157)
		{
			cerebroX = cerebroX - speedC;
			
		}
		
		else if(KeyH.direita == true && cerebroX < 577)
		{
			cerebroX = cerebroX + speedC;
			
		}	
		
		
		
		if(gp.gameState == gp.battleState)
		{
			Projetil();
			
			ProjeteisList.add(Projetil());
			
			
		}
		
	}
	
	public ProjetilS Projetil()
	{
		Random rand = new Random();
		
		//(max - min) + min   
		
	
			projetilY = rand.nextInt(440 - 300) + 300;
			projetilX = projetilX + 3;
			
		ProjetilS projeteis = new ProjetilS(projetilX, projetilY, gp);
		
		
		return projeteis;
	
		
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
		raio1 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio1.png"));
		raio2 = ImageIO.read(getClass().getResourceAsStream("/Batalha/raio2.png"));
		
		
		
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
	
	public void drawP(Graphics2D g2)
	{
	
		g2.drawImage(projetil, projetilX, projetilY, 25, 15, null);
			
	}

}
