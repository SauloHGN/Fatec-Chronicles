package objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePainel;

public class Potion extends superObjetos 
{

	public Potion(GamePainel gp)
	{
		super(gp);
		
		name = "Potion";
		try
		{
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/itens/Potion.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}