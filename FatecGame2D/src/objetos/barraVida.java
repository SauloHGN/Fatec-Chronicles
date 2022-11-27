package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;

public class barraVida extends superObjetos
{
	
	
	public barraVida(GamePainel gp)
	{
		super(gp);
		
		name = "Vida";
		
		try 
		{
			Image1 = ImageIO.read(getClass().getResourceAsStream("/objetos/Vida1.png"));
			Image2 = ImageIO.read(getClass().getResourceAsStream("/objetos/Vida2.png"));
			Image3 = ImageIO.read(getClass().getResourceAsStream("/objetos/Vida3.png"));
			Image4 = ImageIO.read(getClass().getResourceAsStream("/objetos/Vida4.png"));
			Image5 = ImageIO.read(getClass().getResourceAsStream("/objetos/Vida5.png"));	
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
