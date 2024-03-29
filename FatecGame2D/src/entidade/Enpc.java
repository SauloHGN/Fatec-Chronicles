package entidade;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePainel;

public class Enpc extends Entidade
{
	public Enpc(GamePainel gp)
	{
		super(gp);		
		Direction = "parado";
		speed = 2;
		getImage();			
		setDialogo();	
	}
	
	public void getImage()// tiles das animações do npc
	{
		try 
		{
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Ebaixo1.png"));
			baixo2 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Ebaixo2.png"));
			cima1 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Ecima1.png"));
			cima2 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Ecima2.png"));
			costas = ImageIO.read(getClass().getResourceAsStream("/Enpc/Ecostas.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Eleft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Eleft2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Eright1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Enpc/Eright2.png"));
			parado = ImageIO.read(getClass().getResourceAsStream("/Enpc/Eparado.png"));			
		}	
		catch(IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void setAction()
	{
		actionCont++;
		
		if(actionCont == 50) 
		{
			// intervalo para mudar a direção do npc
			Random random = new Random();
			int i = random.nextInt(100)+1;
			
			if(i <= 25) 
			{
				Direction = "cima";
			}
			
			if(i > 25 && i<=50)
			{
				Direction = "baixo";
			}
			
			if(i > 50 && i <= 75)
			{
				Direction = "left";
			}
			
			if(i > 75 && i <= 100)
			{
				Direction = "right";
			}
			
			actionCont = 0;
		}
			
		setDialogo();
	}
	
	public void  setDialogo() // define as falas dos npcs
	{		
		if(gp.player.level <= 1)
		{
			dialogos[0][0] = "Bruno: Não tenho nada para \ntratar com você agora, você \nainda não encontrou os \nrequisitos funcionais.";		
		}
			
		if(gp.player.level > 4)
		{
			dialogos[0][0] = "Bruno: ...";		
		}
		
	}
	public void fala()
	{
		super.fala();
		setDialogo();
		IniciarDialogo(this, setDialogo);
	}	
}
